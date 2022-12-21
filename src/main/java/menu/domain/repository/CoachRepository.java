package menu.domain.repository;

import menu.domain.Coach;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static menu.constant.CoachConstant.COACH_MAX_COUNT;
import static menu.constant.CoachConstant.COACH_MIN_COUNT;
import static menu.constant.SystemConstant.ERROR_PREFIX;

public class CoachRepository {

    private final List<Coach> coaches = new ArrayList<>();

    public void addCoaches(List<String> coachNames) {
        validateCoachesCount(coachNames);
        coachNames.forEach(coachName -> addCoach(new Coach(coachName)));
    }

    public void clearCoaches() {
        coaches.clear();
    }

    private void addCoach(Coach coach) {
        coaches.add(coach);
    }

    private void validateCoachesCount(List<String> coachNames) {
        if (coachNames.size() > COACH_MAX_COUNT) {
            throw new IllegalArgumentException(ERROR_PREFIX + "코치는 최대 5명까지만 입력 가능합니다.");
        }
        if (coachNames.size() < COACH_MIN_COUNT) {
            throw new IllegalArgumentException(ERROR_PREFIX + "코치는 최소 2명 이상 입력해야 합니다.");
        }
    }
}
