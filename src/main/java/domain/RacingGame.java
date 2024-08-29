package domain;

import strategy.NumberGenerator;
import strategy.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {
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
            playOneRound();
        }
    }

    private void playOneRound() {
        for (int i = 0; i < racingCars.size(); i++) {
            int number = numberGenerator.generate();
            if ((Car.isMovable(number))) {
                racingCars.get(i).incrementDistance();
            }
        }
    }

    public List<Car> getRacingCars() {
        return List.copyOf(racingCars);
    }

    public List<String> getWinners() {
        int maxDistance = findMaxDistance();
        List<String> winners = racingCars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.toList());

        return List.copyOf(winners);
    }

    private int findMaxDistance() {
        return racingCars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }
}