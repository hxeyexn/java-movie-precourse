package payment;

import reservation.Reservation;
import screening.Screening;

public interface DiscountApplier {
    void apply(
        Reservation reservation,
        Screening screening
    );
}
