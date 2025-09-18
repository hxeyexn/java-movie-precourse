package movie;

import java.util.ArrayList;
import java.util.List;

public class SelectedMovies {
    private final List<Movie> movies = new ArrayList<>();

    public SelectedMovies() {}

    public List<Movie> update(
        List<Movie> selectedMovies,
        int totalMovieCount
    ) {
        if (!isValidMinimum(selectedMovies.size())) {
            throw new IllegalArgumentException("영화 수는 1보다 작을 수 없습니다.");
        }
        if (!isValidMaximum(selectedMovies.size(), totalMovieCount)) {
            throw new IllegalArgumentException(String.format("영화 수는 %d보다 클 수 없습니다.", totalMovieCount));
        }

        movies.clear();
        movies.addAll(selectedMovies);
        return movies;
    }

    private boolean isValidMinimum(int selectedCount) {
        return selectedCount >= 1;
    }

    private boolean isValidMaximum(
        int selectedCount,
        int totalCount
    ) {
        return selectedCount <= totalCount;
    }

    public List<Movie> get() {
        return movies;
    }
}
