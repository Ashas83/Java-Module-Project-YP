import java.util.ArrayList;

// Класс, в котором рассчитывается и запоминается лидер

public class Race {
    private ArrayList<Car> cars;  // Список автомобилей

    // Конструктор
    public Race(ArrayList<Car> cars) {
        this.cars = cars;
    }

    // Метод для определения автомобилей с наибольшим пройденным расстоянием!
    public ArrayList<Car> getLeaders() {
        ArrayList<Car> leaders = new ArrayList<>();
        double maxDistance = 0;

        for (Car car : cars) {
            double distance = calculateDistance(car);
            if (distance > maxDistance) {
                maxDistance = distance;
                leaders.clear();
                leaders.add(car);
            } else if (distance == maxDistance) {
                leaders.add(car);
            }
        }

        return leaders;
    }

    // Метод для расчета пройденного расстояния
    public double calculateDistance(Car car) {
        return car.getSpeed() * 24; // Расстояние = скорость * время (24 часа)
    }

}