package seat;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SeatTest {
    @Test
    void 좌석_번호의_행은_알파벳으로_열은_숫자로_표시한다() {
        Seat seat = new Seat('A', 1, Grade.S, false);

        assertThat(seat.getNumber()).isEqualTo("A1");
    }

    @Test
    void 좌석_번호가_같다면_같은_좌석이다() {
        Seat seat1 = new Seat('A', 1, Grade.S, false);
        Seat seat2 = new Seat('A', 1, Grade.S, false);

        assertThat(seat1).isEqualTo(seat2);
    }

    @Test
    void 예약_여부와_관계없이_좌석_번호가_같다면_같은_좌석이다() {
        Seat seat1 = new Seat('A', 1, Grade.S, false);
        Seat seat2 = new Seat('A', 1, Grade.S, true);

        assertThat(seat1).isEqualTo(seat2);
    }

    @Test
    void 좌석_번호가_다르면_다른_좌석이다() {
        Seat seat1 = new Seat('A', 1, Grade.S, false);
        Seat seat2 = new Seat('C', 1, Grade.S, false);

        assertThat(seat1).isNotEqualTo(seat2);
    }
}
