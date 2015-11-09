class Yen {
    private int amount;

    Yen(int amount) {
        this.amount = amount;
    }


    Yen times(int multiplier) {
        return new Yen(amount * multiplier);
    }

    @Override
    public boolean equals(Object object) {
        return amount == ((Yen) object).amount;
    }

}
