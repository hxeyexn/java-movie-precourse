package payment.discountpolicy;

import reservation.Reservation;
import screening.Screening;
import java.time.LocalTime;

public class TimeDiscountPolicy implements DiscountPolicy {
    private final static int DISCOUNT_PRICE = 2_000;
    private final static LocalTime EARLY_TIME = LocalTime.of(11, 0);
    private final static LocalTime LATE_TIME = LocalTime.of(20, 0);

    @Override
    public void discount(
        Reservation reservation,
        Screening screening
    ) {
        LocalTime startTime = screening.getStartTime();

        if (isEarlyOrLate(startTime)) {
            int price = reservation.getPrice();
            int newPrice = price - DISCOUNT_PRICE;
            reservation.setPrice(newPrice);
        }
    }

    public boolean isEarlyOrLate(LocalTime startTime) {
        return startTime.isBefore(EARLY_TIME)
            || startTime.isAfter(LATE_TIME)
            || startTime.equals(EARLY_TIME)
            || startTime.equals(LATE_TIME);
    }
}
