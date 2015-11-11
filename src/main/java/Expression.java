public interface Expression {
    Money reduce(Bank bank, CurrencyType to);
    Expression plus(Expression addend);
    Expression times(int multiplier);
}
