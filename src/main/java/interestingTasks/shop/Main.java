package interestingTasks.shop;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * В магазине есть какие-то товары. Каждый покупать заходит в магазин что-то купить. Задача:
 * Создать список товаров с ценами. Создать список покупателей. Покупатели рандомно покупают товары.
 * Вывести всех покупателей и купленные им товары.
 * Дополнительно1: создать чек каждому покупателю (товар – цена, вся сумма)
 * Дополнительно2: в магазине хранится ограниченное кол-во товара (например каждого по 100), вывести на экран товары которых
 *      после всех покупок осталось меньше 10
 * ================================================================================
 * ================================================================================
 *
 *
 * В общем логика здесь сложноватая.. есть продукты, магазин и клиент.
 * Продукты - имеют имя, кол-во и цену. Но сравнение работает только по имени.. и это важно.
 *
 * Заполняем магазин продуктами, "запускаем" 3х покупцев (нити) и они скупают там.. у каждого из
 * них есть определенное кол-во денег, на которое они могут купить. Если денег хвататет и есть такое кол-во -
 * они его покупает, если чего-то не хватает.. то покупает то, что может или на сколько может.
 *
 * В общем, программа довольно сложная и тут много чего можно менять)
 */

public class Main {

    private static List<Costumer> costumers = new ArrayList<>();

    static {
        Product milk = new Product("Молоко", 21);
        Product meat = new Product("Мясо", 43);
        Product water = new Product("Вода", 16);
        Product rice = new Product("Рис", 37);
        Product beer = new Product("Пиво", 9);
        Product apple = new Product("Яблоко", 32);
        Shop.getInstance().addProducts(milk, meat, water, rice, beer, apple);
    }
    public static void main(String[] args) throws InterruptedException {
        Shop shop = Shop.getInstance();

        // создаем хомячков
        Collections.addAll(costumers,
                new Costumer("Петя_1"),
                new Costumer("Petya_2"),
                new Costumer("Petya_Angli4anin_3"));

        // запускаем хомячков
        costumers.forEach(Costumer::start);

        // даем им время уничтожить магазин
        Thread.sleep(3000);
        costumers.forEach(Costumer::interrupt);

        // собираем статистику
        System.out.println("=============================================\n\n");
        System.out.println("В магазине " + shop.getName() + " осталось товаров:");
        shop.getProducts().forEach(System.out::println);
        System.out.println("\nТоваров меньше 10шт:");
        shop.getProducts().stream().filter(x -> x.getAmount() < 10).forEach(System.out::println);

        System.out.println("\nСтатистика по клиентам:");
        costumers.forEach(System.out::println);
    }
}
