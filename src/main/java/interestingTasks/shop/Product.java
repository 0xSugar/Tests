package interestingTasks.shop;

import java.util.Objects;

/**
 * Equals работает только по имени
 */

public class Product {  // у каждого продукта есть имя, цена и кол-во
    private String name;
    private int price;
    private int amount;

    // конструктор
    public Product(String name, int price) {
        this(name, price, 100);
    }

    public Product(String name, int price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    // геттеры и сетторы
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // методы
    public void minus(int amount) {
        if (this.amount >= amount) {
            this.amount -= amount;
        } else {
            this.amount = 0;
        }
    }

    public void add(int amount) {
        this.amount += amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(getName(), product.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return "Product " +
                "name='" + name + '\'' +
                ", amount=" + amount;
    }
}
