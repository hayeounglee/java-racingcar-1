import view.InputView;
import view.ResultView;
import domain.RacingGame;

public class RacingMain {
    public static void main(String[] args) {
        InputView inputview = new InputView();
        ResultView resultView = new ResultView();

        final var carNames = inputview.getCarNames();
        final var tryCount = inputview.getTryCount();
        final var racingGame = new RacingGame(carNames, tryCount);

        racingGame.playGame();

        resultView.printResult(racingGame.getRacingCars());
    }
}