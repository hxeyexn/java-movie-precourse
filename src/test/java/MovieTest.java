import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MovieTest {
    private final MovieFixture fixture = new MovieFixture();

    @Test
    void 선택된_영화의_제목이_올바르다면_true를_반환한다() {
        Movie movie = fixture.getMovie1();
        boolean actual = movie.isValidTitle("F1 더 무비");

        assertThat(actual).isTrue();
    }

    @Test
    void 선택된_영화의_제목이_올바르지_않다면_예외를_던진다() {
        Movie movie = fixture.getMovie1();

        assertThatThrownBy(() -> movie.isValidTitle("F1 더"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("영화 제목이 올바르지 않습니다.");
    }
}
