package menu.repository;

import menu.domain.Category;
import menu.domain.Menu;
import menu.domain.repository.MenuRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}