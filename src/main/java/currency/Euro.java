package currency;

public final class Euro extends BaseCurrency {

    private static Euro instance;

    public static BaseCurrency getInstance() {
        if (instance == null)
            instance = new Euro();

        return instance;
    }
    private Euro() {}
    public String getCode() {
        return "EURO";
    }

    public double getExchangeRate() {
        return 1.08;
    }
}
