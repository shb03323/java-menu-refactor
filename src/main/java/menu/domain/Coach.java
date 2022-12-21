package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final String coachName;
    private final List<Menu> dislikeMenus = new ArrayList<>();

    public Coach(String coachName) {
        this.coachName = coachName;
    }

    public boolean isSameName(String coachName) {
        return this.coachName.equals(coachName);
    }
}
