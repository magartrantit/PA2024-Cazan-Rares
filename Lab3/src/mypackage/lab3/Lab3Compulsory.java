package mypackage.lab3;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Lab3Compulsory {
    public static void main(String[] args) {

        //cream obiecte de tip Attraction
        //statui
        Statue statue = new Statue("Statue of Liberty", "New York, USA");
        statue.setTicketPrice(10);
        statue.getTimeTable().put(DayOfWeek.MONDAY, new TimeInterval(LocalTime.of(9, 0), LocalTime.of(17, 0)));
        statue.getTimeTable().put(DayOfWeek.THURSDAY, new TimeInterval(LocalTime.of(9, 0), LocalTime.of(17, 0)));
        statue.getTimeTable().put(DayOfWeek.FRIDAY, new TimeInterval(LocalTime.of(9, 0), LocalTime.of(17, 0)));

        Statue statue2 = new Statue("Christ the Redeemer", "Rio de Janeiro, Brazil");
        statue2.setTicketPrice(15);
        statue2.getTimeTable().put(DayOfWeek.TUESDAY, new TimeInterval(LocalTime.of(8, 0), LocalTime.of(19, 0)));
        statue2.getTimeTable().put(DayOfWeek.WEDNESDAY, new TimeInterval(LocalTime.of(8, 0), LocalTime.of(19, 0)));

        Statue statue3 = new Statue("The Motherland Calls", "Volgograd, Russia");
        statue3.setTicketPrice(5);
        statue3.getTimeTable().put(DayOfWeek.THURSDAY, new TimeInterval(LocalTime.of(10, 0), LocalTime.of(22, 0)));
        statue3.getTimeTable().put(DayOfWeek.FRIDAY, new TimeInterval(LocalTime.of(10, 0), LocalTime.of(22, 0)));

        //biserici
        Church church = new Church("St. Peter's Basilica", "Vatican City, Rome, Italy");
        church.getTimeTable().put(DayOfWeek.THURSDAY, new TimeInterval(LocalTime.of(7, 0), LocalTime.of(20, 0)));

        Church church2 = new Church("Sagrada Familia", "Barcelona, Spain");
        church2.getTimeTable().put(DayOfWeek.MONDAY, new TimeInterval(LocalTime.of(9, 0), LocalTime.of(18, 0)));

        Church church3 = new Church("Notre-Dame de Paris", "Paris, France");
        church3.getTimeTable().put(DayOfWeek.TUESDAY, new TimeInterval(LocalTime.of(8, 0), LocalTime.of(18, 30)));

        Church church4 = new Church("Saint Basil's Cathedral", "Moscow, Russia");
        church4.getTimeTable().put(DayOfWeek.WEDNESDAY, new TimeInterval(LocalTime.of(10, 0), LocalTime.of(17, 0)));

        //concerte
        Conccert concert = new Conccert("Tomorrowland", "Boom, Belgium");
        concert.setTicketPrice(20);
        concert.getTimeTable().put(DayOfWeek.FRIDAY, new TimeInterval(LocalTime.of(12, 0), LocalTime.of(23, 0)));
        concert.getTimeTable().put(DayOfWeek.SUNDAY, new TimeInterval(LocalTime.of(12, 0), LocalTime.of(23, 0)));

        Conccert concert2 = new Conccert("Coachella", "Indio, California, USA");
        concert2.setTicketPrice(25);
        concert2.getTimeTable().put(DayOfWeek.SATURDAY, new TimeInterval(LocalTime.of(11, 0), LocalTime.of(23, 0)));
        concert2.getTimeTable().put(DayOfWeek.SUNDAY, new TimeInterval(LocalTime.of(11, 0), LocalTime.of(23, 0)));


        //sortam atractiile dupa nume
        List<Attraction> attractions = Arrays.asList(statue, church, concert);
        Collections.sort(attractions);

        //afisam atractiile
        for (Attraction attraction : attractions) {
            System.out.println(attraction);
        }

        //afisam atractiile care sunt visitabile dar nu sunt platibile
        System.out.println("\n");
        System.out.println("Visitable but not payable attractions:");
        Trip trip = new Trip();
        trip.getAttractions().addAll(attractions);
        trip.displayVisitableNotPayable();

        //afisam planul de calatorie
        System.out.println("\n");
        TravelPlan travelPlan = new TravelPlan();
        travelPlan.addAttraction(DayOfWeek.MONDAY, statue);
        travelPlan.addAttraction(DayOfWeek.THURSDAY, church);
        travelPlan.addAttraction(DayOfWeek.FRIDAY, concert);

        System.out.println(travelPlan);

        // Cream graful
        Graph graph = new Graph();
        graph.addEdge(statue, church);
        graph.addEdge(church, concert);
        graph.addEdge(concert, statue);
        graph.addEdge(statue2, statue3);
        graph.addEdge(concert, concert2);
        graph.addEdge(church, church2);
        graph.addEdge(church2, church3);
        graph.addEdge(church3, church4);

        // Degree Descending
        DegreeDescendingHeuristic degreeHeuristic = new DegreeDescendingHeuristic();
        Map<Attraction, Integer> degreeColoring = degreeHeuristic.applyColoring(graph);

        // Afisam colorarea
        System.out.println("Degree Heuristic Coloring:");
        for (Map.Entry<Attraction, Integer> entry : degreeColoring.entrySet()) {
            System.out.println("Attraction: " + entry.getKey().getName() + ", Color: " + entry.getValue());
        }

        // DSatur
        DSaturHeuristic dSaturHeuristic = new DSaturHeuristic();
        Map<Attraction, Integer> dSaturColoring = dSaturHeuristic.applyColoring(graph);

        // Afisam colorarea
        System.out.println("\nDSatur Heuristic Coloring:");
        for (Map.Entry<Attraction, Integer> entry : dSaturColoring.entrySet()) {
            System.out.println("Attraction: " + entry.getKey().getName() + ", Color: " + entry.getValue());
        }
        System.out.println("\n");

        // Create an array of day names
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        // Afisam zilele in care fiecare atractie va fi vizitata conform primei colorari
        System.out.println("Degree Heuristic Visit Days:");
        for (Map.Entry<Attraction, Integer> entry : degreeColoring.entrySet()) {
            System.out.println("Attraction: " + entry.getKey().getName() + ", Day: " + days[entry.getValue()]);
        }

        // Afisam zilele in care fiecare atractie va fi vizitata conform celei de-a doua colorari
        System.out.println("\nDSatur Heuristic Visit Days:");
        for (Map.Entry<Attraction, Integer> entry : dSaturColoring.entrySet()) {
            System.out.println("Attraction: " + entry.getKey().getName() + ", Day: " + days[entry.getValue()]);
        }
    }
}