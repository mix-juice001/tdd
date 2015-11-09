import spock.lang.Specification

class MoneySpec extends Specification {

    def 金額の掛け算() {
        setup:
        Dollar five = new Dollar(5)

        when:
        def product = five.times(2)
        then:
        product.amount == 10

        when:
        product = five.times(3)
        then:
        product.amount == 15
    }
}
