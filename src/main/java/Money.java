abstract class Money {
    protected int amount;
    protected String currency;

    public static Money yen(int amount) {
        return new Yen(amount, "JPY");
    }

    abstract Money times(int multiplier);

    public static Money dollar(int amount) {
        return new Dollar(amount, "USD");
    }

    @Override
    public boolean equals(Object object) {
        return amount == ((Money) object).amount
                && this.getClass().equals(object.getClass());
    }

    String currency() {
        return currency;
    }
}
