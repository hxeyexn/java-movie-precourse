package payment;

import fixture.ScreeningFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reservation.Reservation;
import screening.Screening;

import static org.assertj.core.api.Assertions.assertThat;

public class TimeDiscountPolicyTest {
    private TimeDiscountPolicy policy;
    private Reservation reservation;
    private Screening screening;
    private final ScreeningFixture screeningFixture = new ScreeningFixture();

    @BeforeEach
    void setUp() {
        policy = new TimeDiscountPolicy();
        reservation = new Reservation();
        reservation.setPrice(10000);
    }

    @Test
    void 오전_11시_이전에_시작되는_상영은_할인이_적용된다() {
        screening = screeningFixture.getEarlyScreening();

        policy.discount(reservation, screening);

        assertThat(reservation.getPrice()).isEqualTo(8_000);
    }

    @Test
    void 오후_8시_이후에_시작되는_상영은_할인이_적용된다() {
        screening = screeningFixture.getLateScreening();

        policy.discount(reservation, screening);

        assertThat(reservation.getPrice()).isEqualTo(8_000);
    }

    @Test
    void 오전_11시_이후부터_오후_8시_이전에_시작되는_상영은_할인이_적용되지_않는다() {
        screening = screeningFixture.getScreening2();

        policy.discount(reservation, screening);

        assertThat(reservation.getPrice()).isEqualTo(10_000);
    }
}
