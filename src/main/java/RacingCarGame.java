import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.List;

public class RacingCarGame {
    private static final int RANDOM_BOUND = 10;
    private static final int THRESHOLD = 4;

    public static boolean isDistanceLeft(int distance){
        if(distance < 0) return false;
        return true;
    }

    public static String[] findMax(Car[] array){
        int maxDistance = -1;
        List<String> winners = new ArrayList<>();

        for(int i = 0; i < array.length; i++){
            if(array[i].getDistance()> maxDistance){
                maxDistance = array[i].getDistance();
            }
        }

        for(int i = 0; i < array.length; i++){
            if(array[i].getDistance() == maxDistance){
                winners.add(array[i].getName());
            }
        }
        String[] rank = winners.toArray(new String[winners.size()]);
        return rank;
    }

    public static void printDistance(Car car){
        System.out.print(car.getName()+':');
        int distance = car.getDistance();

        while(isDistanceLeft(distance)){
            System.out.print('-');
            distance--;
        }
        System.out.println();
    }

    public static boolean isRandomNumberHigh() {

        Random random = new Random();
        int randomInt = random.nextInt(RANDOM_BOUND);
        if (randomInt >= THRESHOLD) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int num = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        String[] carNames = input.split(",");
        num = carNames.length;

        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = scanner.nextInt();

        Car[] storeCars = new Car[num];
        for(int i = 0; i <num; i++){
            storeCars[i] = new Car(carNames[i]);
        }

        while(tryCount-->0){
            for(int i = 0; i <num; i++) {
                if((isRandomNumberHigh())){storeCars[i].setDistance();}
            }
        }

        System.out.println("실행 결과");
        for(int i = 0; i <num; i++) {
            printDistance(storeCars[i]);
        }

        String[] rank = findMax(storeCars);

        for (int i=0; i<rank.length; i++){
            System.out.print(rank[i]);
            if(i!=rank.length-1){
                System.out.print(',');
            }
        }

        System.out.println("가 최종 우승했습니다.");

    }
}