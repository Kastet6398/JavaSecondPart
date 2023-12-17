package currency;

public final class Usd extends BaseCurrency {
    // START singleton
    private static Usd instance;

    public static BaseCurrency getInstance() {
        if (instance == null)
            instance = new Usd();

        return instance;
    }
    private Usd() {}
    // END singleton
    public String getCode() {
        return "USD";
    }

    public double getExchangeRate() {
        return 1;
    }
}
