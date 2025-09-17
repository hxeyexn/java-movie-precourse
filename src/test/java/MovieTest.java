import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MovieTest {
    Movie movie =
        new Movie(
            0,
            "F1 더 무비",
            new ScreeningPeriod(
                LocalDateTime.of(LocalDate.of(2025, 6, 25), LocalTime.NOON),
                LocalDateTime.of(LocalDate.of(2025, 9, 30), LocalTime.MIDNIGHT)
            ),
            155
        );

    @Test
    void 선택된_영화의_제목이_올바르다면_true를_반환한다() {
        boolean actual = movie.isValidTitle("F1 더 무비");
        assertThat(actual).isTrue();
    }

    @Test
    void 선택된_영화의_제목이_올바르지_않다면_예외를_던진다() {
        assertThatThrownBy(() -> movie.isValidTitle("F1 더"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("영화 제목이 올바르지 않습니다.");
    }
}
