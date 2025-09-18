package user;

public class User {
    private long id;
    private String name;
    private int point;

    public User(
        long id,
        String name,
        int point
    ) {
        this.id = id;
        this.name = name;
        this.point = point;
    }

    public int getPoint() {
        return point;
    }
}
