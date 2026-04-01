package bigorsmall;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BigOrSmall {

    // ===== Required instance variables only =====
    private ScoreBoard scoreBoard;
    private int maxRounds;
    private int consecutiveCorrectCount;

    // ===== Constructor =====
    public BigOrSmall(int maxRounds) {
        this.maxRounds = maxRounds;
        this.scoreBoard = new ScoreBoard();
        this.consecutiveCorrectCount = 0;
    }

    // ===== Start game =====
    public void play() {
        RandomNumberGenerator rng = new RandomNumberGenerator(9);

        int roundNumber = 1;
        int currentNumber = rng.generate(); // initial current number

        // Count only correct + incorrect rounds
        while (roundNumber <= maxRounds) {

            Round round = new Round(roundNumber, currentNumber, maxRounds);

            // play(): 1 = correct, -1 = incorrect, 0 = draw
            int result = round.play();

            if (result == 0) {
                // Draw: round number NOT increased, streak NOT reset
                currentNumber = round.getCurrentNumber();
                continue;
            }

            if (result == 1) {
                consecutiveCorrectCount++;
                int score = 100 + (consecutiveCorrectCount - 1) * 100;
                scoreBoard.addScore(score);
            } else {
                consecutiveCorrectCount = 0;
                scoreBoard.addScore(0);
            }

            scoreBoard.show();

            // Next round starts with a new random current number
            currentNumber = rng.generate();
            roundNumber++;
        }

        showResult();
        saveScore();
    }

    // ===== Show final result =====
    public void showResult() {
        System.out.println("GAME OVER");
        System.out.println("最終スコア: " + scoreBoard.getTotalScore());
    }

    // ===== Save score =====
    public void saveScore() {
        try (FileWriter writer = new FileWriter("scores.csv", true)) {
            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
            String date = LocalDateTime.now().format(formatter);
            writer.write("Score: " + scoreBoard.getTotalScore()
                    + ", Date: " + date + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("スコア保存中にエラーが発生しました。");
        }
    }
}
