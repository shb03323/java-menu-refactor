package menu.domain.repository;

import menu.domain.Coach;

import java.util.ArrayList;
import java.util.List;

public class CoachRepository {

    private final List<Coach> coaches = new ArrayList<>();

    public void addCoach(Coach coach) {
        coaches.add(coach);
    }
}
