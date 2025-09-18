import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SelectedSeatsTest {
    SeatFixture fixture = new SeatFixture();
    ScreeningFixture screeningFixture = new ScreeningFixture();
    SelectedSeats selectedSeats;

    @BeforeEach
    public void setUp() {
        Screening screening = screeningFixture.getScreening1();
        selectedSeats = new SelectedSeats(screening);
    }

    @Test
    void 예약_가능한_좌석을_선택하면_선택한_좌석을_저장한다() {
        List<Seat> selectedSeats = fixture.getAvailableSeats();
        this.selectedSeats.update(selectedSeats);

        assertThat(this.selectedSeats.get()).isEqualTo(selectedSeats);
    }

    @Test
    void 예약_불가능한_좌석을_하나라도_선택하면_예외를_던진다() {
        assertThatThrownBy(() -> selectedSeats.update(fixture.getUnavailableSeats()))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("예약된 좌석은 선택할 수 없습니다.");
    }
}
