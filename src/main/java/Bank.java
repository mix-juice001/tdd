import java.util.HashMap;
import java.util.Map;

class Bank {

    private Map<Pair, Integer> rates = new HashMap<>();

    Expression reduce(Expression source, CurrencyType to) {
        return source.reduce(this, to);
    }

    int rate(CurrencyType from, CurrencyType to) {
        if (from == to) return 1;
        return rates.get(new Pair(from, to));
    }

    public void addRate(CurrencyType from, CurrencyType to, int rate) {
        rates.put(new Pair(from, to), rate);
    }

    private class Pair {
        private CurrencyType from;
        private CurrencyType to;

        public Pair(CurrencyType from, CurrencyType to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (from != null ? !from.equals(pair.from) : pair.from != null) return false;
            return !(to != null ? !to.equals(pair.to) : pair.to != null);

        }

        @Override
        public int hashCode() {
            int result = from != null ? from.hashCode() : 0;
            result = 31 * result + (to != null ? to.hashCode() : 0);
            return result;
        }
    }
}
