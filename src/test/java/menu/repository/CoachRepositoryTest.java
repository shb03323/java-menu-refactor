package menu.repository;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.domain.repository.CoachRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoachRepositoryTest {

    private CoachRepository coachRepository;

    @BeforeEach
    void setUp() {
        coachRepository = new CoachRepository();
    }

    @Test
    void 코치_생성_테스트() {
        coachRepository.addCoaches(List.of("후니", "포비"));
        assertEquals(coachRepository.getCoaches().size(), 2);
    }

    @Test
    void 코치_목록_초기화_테스트() {
        coachRepository.addCoaches(List.of("후니", "포비"));
        coachRepository.clearCoaches();
        assertEquals(coachRepository.getCoaches().size(), 0);
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

    @Test
    void 코치들의_점심_메뉴_추천_목록_제대로_들고오는지_확인() {
        coachRepository.addCoaches(List.of("후니", "건모"));
        Menu menu = new Menu("우아한", Category.KOREAN);
        Coach coach1 = coachRepository.getCoaches().get(0);
        Coach coach2 = coachRepository.getCoaches().get(1);
        coach1.addRecommendMenu(menu);
        coach2.addRecommendMenu(menu);

        Map<String, List<String>> recommendMenusName = new LinkedHashMap<>();
        recommendMenusName.put("후니", coach1.getRecommendMenusName());
        recommendMenusName.put("건모", coach2.getRecommendMenusName());

        assertEquals(coachRepository.getRecommendMenusName(), recommendMenusName);
    }
}
