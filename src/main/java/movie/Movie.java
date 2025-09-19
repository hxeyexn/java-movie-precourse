package movie;

import java.util.Objects;

public class Movie {
    private int id;
    private String title;
    private ScreeningPeriod screeningPeriod;
    private int screeningTime;

    public Movie(int id, String title, ScreeningPeriod screeningPeriod, int screeningTime) {
        this.id = id;
        this.title = title;
        this.screeningPeriod = screeningPeriod;
        this.screeningTime = screeningTime;
    }

    public boolean isValidTitle(String title) {
        if (!isEquals(title)) {
            throw new IllegalArgumentException("영화 제목이 올바르지 않습니다.");
        }

        return true;
    }

    private boolean isEquals(String title) {
        return title.equals(this.title);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) return true;
        if (!(object instanceof Movie movie)) return false;

        return id == movie.id &&
            title.equals(movie.title) &&
            screeningPeriod == movie.screeningPeriod &&
            screeningTime == movie.screeningTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, screeningPeriod, screeningTime);
    }

    public String getTitle() {
        return title;
    }

    public int getScreeningTime() {
        return screeningTime;
    }
}
