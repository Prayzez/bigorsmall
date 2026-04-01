package bigorsmall;

public class Main {
    public static void main(String[] args) {
        BigOrSmall game = new BigOrSmall(10); // 最大10ラウンド
        System.out.println("ゲームを開始します。");
        game.play();
        System.out.println("ゲームを終了します。");
    }
}