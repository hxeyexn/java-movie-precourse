import java.time.LocalTime;
import java.util.List;

public class TheaterFixture {
    SeatFixture seatFixture = new SeatFixture();

    public Theater getTheater1() {
        return new Theater(
            0L,
            "1관",
            new OperatingHours(
                LocalTime.of(9, 0),
                LocalTime.of(22, 0)
            ),
            new Seats(seatFixture.getSeats())
        );
    }

    public Theater getTheater2() {
        return new Theater(
            1L,
            "2관",
            new OperatingHours(
                LocalTime.of(10, 0),
                LocalTime.of(23, 0)
            ),
            new Seats(seatFixture.getSeats())
        );
    }

    public Theater getTheater3() {
        return new Theater(
            2L,
            "3관",
            new OperatingHours(
                LocalTime.of(10, 20),
                LocalTime.of(23, 0)
            ),
            new Seats(seatFixture.getSeats())
        );
    }

    public Theater getTheater4() {
        return new Theater(
            0L,
            "1관",
            new OperatingHours(
                LocalTime.of(9, 0),
                LocalTime.of(10, 30)
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
