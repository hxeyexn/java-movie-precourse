package theater;

import seat.Seats;

import java.time.LocalTime;

public class Theater {
    private final long id;
    private final String name;
    private final OperatingHours operatingHours;
    private final Seats seats;

    public Theater(
        long id,
        String name,
        OperatingHours operatingHours,
        Seats seats
    ) {
        this.id = id;
        this.name = name;
        this.operatingHours = operatingHours;
        this.seats = seats;
    }

    public String getName() {
        return name;
    }

    public LocalTime getOpenTime() {
        return operatingHours.open;
    }

    public LocalTime getCloseTime() {
        return operatingHours.close;
    }
}
