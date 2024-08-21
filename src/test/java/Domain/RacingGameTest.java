package Domain;

import domain.Car;
import domain.RacingGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputView;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RacingGameTest {
    @Test
    @DisplayName("RacingGame 한 라운드 실행 시, 숫자가 4 이상일 때만 자동차가 전진한다")
    void moveWhenNumberIs_GreaterThanFour(){
        RacingGame racingGame = new RacingGame(List.of("car1, car2"), 1);

        racingGame.playGame();

        List<Car> racingCars = racingGame.getRacingCars();
        assertEquals(racingCars.get(0).getDistance(), 0);
        assertEquals(racingCars.get(1).getDistance(), 1);


    }

}
