package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private static final int RANDOM_BOUND = 10;
    private static final int MOVE_THRESHOLD = 4;
    private static final Random random = new Random();
    private List<Car> racingCars;
    private int tryCount;

    public RacingGame(List<String> carNames, int tryCount){
        this.racingCars = createRacingCars(carNames);
        this.tryCount = tryCount;
    }

    private List<Car> createRacingCars(List<String> carNames){
        List<Car> racingCars = new ArrayList<>();
        for (int i = 0; i < carNames.size(); i++) {
            racingCars.add(new Car(carNames.get(i)));
        }
        return racingCars;
    }

    public void playGame() {
        while (tryCount-- > 0) {
            playOneRound(racingCars);
        }
    }

    private void playOneRound(List<Car> racingCars){
        for (int i = 0; i < racingCars.size(); i++) {
            int randomInt = random.nextInt(RANDOM_BOUND);
            if ((isMovable(randomInt))) racingCars.get(i).incrementDistance();
        }
    }

    public static boolean isMovable(int randomInt) {
        return randomInt >= MOVE_THRESHOLD;
    }

    public List<Car> getRacingCars(){
        return List.copyOf(racingCars);
   }

    public static List<String> getWinners(List<Car> racingCars) {
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

    private static void addWinner(List<String> winners, Car car, int maxDistance){
        if (car.getDistance() == maxDistance) {
            winners.add(car.getName());
        }
    }
}