package payment.discountapplier;

import reservation.Reservation;
import screening.Screening;
import user.User;

public class PointApplier implements DiscountApplier {
    private final User user;
    private final int pointAmount;

    public PointApplier(User user, int pointAmount) {
        this.user = user;
        this.pointAmount = pointAmount;
    }

    @Override
    public void apply(Reservation reservation, Screening screening) {
        user.usePoint(pointAmount);
        int newPrice = reservation.getPrice() - pointAmount;
        reservation.setPrice(newPrice);
    }
}
