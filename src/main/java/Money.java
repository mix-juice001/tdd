class Money {
    protected int amount;

    @Override
    public boolean equals(Object object) {
        return amount == ((Money) object).amount
                && this.getClass().equals(object.getClass());
    }
}
