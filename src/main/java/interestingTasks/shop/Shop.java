package interestingTasks.shop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shop {
    private static Shop shop = new Shop("SuperCheap");
    public static Shop getInstance() {
        return shop;
    }

    // поля
    private String name;
    private final List<Product> products = Collections.synchronizedList(new ArrayList<>());

    // конструктор
    private Shop(String name) {
        this.name = name;
    }

    // геттеры и сетторы
    public String getName() {
        return name;
    }
    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }


    // методы
    public List<Product> getPresentProducts() {     // возвращает список доступных товаров
        List<Product> presentProducts = new ArrayList<>();
        for (Product product: products) {
            if (product.getAmount() > 0) {
                presentProducts.add(product);
            }
        }
        return presentProducts;
    }

    public void addProducts (Product...products) {  // добавляет все продукты
        for (Product product : products) {
            addProduct(product);
        }
    }

    public void addProduct(Product product) {       // добавляет продукт
        if (products.contains(product)) {   // если он уже есть
            updateProduct(product);         // то у него обновляется колличество
        } else {
            products.add(product);          // если нет - добавляется
        }
    }

    private void updateProduct(Product product) {
        int index = products.indexOf(product);          // получаем индекс этого товара
        Product productInTheShop = products.get(index); // получаем этот продукт из листа

        productInTheShop.add(product.getAmount());      // добавляем к нашему продукту колличество с пришедшого
    }

    public void buy(Costumer costumer, Product product, int amount) {   // xDD у меня на экран поместился
        synchronized (products) {
            boolean enoughMoney = costumer.getMoney() >= (product.getPrice() * amount);     // если есть деньги
            boolean enoughProducts = product.getAmount() >= amount;                         // если хватает товара

            if (enoughMoney && enoughProducts) {
                product.minus(amount);              // отнимаем колличество у продукта
                costumer.withdraw(product.getPrice() * amount); // снимаем деньги

                System.out.println(String.format("%s купил %s в колличестве %dшт", costumer.getName(), product.getName(), amount));
            } else if (enoughMoney) {
                // если есть деньги, но нет товара - покупаем что можем:
                int canBuy = product.getAmount();

                product.minus(canBuy);
                costumer.withdraw(canBuy * product.getPrice());

                System.out.println(String.format("Эх, не хватило товара.. зато %s купил %s в колличестве %dшт (вместо %dшт)",
                        costumer.getName(), product.getName(), canBuy, amount));
            } else if (enoughProducts) {
                // если товар есть, а денег не хватает
                int canBuy = 0;
                int money = costumer.getMoney();

                while (true) {      // считаем сколько хомячек может купить товара на свои деньги
                    if (money > product.getPrice()) {
                        money -= product.getPrice();
                        canBuy++;
                    } else {
                        break;
                    }
                }

                product.minus(canBuy);
                costumer.withdraw(canBuy * product.getPrice());
                System.out.println(String.format("Эх, не хватило денег.. зато %s купил %s в колличестве %dшт (вместо %dшт)",
                        costumer.getName(), product.getName(), canBuy, amount));
            } else {
                System.out.println("Вот же неудача, нет ни денег, ни товара");
            }
        }
    }
}
