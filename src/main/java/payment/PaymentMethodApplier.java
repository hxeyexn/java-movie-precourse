package payment;

import reservation.Reservation;
import screening.Screening;

public class PaymentMethodApplier implements DiscountApplier {
    private final PaymentMethod paymentMethod;

    public PaymentMethodApplier(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public void apply(Reservation reservation, Screening screening) {
        int newPrice = (int) Math.round(reservation.getPrice() * paymentMethod.getDiscountPercent());
        reservation.setPrice(newPrice);
    }
}
