package domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.strategy.FixedNumberGenerator;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @DisplayName("RacingGame 의 한 라운드 실행 시, 4 이상의 숫자일 때만 자동차가 전진한다")
    @Test
    void playOneRound() {
        // given
        final FixedNumberGenerator numberGenerator = new FixedNumberGenerator(new ArrayList<>(List.of(3, 6)));
        final RacingGame racingGame = new RacingGame(numberGenerator, List.of("car1", "car2"), 1);

        // when
        racingGame.playGame();

        // then
        final List<Car> cars = racingGame.getRacingCars();
        assertThat(cars.get(0).getDistance()).isEqualTo(0);
        assertThat(cars.get(1).getDistance()).isEqualTo(1);
    }
}
