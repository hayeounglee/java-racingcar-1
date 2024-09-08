package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static InputView inputView;
    private static final String CAR_NAME_PROMPT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_COUNT_PROMPT = "시도할 회수는 몇회인가요?";
    private final Scanner scanner = new Scanner(System.in);

    private InputView(){
    }

    public static InputView getInstance(){
        if (inputView == null){
            inputView = new InputView();
        }
        return inputView;
    }

    public List<String> getCarNames(){
        System.out.println(CAR_NAME_PROMPT);
        String input = scanner.nextLine();
        return Arrays.asList(input.split(","));
    }

    public int getTryCount(){
        while(true) {
            System.out.println(TRY_COUNT_PROMPT);
            return scanner.nextInt();
        }
    }
}
