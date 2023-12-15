package currency;

public abstract class BaseCurrency {

    public abstract String getCode();

    public abstract double getExchangeRate();

    public static BaseCurrency init(String code, double exchangeRate) {
        return new BaseCurrency() {
            @Override
            public String getCode() {
                return code;
            }
            @Override
            public double getExchangeRate() {
                return exchangeRate;
            }
        };
    }

}
