class Yen extends Money {


    Yen(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }


    Money times(int multiplier) {
        return Money.yen(amount * multiplier);
    }

}
