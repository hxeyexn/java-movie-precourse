package theater;

import java.time.LocalDateTime;

public class OperatingHours {
    LocalDateTime open;
    LocalDateTime close;

    public OperatingHours(
        LocalDateTime open,
        LocalDateTime close
    ) {
        this.open = open;
        this.close = close;
    }
}
