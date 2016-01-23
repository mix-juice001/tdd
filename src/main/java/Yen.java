class Yen extends Money {

    Yen(int amount) {
        this.amount = amount;
    }


    Yen times(int multiplier) {
        return new Yen(amount * multiplier);
    }


}
