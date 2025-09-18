package screening;

import movie.Movie;
import theater.Theater;

import java.time.LocalTime;

public class Screening {
    private Movie movie;
    private Theater theater;
    private ScreeningTime time;

    public Screening(
        Movie movie,
        Theater theater,
        ScreeningTime time
    ) {
        this.movie = movie;
        this.theater = theater;
        this.time = time;
    }

    public Movie getMovie() {
        return movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public ScreeningTime getTime() {
        return time;
    }

    public LocalTime getStartTime() {
        return time.start;
    }

    public LocalTime getEndTime() {
        return time.end;
    }

    public boolean overlapsWith(Screening screening) {
        return this.getStartTime().isBefore(screening.getEndTime()) &&
            this.getEndTime().isAfter(screening.getStartTime());
    }
}
