package user;

import fixture.UserFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {
    private User user;
    UserFixture userFixture = new UserFixture();

    @BeforeEach
    public void setUp() {
        user = userFixture.getUser();
    }

    @Test
    void 사용자의_보유_포인트를_조회한다() {
        assertThat(user.getPoint()).isEqualTo(10_000);
    }

    @Test
    void 사용하고자_하는_포인트의_금액이_보유한_포인트보다_적으면_포인트를_사용할_수_있다() {
        user.usePoint(3_000);

        assertThat(user.getPoint()).isEqualTo(7_000);
    }

    @Test
    void 사용하고자_하는_포인트의_금액이_보유한_포인트보다_크면_예외를_던진다() {
        assertThatThrownBy(() -> user.usePoint(13_000))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("보유한 포인트보다 많이 사용할 수 없습니다.");
    }
}
