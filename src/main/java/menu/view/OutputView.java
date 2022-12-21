package menu.view;

import menu.domain.Category;
import menu.domain.Days;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String PARTITION = " | ";
    private static final String OPEN_BRACKET = "[ ";
    private static final String CLOSE_BRACKET = " ]";
    private static final String DIVISION = "구분";
    private static final String CATEGORY = "카테고리";

    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String MENU_RECOMMEND_RESULT_MESSAGE = "메뉴 추천 결과입니다.";

    public static void printErrorMessage(String message) {
        System.out.println(message);
        System.out.println();
    }

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
        System.out.println();
    }

    public static void printResult(List<String> recommendCategories, Map<String, List<String>> recommendMenus) {
        System.out.println(MENU_RECOMMEND_RESULT_MESSAGE);
        printDays();
        printRecommendCategories(recommendCategories);
        recommendMenus.keySet()
                .forEach(coachName -> printRecommendMenus(coachName, recommendMenus.get(coachName)));
        System.out.println();
        printRecommendFinish();
    }

    private static void printDays() {
        System.out.print(OPEN_BRACKET + DIVISION);
        Arrays.stream(Days.values())
                .forEach(day -> System.out.print(PARTITION + day.getDayName()));
        System.out.println(CLOSE_BRACKET);
    }

    private static void printRecommendCategories(List<String> recommendCategories) {
        System.out.print(OPEN_BRACKET + CATEGORY);
        recommendCategories.forEach(recommendCategory -> System.out.print(PARTITION + recommendCategory));
        System.out.println(CLOSE_BRACKET);
    }

    private static void printRecommendMenus(String coachName, List<String> recommendMenusName) {
        System.out.print(OPEN_BRACKET + coachName);
        recommendMenusName.forEach(menuName -> System.out.print(PARTITION + menuName));
        System.out.println(CLOSE_BRACKET);
    }

    private static void printRecommendFinish() {
        System.out.println("추천을 완료했습니다.");
    }
}
