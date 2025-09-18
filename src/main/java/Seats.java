import java.util.List;

public class Seats {
    private List<Seat> seats;
    private List<Seat> selectedSeats;

    public Seats(List<Seat> seats) {
        this.seats = seats;
    }

    public List<Seat> get() {
        return seats;
    }

    public void validate(List<Seat> selectedSeats) {
        for (Seat seat: selectedSeats) {
            if (!seat.isAvailable()) {
                throw new IllegalArgumentException("예약된 좌석은 선택할 수 없습니다.");
            }
            this.selectedSeats = selectedSeats;
        }
    }

    public List<Seat> getSelected() {
        return selectedSeats;
    }
}
