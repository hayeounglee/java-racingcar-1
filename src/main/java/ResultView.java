import java.util.ArrayList;
import java.util.List;

public class ResultView {
    public static void printResult(List<Car> racingCars) {
        System.out.println("실행 결과");
        for (int i = 0; i < racingCars.size(); i++) {
            printDistance(racingCars.get(i));
        }

        List<String> winners = getWinners(racingCars);
        System.out.println(String.join(",", winners) + "가 최종 우승했습니다.");
    }

    private static void printDistance(Car car) {
        System.out.print(car.getName() + ':');
        int distance = car.getDistance();

        while (distance > 0) {
            System.out.print('-');
            distance--;
        }
        System.out.println();
    }

    private static List<String> getWinners(List<Car> racingCars) {
        List<String> winners = new ArrayList<>();

        int maxDistance = findMaxDistance(racingCars);
        for (Car car : racingCars) {
            addWinner(winners, car, maxDistance);
        }
        return winners;
    }

    private static int findMaxDistance(List<Car> racingCars){
        int maxDistance = -1;
        for (Car car : racingCars) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }
        return maxDistance;
    }

    private static void addWinner(List<String> winners, Car car, int maxDistance){
        if (car.getDistance() == maxDistance) {
            winners.add(car.getName());
        }
    }
}
