package menu.controller;

import menu.domain.Coach;
import menu.domain.Menu;
import menu.domain.repository.CoachRepository;
import menu.domain.repository.MenuRepository;
import menu.domain.service.MenuMaker;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class MenuController {

    private final MenuRepository menuRepository;
    private final CoachRepository coachRepository;

    public MenuController() {
        this.menuRepository = new MenuRepository();
        this.coachRepository = new CoachRepository();
        initMenus();
    }

    public void run() {
        OutputView.printStartMessage();
        addCoaches();
        addDislikeMenus();
    }

    private void initMenus() {
        MenuMaker menuMaker = new MenuMaker(menuRepository);
        menuMaker.makeMenus();
    }

    private void addCoaches() {
        try {
            List<String> coachesName = InputView.inputCoachesName();
            coachRepository.addCoaches(coachesName);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            coachRepository.clearCoaches();
            addCoaches();
        }
    }

    private void addDislikeMenus() {
        coachRepository.getCoaches()
                .forEach(this::addDislikeMenusOfOneCoach);
    }

    private void addDislikeMenusOfOneCoach(Coach coach) {
        try {
            List<String> menuNames = InputView.inputDislikeMenusName(coach.getCoachName());
            List<Menu> menus = menuRepository.changeMenuNamesToMenus(menuNames);
            coach.addDislikeMenus(menus);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            addDislikeMenusOfOneCoach(coach);
        }
    }
}
