import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SeatsTest {
    SeatFixture fixture = new SeatFixture();

    Seats seats;

    @BeforeEach
    public void setUp() {
        seats = new Seats(fixture.getSeats());
    }

    @Test
    void 좌석_정보를_제공한다() {
        assertThat(seats.get()).isEqualTo(fixture.getSeats());
    }

    @Test
    void 예약_가능한_좌석을_선택하면_선택한_좌석을_저장한다() {
        List<Seat> selectedSeats = fixture.getAvailableSeats();
        seats.validate(selectedSeats);

        assertThat(seats.getSelected()).isEqualTo(selectedSeats);
    }

    @Test
    void 예약_불가능한_좌석을_하나라도_선택하면_예외를_던진다() {
        assertThatThrownBy(() -> seats.validate(fixture.getUnavailableSeats()))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("예약된 좌석은 선택할 수 없습니다.");
    }
}
