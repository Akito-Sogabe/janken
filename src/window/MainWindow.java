package window;

//    ゲームのメイン画面

import enums.Hands;
import enums.Status;

import javax.swing.*;

public class MainWindow {

//    ゲームを表示するフレーム
    private final JFrame frame;

//    メッセージを表示するラベル
    private final JLabel messageLabel;

//    グーのボタン
    private final JButton rockButton;

//    チョキのボタン
    private final JButton scissorsButton;

//    パーのボタン
    private final JButton paperButton;

//    ステータスの表示
    private Status playState;

//    相手が出した手
    private Hands opponentHand;

//    コンストラクタ
    public MainWindow(){
//        画面生成
        this.frame = new JFrame("じゃんけんゲーム");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        画面サイズを指定
        this.frame.setBounds(200,200,600,400);

        var pane = this.frame.getContentPane();

//        このキャンバスに対してボタンやラベルを配置していく
        var canvas = new JPanel();

//        ラベル
        this.messageLabel = new JLabel("じゃんけーん");
        this.messageLabel.setBounds(20,20,400,30);
        canvas.add(this.messageLabel);

//        ボタンを作成する

//        グー
        this.rockButton = new JButton(Hands.Rock.getDisplay());
        this.rockButton.setBounds(100,100,100,40);
        this.rockButton.addActionListener((e) -> this.selectHand(Hands.Rock));
        canvas.add(this.rockButton);

//        チョキ
        this.scissorsButton = new JButton(Hands.Scissors.getDisplay());
        this.scissorsButton.setBounds(100,100,100,40);
        this.scissorsButton.addActionListener((e) -> this.selectHand(Hands.Scissors));
        canvas.add(this.scissorsButton);

//        パー
        this.paperButton = new JButton(Hands.Paper.getDisplay());
        this.paperButton.setBounds(100,100,100,40);
        this.paperButton.addActionListener((e) -> this.selectHand(Hands.Paper));
        canvas.add(this.paperButton);

//        画面にキャンバスを追加
        pane.add(canvas);
    }

//    画面表示
    public void show(){
        this.init();
        this.frame.setVisible(true);
    }

//    ゲームの初期化
    public void init(){
        this.opponentHand = Hands.getRandomHand();
        this.playState = Status.Wait;
    }

//    自分の手を選んだ時の処理
    public void selectHand(Hands selected){
//        入力待ちでなければ以降の処理はしない
        if (this.playState != Status.Wait){
            return;
        }
//        勝ち負けの判定
        switch ((selected.getNumber() - opponentHand.getNumber() + 3 ) % 3){
            case 0:
//                引き分けなので継続
                this.messageLabel.setText("あいこ");
//                手を出しなおす
                this.init();
                break;
            case 1:
//                負け
                this.messageLabel.setText("まけ");
//                ゲーム終了
                this.playState = Status.Done;
                break;
            case 2:
//                勝ち
                this.messageLabel.setText("勝ち");
//                ゲーム終了
                this.playState = Status.Done;
                break;
        }
    }

}
