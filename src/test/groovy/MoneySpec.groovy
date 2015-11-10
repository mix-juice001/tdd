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
        def five = Money.dollar(5)
        def sum = five.plus(five)
        def bank = new Bank()
        def reduced = bank.reduce(sum, "USD")
        then:
        reduced == Money.dollar(10)
    }

    def Sumを返却する足し算() {
        when:
        def five = Money.dollar(5)
        def result = five.plus(five)
        def sum = (Sum) result
        then:
        five == sum.augend
        five == sum.addend
    }

    def reduceMoney() {
        def five = Money.dollar(5)
        def bank = new Bank()
        expect:
        bank.reduce(five, "USD") == five
    }

    def 異なる通貨のreduce() {
        when:
        def bank = new Bank()
        bank.addRate("JPY", "USD", 2)
        def twoYen = Money.yen(2)
        then:
        bank.reduce(twoYen, "USD") == Money.dollar(1)
    }

    def 同じ通貨のrate換算() {
        def bank = new Bank()
        expect:
        bank.rate("USD", "USD") == 1
    }

    def mixedAddition() {
        when:
        def bank = new Bank()
        bank.addRate("JPY", "USD", 2)
        then:
        bank.reduce(Money.dollar(5).plus(Money.yen(10)), "USD") == Money.dollar(10)
    }
}
