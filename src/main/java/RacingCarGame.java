import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.List;

public class RacingCarGame {
    private static final int RANDOM_BOUND = 10;
    private static final int MOVE_THRESHOLD = 4;
    private static final Random random = new Random();

    private static void playOneRound(List<Car> racingCars){
        for (int i = 0; i < racingCars.size(); i++) {
            if ((isMovable())) racingCars.get(i).incrementDistance();

        }
    }

    private static void playGame(List<Car> racingCars, int tryCount) {
        while (tryCount-- > 0) {
            playOneRound(racingCars);
        }
        printResult(racingCars);
    }

    private static void printResult(List<Car> racingCars) {
        System.out.println("실행 결과");
        for (int i = 0; i < racingCars.size(); i++) {
            printDistance(racingCars.get(i));
        }

        List<String> winners = getWinners(racingCars);
        System.out.println(String.join(",", winners) + "가 최종 우승했습니다.");
    }

    private static List<String> getWinners(List<Car> racingCars) {
        List<String> winners = new ArrayList<>();

        int maxDistance = findMaxDistance(racingCars);
        for (Car car : racingCars) {
            addWinner(winners, car, maxDistance);
        }
        return winners;
    }

    private static int findMaxDistance(List<Car> racingCars){
        int maxDistance = -1;
        for (Car car : racingCars) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }
        return maxDistance;
    }

    private static List<String> addWinner(List<String> winners, Car car, int maxDistance){
        if (car.getDistance() == maxDistance) {
            winners.add(car.getName());
        }
        return winners;
    }

    private static void printDistance(Car car) {
        System.out.print(car.getName() + ':');
        int distance = car.getDistance();

        while (distance > 0) {
            System.out.print('-');
            distance--;
        }
        System.out.println();
    }

    private static boolean isMovable() {
        int randomInt = random.nextInt(RANDOM_BOUND);
        return randomInt >= MOVE_THRESHOLD;
    }

    private static List<Car> createRacingCars(List<String> carNames){
        List<Car> racingCars = new ArrayList<>();
        for (int i = 0; i < carNames.size(); i++) {
            racingCars.add(new Car(carNames.get(i)));
        }
        return racingCars;
    }

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        final var carNames = InputView.getCarNames();
        final var tryCount = InputView.getTryCount();

        List<Car> racingCars = createRacingCars(carNames);

        playGame(racingCars, tryCount);
    }
}