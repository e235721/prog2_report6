package jp.ac.uryukyu.ie.e235721;

/**
 * Card クラスのコンストラクタ。
 *  mark   カードのマーク
 *  number カードの数字
 */

public class Card {
    private String mark;
    private int number;

    public Card(String mark, int number) {
        this.mark = mark;
        this.number = number;
    }

    public String getMark() {
        return mark;
    }

    public int getNumber() {
        return number;
    }

    /**
     * カードを表示するための文字列を取得します。
     * @return カードの表示用文字列
     */

    public String getDisplay() {
        switch (number) {
            case 1:
                return "A";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
                return String.valueOf(number);
        }
    }

    /**
     * ブラックジャックのポイントを取得
     * @return ブラックジャックの点数
     */
    
    public int getPoint() {
        return (number > 10) ? 10 : number;
    }

    @Override
    public String toString() {
        return mark + "の" + getDisplay();  //カードの文字列表現
    }
}
