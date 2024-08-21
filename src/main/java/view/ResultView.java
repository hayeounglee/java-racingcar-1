package view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import domain.Car;
import domain.RacingGame;

public class ResultView {
    public void printResult(RacingGame racingGame) {
        System.out.println("실행 결과");
        for (int i = 0; i < racingGame.getRacingCars().size(); i++) {
            printDistance(racingGame.getRacingCars().get(i));
        }

        List<String> winners = racingGame.getWinners();
        System.out.println(String.join(",", winners + "가 최종 우승했습니다."));
    }

    private void printDistance(Car car) {
        int distance = car.getDistance();

        System.out.print(car.getName() + ':');
        String distanceResult = "-".repeat(distance);
        System.out.println(distanceResult);
    }

}
