package mypackage.lab3;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TravelPlan {
    private Map<DayOfWeek, List<Attraction>> plan;

    //constructor
    public TravelPlan() {
        this.plan = new HashMap<>();
    }

    //metoda pentru adaugarea unei atractii in plan
    public void addAttraction(DayOfWeek day, Attraction attraction) {
        this.plan.computeIfAbsent(day, k -> new ArrayList<>()).add(attraction);
    }

    //getter pentru plan
    public Map<DayOfWeek, List<Attraction>> getPlan() {
        return plan;
    }

    //metoda toString pentru afisarea planului
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<DayOfWeek, List<Attraction>> entry : plan.entrySet()) {
            sb.append(entry.getKey()).append(": ");
            for (Attraction attraction : entry.getValue()) {
                sb.append(attraction.getName()).append(", ");
            }
            sb.setLength(sb.length() - 2); // remove trailing comma
            sb.append("\n");
        }
        return sb.toString();
    }
}