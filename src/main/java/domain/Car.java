package domain;

public class Car {
    private static final int NAME_LENGTH_MAXIMUM = 5;
    private static final int MOVE_THRESHOLD = 4;

    private String name;
    private int distance;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.distance = 0;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 null 이거나 공백일 수 없습니다.");
        }
        if (name.length() > NAME_LENGTH_MAXIMUM) {
            throw new IllegalArgumentException("이름은 " + NAME_LENGTH_MAXIMUM + "자를 초과할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public static boolean isMovable(int randomInt) {
        return randomInt >= MOVE_THRESHOLD;
    }

    public void incrementDistance() {
        this.distance = this.distance + 1;
    }
}

