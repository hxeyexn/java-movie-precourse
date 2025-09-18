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
        validateNoOverlap(screenings);
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

    private void validateNoOverlap(List<Screening> screenings) {
        int size = screenings.size();

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                validatePair(screenings.get(i), screenings.get(j));
            }
        }
    }

    private void validatePair(
        Screening firstScreening,
        Screening secondScreening
    ) {
        if (firstScreening.overlapsWith(secondScreening)) {
            throw new IllegalArgumentException("시간이 겹치는 상영은 함께 예매가 불가능합니다.");
        }
    }

    public List<Screening> get() {
        return screenings;
    }
}
