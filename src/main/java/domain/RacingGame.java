package domain;

import strategy.NumberGenerator;
import strategy.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {
    private final int RANDOM_BOUND = 10;
    private final NumberGenerator numberGenerator;
    private final List<Car> racingCars;
    private int tryCount;

    public RacingGame(NumberGenerator numberGenerator, List<String> carNames, int tryCount) {
        this.numberGenerator = numberGenerator;
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
            int number = numberGenerator.generator();
            if ((Car.isMovable(number))) {
                racingCars.get(i).incrementDistance();
            }
        }
    }

    public List<Car> getRacingCars() {
        return List.copyOf(racingCars);
    }

    public static List<String> getWinners(List<Car> racingCars) {
        int maxDistance = findMaxDistance(racingCars);
        List<String> winners = racingCars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.toList());

        return List.copyOf(winners);
    }

    private static int findMaxDistance(List<Car> racingCars) {
        return racingCars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }
}