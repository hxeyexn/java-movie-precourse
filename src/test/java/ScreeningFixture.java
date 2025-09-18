import java.time.LocalTime;
import java.util.List;

public class ScreeningFixture {
    MovieFixture movieFixture = new MovieFixture();
    TheaterFixture theaterFixture = new TheaterFixture();

    public Screening getScreening1() {
        return new Screening(
            movieFixture.getMovie1(),
            theaterFixture.getTheater1(),
            new ScreeningTime(
                LocalTime.of(9, 0),
                LocalTime.of(11, 35)
            )
        );
    }

    public Screening getScreening2() {
        return new Screening(
            movieFixture.getMovie2(),
            theaterFixture.getTheater2(),
            new ScreeningTime(
                LocalTime.of(12, 0),
                LocalTime.of(13, 43)
            )
        );
    }
    
    public List<Screening> getTwoScreenings() {
        return List.of(getScreening1(), getScreening2());
    }
}