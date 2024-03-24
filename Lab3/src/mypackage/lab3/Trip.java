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
        List<Attraction> visitableNotPayable = new ArrayList<>();

        for (Attraction attraction : attractions) {
            if (attraction instanceof Visitable && !(attraction instanceof Payable)) {
                visitableNotPayable.add(attraction);
            }
        }

        visitableNotPayable.sort(Comparator.comparing(attraction -> ((Visitable) attraction).getOpeningHour(day)));

        for (Attraction attraction : visitableNotPayable) {
            System.out.println(attraction);
        }
    }

    //getter pentru atractii
    public List<Attraction> getAttractions() {
        return attractions;
    }
}
