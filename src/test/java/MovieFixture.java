import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class MovieFixture {
    public Movie getMovie1() {
        return new Movie(
            0,
            "F1 더 무비",
            new ScreeningPeriod(
                LocalDateTime.of(LocalDate.of(2025, 6, 25), LocalTime.NOON),
                LocalDateTime.of(LocalDate.of(2025, 9, 30), LocalTime.MIDNIGHT)
            ),
            155
        );
    }

    public Movie getMovie2() {
        return new Movie(
            1,
            "얼굴",
            new ScreeningPeriod(
                LocalDateTime.of(LocalDate.of(2025, 9, 11), LocalTime.NOON),
                LocalDateTime.of(LocalDate.of(2025, 10, 20), LocalTime.MIDNIGHT)
            ),
            103
        );
    }

    public Movie getMovie3() {
        return new Movie(
            2,
            "좀비딸",
            new ScreeningPeriod(
                LocalDateTime.of(LocalDate.of(2025, 7, 30), LocalTime.NOON),
                LocalDateTime.of(LocalDate.of(2025, 9, 30), LocalTime.MIDNIGHT)
            ),
            114
        );
    }

    public Movie getMovie4() {
        return new Movie(
                3,
                "드래곤 길들이기",
                new ScreeningPeriod(
                    LocalDateTime.of(LocalDate.of(2025, 6, 6), LocalTime.NOON),
                    LocalDateTime.of(LocalDate.of(2025, 8, 25), LocalTime.MIDNIGHT)
                ),
                124
        );
    }

    public List<Movie> getMovies() {
        return List.of(
            getMovie1(),
            getMovie2(),
            getMovie3(),
            getMovie4()
        );
    }

    public List<Movie> getTwoMovies() {
        return List.of(
            getMovie1(),
            getMovie2()
        );
    }
}
