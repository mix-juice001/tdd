class Bank {

    Expression reduce(Expression source, String to) {
        Sum sum = (Sum) source;
        return sum.reduce(to);
    }
}
