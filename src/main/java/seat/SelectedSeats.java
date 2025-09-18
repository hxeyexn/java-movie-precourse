package seat;

import screening.Screening;

import java.util.ArrayList;
import java.util.List;

public class SelectedSeats {
    private Screening screening;
    private List<Seat> selectedSeats = new ArrayList<>();

    public SelectedSeats(Screening screening) {
        this.screening = screening;
    }

    public void update(List<Seat> seats) {
        for (Seat seat: seats) {
            if (!seat.isAvailable()) {
                throw new IllegalArgumentException("예약된 좌석은 선택할 수 없습니다.");
            }
        }
        selectedSeats.clear();
        selectedSeats.addAll(seats);
    }

    public List<Seat> get() {
        return selectedSeats;
    }

    public Screening getScreening() {
        return screening;
    }
}