package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static menu.constant.CoachConstant.COACH_NAME_MAX_LENGTH;
import static menu.constant.CoachConstant.COACH_NAME_MIN_LENGTH;
import static menu.constant.SystemConstant.ERROR_PREFIX;

public class Coach {

    private final String coachName;
    private final List<Menu> dislikeMenus = new ArrayList<>();

    public Coach(String coachName) {
        validateCoachNameLength(coachName);
        this.coachName = coachName;
    }

    public void addDislikeMenus(List<Menu> dislikeMenus) {
        validateSameDislikeMenu(dislikeMenus);
        this.dislikeMenus.addAll(dislikeMenus);
    }

    public String getCoachName() {
        return coachName;
    }

    public boolean isSameName(String coachName) {
        return this.coachName.equals(coachName);
    }

    private void validateCoachNameLength(String coachName) {
        if (coachName.length() > COACH_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ERROR_PREFIX + "코치의 이름은 최대 4글자 입니다.");
        }
        if (coachName.length() < COACH_NAME_MIN_LENGTH) {
            throw new IllegalArgumentException(ERROR_PREFIX + "코치의 이름은 최소 2글자 입니다.");
        }
    }

    private void validateSameDislikeMenu(List<Menu> menus) {
        List<Menu> distinctMenus = menus.stream()
                .distinct()
                .collect(Collectors.toUnmodifiableList());
        if (distinctMenus.size() < menus.size()) {
            throw new IllegalArgumentException(ERROR_PREFIX + "메뉴 이름을 중복으로 입력하셨습니다.");
        }
    }
}
