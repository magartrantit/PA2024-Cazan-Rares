package mypackage.lab3;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Church extends Attraction implements Visitable {

    //variabile
    private String name;
    private String description;
    private Map<DayOfWeek, TimeInterval> timetable;

    //metoda care compara doua obiecte de tip atractie
    @Override
    public int compareTo(Attraction other) {
        if (this.name == null || other.getName() == null) {
            return -1;
        }
        return this.name.compareTo(other.getName());
    }

    //constructor
    public Church(String name, String description) {
        this.name = name;
        setName(name);
        this.description = description;
        this.timetable = new HashMap<>();
    }

    //getter care returneaza ora de deschidere
    @Override
    public LocalTime getOpeningHour(DayOfWeek date) {
        return Visitable.super.getOpeningHour(date);
    }

    //getter care returneaza timetableul
    @Override
    public Map<DayOfWeek, TimeInterval> getTimeTable() {
        return timetable;
    }

    //setter care seteaza timetableul
    public void setTimetable(Map<DayOfWeek, TimeInterval> timetable) {
        this.timetable = timetable;
    }

    //metoda toString
    @Override
    public String toString() {
        return "Church{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", timetable=" + timetable +
                '}';
    }
}
