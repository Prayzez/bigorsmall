package bigorsmall;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {

    // ===== Required instance variable =====
    private List<Integer> scores;

    public ScoreBoard() {
        scores = new ArrayList<>();
    }

    public void addScore(int score) {
        scores.add(score);
    }

    public void show() {
        System.out.println("---- スコアボード ----");
        for (int i = 0; i < scores.size(); i++) {
            System.out.println("Round " + (i + 1) + ": " + scores.get(i));
        }
        System.out.println("合計スコア: " + getTotalScore());
        System.out.println("--------------------");
    }

    public int getTotalScore() {
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        return total;
    }
}
