package org.example;

public enum Currency {
    SEK("SEK", 1.0, "kr"),
    USD("USD", 0.092, "$"),
    EUR("EUR", 0.085, "€");

    private final String code;
    private final double rateToSek; // Exchange rate from this currency to SEK
    private final String symbol;

    Currency(String code, double rateToSek, String symbol) {
        this.code = code;
        this.rateToSek = rateToSek;
        this.symbol = symbol;
    }

    public String getCode() {
        return code;
    }

    public double getRateToSek() {
        return rateToSek;
    }

    public String getSymbol() {
        return symbol;
    }


    public double convertTo(Currency target, double amount) {
        // First convert to SEK, then to target currency
        double amountInSek = amount / this.rateToSek;
        return amountInSek * target.getRateToSek();
    }


    public String format(double amount) {
        return String.format("%.2f %s", amount, symbol);
    }
}