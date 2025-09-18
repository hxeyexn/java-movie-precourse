package movie;

import fixture.MovieFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SelectedMoviesTest {
    private SelectedMovies selectedMovies;
    private final MovieFixture fixture = new MovieFixture();

    @BeforeEach
    void setUp() {
        selectedMovies = new SelectedMovies();
    }

    @Test
    void 선택된_영화_수가_1개_이상이고_상영_중인_영화_수_이하이면_선택된_영화_정보를_저장한다() {
        List<Movie> movies = fixture.getMovies();
        int totalMovieCount = 5;
        List<Movie> actual = selectedMovies.update(movies, totalMovieCount);

        assertThat(actual).isEqualTo(movies);
    }

    @Test
    void 선택된_영화_수가_1개_미만이면_예외를_던진다() {
        List<Movie> movies = emptyList();
        int totalMovieCount = 3;

        assertThatThrownBy(() -> selectedMovies.update(movies, totalMovieCount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("영화 수는 1보다 작을 수 없습니다.");
    }

    @Test
    void 선택된_영화_수가_상영_중인_영화_수_이상이면_예외를_던진다() {
        List<Movie> movies = fixture.getMovies();
        int totalMovieCount = 2;

        assertThatThrownBy(() -> selectedMovies.update(movies, totalMovieCount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("영화 수는 2보다 클 수 없습니다.");
    }
}
