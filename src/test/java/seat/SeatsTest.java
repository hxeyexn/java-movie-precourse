package seat;

import fixture.SeatFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
