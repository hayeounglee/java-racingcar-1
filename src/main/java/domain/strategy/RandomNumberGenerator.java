package domain.strategy;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int RANDOM_BOUND = 10;

    private final Random random;

    public RandomNumberGenerator(final Random random) {
        this.random = random;
    }

    @Override
    public int generate() {
        return random.nextInt(RANDOM_BOUND);
    }
}
