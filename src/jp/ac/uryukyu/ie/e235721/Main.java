package jp.ac.uryukyu.ie.e235721;

public class Main{
    public static void main(String[] args) {
        Deck deck = new Deck();
        User user = new User();
        Dealer dealer = new Dealer();

        // 初期カードの配布
        user.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());
        user.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());

        dealer.displayPartialStatus();  // ディーラーの一部の手札を表示
        user.play(deck);    //ユーザーのターン
        dealer.play(deck);  // ディーラーのターン
        displayResult(user, dealer);    // 結果表示
    }

    /**
     * ゲームの結果を表示するメソッド
     * それぞれの合計点数を比較し、勝敗を表示する
     * @param user ユーザーのプレイヤーオブジェクト
     * @param dealer ディーラーのプレイヤーオブジェクト
     */

    public static void displayResult(User user, Dealer dealer) {
        dealer.displayStatus();
        System.out.println("Userの合計: " + user.getCurrentScore());
        System.out.println("Dealerの合計: " + dealer.getCurrentScore());

        if (user.isBust()) {
            System.out.println("Bustした（敗北）");
        } else if (dealer.isBust()) {
            System.out.println("DealerがBustした!（勝利）");
        } else {
            int userScore = user.getCurrentScore();
            int dealerScore = dealer.getCurrentScore();

            if (userScore > dealerScore) {
                System.out.println("勝利した！");
            } else if (userScore < dealerScore) {
                System.out.println("敗北");
            } else {
                System.out.println("引き分け");
            }
        }
    }
}