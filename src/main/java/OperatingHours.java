import java.time.LocalTime;

public class OperatingHours {
    LocalTime open;
    LocalTime close;

    public OperatingHours(
        LocalTime open,
        LocalTime close
    ) {
        this.open = open;
        this.close = close;
    }
}
