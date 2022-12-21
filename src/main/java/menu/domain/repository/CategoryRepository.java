package menu.domain.repository;

import menu.domain.Category;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static menu.constant.RecommendConstant.DAY_COUNT;

public class CategoryRepository {

    private final List<Category> dailyCategories = new ArrayList<>();

    public void addTodayCategory(Category category) {
        dailyCategories.add(category);
    }

    public boolean isAvailableCategory(Category category) {
        int sameCategoryCount = Collections.frequency(dailyCategories, category);
        return sameCategoryCount < 2;
    }

    public boolean isNotLastDay() {
        return dailyCategories.size() != DAY_COUNT;
    }
}
