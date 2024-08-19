package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String CAR_NAME_PROMPT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_COUNT_PROMPT = "시도할 회수는 몇 회인가요?";

    private Scanner scanner = new Scanner(System.in);

    public List<String> getCarNames() {
        System.out.println(CAR_NAME_PROMPT);

        String input = scanner.nextLine();
        return Arrays.asList(input.split(","));
    }

    public int getTryCount() {
        while (true) {
            System.out.println(TRY_COUNT_PROMPT);
            int tryCount = scanner.nextInt();
            if (tryCount > 0) {
                return tryCount;
            }
        }
    }
}
