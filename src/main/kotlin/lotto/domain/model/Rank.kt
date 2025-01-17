package lotto.domain.model

enum class Rank(val matchCount: Int, val reward: Int, val isMatchBonusNumber: Boolean = false) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, isMatchBonusNumber = true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0),
    ;

    companion object {
        fun valueOf(matchCount: Int, isMatchBonusNumber: Boolean = false): Rank {
            return values().find { it.matchCount == matchCount && if (it.isMatchBonusNumber) isMatchBonusNumber else true }
                ?: takeIf { matchCount in MISS.matchCount until FIFTH.matchCount }?.let { MISS }
                ?: throw IllegalArgumentException("로또 숫자의 일치 수는 로또 숫자 수의 범위를 벗어날 수 없습니다. matchCount=$matchCount")
        }

        fun Array<Rank>.filterHasReward(): List<Rank> = filter { it.reward > 0 }

        fun Iterable<Rank>.sortedByReward(): List<Rank> = sortedBy { it.reward }
    }
}
