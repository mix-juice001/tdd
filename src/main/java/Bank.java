class Bank {

    Expression reduce(Expression source, String to) {
        if (source instanceof Money) return ((Money) source).reduce(to);
        Sum sum = (Sum) source;
        return sum.reduce(to);
    }
}
