package mypackage.lab3;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Trip {

    //variabilele
    private DayOfWeek day;
    private List<Attraction> attractions = new ArrayList<>();

    //metoda pentru a afisa atractiile vizitabile dar nu si platibile
    public void displayVisitableNotPayable() {
        attractions.stream()
                .filter(attraction -> attraction instanceof Visitable && !(attraction instanceof Payable))
                .sorted(Comparator.comparing(attraction -> ((Visitable) attraction).getOpeningHour(day)))
                .forEach(System.out::println);
    }

    //getter pentru atractii
    public List<Attraction> getAttractions() {
        return attractions;
    }
}
