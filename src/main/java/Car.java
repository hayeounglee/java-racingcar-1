public class Car {
    private String name;
    private int distance;

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

    public void setDistance(){
        this.distance = this.distance + 1;
    }
}
