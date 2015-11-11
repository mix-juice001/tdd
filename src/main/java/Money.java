class Money implements Expression {
    protected int amount;
    protected CurrencyType currency;

    Money(int amount, CurrencyType currency) {
        this.amount = amount;
        this.currency =currency;
    }

    public static Money yen(int amount) {
        return new Money(amount, CurrencyType.JPY);
    }

    public static Money dollar(int amount) {
        return new Money(amount, CurrencyType.USD);
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
    public Money reduce(Bank bank, CurrencyType to) {
        int rate = bank.rate(currency, to);
        return new Money(amount / rate, to);
    }
}
