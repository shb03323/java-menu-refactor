package menu.domain;

public class Menu {

    private final String menuName;
    private final Category category;

    public Menu(String menuName, Category category) {
        this.menuName = menuName;
        this.category = category;
    }

    public boolean isSameName(String menuName) {
        return this.menuName.equals(menuName);
    }
}
