package menu.controller;

import menu.domain.service.MenuMaker;

public class MenuController {

    public MenuController() {
        initMenus();
    }

    private void initMenus() {
        MenuMaker menuMaker = new MenuMaker();
        menuMaker.makeMenus();
    }
}
