package payment.discountApplier;

import payment.discountpolicy.DiscountPolicy;
import payment.discountpolicy.MovieDayDiscountPolicy;
import payment.discountpolicy.TimeDiscountPolicy;
import reservation.Reservation;
import screening.Screening;

import java.util.List;

public class MovieApplier implements DiscountApplier {
    private final List<DiscountPolicy> policies =
        List.of(
            new MovieDayDiscountPolicy(),
            new TimeDiscountPolicy()
        );

    @Override
    public void apply(Reservation reservation, Screening screening) {
        for (DiscountPolicy policy : policies) {
            policy.discount(reservation, screening);
        }
    }
}
