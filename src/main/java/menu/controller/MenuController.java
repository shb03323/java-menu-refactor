package menu.controller;

import menu.domain.Coach;
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
    }

    private void initMenus() {
        MenuMaker menuMaker = new MenuMaker(menuRepository);
        menuMaker.makeMenus();
    }

    private void addCoaches() {
        try {
            List<String> coachesName = InputView.inputCoachesName();
            coachesName.forEach(coachName -> coachRepository.addCoach(new Coach(coachName)));
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            addCoaches();
        }
    }
}
