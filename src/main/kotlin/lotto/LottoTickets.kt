package lotto

@JvmInline
value class LottoTickets(private val values: List<LottoTicket>) {
    fun size(): Int {
        return this.values.size
    }

    fun matchNumbers(winningNumbers: WinningNumbers): List<LottoMatchResult> {
        return values.map { lottoTicket ->
            LottoMatchResult(
                matchCount = lottoTicket.matchNumbers(winningNumbers.numbers),
                isBonusMatch = winningNumbers.bonusNumber in lottoTicket,
            )
        }
    }

    fun forEach(action: (LottoTicket) -> Unit) {
        this.values.forEach(action)
    }
}