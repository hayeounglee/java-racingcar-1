import domain.Car;
import domain.RacingGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.Arrays;
import java.util.List;

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
}
