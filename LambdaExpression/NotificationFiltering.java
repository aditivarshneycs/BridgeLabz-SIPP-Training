package LambdaExpression;

import java.util.*;
import java.util.function.Predicate;

class Alert {
    String type;
    String message;

    Alert(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public String toString() {
        return "[" + type + "] " + message;
    }
}

public class NotificationFiltering {
    public static void main(String[] args) {
        List<Alert> alerts = Arrays.asList(
            new Alert("CRITICAL", "Patient heart rate abnormal"),
            new Alert("INFO", "Patient medication due"),
            new Alert("REMINDER", "Doctor appointment at 5 PM")
        );

        Predicate<Alert> criticalOnly = alert -> "CRITICAL".equals(alert.type);

        alerts.stream().filter(criticalOnly).forEach(System.out::println);
    }
}
