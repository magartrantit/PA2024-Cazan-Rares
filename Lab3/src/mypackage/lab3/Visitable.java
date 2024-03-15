package mypackage.lab3;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Map;

public interface Visitable {
    Map<DayOfWeek, TimeInterval> getTimeTable();

    //metoda care returneaza ora de deschidere
    default LocalTime getOpeningHour(DayOfWeek day) {
        TimeInterval timeInterval = getTimeTable().get(day);
        if (timeInterval != null) {
            return timeInterval.getFirst();
        } else {
            return null;
        }
    }

}