package lotto.domain.model

@JvmInline
value class LottoCash(val value: Int) {

    fun purchase(lottoPrice: Int): LottoCash {
        return LottoCash(value - lottoPrice)
    }

    init {
        require(value >= 0) {
            "숫자는 음수일 수 없습니다. value=$value"
        }
    }
}