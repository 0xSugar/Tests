package observer;

public class Main {
    public static void main(String[] args) {
        GameNews gameNews = new GameNews();
        gameNews.addObserver(new Gamer("Василий"));
        gameNews.addObserver(new Gamer("Franko"));
        gameNews.addObserver(new Gamer("Martil"));
        gameNews.addObserver(new Gamer("dilGal"));
        gameNews.addObserver(new Gamer("TithTiThTiTH"));

        System.out.println(gameNews.hasChanged());

        gameNews.notifyObservers("Почта пришла");

    }
}
