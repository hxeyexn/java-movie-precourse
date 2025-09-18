package payment;

import fixture.ScreeningFixture;
import fixture.UserFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reservation.Reservation;
import screening.Screening;
import user.User;

import static org.assertj.core.api.Assertions.assertThat;

public class PaymentTest {
    Payment payment;
    Reservation reservation;
    Screening screening;
    UserFixture userFixture = new UserFixture();
    ScreeningFixture screeningFixture = new ScreeningFixture();

    @BeforeEach
    public void setUp() {
        User user = userFixture.getUser();
        reservation = new Reservation();
        payment = new Payment(user);
    }

    @Test
    void 무비데이와_시간_조건에_동시에_만족하면_무비데이_할인이_먼저_적용된다() {
        reservation.setPrice(10_000);
        screening = screeningFixture.getLateScreening();
        payment.pay(reservation, screening, 0);

        assertThat(reservation.getPrice()).isEqualTo(7_000);
    }

    @Test
    void 무비데이와_시간_조건에_동시에_만족하면_시간_할인이_먼저_적용되지_않는다() {
        reservation.setPrice(10_000);
        screening = screeningFixture.getLateScreening();
        payment.pay(reservation, screening, 0);

        assertThat(reservation.getPrice()).isNotEqualTo(7_200);
    }

    @Test
    void 무비데이와_시간_조건_모두_만족하지_못한다면_할인은_적용되지_않는다() {
        reservation.setPrice(10_000);
        screening = screeningFixture.getScreening2();
        payment.pay(reservation, screening, 1_000);

        assertThat(reservation.getPrice()).isEqualTo(9_000);
    }

    @Test
    void 예매하고자_하는_상영_시간이_무비데이_조건에_해당되면_무비데이_할인이_적용된다() {
        reservation.setPrice(10_000);
        screening = screeningFixture.getMovieDayScreening();
        payment.pay(reservation, screening, 0);

        assertThat(reservation.getPrice()).isEqualTo(9_000);
    }

    @Test
    void 예매하고자_하는_상영_시간이_시간_조건에_해당되면_시간_할인이_적용된다() {
        reservation.setPrice(10_000);
        screening = screeningFixture.getEarlyScreening();
        payment.pay(reservation, screening, 0);

        assertThat(reservation.getPrice()).isEqualTo(8_000);
    }

    @Test
    void 무비데이와_시간_조건을_동시에_만족하고_포인트도_사용하면_포인트는_마지막에_사용된다() {
        reservation.setPrice(10_000);
        screening = screeningFixture.getEarlyScreening();
        payment.pay(reservation, screening, 3_000);

        assertThat(reservation.getPrice()).isEqualTo(5_000);
    }

    @Test
    void 포인트를_사용하지_않으면_가격에_변화가_없다() {
        reservation.setPrice(10_000);
        screening = screeningFixture.getScreening2();
        payment.pay(reservation, screening, 0);

        assertThat(reservation.getPrice()).isEqualTo(10_000);
    }
}
