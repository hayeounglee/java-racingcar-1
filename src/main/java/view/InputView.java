package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static Scanner scanner = new Scanner(System.in);

    public static List<String> getCarNames(){
        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            String input = scanner.nextLine();
            List<String> carNames = new ArrayList<>(Arrays.asList(input.split(",")));

            if (isValidName(carNames)) return carNames;
        }
    }

    private static boolean isValidName(List<String> carNames){
        for(String name : carNames){
            if(name.length() > MAX_CAR_NAME_LENGTH) return false;
        }
        return true;
    }

    public static int getTryCount(){
        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = scanner.nextInt();

        return tryCount;
    }
}
