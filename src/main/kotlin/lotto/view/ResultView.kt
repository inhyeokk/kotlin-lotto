package lotto.view

import lotto.model.Lottos
import lotto.model.WinningRank
import lotto.model.WinningRank.NONE
import kotlin.math.floor

object ResultView {

    fun printPurchasedLottoCount(lottoCount: Int) = println("${lottoCount}개를 구매했습니다.")

    fun printPurchasedLottos(lottos: Lottos) {
        lottos.lottos.forEach { println(it) }
        println()
    }

    fun printWinningStatistics(paymentPrice: Int, winningRanks: List<WinningRank>) {
        println()
        println("당첨 통계")
        println("---------")

        printWinningStatus(winningRanks)
        printEarningsRatio(paymentPrice, winningRanks)
    }

    private fun printWinningStatus(winningRanks: List<WinningRank>) {
        WinningRank.values().filter { it != NONE }
            .reversed()
            .map { println("${it.matchedNumberCount}개 일치 (${it.prizeMoney}원)- ${winningRanks.count { rank -> it == rank }}개") }
    }

    private fun printEarningsRatio(paymentPrice: Int, winningRanks: List<WinningRank>) {
        val earnings = winningRanks.sumOf { it.prizeMoney }
        val earningsRatio = earnings / paymentPrice.toDouble()

        println("총 수익률은 ${floor(earningsRatio * 100) / 100}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}