package menu.controller;

import menu.domain.repository.MenuRepository;
import menu.domain.service.MenuMaker;

public class MenuController {

    private final MenuRepository menuRepository;

    public MenuController() {
        this.menuRepository = new MenuRepository();
        initMenus();
    }

    private void initMenus() {
        MenuMaker menuMaker = new MenuMaker(menuRepository);
        menuMaker.makeMenus();
    }
}
