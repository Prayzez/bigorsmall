package bigorsmall;

import java.util.Scanner;

public class Round {

    // ===== Required instance variables only =====
    private int roundNumber;
    private int maxRounds;
    private int currentNumber;
    private int nextNumber;
    private String prediction;

    // constants for readability
    private static final String BIG = "b";
    private static final String SMALL = "s";

    // ===== Constructor (EXACT signature & order) =====
    public Round(int roundNumber, int currentNumber, int maxRounds) {
        this.roundNumber = roundNumber;
        this.currentNumber = currentNumber;
        this.maxRounds = maxRounds;
    }

    // ===== Play one round =====
    // return: 1 = correct, -1 = incorrect, 0 = draw
    public int play() {
        showRemainingRounds();
        showCurrentNumber();
        inputPrediction();
        generateNextNumber();

        if (nextNumber == currentNumber) {
            System.out.println("Draw");
            return 0;
        }

        System.out.println("次の数値: " + nextNumber);

        if (isCorrect()) {
            System.out.println("正解！");
            return 1;
        } else {
            System.out.println("不正解");
            return -1;
        }
    }

    // ===== Required method =====
    public boolean isCorrect() {
        if (BIG.equals(prediction)) {
            return nextNumber > currentNumber;
        }
        return nextNumber < currentNumber;
    }

    // ===== Helper methods =====
    private void showRemainingRounds() {
        System.out.println("残りラウンド回数: " + (maxRounds - roundNumber));
    }

    private void showCurrentNumber() {
        System.out.println("現在の数値: " + currentNumber);
    }

    private void inputPrediction() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("b(高い) / s(低い) を入力: ");
            prediction = scanner.nextLine();
            if (BIG.equals(prediction) || SMALL.equals(prediction)) {
                break;
            }
            System.out.println("無効な入力です。再入力してください。");
        }
    }

    private void generateNextNumber() {
        RandomNumberGenerator rng = new RandomNumberGenerator(9);
        nextNumber = rng.generate();
    }

    // ===== Getter for draw handling =====
    public int getCurrentNumber() {
        return currentNumber;
    }
}
