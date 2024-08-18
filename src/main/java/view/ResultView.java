package view;

import java.util.ArrayList;
import java.util.List;
import domain.Car;

public class ResultView {
    public void printResult(List<Car> racingCars) {
        System.out.println("실행 결과");
        for (int i = 0; i < racingCars.size(); i++) {
            printDistance(racingCars.get(i));
        }

        List<String> winners = domain.RacingGame.getWinners(racingCars);
        System.out.println(String.join(",", winners) + "가 최종 우승했습니다.");
    }

    private void printDistance(Car car) {
        int distance = car.getDistance();

        System.out.print(car.getName() + ':');
        String distanceResult = "-".repeat(distance);
        System.out.println(distanceResult);
    }
}
