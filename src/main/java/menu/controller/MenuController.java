package menu.controller;

import menu.domain.repository.MenuRepository;
import menu.domain.service.MenuMaker;
import menu.view.OutputView;

public class MenuController {

    private final MenuRepository menuRepository;

    public MenuController() {
        this.menuRepository = new MenuRepository();
        initMenus();
    }

    public void run() {
        OutputView.printStartMessage();
    }

    private void initMenus() {
        MenuMaker menuMaker = new MenuMaker(menuRepository);
        menuMaker.makeMenus();
    }
}
