package fixture;

import seat.Seats;
import theater.OperatingHours;
import theater.Theater;
import java.time.LocalDateTime;
import java.util.List;

public class TheaterFixture {
    SeatFixture seatFixture = new SeatFixture();

    public Theater getTheater1() {
        return new Theater(
            0L,
            "1관",
            new OperatingHours(
                LocalDateTime.of(2025, 1, 1, 9, 0),   // 예시 날짜로 채움
                LocalDateTime.of(2025, 1, 1, 22, 0)
            ),
            new Seats(seatFixture.getSeats())
        );
    }

    public Theater getTheater2() {
        return new Theater(
            1L,
            "2관",
            new OperatingHours(
                LocalDateTime.of(2025, 1, 1, 10, 0),
                LocalDateTime.of(2025, 1, 1, 23, 0)
            ),
            new Seats(seatFixture.getSeats())
        );
    }

    public Theater getTheater3() {
        return new Theater(
            2L,
            "3관",
            new OperatingHours(
                LocalDateTime.of(2025, 1, 1, 10, 20),
                LocalDateTime.of(2025, 1, 1, 23, 0)
            ),
            new Seats(seatFixture.getSeats())
        );
    }

    public Theater getTheater4() {
        return new Theater(
            3L,
            "1관",
            new OperatingHours(
                LocalDateTime.of(2025, 1, 1, 9, 0),
                LocalDateTime.of(2025, 1, 1, 10, 30)
            ),
            new Seats(seatFixture.getSeats())
        );
    }

    public List<Theater> getTheaters() {
        return List.of(
            getTheater1(),
            getTheater2(),
            getTheater3()
        );
    }
}
