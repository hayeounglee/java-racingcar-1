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
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        car1.incrementDistance();
        car2.incrementDistance();
        car2.incrementDistance();
        car3.incrementDistance();
        car3.incrementDistance();
        car3.incrementDistance();

        List<Car> winners = Arrays.asList(car1, car2, car3);

        List<String> expectedWinners = Arrays.asList("car3");

        assertEquals(RacingGame.getWinners(winners), expectedWinners);
    }

    @Test
    @DisplayName("동점일 때 모든 자동차를 출력한다")
    void testEqualWinners(){
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        List<Car> winners = Arrays.asList(car1, car2, car3);

        List<String> expectedWinners = Arrays.asList("car1", "car2", "car3");

        assertEquals(RacingGame.getWinners(winners), expectedWinners);
    }

    @Test
    @DisplayName("자동차 이름이 whiteSpace 일 때 재입력을 요구한다")
    void testShortName(){
        InputView inputview = new InputView();
        String input = "car1, ,car2\ncar1,car3,car4\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        inputview.getCarNames();

        String output = outContent.toString();
        assertTrue(output.contains(inputview.CAR_NAME_PROMPT));
        assertTrue(output.contains(inputview.NAME_VALIDATION_ERROR));
    }

    @Test
    @DisplayName("자동차 이름이 null 일 때 재입력을 요구한다")
    void testNullName(){
        InputView inputview = new InputView();
        String input = "car1,,car2\ncar1,car3,car4\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        inputview.getCarNames();

        String output = outContent.toString();
        assertTrue(output.contains(inputview.CAR_NAME_PROMPT));
        assertTrue(output.contains(inputview.NAME_VALIDATION_ERROR));
    }

    @Test
    @DisplayName("자동차 이름이 6자일 때 재입력을 요구한다")
    void testLongName(){
        InputView inputview = new InputView();
        String input = "car1,hippo22\ncar1,car3,car4\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        inputview.getCarNames();

        String output = outContent.toString();
        assertTrue(output.contains(inputview.CAR_NAME_PROMPT));
        assertTrue(output.contains(inputview.NAME_VALIDATION_ERROR));
    }

    @Test
    @DisplayName("시도 회수가 0이하일 때 재입력을 요구한다.")
    void testTryCount(){
        InputView inputview = new InputView();

        String input = "0\n1\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        inputview.getTryCount();

        String output = outContent.toString();
        assertTrue(output.contains(inputview.TRY_COUNT_ERROR));
    }


}
