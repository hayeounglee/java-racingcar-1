package view;

import java.util.List;
import domain.Car;

public class ResultView {
    public void printResult(List<Car> racingCars, List<Car> winners) {
        System.out.println("실행 결과");
        racingCars.stream()
                .forEach(car -> printDistance(car.getDistance(), car.getName()));

        System.out.println(String.join(",", winners.stream()
                .map(Car::getName).toArray(String[]::new))
                + "가 최종 우승했습니다.");
    }

    private void printDistance(int distance, String name) {
        System.out.print(name + ':');
        String distanceResult = "-".repeat(distance);
        System.out.println(distanceResult);
    }

}
