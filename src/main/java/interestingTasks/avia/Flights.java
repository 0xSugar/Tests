package interestingTasks.avia;

import java.util.*;

public class Flights {
    private static HashMap<Direction, Integer> directions = new HashMap<>();

    static {                                    // заполняем всеми возможными направлениями
        City[] cities = City.values();          // это нужно, что бы можно было без ошибок и проверок
        for (City city : cities) {              // добавлять +1 перелет.. т.е. берется такой перелет и меняется
            for (City city2 : cities) {         // значение на = значение + 1.. в противном случае нужно делать
                if (city != city2) {            // проверку, есть ли такой элемент в мапе.. потом if и т.д.
                    directions.put(new Direction(city, city2), 0);
                }
            }
        }
    }

    public static void goTo(Passenger passenger) {
        City goToCity = getCity(passenger);    // берем город, где не был
        System.out.printf("Пассажир %s летит из %s в %s %n", passenger.getName(), passenger.getCity(), goToCity);

        // создаем направление
        Direction direction = new Direction(passenger.getCity(), goToCity);
        // обновляем счетчик
        directions.put(direction, directions.get(direction) + 1);
        // присваиваем новые значения
        passenger.setCity(goToCity);
    }

    public static City getCity(Passenger passenger) {
        List<City> cities = new ArrayList<>(Arrays.asList(City.values()));
        cities.remove(passenger.getCity());

        return cities.get((int) (Math.random() * 100) % cities.size());
    }

    public static HashMap<Direction, Integer> getDirections() {
        return directions;
    }

    public static int totalFlights() {
        int total = 0;
        for (Map.Entry<Direction, Integer> entry : directions.entrySet()) {
            total += entry.getValue();
        }
        return total;
    }
}
