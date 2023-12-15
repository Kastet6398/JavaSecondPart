package currency;

public final class Uah extends BaseCurrency {

    private static Uah instance;

    public static BaseCurrency getInstance() {
        if (instance == null)
            instance = new Uah();

        return instance;
    }
    private Uah() {}
    public String getCode() {
        return "UAH";
    }

    public double getExchangeRate() {
        return .027;
    }
}
