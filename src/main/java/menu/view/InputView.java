package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static final String INPUT_SPLIT_OPTION = ",";
    private static final String INPUT_COACHES_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";

    public static List<String> inputCoachesName() {
        System.out.println(INPUT_COACHES_NAME);
        String input = Console.readLine();
        System.out.println();
        return parseToSplitOption(input);
    }

    private static List<String> parseToSplitOption(String input) {
        return Arrays.stream(input.split(INPUT_SPLIT_OPTION))
                .collect(Collectors.toUnmodifiableList());
    }
}
