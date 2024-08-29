package strategy;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator{
    private Random random;
    private static final int RANDOM_BOUND = 10;

    public RandomNumberGenerator(Random random){
        this.random = random;
    }
    @Override
    public int generate(){
        return random.nextInt(RANDOM_BOUND);
    }
}
