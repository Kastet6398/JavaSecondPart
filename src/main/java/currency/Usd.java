package currency;

public final class Usd extends BaseCurrency {

    private static Usd instance;

    public static BaseCurrency getInstance() {
        if (instance == null)
            instance = new Usd();

        return instance;
    }
    private Usd() {}
    public String getCode() {
        return "USD";
    }

    public double getExchangeRate() {
        return 1;
    }
}
