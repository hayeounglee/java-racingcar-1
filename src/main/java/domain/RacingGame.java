package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {
    private static final int RANDOM_BOUND = 10;
    private static final int MOVE_THRESHOLD = 4;
    private static final Random random = new Random();
    private List<Car> racingCars;
    private int tryCount;

    public RacingGame(List<String> carNames, int tryCount) {
        this.racingCars = createRacingCars(carNames);
        this.tryCount = tryCount;
    }

    private List<Car> createRacingCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void playGame() {
        while (tryCount-- > 0) {
            playOneRound(racingCars);
        }
    }

    private void playOneRound(List<Car> racingCars) {
        for (int i = 0; i < racingCars.size(); i++) {
            int randomInt = random.nextInt(RANDOM_BOUND);
            if ((isMovable(randomInt))) {
                racingCars.get(i).incrementDistance();
            }
        }
    }

    public static boolean isMovable(int randomInt) {
        return randomInt >= MOVE_THRESHOLD;
    }

    public List<Car> getRacingCars() {
        return List.copyOf(racingCars);
    }

    public static List<String> getWinners(List<Car> racingCars) {
        int maxDistance = findMaxDistance(racingCars);
        return racingCars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private static int findMaxDistance(List<Car> racingCars) {
        return racingCars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }
}