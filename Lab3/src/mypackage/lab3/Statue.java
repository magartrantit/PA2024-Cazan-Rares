package mypackage.lab3;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Statue extends Attraction implements Visitable, Payable {

    //variabile
    private String name;
    private String description;
    private Map<DayOfWeek, TimeInterval> timetable;
    private double ticketPrice;

    //constructor
    public Statue(String name, String description) {
        this.name = name;
        setName(name);
        this.description = description;
        this.timetable = new HashMap<>();
    }

    //metoda care returneaza timetableul
    @Override
    public Map<DayOfWeek, TimeInterval> getTimeTable() {
        return timetable;
    }

    //metoda care returneaza orarul de deschidere
    @Override
    public LocalTime getOpeningHour(DayOfWeek date) {
        return Visitable.super.getOpeningHour(date);
    }

    //metoda care compara doua obiecte de tip atractie
    @Override
    public int compareTo(Attraction other) {
        if (this.name == null || other.getName() == null) {
            return -1;
        }
        return this.name.compareTo(other.getName());
    }

    //setter care seteaza timetableul
    public void setTimetable(Map<DayOfWeek, TimeInterval> timetable) {
        this.timetable = timetable;
    }

    //getter care returneaza pretul biletului
    @Override
    public double getTicketPrice() {
        return ticketPrice;
    }

    //setter care seteaza pretul biletului
    @Override
    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    //metoda care returneaza un string cu informatiile despre atractie
    @Override
    public String toString() {
        return "Statue{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", timetable=" + timetable +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
