import java.util.ArrayList;

// Класс, в котором рассчитывается и запоминается лидер

public class Race {
    private ArrayList<Car> cars;  // Список автомобилей

    // Конструктор
    public Race(ArrayList<Car> cars) {
        this.cars = cars;
    }

    // Метод для определения автомобиля с наибольшим пройденным расстоянием
    public Car getLeader() {
        Car leader = null;
        double maxDistance = 0;

        for (Car car : cars) {
            double distance = calculateDistance(car);
            if (distance > maxDistance) {
                maxDistance = distance;
                leader = car;
            }
        }

        return leader;
    }

    // Метод для расчета пройденного расстояния
    public double calculateDistance(Car car) {
        return car.getSpeed() * 24; // Расстояние = скорость * время (24 часа)
    }
}
