package payment;

import fixture.ScreeningFixture;
import fixture.UserFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import payment.discountApplier.DiscountApplier;
import payment.discountApplier.MovieApplier;
import payment.discountApplier.PaymentMethodApplier;
import payment.discountApplier.PointApplier;
import reservation.Reservation;
import screening.Screening;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PaymentTest {
    Payment payment;
    Reservation reservation;
    Screening screening;
    UserFixture userFixture = new UserFixture();
    ScreeningFixture screeningFixture = new ScreeningFixture();

    DiscountApplier movieApplier = new MovieApplier();
    DiscountApplier pointApplier = new PointApplier(userFixture.getUser(), 2_000);

    @BeforeEach
    public void setUp() {
        reservation = new Reservation();
        reservation.setPrice(10_000);
    }

    @Test
    void 무비데이와_시간_조건에_동시에_만족하면_무비데이_할인이_먼저_적용된다() {
        payment = new Payment(List.of(movieApplier));
        screening = screeningFixture.getLateScreening();
        payment.pay(reservation, screening);

        assertThat(reservation.getPrice()).isEqualTo(7_000);
    }

    @Test
    void 무비데이와_시간_조건에_동시에_만족하면_시간_할인이_먼저_적용되지_않는다() {
        payment = new Payment(List.of(movieApplier));
        screening = screeningFixture.getLateScreening();
        payment.pay(reservation, screening);

        assertThat(reservation.getPrice()).isNotEqualTo(7_200);
    }

    @Test
    void 무비데이와_시간_조건_모두_만족하지_못한다면_할인은_적용되지_않는다() {
        payment = new Payment(List.of(movieApplier));
        screening = screeningFixture.getScreening2();
        payment.pay(reservation, screening);

        assertThat(reservation.getPrice()).isEqualTo(10_000);
    }

    @Test
    void 예매하고자_하는_상영_시간이_무비데이_조건에_해당되면_무비데이_할인이_적용된다() {
        payment = new Payment(List.of(movieApplier));
        screening = screeningFixture.getMovieDayScreening();
        payment.pay(reservation, screening);

        assertThat(reservation.getPrice()).isEqualTo(9_000);
    }

    @Test
    void 예매하고자_하는_상영_시간이_시간_조건에_해당되면_시간_할인이_적용된다() {
        payment = new Payment(List.of(movieApplier));
        screening = screeningFixture.getEarlyScreening();
        payment.pay(reservation, screening);

        assertThat(reservation.getPrice()).isEqualTo(8_000);
    }

    @Test
    void 무비데이와_시간_조건을_동시에_만족하고_포인트_사용하면_포인트는_마지막에_사용된다() {
        payment = new Payment(List.of(movieApplier, pointApplier));
        screening = screeningFixture.getLateScreening();
        payment.pay(reservation, screening);

        assertThat(reservation.getPrice()).isEqualTo(5_000);
    }

    @Test
    void 포인트를_사용하지_않으면_가격에_변화가_없다() {
        payment = new Payment(List.of(movieApplier));
        screening = screeningFixture.getScreening2();
        payment.pay(reservation, screening);

        assertThat(reservation.getPrice()).isEqualTo(10_000);
    }

    @Test
    void 신용카드를_사용하면_5프로가_할인된다() {
        payment = new Payment(List.of(new PaymentMethodApplier(PaymentMethod.CREDIT_CARD)));
        screening = screeningFixture.getScreening2();
        payment.pay(reservation, screening);

        assertThat(reservation.getPrice()).isEqualTo(9_500);
    }

    @Test
    void 현금을_사용하면_2프로가_할인된다() {
        payment = new Payment(List.of(new PaymentMethodApplier(PaymentMethod.CASH)));
        screening = screeningFixture.getScreening2();
        payment.pay(reservation, screening);

        assertThat(reservation.getPrice()).isEqualTo(9_800);
    }

    @Test
    void 포인트를_적용한_뒤_결제_수단에_따른_추가_할인이_적용된다() {
        payment = new Payment(List.of(pointApplier, new PaymentMethodApplier(PaymentMethod.CREDIT_CARD)));
        screening = screeningFixture.getScreening2();
        payment.pay(reservation, screening);

        assertThat(reservation.getPrice()).isEqualTo(7_600);
    }
}
