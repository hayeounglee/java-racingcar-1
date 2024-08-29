package view;

import java.util.List;
import domain.Car;

public class ResultView {
    public void printResult(List<Car> racingCars, List<String> winners) {
        System.out.println("실행 결과");
        for (int i = 0; i < racingCars.size(); i++) {
            printDistance(racingCars.get(i).getDistance(), racingCars.get(i).getName());
        }
        System.out.println(String.join(",", winners + "가 최종 우승했습니다."));
    }

    private void printDistance(int distance, String name) {
        System.out.print(name + ':');
        String distanceResult = "-".repeat(distance);
        System.out.println(distanceResult);
    }

}
