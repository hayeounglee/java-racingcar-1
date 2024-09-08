package domain;

import strategy.NumberGenerator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    public static final String TRY_COUNT_ERROR = "0이하는 입력할 수 없습니다.";
    private final NumberGenerator numberGenerator;
    private final List<Car> racingCars;
    private int tryCount;

    public RacingGame(NumberGenerator numberGenerator, List<String> carNames, int tryCount) {
        validateTryCount(tryCount);
        this.numberGenerator = numberGenerator;
        this.racingCars = createRacingCars(carNames);
        this.tryCount = tryCount;
    }

    private void validateTryCount(int tryCount){
        if (tryCount <= 0){
            throw new IllegalArgumentException(TRY_COUNT_ERROR);
        }
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
        racingCars.stream()
                .filter(car -> Car.isMovable(numberGenerator.generate()))
                .forEach(Car::incrementDistance);
    }

    private int findMaxDistance() {
        return racingCars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
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
        return winners;
    }
}