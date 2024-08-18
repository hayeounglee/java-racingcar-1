package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    public static final String CAR_NAME_PROMPT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String NAME_VALIDATION_ERROR = "이름은 " + MAX_CAR_NAME_LENGTH + "자를 초과하거나 공백이거나 null 일 수 없습니다.";
    public static final String TRY_COUNT_PROMPT = "시도할 회수는 몇회인가요?";
    public static final String TRY_COUNT_ERROR = "0이하는 입력할 수 없습니다.";
    private Scanner scanner = new Scanner(System.in);

    public List<String> getCarNames(){
        while (true) {
            System.out.println(CAR_NAME_PROMPT);

            String input = scanner.nextLine();
            List<String> carNames = Arrays.asList(input.split(","));

            if (isValidName(carNames)) return carNames;
        }
    }

    private boolean isValidName(List<String> carNames){
        for(String name : carNames){
            if(name.length() > MAX_CAR_NAME_LENGTH || name.trim().isEmpty() || name.length() == 0) {
                System.out.println(NAME_VALIDATION_ERROR);
                return false;
            }
        }
        return true;
    }

    public int getTryCount(){
        while(true) {
            System.out.println(TRY_COUNT_PROMPT);
            int tryCount = scanner.nextInt();
            if(tryCount > 0) return tryCount;
            System.out.println(TRY_COUNT_ERROR);
        }
    }
}
