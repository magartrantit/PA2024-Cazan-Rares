package mypackage.lab3;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lab3Compulsory {
    public static void main(String[] args) {

        //cream obiecte de tip Attraction
        Statue statue = new Statue("Statue of Liberty", "New York, USA");
        statue.setTicketPrice(10);
        statue.getTimeTable().put(DayOfWeek.MONDAY, new TimeInterval(LocalTime.of(9, 0), LocalTime.of(17, 0)));
        statue.getTimeTable().put(DayOfWeek.THURSDAY, new TimeInterval(LocalTime.of(9, 0), LocalTime.of(17, 0)));
        statue.getTimeTable().put(DayOfWeek.FRIDAY, new TimeInterval(LocalTime.of(9, 0), LocalTime.of(17, 0)));

        Church church = new Church("St. Peter's Basilica", "Vatican City, Rome, Italy");
        church.getTimeTable().put(DayOfWeek.THURSDAY, new TimeInterval(LocalTime.of(7, 0), LocalTime.of(20, 0)));

        Conccert concert = new Conccert("Tomorrowland", "Boom, Belgium");
        concert.setTicketPrice(20);
        concert.getTimeTable().put(DayOfWeek.FRIDAY, new TimeInterval(LocalTime.of(12, 0), LocalTime.of(23, 0)));
        concert.getTimeTable().put(DayOfWeek.SUNDAY, new TimeInterval(LocalTime.of(12, 0), LocalTime.of(23, 0)));

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


    }
}