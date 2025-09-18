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

    public void usePoint(int amount) {
        if (amount > point) {
            throw new IllegalArgumentException("보유한 포인트보다 많이 사용할 수 없습니다.");
        }
        point -= amount;
    }

    public int getPoint() {
        return point;
    }
}
