package jp.ac.uryukyu.ie.e235721;
import java.util.ArrayList;
import java.util.List;

public abstract class PlayerBase {
    protected List<Card> hand;

    public PlayerBase() {
        this.hand = new ArrayList<>();
    }

    public int getCurrentScore() {
        int score = 0;
        int Aces = 0;

        for (Card card : hand) {
            score += card.getPoint();
            if (card.getNumber() == 1) {
                Aces++;
            }
        }

        // Acesを11として数え、バーストしない範囲で10ずつ引く
        while (Aces > 0 && score + 10 <= 21) {
            score += 10;
            Aces--;
        }

        return score;
    }

    public boolean isBust() {
        return getCurrentScore() > 21;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public List<Card> getHand() {
        return hand;
    }

    public abstract void play(Deck deck);
}