package menu.domain.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;
import menu.domain.CategoryGenerator;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.domain.repository.CategoryRepository;
import menu.domain.repository.CoachRepository;
import menu.domain.repository.MenuRepository;

import java.util.List;

public class MenuRecommender {

    private final CategoryGenerator categoryGenerator;
    private final CategoryRepository categoryRepository;
    private final MenuRepository menuRepository;
    private final CoachRepository coachRepository;

    public MenuRecommender(CategoryGenerator categoryGenerator, CategoryRepository categoryRepository,
                           MenuRepository menuRepository, CoachRepository coachRepository) {
        this.categoryGenerator = categoryGenerator;
        this.categoryRepository = categoryRepository;
        this.menuRepository = menuRepository;
        this.coachRepository = coachRepository;
    }

    public void recommend() {
        while (categoryRepository.isNotLastDay()) {
            Category category = recommendCategory();
            coachRepository.getCoaches()
                            .forEach(coach -> recommendMenu(category, coach));
        }
    }

    private Category recommendCategory() {
        Category category;
        do {
            category = categoryGenerator.generate();
        } while (!categoryRepository.isAvailableCategory(category));
        categoryRepository.addTodayCategory(category);
        return category;
    }

    private void recommendMenu(Category category, Coach coach) {
        List<String> menuNames = menuRepository.findMenuNamesByCategory(category);
        Menu menu;
        do {
            String menuName = Randoms.shuffle(menuNames).get(0);
            menu = menuRepository.findByName(menuName);
        } while (coach.isOverlappedMenu(menu));
        coach.addRecommendMenu(menu);
    }
}
