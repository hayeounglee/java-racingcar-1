import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.List;

public class RacingCarGame {

    public static String[] findMax(Car[] array){
        int maxDistance = -1;
        List<String> winners = new ArrayList<>();

        for(int i = 0; i < array.length; i++){
            if(array[i].distance > maxDistance){
                maxDistance = array[i].distance;
            }
        }

        for(int i = 0; i < array.length; i++){
            if(array[i].distance == maxDistance){
                winners.add(array[i].name);
            }
        }
        String[] rank = winners.toArray(new String[winners.size()]);
        return rank;
    }

    static void printDistance(Car car){
        System.out.print(car.name+':');
        int distance = car.distance;

        while(true){
            if(distance-- <= 0){
                break;
            }
            System.out.print('-');
        }
        System.out.println();
    }
    static boolean randomMethod() {
        Random random = new Random();
        int randomInt = random.nextInt(10);
        if (randomInt >= 4) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        String[] parts = input.split(",");

        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = scanner.nextInt();


        Car[] cars = {
            new Car(parts[0]),
            new Car(parts[1]),
            new Car(parts[2])
        };

        while(tryCount-->0){
            if(randomMethod()){cars[0].distance++;}
            if(randomMethod()){cars[1].distance++;}
            if(randomMethod()){cars[2].distance++;}
        }

        System.out.println("실행 결과");
        printDistance(cars[0]);
        printDistance(cars[1]);
        printDistance(cars[2]);

        String[] rank = findMax(cars);
        // System.out.println(cars[0].distance);

        for (int i=0; i<rank.length; i++){
            System.out.print(rank[i]);
            if(i!=rank.length-1){
                System.out.print(',');
            }
        }

        System.out.println("가 최종 우승했습니다.");

    }
}