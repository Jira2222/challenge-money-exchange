package fabian.challenge.money.exchange.main;

import fabian.challenge.money.exchange.models.Money;
import fabian.challenge.money.exchange.models.MoneyConsult;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Scanner

        Scanner key = new Scanner(System.in);

        //Variables

        var exit = 1;

        //New object
        MoneyConsult consult = new MoneyConsult();

        //App

        System.out.println("""
                *********************************************************
                Money Exchange App.
                Here you can convert money to different exchange rates.
                """);

        while (exit == 1) {
            System.out.println("""
                    Please Choose one money exchange rate to convert:
                    
                    1) USD (Dollar) =>> COP (Colombian Peso)
                    2) COP (Colombian Peso) =>> USD (Dollar)
                    3) USD (Dollar) =>> EUR (UE Euro)
                    4) EUR (UE Euro) =>> USD (Dollar)
                    5) USD (Dollar) =>> GBP (Grand Britain Pound)
                    6) GBP (Grand Britain Pound) =>> USD (Dollar)
                    7) Exit
                    
                    Please input a number between 1 to 7:
                    """);

            try {
                var option = Integer.valueOf(key.nextLine());

                if(option > 0 && option <= 6){
                    Money money = consult.chooseExchange(option);

                    //Variables

                    var base = money.base_code();
                    var target = money.target_code();
                    var conversion = money.conversion_rate();

                    //Final Result

                    System.out.println("Please input value to convert:");

                    //Data Variables
                    var value = Double.valueOf(key.nextLine());
                    var total = Math.round((conversion * value) * 100.0) / 100.0;

                    System.out.println("Money conversion: " + value + " " + base + " = " + total + " " + target);
                    System.out.println("""
                            *********************************************************
                            """);

                } else if (option == 7) {
                    exit = 0;
                } else {
                    System.out.println("No valid option For input int: " + option);
                    System.out.println("********************************************************");
                }

            } catch (NumberFormatException e){
                System.out.println("No valid option " + e.getMessage());
                System.out.println("********************************************************");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("App Finished.");
            }
        }

        System.out.println("Thank you to use our service. Have a nice day!!!");
    }
}
