import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Scheduling {
    final int CLEANING_TIME = 15;
    private final List<Screening> screenings = new ArrayList<>();

    public void schedule(
        List<Movie> movies,
        List<Theater> theaters
    ) {
        for (Theater theater : theaters) {
            LocalTime currentTime = theater.getOpenTime();

            for (Movie movie : movies) {
                LocalTime end = currentTime.plusMinutes(movie.screeningTime + CLEANING_TIME);
                if (end.isAfter(theater.getCloseTime())) break;

                addScreening(theater, movie, currentTime, end);
            }
        }
    }

    private void addScreening(
        Theater theater,
        Movie movie,
        LocalTime currentTime,
        LocalTime end
    ) {
        ScreeningTime time = new ScreeningTime(currentTime, end);
        Screening screening = new Screening(movie, theater, time);
        screenings.add(screening);
    }

    public List<Screening> getScreenings() {
        return screenings;
    }
}
