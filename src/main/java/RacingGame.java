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

    private static List<Car> createRacingCars(List<String> carNames){
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

    private static void playOneRound(List<Car> racingCars){
        for (int i = 0; i < racingCars.size(); i++) {
            if ((isMovable())) racingCars.get(i).incrementDistance();

        }
    }

    private static boolean isMovable() {
        int randomInt = random.nextInt(RANDOM_BOUND);
        return randomInt >= MOVE_THRESHOLD;
    }

   public List<Car> getRacingCars(){
        return racingCars;
   }
}
