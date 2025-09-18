package screening;

import java.time.LocalDateTime;

public class ScreeningTime {
    public LocalDateTime start;
    public LocalDateTime end;

    public ScreeningTime(
        LocalDateTime start,
        LocalDateTime end
    ) {
        this.start = start;
        this.end = end;
    }
}
