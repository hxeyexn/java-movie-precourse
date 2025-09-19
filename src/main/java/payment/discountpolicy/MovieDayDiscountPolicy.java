package payment.discountpolicy;

import reservation.Reservation;
import screening.Screening;
import java.time.LocalDateTime;
import java.util.List;

public class MovieDayDiscountPolicy implements DiscountPolicy {
    private final static double DISCOUNT_RATE = 0.9;
    private final static List<Integer> DAYS = List.of(10, 20, 30);

    @Override
    public void discount(
        Reservation reservation,
        Screening screening
    ) {
        LocalDateTime date = screening.getTime().start;

        if (isMovieDay(date)) {
            int price = reservation.getPrice();
            int newPrice = (int) Math.round(price * DISCOUNT_RATE);
            reservation.setPrice(newPrice);
        }
    }

    public boolean isMovieDay(LocalDateTime date) {
        int day = date.getDayOfMonth();
        return DAYS.contains(day);
    }
}
