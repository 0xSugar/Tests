package archive.accesses;

import archive.accesses.HideMe.Technologies;

public class Main {
    public static void main(String[] args) {

        Technologies tech = new Robot("Jade");

        Robot one = new Robot("Mike");
        Robot two = new Robot("Ike");

        one.setTech(two);
        two.setTech(one);

        one.whatCanDo();
        two.whatCanDo();


    }
}
