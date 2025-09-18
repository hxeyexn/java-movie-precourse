package fixture;

import user.User;

public class UserFixture {
    public User getUser() {
        return new User(0L, "혜연", 10_000);
    }
}
