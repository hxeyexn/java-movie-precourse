package screening;

import movie.Movie;
import theater.Theater;
import java.time.LocalDateTime;
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
            LocalDateTime currentTime = theater.getOpenTime();
            int index = 0;

            while(true) {
                Movie movie = movies.get(index);
                LocalDateTime end = currentTime.plusMinutes(movie.getScreeningTime());
                if (end.toLocalTime().isAfter(theater.getCloseTime().toLocalTime())) break;

                addScreening(theater, movie, currentTime, end);
                currentTime = end.plusMinutes(CLEANING_TIME);
                index = (index + 1) % movies.size();
            }
        }
    }

    private void addScreening(
        Theater theater,
        Movie movie,
        LocalDateTime currentTime,
        LocalDateTime end
    ) {
        ScreeningTime time = new ScreeningTime(currentTime, end);
        Screening screening = new Screening(movie, theater, time);
        screenings.add(screening);
    }

    public List<Screening> getScreenings() {
        return screenings;
    }

    public List<Screening> getScreeningsBy(String movieTitle) {
        return screenings.stream()
            .filter(screening -> screening.getMovie().getTitle().equals(movieTitle))
            .toList();
    }
}
