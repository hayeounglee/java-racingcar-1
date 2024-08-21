package Domain;

import domain.Car;
import domain.RacingGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import strategy.FixedNumberGenerator;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class RacingGameTest {
    @Test
    @DisplayName("RacingGame 한 라운드 실행 시, 숫자가 4 이상일 때만 자동차가 전진한다")
    void moveWhenNumberIs_GreaterThanFour(){
        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator(List.of(3,4));
        RacingGame racingGame = new RacingGame(fixedNumberGenerator, List.of("car1", "car2"), 1);

        racingGame.playGame();

        List<Car> racingCars = racingGame.getRacingCars();
        assertEquals(racingCars.get(0).getDistance(), 0);
        assertEquals(racingCars.get(1).getDistance(), 1);
    }

}
