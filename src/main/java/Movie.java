public class Movie {
    int id;
    String title;
    ScreeningPeriod screeningPeriod;
    int screeningTime;

    public boolean isValidTitle(String title) {
        if (!isEquals(title)) {
            throw new IllegalArgumentException("영화 제목이 올바르지 않습니다.");
        }
        return true;
    }

    private boolean isEquals(String title) {
        return title.equals(this.title);
    }

    public Movie(
        int id,
        String title,
        ScreeningPeriod screeningPeriod,
        int screeningTime
    ) {
        this.id = id;
        this.title = title;
        this.screeningPeriod = screeningPeriod;
        this.screeningTime = screeningTime;
    }
}
