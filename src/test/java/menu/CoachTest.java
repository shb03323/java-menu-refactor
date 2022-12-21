package menu;

import menu.domain.Coach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoachTest {

    @Test
    void 코치_생성_성공() {
        String coachName = "후니";
        Coach coach = new Coach(coachName);

        assertTrue(coach.isSameName(coachName));
    }

    @ParameterizedTest
    @ValueSource(strings = {"쿠크르삥뽕", "준"})
    void 코치_이름_길이_예외_처리_테스트(String coachName) {
        assertThatThrownBy(() -> new Coach(coachName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
