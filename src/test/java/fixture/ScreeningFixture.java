package fixture;

import screening.Screening;
import screening.ScreeningTime;
import java.time.LocalDateTime;
import java.util.List;

public class ScreeningFixture {
    MovieFixture movieFixture = new MovieFixture();
    TheaterFixture theaterFixture = new TheaterFixture();

    public Screening getScreening1() {
        return new Screening(
            movieFixture.getMovie1(),
            theaterFixture.getTheater1(),
            new ScreeningTime(
                LocalDateTime.of(2025, 1, 1, 9, 0),
                LocalDateTime.of(2025, 1, 1, 11, 35)
            )
        );
    }

    public Screening getScreening2() {
        return new Screening(
            movieFixture.getMovie2(),
            theaterFixture.getTheater2(),
            new ScreeningTime(
                LocalDateTime.of(2025, 1, 1, 12, 0),
                LocalDateTime.of(2025, 1, 1, 13, 43)
            )
        );
    }

    public Screening getScreening3() {
        return new Screening(
            movieFixture.getMovie2(),
            theaterFixture.getTheater2(),
            new ScreeningTime(
                LocalDateTime.of(2025, 1, 1, 10, 0),
                LocalDateTime.of(2025, 1, 1, 12, 35)
            )
        );
    }

    public Screening getMovieDayScreening() {
        return new Screening(
            movieFixture.getMovie2(),
            theaterFixture.getTheater2(),
            new ScreeningTime(
                    LocalDateTime.of(2025, 1, 10, 10, 0),
                    LocalDateTime.of(2025, 1, 10, 12, 35)
            )
        );
    }

    public Screening getEarlyScreening() {
        return new Screening(
            movieFixture.getMovie2(),
            theaterFixture.getTheater2(),
            new ScreeningTime(
                LocalDateTime.of(2025, 1, 1, 9, 0),
                LocalDateTime.of(2025, 1, 1, 11, 35)
            )
        );
    }

    public Screening getLateScreening() {
        return new Screening(
            movieFixture.getMovie2(),
            theaterFixture.getTheater2(),
            new ScreeningTime(
                LocalDateTime.of(2025, 1, 10, 20, 0),
                LocalDateTime.of(2025, 1, 10, 22, 0)
            )
        );
    }
    
    public List<Screening> getTwoScreenings() {
        return List.of(getScreening1(), getScreening2());
    }

    public List<Screening> getOverlapScreenings() {
        return List.of(getScreening1(), getScreening3());
    }
}