package menu.repository;

import menu.domain.Category;
import menu.domain.Menu;
import menu.domain.repository.MenuRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MenuRepositoryTest {

    private MenuRepository menuRepository;

    @BeforeEach
    void setUp() {
        menuRepository = new MenuRepository();
    }

    @Test
    void 메뉴가_잘_추가되는지_확인() {
        Menu menu1 = new Menu("쌀국수", Category.ASIAN);
        Menu menu2 = new Menu("하이라이스", Category.JAPANESE);
        menuRepository.addMenu(menu1);
        menuRepository.addMenu(menu2);

        assertThat(menuRepository.findByName("쌀국수")).isEqualTo(menu1);
        assertThat(menuRepository.findByName("하이라이스")).isEqualTo(menu2);
    }

    @Test
    void 메뉴_이름에서_객체로_바뀌는지_확인() {
        Menu menu = new Menu("쌀국수", Category.ASIAN);
        menuRepository.addMenu(menu);
        List<String> menuNames = List.of("쌀국수");

        assertThat(menuRepository.changeMenuNamesToMenus(menuNames).get(0))
                .isEqualTo(menu);
    }

    @Test
    void 카테고리별_메뉴를_제대로_추출하는지_확인() {
        Category category = Category.KOREAN;
        menuRepository.findMenuNamesByCategory(category)
                .forEach(menuName -> {
                    Menu menu = menuRepository.findByName(menuName);
                    assertTrue(menu.categoryOf(category));
                });
    }
}
