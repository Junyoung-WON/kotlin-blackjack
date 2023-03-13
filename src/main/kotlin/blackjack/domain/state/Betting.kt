package blackjack.domain.state

import blackjack.domain.Money
import blackjack.domain.card.Card
import blackjack.domain.card.Hand

class Betting(override val hand: Hand) : Started(hand) {
    override val bettingMoney: Money? = null

    override fun draw(card: Card): State {
        throw IllegalStateException(MUST_BETTING_ERROR)
    }

    override fun betting(money: Money): State = Deal(hand, money)

    companion object {
        private const val MUST_BETTING_ERROR = "베팅부터 해야합니다."
    }
}
