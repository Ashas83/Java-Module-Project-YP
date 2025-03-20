// Класс, в котором хранятся параметры!

public class Car {
    private String name;
    private double speed; // Тип изменен на double

    public Car(String name, double speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

}