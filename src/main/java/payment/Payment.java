package payment;

import payment.discountApplier.DiscountApplier;
import reservation.Reservation;
import screening.Screening;

import java.util.List;

public class Payment {
    private final List<DiscountApplier> appliers;

    public Payment(List<DiscountApplier> appliers) {
        this.appliers = appliers;
    }

    public void pay(
        Reservation reservation,
        Screening screening
    ) {
        for (DiscountApplier applier: appliers) {
            applier.apply(reservation, screening);
        }
    }
}
