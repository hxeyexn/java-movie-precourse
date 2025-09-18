package reservation;

import movie.Movie;
import movie.SelectedMovies;
import screening.Screening;
import screening.SelectedScreenings;
import seat.Seat;
import seat.SelectedSeats;
import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private SelectedMovies selectedMovies = new SelectedMovies();
    private SelectedScreenings selectedScreenings = new SelectedScreenings();
    private List<SelectedSeats> selectedSeats = new ArrayList<>();
    private int price = 0;

    public void selectMovies(
        List<Movie> movies,
        int totalMovieCount
    ) {
        selectedMovies.update(movies, totalMovieCount);
    }

    public void selectScreenings(List<Screening> screenings) {
        selectedScreenings.update(selectedMovies.get(), screenings);
    }

    public void selectSeats(Screening screening, List<Seat> seats) {
        SelectedSeats selectedSeats = new SelectedSeats(screening);
        selectedSeats.update(seats);
        price = selectedSeats.getTotalPrice();
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int newPrice) {
        this.price = newPrice;
    }
}
