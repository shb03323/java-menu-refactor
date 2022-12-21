package menu.domain;

public class Menu {

    private final String menuName;
    private final Category category;

    public Menu(String menuName, Category category) {
        this.menuName = menuName;
        this.category = category;
    }

    public boolean nameOf(String menuName) {
        return this.menuName.equals(menuName);
    }

    public boolean categoryOf(Category category) {
        return this.category.equals(category);
    }

    public String getMenuName() {
        return menuName;
    }
}
