package interestingTasks.shop;

import java.util.List;
import java.util.SplittableRandom;

public class Costumer extends Thread {
    private static SplittableRandom random = new SplittableRandom();
    private int bill;
    private int money;

    // конструтор
    public Costumer(String name) {
        this(name, random.nextInt(2000, 5000));
    }

    public Costumer(String name, int money) {
        super(name);
        this.money = money;
    }

    // геттеры и сетторы
    public int getMoney() {
        return money;
    }

    // методы
    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(random.nextInt(100, 200)); // им же нужно подумать
                if (checkMoney()) return;
                buy();
            }
        } catch (Exception e) {

        }
    }

    private boolean checkMoney() {
        if (money < 10) {
            System.out.println(getName() + " уже скупился на все деньги и уходит из магазина");
            return true;
        }
        return false;
    }

    private void buy() {
        Shop shop = Shop.getInstance();
        List<Product> presentProducts = shop.getPresentProducts();
        if (presentProducts.size() == 0) {
            System.out.println("Продукты закончились, " + getName() + " уходит из магазина");
            interrupt();
        }
        int index = random.nextInt(100) % presentProducts.size();
        int amount = random.nextInt(2,12);

        Product product = presentProducts.get(index);

        shop.buy(this, product, amount);
    }

    public void withdraw (int amount) {
        if (money > amount) {
            money -= amount;
            bill += amount;
        } else {
            money = 0;
        }
    }


    @Override
    public String toString() {
        return String.format("%s: осталось денег %d, купил на %d", getName(), money, bill);
    }
}
