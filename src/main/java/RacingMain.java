import view.InputView;
import view.ResultView;
import domain.RacingGame;

public class RacingMain {
    public static void main(String[] args) {
        final var carNames = InputView.getCarNames();
        final var tryCount = InputView.getTryCount();
        final var racingGame = new RacingGame(carNames, tryCount);

        racingGame.playGame();

        ResultView.printResult(racingGame.getRacingCars());
    }
}