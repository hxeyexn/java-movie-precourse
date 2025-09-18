import java.util.ArrayList;
import java.util.List;

public class SelectedScreenings {
    private List<Screening> screenings = new ArrayList<>();

    public SelectedScreenings() {}

    public void update(
        List<Movie> movies,
        List<Screening> screenings
    ) {
        validateMovieScheduled(movies, screenings);
        this.screenings.addAll(screenings);
    }

    private void validateMovieScheduled(
        List<Movie> movies,
        List<Screening> screenings
    ) {
        if (!isAllMoviesScheduled(movies, screenings)) {
            throw new IllegalArgumentException("선택된 모든 영화의 상영 시간이 선택되지 않았습니다.");
        }
    }

    private boolean isAllMoviesScheduled(
        List<Movie> movies,
        List<Screening> screenings
    ) {
        return movies.size() == screenings.size();
    }

    public List<Screening> get() {
        return screenings;
    }
}
