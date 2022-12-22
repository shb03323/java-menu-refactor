package menu.repository;

import menu.domain.Category;
import menu.domain.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryRepositoryTest {

    private CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        categoryRepository = new CategoryRepository();
        List.of(Category.ASIAN, Category.CHINESE, Category.ASIAN)
                .forEach(category -> categoryRepository.addTodayCategory(category));
    }

    @Test
    void 같은_카테고리가_주에_3번_이상_나오면_예외_처리_하는지_확인() {
        assertFalse(categoryRepository.isAvailableCategory(Category.ASIAN));
    }

    @Test
    void 추천이_끝났는지_확인하는_메소드가_잘_동작하는지_확인() {
        assertTrue(categoryRepository.isNotLastDay());
    }

    @Test
    void 추천_카테고리_목록의_이름_목록이_제대로_생성되는지_확인() {
        List<String> categoryNames = List.of(
                Category.ASIAN.getCategoryName(),
                Category.CHINESE.getCategoryName(),
                Category.ASIAN.getCategoryName()
        );

        assertEquals(categoryNames, categoryRepository.getRecommendCategoriesName());
    }
}
