import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.List;

public class RacingCarGame {
    private static final int RANDOM_BOUND = 10;
    private static final int MOVE_THRESHOLD = 4;
    private static final Random random = new Random();

    private static void playGame(List<Car> racingCars, int tryCount) {
        int listLength = racingCars.size();
        while (tryCount-- > 0) {
            for (int i = 0; i < listLength; i++) {
                if ((shouldMoveForward())) {
                    racingCars.get(i).incrementDistance();
                }
            }
        }
        printResult(racingCars);
    }

    private static void printResult(List<Car> carList) {
        int listLength = carList.size();

        System.out.println("실행 결과");
        for (int i = 0; i < listLength; i++) {
            printDistance(carList.get(i));
        }

        List<String> rank = findMax(carList);

        for (int i = 0; i < rank.size(); i++) {
            System.out.print(rank.get(i));
            if (i != rank.size() - 1) {
                System.out.print(',');
            }
        }

        System.out.println("가 최종 우승했습니다.");
    }

    public static List<String> findMax(List<Car> array) {
        int maxDistance = -1;
        List<String> winners = new ArrayList<>();

        for (Car car : array) {
            if (car.getDistance() > maxDistance) {
                maxDistance = car.getDistance();
            }
        }

        for (Car car : array) {
            if (car.getDistance() == maxDistance) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public static void printDistance(Car car) {
        System.out.print(car.getName() + ':');
        int distance = car.getDistance();

        while (distance > 0) {
            System.out.print('-');
            distance--;
        }
        System.out.println();
    }

    public static boolean shouldMoveForward() {
        int randomInt = random.nextInt(RANDOM_BOUND);
        return randomInt >= MOVE_THRESHOLD;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        List<String> carNames = new ArrayList<>(Arrays.asList(input.split(",")));

        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = scanner.nextInt();

        int num = carNames.size();
        List<Car> racingCars = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            racingCars.add(new Car(carNames.get(i)));
        }

        playGame(racingCars, tryCount);

    }
}