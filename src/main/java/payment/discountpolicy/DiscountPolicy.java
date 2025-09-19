package payment.discountpolicy;

import reservation.Reservation;
import screening.Screening;

public interface DiscountPolicy {
    void discount(
        Reservation reservation,
        Screening screening
    );
}