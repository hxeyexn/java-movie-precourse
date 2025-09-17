import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SchedulingTest {
    private final MovieFixture movieFixture = new MovieFixture();
    private final TheaterFixture theaterFixture = new TheaterFixture();
    private Scheduling scheduling;

    @BeforeEach
    void setUp() {
        scheduling = new Scheduling();
    }

    @Test
    void 하나의_영화는_하루에도_여러_차례_상영될_수_있다() {
        List<Movie> movies = movieFixture.getMovies();
        List<Theater> theaters = theaterFixture.getTheaters();
        scheduling.schedule(movies, theaters);

        List<Screening> screenings = scheduling.getScreenings();
        long actual =
            screenings.stream()
                .filter(screening -> screening.getMovie().title.equals("F1 더 무비"))
                .count();
        assertThat(actual).isGreaterThan(1);
    }
}
