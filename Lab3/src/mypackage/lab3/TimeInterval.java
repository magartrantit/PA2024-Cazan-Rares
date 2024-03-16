package mypackage.lab3;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeInterval extends Pair<LocalTime, LocalTime> {
    //constructor
    public TimeInterval(LocalTime first, LocalTime second) {
        super(first, second);
    }

    //getter care returneaza prima ora
    public LocalTime getFirst() {
        return first;
    }

    //metoda toString
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return first.format(formatter) + " - " + second.format(formatter);
    }

    public LocalTime getSecond() {
        return second;
    }
}
