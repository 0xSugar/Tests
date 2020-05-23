package interestingTasks.avia;

public class Passenger {
    private String name;
    private City city;

    // конструктор
    public Passenger(String name) {     // я решил не лепить в одну строку, что бы глаза из зерниц не повылазили
        this(name, getRandomCity());
    }
    public Passenger(String name, City city) {
        this.name = name;
        this.city = city;
    }

    // геттеры и сетторы
    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    // методы
    private static City getRandomCity() {
        int idOfCity = (int) (Math.random() * 100) % City.values().length;
        City[] cities = City.values();
        return cities[idOfCity];
    }
}
