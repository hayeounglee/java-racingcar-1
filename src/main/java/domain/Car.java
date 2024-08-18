package domain;

public class Car {
    private String name;
    private int distance;
    private static final int MOVE_THRESHOLD = 4;

    public Car(String name){
        this.name = name;
        this.distance = 0;
    }

    public String getName(){
        return name;
    }

    public int getDistance(){
        return distance;
    }

    public static boolean isMovable(int randomInt) {
        return randomInt >= MOVE_THRESHOLD;
    }

    public void incrementDistance(){
        this.distance = this.distance + 1;
    }
}
