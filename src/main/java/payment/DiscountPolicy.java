package payment;

import reservation.Reservation;
import screening.Screening;

interface DiscountPolicy {
    void discount(Reservation reservation, Screening screening);
}