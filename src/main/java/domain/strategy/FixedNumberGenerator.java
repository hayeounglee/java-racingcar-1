package domain.strategy;

import java.util.List;

public class FixedNumberGenerator implements NumberGenerator {

    private final List<Integer> numbers;

    public FixedNumberGenerator(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public int generate() {
        return numbers.remove(0);
    }
}
