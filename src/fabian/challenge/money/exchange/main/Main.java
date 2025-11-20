package fabian.challenge.money.exchange.main;

import fabian.challenge.money.exchange.models.Money;
import fabian.challenge.money.exchange.models.MoneyConsult;

public class Main {
    public static void main(String[] args) {
        MoneyConsult consult = new MoneyConsult();

        try {
            Money money = consult.chooseExchange(8);
            System.out.println(money);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("App Finished.");
        }

    }
}
