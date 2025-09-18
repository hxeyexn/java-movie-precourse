package fixture;

import seat.Grade;
import seat.Seat;
import java.util.List;

public class SeatFixture {
    public List<Seat> getSeats() {
        return List.of(new Seat('A', 1, Grade.S, false),
            new Seat('A', 2, Grade.S, true),
            new Seat('A', 3, Grade.S, true),
            new Seat('A', 4, Grade.S, false),
            new Seat('B', 1, Grade.A, true),
            new Seat('B', 2, Grade.A, false),
            new Seat('B', 3, Grade.A, false),
            new Seat('B', 4, Grade.A, true),
            new Seat('C', 1, Grade.B, false),
            new Seat('C', 2, Grade.B, true),
            new Seat('C', 3, Grade.B, false),
            new Seat('C', 4, Grade.B, true)

        );
    }

    public List<Seat> getAvailableSeats() {
        return List.of(
            new Seat('A', 1, Grade.S, false),
            new Seat('A', 2, Grade.S, false)
        );
    }

    public List<Seat> getUnavailableSeats() {
        return List.of(
            new Seat('A', 1, Grade.S, false),
            new Seat('A', 2, Grade.S, true)
        );
    }
}
