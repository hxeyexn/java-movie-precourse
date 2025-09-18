package screening;

import java.time.LocalTime;

public class ScreeningTime {
    public LocalTime start;
    public LocalTime end;

    public ScreeningTime(
        LocalTime start,
        LocalTime end
    ) {
        this.start = start;
        this.end = end;
    }
}
