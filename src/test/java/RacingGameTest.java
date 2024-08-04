import domain.Car;
import domain.RacingGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RacingGameTest {
    @Test
    @DisplayName("입력받은 자동차 이름만큼 객체가 생성된다")
    void testCreateRacingCars(){
        List<String> carNames = Arrays.asList("Car1", "Car2", "Car3");
        RacingGame game = new RacingGame(carNames, 3);
        List<Car> racingCars = game.getRacingCars();

        assertEquals("Car1", racingCars.get(0).getName());
        assertEquals("Car2", racingCars.get(1).getName());
        assertEquals("Car3", racingCars.get(2).getName());
    }

    @Test
    @DisplayName("랜덤 숫자 4이상일 때만 전진한다")
    void testMoveForward(){
        List<String> carNames = Arrays.asList("Car1");
        RacingGame game = new RacingGame(carNames, 3);
        assertTrue(game.isMovable(4));
    }

    @Test
    @DisplayName("랜덤 숫자 3이하일 때 멈춘다")
    void testStopMove(){
        List<String> carNames = Arrays.asList("Car2");
        RacingGame game = new RacingGame(carNames, 3);
        assertFalse(game.isMovable(3));
    }

    @Test
    @DisplayName("우승자를 제대로 출력한다")
    void testWinners(){

    }
}
