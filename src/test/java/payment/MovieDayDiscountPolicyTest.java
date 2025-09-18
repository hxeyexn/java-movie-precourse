package payment;

import fixture.ScreeningFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reservation.Reservation;
import screening.Screening;

import static org.assertj.core.api.Assertions.assertThat;

class MovieDayDiscountPolicyTest {
    private MovieDayDiscountPolicy policy;
    private Reservation reservation;
    private Screening screening;
    private final ScreeningFixture screeningFixture = new ScreeningFixture();

    @BeforeEach
    void setUp() {
        policy = new MovieDayDiscountPolicy();
        reservation = new Reservation();
        reservation.setPrice(10000);
    }

    @Test
    void 무비데이면_할인이_적용된다() {
        screening = screeningFixture.getMovieDayScreening();

        policy.discount(reservation, screening);

        assertThat(reservation.getPrice()).isEqualTo(9_000);
    }

    @Test
    void 무비데이가_아니면_할인이_적용되지_않는다() {
        screening = screeningFixture.getScreening1();

        policy.discount(reservation, screening);

        assertThat(reservation.getPrice()).isEqualTo(10_000);
    }
}
