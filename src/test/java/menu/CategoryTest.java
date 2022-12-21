package menu;

import menu.domain.Category;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CategoryTest {

    @Test
    void 카테고리_검색_테스트() {
        assertThat(Category.from(1)).isEqualTo(Category.JAPANESE);
        assertThat(Category.from(2)).isEqualTo(Category.KOREAN);
        assertThat(Category.from(3)).isEqualTo(Category.CHINESE);
        assertThat(Category.from(4)).isEqualTo(Category.ASIAN);
        assertThat(Category.from(5)).isEqualTo(Category.WESTERN);
    }

    @Test
    void 카테고리_잘못된_검색_예외_처리_하는지_확인() {
        assertThatThrownBy(() -> Category.from(10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
