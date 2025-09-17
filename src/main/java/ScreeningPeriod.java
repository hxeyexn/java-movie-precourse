import java.time.LocalDateTime;

public class ScreeningPeriod {
    LocalDateTime startDateTime;
    LocalDateTime endDateTime;

    public ScreeningPeriod(
        LocalDateTime startDateTime,
        LocalDateTime endDateTime
    ) {
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }
}