class Dollar {
    private int amount;

    Dollar(int amount) {
        this.amount = amount;
    }


    void times(int multiplier) {
        this.amount = amount * multiplier;
    }
}
