abstract class Money {
    protected int amount;

    public static Money yen(int amount) {
        return new Yen(amount);
    }

    abstract Money times(int multiplier);

    public static Money dollar(int amount) {
        return new Dollar(amount);
    }

    @Override
    public boolean equals(Object object) {
        return amount == ((Money) object).amount
                && this.getClass().equals(object.getClass());
    }
}
