package screening;

import movie.Movie;
import theater.Theater;
import java.time.LocalDateTime;
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
            scheduleScreeningFor(theater, movies);
        }
    }

    private void scheduleScreeningFor(
        Theater theater,
        List<Movie> movies
    ) {
        LocalDateTime currentTime = theater.getOpenTime();
        int index = 0;

        while(true) {
            Movie movie = movies.get(index);
            LocalDateTime endTime = calculateNextEndTime(currentTime, movie);
            if (isTheaterClosed(endTime, theater)) break;

            addScreening(theater, movie, currentTime, endTime);
            currentTime = calculateNextStartTime(endTime);
            index = calculateNextIndex(index, movies);
        }
    }

    private LocalDateTime calculateNextEndTime(
        LocalDateTime currentTime,
        Movie movie
    ) {
        int screeningTime = movie.getScreeningTime();
        return currentTime.plusMinutes(screeningTime);
    }

    private boolean isTheaterClosed(
        LocalDateTime endTime,
        Theater theater
    ) {
        LocalTime screeningEndTime = endTime.toLocalTime();
        LocalTime operatingEndTime = theater.getCloseTime().toLocalTime();

        return screeningEndTime.isAfter(operatingEndTime);
    }

    private LocalDateTime calculateNextStartTime(LocalDateTime endTime) {
        return endTime.plusMinutes(CLEANING_TIME);
    }

    private int calculateNextIndex(
        int index,
        List<Movie> movies
    ) {
        return (index + 1) % movies.size();
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
