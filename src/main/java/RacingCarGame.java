import java.util.Random;
import java.util.Scanner;

public class RacingCarGame {

    static void printDistance(Car car){
        System.out.print(car.name+':');
        while(true){
            if(car.distance-- <= 0){
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

//    static int findmax(){
//
//    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        String[] parts = input.split(",");

        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = scanner.nextInt();


        Car[] car = {
            new Car(parts[0]),
            new Car(parts[1]),
            new Car(parts[2])
        };

        while(tryCount-->0){
            if(randomMethod()){car[0].distance++;}
            if(randomMethod()){car[1].distance++;}
            if(randomMethod()){car[2].distance++;}
        }

        System.out.println("실행 결과");
        printDistance(car[0]);
        printDistance(car[1]);
        printDistance(car[2]);


        System.out.println("가 최종 우승했습니다.");

    }
}