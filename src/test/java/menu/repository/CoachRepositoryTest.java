package menu.repository;

import menu.domain.repository.CoachRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CoachRepositoryTest {

    private CoachRepository coachRepository;

    @BeforeEach
    void setUp() {
        coachRepository = new CoachRepository();
    }

    private static Stream<Arguments> generateCoachesNameData() {
        return Stream.of(
                Arguments.of(List.of("후니")),
                Arguments.of(List.of("후니", "포비", "쥬니", "레아", "지우", "루피"))
        );
    }

    @ParameterizedTest
    @MethodSource("generateCoachesNameData")
    void 코치_명수_예외_처리_테스트(List<String> coachesName) {
        assertThatThrownBy(() -> coachRepository.addCoaches(coachesName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 코치_이름_중복_예외_처리_테스트() {
        List<String> coachesName = List.of("혜수", "지윤", "혜수", "정훈");
        assertThatThrownBy(() -> coachRepository.addCoaches(coachesName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
