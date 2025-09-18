package theater;

import seat.Seats;

import java.time.LocalDateTime;

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

    public LocalDateTime getOpenTime() {
        return operatingHours.open;
    }

    public LocalDateTime getCloseTime() {
        return operatingHours.close;
    }
}
