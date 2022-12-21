package menu.view;

public class OutputView {

    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";

    public static void printErrorMessage(String message) {
        System.out.println(message);
        System.out.println();
    }

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
        System.out.println();
    }
}
