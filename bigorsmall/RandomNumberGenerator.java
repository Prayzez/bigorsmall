package bigorsmall;

import java.util.Random;

public class RandomNumberGenerator {

    private Random random;
    private int maxNumber;

    public RandomNumberGenerator(int maxNumber) {
        this.maxNumber = maxNumber;
        this.random = new Random();
    }

    public int generate() {
        return random.nextInt(maxNumber) + 1;
    }
}
