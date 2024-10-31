package Task2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Currency {
    private final String name;
    private final double conversionRateToUSD;

    public Currency(String name, double conversionRateToUSD) {
        this.name = name;
        this.conversionRateToUSD = conversionRateToUSD;
    }

    public String getName() {
        return name;
    }

    public double getConversionRateToUSD() {
        return conversionRateToUSD;
    }

    public double convertTo(double amount, Currency targetCurrency) {
        double amountInUSD = amount * this.conversionRateToUSD; // Конвертируем сумму в доллары
        return amountInUSD / targetCurrency.getConversionRateToUSD();
    }
}

class CurrencyConverter {
    private final Map<Integer, Currency> currencies;

    public CurrencyConverter() {
        currencies = new HashMap<>();
        currencies.put(1, new Currency("Доллар", 1.0));
        currencies.put(2, new Currency("Юань", 0.14));
        currencies.put(3, new Currency("Рубль", 0.0103));
        currencies.put(4, new Currency("Евро", 1.085));
        currencies.put(5, new Currency("Белорусский рубль", 0.3012));
    }

    public Currency getCurrency(int choice) {
        return currencies.get(choice);
    }

    public void displayConversionOptions() {
        System.out.println("В какой валюте вы хотите ввести сумму?");
        for (Map.Entry<Integer, Currency> entry : currencies.entrySet()) {
            System.out.println("[" + entry.getKey() + "] : " + entry.getValue().getName());
        }
    }

    public void convertAndDisplay(double amount, Currency fromCurrency) {
        System.out.println("\nКонвертация для " + amount + " " + fromCurrency.getName() + ":");
        for (Currency toCurrency : currencies.values()) {
            if (!fromCurrency.equals(toCurrency)) {
                double convertedAmount = fromCurrency.convertTo(amount, toCurrency);
                System.out.printf("%.2f %s = %.2f %s\n", amount, fromCurrency.getName(), convertedAmount, toCurrency.getName());
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();

        converter.displayConversionOptions();
        int choice = sc.nextInt();
        Currency selectedCurrency = converter.getCurrency(choice);
        if (selectedCurrency == null) {
            System.out.println("Неправильный выбор валюты!");
            return;
        }

        System.out.println("\nВведите сумму: ");
        double amount = sc.nextDouble();

        converter.convertAndDisplay(amount, selectedCurrency);
    }
}
