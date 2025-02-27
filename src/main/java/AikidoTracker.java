import java.time.LocalDate;
import java.util.Scanner;

public class AikidoTracker {
    private String name;
    private LocalDate start;
    private int sessions = 0;
    private int durations = 0;

    public AikidoTracker(String name, String start) {
        this.name = name;
        this.start = LocalDate.parse(start);
    }

    public String getName() {
        return name;
    }

    public LocalDate getStart() {
        return start;
    }

    public int getSessions() {
        return sessions;
    }

    public int getDurations() {
        return durations;
    }

    public void addSession(String date, int duration) {
        sessions++;
        durations += duration;
    }

    public boolean isEligibleForKyu() {
        if (sessions == 0){
            return false;
        }

        LocalDate today = LocalDate.now();
        long months = java.time.temporal.ChronoUnit.MONTHS.between(start, today);

        return months >= 6 || sessions >= 100;
    }


}
