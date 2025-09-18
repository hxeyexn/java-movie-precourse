import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

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
                .filter(screening -> getMovieTitle(screening).equals("F1 더 무비"))
                .count();
        assertThat(actual).isGreaterThan(1);
    }

    @Test
    void 하나의_상영관에서_여러_영화를_상영할_수_있다() {
        Movie movie1 = movieFixture.getMovie1();
        Movie movie2 = movieFixture.getMovie2();
        Theater theater = theaterFixture.getTheater1();
        scheduling.schedule(List.of(movie1, movie2), List.of(theater));

        List<Screening> screenings = scheduling.getScreenings();
        assertThat(screenings).hasSize(5);
    }

    @Test
    void 여러_개의_상영관에서_하나의_영화를_상영할_수_있다() {
        Movie movie = movieFixture.getMovie1();
        Theater theater1 = theaterFixture.getTheater1();
        Theater theater2 = theaterFixture.getTheater2();
        scheduling.schedule(List.of(movie), List.of(theater1, theater2));

        List<Screening> screenings = scheduling.getScreenings();
        long theater1Count =
            screenings.stream()
                .filter(screening -> getTheaterName(screening).equals("1관"))
                .count();
        long theater2Count =
            screenings.stream()
                .filter(screening -> getTheaterName(screening).equals("2관"))
                .count();

        assertAll(
            () -> assertThat(theater1Count).isGreaterThan(0),
            () -> assertThat(theater2Count).isGreaterThan(0)
        );
    }

    @Test
    void 영화_종료_시간이_상영관_운영_마감_시간을_넘기면_스케줄에_추가하지_않는다() {
        Movie movie = movieFixture.getMovie1();
        Theater theater = theaterFixture.getTheater4();
        scheduling.schedule(List.of(movie), List.of(theater));

        List<Screening> screenings = scheduling.getScreenings();
        assertThat(screenings).hasSize(0);
    }

    @Test
    void 상영_사이에는_15분의_청소_시간이_주어진다() {
        Movie movie = movieFixture.getMovie1();
        Theater theater = theaterFixture.getTheater1();
        scheduling.schedule(List.of(movie), List.of(theater));

        LocalTime firstScreeningEndTime = getScreening(0).getEndTime();
        LocalTime secondScreeningStartTime = getScreening(1).getStartTime();

        long cleaningTime = Duration.between(firstScreeningEndTime, secondScreeningStartTime).getSeconds() / 60;

        assertThat(cleaningTime).isEqualTo(15);
    }

    @Test
    void 상영_시작_시간이_9시이고_러닝_타임이_155분이라면_상영_종료_시간은_11시_35분이다() {
        Movie movie = movieFixture.getMovie1();
        Theater theater = theaterFixture.getTheater1();
        scheduling.schedule(List.of(movie), List.of(theater));

        LocalTime endTime = getScreening(0).getEndTime();

        assertThat(endTime).isEqualTo("11:35");
    }

    @Test
    void 이전_상영_종영_시간이_11시_35분이라면_다음_상영_시간은_15분_후인_11시_50분이다() {
        Movie movie = movieFixture.getMovie1();
        Theater theater = theaterFixture.getTheater1();
        scheduling.schedule(List.of(movie), List.of(theater));

        LocalTime firstScreeningEndTime = getScreening(0).getEndTime();
        LocalTime secondScreeningStartTime = getScreening(1).getStartTime();

        assertAll(
            () -> assertThat(firstScreeningEndTime).isEqualTo("11:35"),
            () -> assertThat(secondScreeningStartTime).isEqualTo("11:50")
        );
    }

    @Test
    void 특정_영화의_상영_시간을_조회할_수_있다() {
        Movie movie1 = movieFixture.getMovie1();
        Movie movie2 = movieFixture.getMovie2();
        Theater theater = theaterFixture.getTheater1();
        scheduling.schedule(List.of(movie1, movie2), List.of(theater));

        List<Screening> actual = scheduling.getScreeningsBy("F1 더 무비");
        assertThat(actual).allMatch(screening -> getMovieTitle(screening).equals("F1 더 무비"));
    }

    private Screening getScreening(int index) {
        return scheduling.getScreenings().get(index);
    }

    private String getTheaterName(Screening screening) {
        return screening.getTheater().getName();
    }

    private String getMovieTitle(Screening screening) {
        return screening.getMovie().getTitle();
    }
}
