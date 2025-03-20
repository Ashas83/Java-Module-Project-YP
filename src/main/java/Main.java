import java.util.ArrayList;
import java.util.Scanner;

// Запрашиваем у пользователя 3 автомобиля, каждый из которых имеет два параметра: название и скорость
// После ввода данных пользователем проверяем, что введённая скорость >0 и ⩽250. Если скорость ввели неверно, программа должна запросить эти данные заново.
// После успешного ввода рассчитываем, сколько километров за 24 часа смог проехать каждый участник гонки (автомобиль), и запоминаем лидера.
// Выводим название автомобиля-лидера в консоль в любом понятном формате. Например: Самая быстрая машина: Москвич.
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Создание объекта scanner и передача в него параметра System.in, отвеч. за ввод с клавы
        int counterPut = 0; // Для подсчета количества введенных авто
        int maxAmountPut = 3; // Макс. количесто для ввода
        ArrayList<Car> carsNew = new ArrayList<>();
        ArrayList<Car> updatedCarsNew = new ArrayList<>();

        // Цикл для ввода наименований авто и проверки на корректность ввода
        while (counterPut < maxAmountPut) {
            System.out.print("Введите наименование автомобиля № " + (counterPut + 1) + ": ");
            String userPutName = scanner.nextLine();
            if (isValidCarName(userPutName)) { // Проверка на корректность ввода
                counterPut += 1;
                carsNew.add(new Car(userPutName, 0)); // Скорость пока неизвестна
            } else {
                System.out.println("Ошибка: введено недопустимое значение!");
            }
        }

        // Ввод скоростей автомобилей с проверкой ввода именно числа и диапазона скорости
        for (Car car : carsNew) {
            while (true) { // Цикл для повторного ввода в случае ошибки
                try {
                    System.out.print("Введите скорость автомобиля " + car.getName() + " (км/ч): ");
                    String userPutSpeed = scanner.nextLine(); // Считываем ввод как строку

                    // Пытаемся преобразовать ввод в double
                    double speed = Double.parseDouble(userPutSpeed);

                    // Если преобразование успешно, заполняем новый объект updatedCars
                    if (speed > 0 && speed <=250) {
                        updatedCarsNew.add(new Car(car.getName(), speed));
                        break; // Выход из цикла while
                    } else {
                        System.out.println("Ошибка: скорость должна быть от 0 до 250 км/ч включительно!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: введено не число! Пожалуйста, введите число (можно с десятыми через точку).");
                }
            }
        }

        // Создаем гонку и передаем параметр updatedCars
        Race race = new Race(updatedCarsNew);

        // Определяем лидера
        ArrayList<Car> leaders = race.getLeaders();

        // Выводим результат
        if (leaders.size() == 1) {
            Car leader = leaders.get(0);
            System.out.println("Автомобиль с наибольшим пройденным расстоянием: " + leader.getName());
            System.out.println("Пройденное расстояние: " + race.calculateDistance(leader) + " км");
        } else {
            System.out.println("Автомобили с наибольшим пройденным расстоянием:");
            for (Car leader : leaders) {
                System.out.println(leader.getName() + " - Пройденное расстояние: " + race.calculateDistance(leader) + " км");
            }
        }
    }

    // Метод для проверки того, что строка является корректным именем автомобиля
    public static boolean isValidCarName(String input) {
        // Регулярное выражение: только буквы
        return input != null && input.matches("^[a-zA-Zа-яА-Я]+(?:\\s[a-zA-Zа-яА-Я]+)*$");
    }

}