import strategy.RandomNumberGenerator;
import view.InputView;
import view.ResultView;
import domain.RacingGame;

import java.util.Random;

public class RacingMain {
    public static void main(String[] args) {
        InputView inputview = new InputView();
        ResultView resultView = new ResultView();

        final var carNames = inputview.getCarNames();
        final var tryCount = inputview.getTryCount();
        final var racingGame = new RacingGame(new RandomNumberGenerator(new Random()), carNames, tryCount);

        racingGame.playGame();

        resultView.printResult(racingGame);
    }
}