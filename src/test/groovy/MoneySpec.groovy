import spock.lang.Specification

class MoneySpec extends Specification {

    def 金額の掛け算() {
        Dollar five = new Dollar(5)
        five.times(2)

        expect:
        five.amount == 10
    }
}
