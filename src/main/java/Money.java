class Money {
    protected int amount;
    protected String currency;

    Money(int amount, String currency) {
        this.amount = amount;
        this.currency =currency;
    }

    public static Money yen(int amount) {
        return new Money(amount, "JPY");
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    @Override
    public boolean equals(Object object) {
        return amount == ((Money) object).amount
                && this.currency.equals(((Money) object).currency);
    }

    String currency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
