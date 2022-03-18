package enums;

import java.util.Random;

public enum Hands {
//    ぐー
    Rock("ぐー",0),
//    ちょき
    Scissors("ちょき",1),
//    ぱー
    Paper("ぱー",2);

//    表示文字
    private final String display;
//    内部番号
    private final int number;

    Hands(String display, int number) {
        this.display = display;
        this.number = number;
    }

//    ランダムに手を表示する
    public static Hands getRandomHand(){
        Random rand = new Random();
        return Hands.values()[rand.nextInt(3)];
    }

//    表示名を取得

    public String getDisplay() {
        return this.display;
    }

//    番号を取得


    public int getNumber() {
        return this.number;
    }
}
