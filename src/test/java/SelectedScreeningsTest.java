import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SelectedScreeningsTest {
    SelectedScreenings selectedScreenings;
    MovieFixture movieFixture = new MovieFixture();
    ScreeningFixture screeningFixture = new ScreeningFixture();

    @BeforeEach
    public void setUp() {
        selectedScreenings = new SelectedScreenings();
    }

    @Test
    void 선택된_모든_영화의_상영_시간이_선택되었고_상영_시간이_겹치지_않는다면_상영_시간을_저장한다() {
        List<Movie> movies = movieFixture.getTwoMovies();
        List<Screening> screenings = screeningFixture.getTwoScreenings();
        selectedScreenings.update(movies, screenings);

        assertThat(selectedScreenings.get()).isEqualTo(screenings);
    }

    @Test
    void 선택된_모든_영화의_상영_시간이_선택되지_않았다면_예외를_던진다() {
        List<Movie> movies = movieFixture.getMovies();
        List<Screening> screenings = screeningFixture.getTwoScreenings();

        assertThatThrownBy(() -> selectedScreenings.update(movies, screenings))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("선택된 모든 영화의 상영 시간이 선택되지 않았습니다.");
    }

    @Test
    void 상영_시간이_겹치는_상영를_선택하면_예외를_던진다() {
        List<Movie> movies = movieFixture.getTwoMovies();
        List<Screening> screenings = screeningFixture.getOverlapScreenings();

        assertThatThrownBy(() -> selectedScreenings.update(movies, screenings))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("시간이 겹치는 상영은 함께 예매가 불가능합니다.");
    }
}
