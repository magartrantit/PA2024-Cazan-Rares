package mypackage.lab3;

import java.time.DayOfWeek;
import java.util.Map;

//clasa abstracta Attraction pentru atractii
public abstract class Attraction implements Comparable<Attraction> {
    private String name;
    Map<DayOfWeek, TimeInterval> timeTable;

    //setter si getter pentru nume
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //metoda compareTo pentru a sorta atractiile dupa nume
    @Override
    public int compareTo(Attraction other) {
        if (this.name == null) {
            return -1;
        }
        return this.name.compareTo(other.name);
    }

    public Map<DayOfWeek, TimeInterval> getTimeTable() {

        return timeTable;
    }
}
