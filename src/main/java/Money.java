class Money implements Expression {
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

    @Override
    public Expression times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        if (!object.getClass().equals(this.getClass())) return false;
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

    @Override
    public Expression plus(Expression addend) {
//        if (addend instanceof Money) return new Money(amount + ((Money) addend).amount, currency);
        return new Sum(this, addend);
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int rate = bank.rate(currency, to);
        return new Money(amount / rate, to);
    }
}
