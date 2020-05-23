package interestingTasks.shopWithBeer;

import java.util.*;

public class Shop {

    private String name;
    private Map<String, Beer> stocks = new HashMap<>();
    private List<String> beerList = new ArrayList<>();
    private int profit;
    private int totalProfit;


    public Shop(String name) {
        this.name = name;
        stocks.put("Оболонь", new Beer("Оболонь", 13d, 100));
        stocks.put("Львовское", new Beer("Львовское", 15d, 100));
        beerList.addAll(stocks.keySet());
    }

    public Map<String, Beer> getStocks() {
        return Collections.unmodifiableMap(stocks);
    }

    public List<String> getBeerNames() {
        return Collections.unmodifiableList(beerList);
    }

    public void buy(Customer customer, String name, Volume bottle) {
        double sum = stocks.get(name).getPrice() * bottle.valume;
        Beer beer = stocks.get(name);
        if (beer.getAmount() >= bottle.valume) {
            beer.setAmount(beer.getAmount() - bottle.valume);
            profit += sum;
//        System.out.println(String.format("Неизвестный покупатель купил %s %.2f на сумму %.2f", name, bottle.valume, sum));
        } else {
//            System.out.println("Закончилось пиво " + beer.getName());
        }
    }

    public void printData() {
        StringBuilder builder = new StringBuilder();
        double needToBuyAdditional = 0;

        builder.append("Выпито пива:\n");
        for (Map.Entry<String, Beer> entry : stocks.entrySet()) {
            Beer beer = entry.getValue();
            builder.append(" - ");
            double amount = 100 - beer.getAmount();
            builder.append(beer.getName())
                    .append(" ")
                    .append(Math.round(amount))
                    .append("\n");
            needToBuyAdditional += amount * (beer.getPrice() / 2);
        }
        builder.append("Доход составил:\n");
        for (Map.Entry<String, Beer> entry : stocks.entrySet()) {
            builder.append(" - ");
            double profit = ((100 - entry.getValue().getAmount()) * entry.getValue().getPrice());
            builder.append(entry.getKey())
                    .append(" ")
                    .append(Math.round(profit))
                    .append("\n");
        }
        builder.append("Всего: ")
                .append(this.profit)
                .append("\n")
                .append("Необходимо закупить пива на ")
                .append(Math.round(needToBuyAdditional))
                .append("\n");
        System.out.println(builder.toString());
    }

    public void printTotal() {
        System.out.println("Всего было получено: " + totalProfit);
    }

    public void refresh() {
        for (Map.Entry<String, Beer> entry : stocks.entrySet()) {
            Beer beer = entry.getValue();
            beer.setAmount(100d);
        }
        profit = 0;
    }

    public void saveData() {
        totalProfit += profit;
    }

    @Override
    public String toString() {
        return name + " \n\t" + stocks;
    }

    public enum Volume {
        BOTTLE_0p3(0.3),
        BOTTLE_0p5(0.3),
        BOTTLE_1p0(1.0),
        BOTTLE_2p5(2.5),
        BOTTLE_5p0(5.0);


        double valume;

        Volume(double valume) {
            this.valume = valume;
        }
    }
}
