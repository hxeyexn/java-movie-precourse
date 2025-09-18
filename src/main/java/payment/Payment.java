package payment;

import reservation.Reservation;
import screening.Screening;
import user.User;

import java.util.List;

public class Payment {
    private final List<DiscountPolicy> policies =
        List.of(
            new MovieDayDiscountPolicy(),
            new TimeDiscountPolicy()
        );
    private final User user;

    public Payment(User user) {
        this.user = user;
    }

    public void pay(
        Reservation reservation,
        Screening screening,
        int pointAmount
    ) {
        applyMovieDiscount(reservation, screening);
        applyPoint(reservation, pointAmount);
    }

    private void applyMovieDiscount(
        Reservation reservation,
        Screening screening
    ) {
        for (DiscountPolicy policy : policies) {
            policy.discount(reservation, screening);
        }
    }

    private void applyPoint(
        Reservation reservation,
        int pointAmount
    ) {
        user.usePoint(pointAmount);
        int newPrice = reservation.getPrice() - pointAmount;
        reservation.setPrice(newPrice);
    }
}
