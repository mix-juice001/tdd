import spock.lang.Specification

class MoneySpec extends Specification {

    def 金額の掛け算() {
        setup:
        Dollar five = new Dollar(5)

        expect:
        five.times(2) == new Dollar(10)
        five.times(3) == new Dollar(15)
    }

    def testEquality() {
        expect:
        new Dollar(5) == new Dollar(5)
        new Dollar(5) != new Dollar(6)
        new Yen(5) == new Yen(5)
        new Yen(5) != new Yen(6)
        new Dollar(5) != new Yen(5)
    }

    def 日本円の掛け算() {
        def five = new Yen(5)
        expect:
        five.times(2) == new Yen(10)
        five.times(3) == new Yen(15)
    }
}
