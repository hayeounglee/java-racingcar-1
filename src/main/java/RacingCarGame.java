import java.util.Scanner;

public class RacingCarGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        String[] parts = input.split(",");

        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = scanner.nextInt();

        String car1 = parts[0];
        String car2 = parts[1];
        String car3 = parts[2];

        Car carObj1 = new Car();
        Car carObj2 = new Car();
        Car carObj3 = new Car();

        while(tryCount-->0){

        }



        System.out.print(car1+':');
        while(true){
            if(carObj1.distance-- <= 0){
                break;
            }
            System.out.print('-');
        }

    }
}