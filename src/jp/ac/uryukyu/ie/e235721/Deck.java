package jp.ac.uryukyu.ie.e235721;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Deck {
    private List<Card> cards;   //カードのリスト

    /**
     * Deckクラスのコンストラクタ
     * デッキを初期化し、シャッフル
     */

    public Deck() {
        this.cards = new ArrayList<>();
        initializeDeck();
        shuffleDeck();
    }

    /**
     * 各マークごとに1から13までのカードを生成し、デッキに追加する。
     */

    private void initializeDeck() {
        String[] marks = {"Spade", "Heart", "Diamond", "Club"};
        for (String mark : marks) {
            for (int i = 1; i <= 13; i++) {
                cards.add(new Card(mark, i));
            }
        }
    }

    private void shuffleDeck() {
        Collections.shuffle(cards); //シャッフルする
    }

    /**
     * デッキからカードを引くメソッド。
     * @return 引かれたカード
     * @throws IllegalStateException 山札が空の場合（可能性として）
     */

    public Card drawCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("山札が空です");
        }
        return cards.remove(0);
    }
}