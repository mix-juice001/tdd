import spock.lang.Specification

class MoneySpec extends Specification {

    def 金額の掛け算() {
        setup:
        Money five = Money.dollar(5)

        expect:
        five.times(2) == Money.dollar(10)
        five.times(3) == Money.dollar(15)
    }

    def testEquality() {
        expect:
        Money.dollar(5) == Money.dollar(5)
        Money.dollar(5) != Money.dollar(6)
        Money.dollar(5) != Money.yen(5)
        Money.dollar(5) != null
        !Money.dollar(5).equals(null)
        Money.dollar(5) != "5"
    }

    def 日本円の掛け算() {
        def five = Money.yen(5)
        expect:
        five.times(2) == Money.yen(10)
        five.times(3) == Money.yen(15)
    }

    def testCurrency() {
        expect:
        "USD" == Money.dollar(1).currency();
        "JPY" == Money.yen(1).currency();
    }

    def 掛け算() {
        Money five = Money.dollar(5)
        expect:
        five.times(a) == Money.dollar(b)

        where:
        a | b
        2 | 10
        3 | 15

    }

    def シンプルな足し算() {
        when:
        def sum = Money.dollar(5).plus(Money.dollar(5))
        then:
        sum == Money.dollar(10)
    }

}
