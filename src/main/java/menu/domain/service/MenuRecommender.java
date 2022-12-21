package menu.domain.service;

import menu.domain.Category;
import menu.domain.CategoryGenerator;
import menu.domain.repository.CategoryRepository;

public class MenuRecommender {

    private final CategoryGenerator categoryGenerator;
    private final CategoryRepository categoryRepository;

    public MenuRecommender(CategoryGenerator categoryGenerator, CategoryRepository categoryRepository) {
        this.categoryGenerator = categoryGenerator;
        this.categoryRepository = categoryRepository;
    }

    public void recommend() {
        while (categoryRepository.isNotLastDay()) {
            Category category = recommendCategory();
        }
    }

    public Category recommendCategory() {
        Category category;
        do {
            category = categoryGenerator.generate();
        } while (categoryRepository.isAvailableCategory(category));
        categoryRepository.addTodayCategory(category);
        return category;
    }

}
