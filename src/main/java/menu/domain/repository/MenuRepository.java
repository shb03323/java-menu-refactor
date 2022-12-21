package menu.domain.repository;

import menu.domain.Category;
import menu.domain.Menu;

import java.util.ArrayList;
import java.util.List;

public class MenuRepository {

    private static final List<Menu> menus = new ArrayList<>();

    public static void addMenu(String menuName, Category category) {
        menus.add(new Menu(menuName, category));
    }
}
