package strategy;

import java.util.Random;

public class RandomNumberGenerator extends NumberGenerator{
    private Random random;
    private static final int RANDOM_BOUND = 10;

    public RandomNumberGenerator(Random random){
        this.random = random;
    }
    @Override
    public int generator(){
        return random.nextInt(RANDOM_BOUND);
    }
}
