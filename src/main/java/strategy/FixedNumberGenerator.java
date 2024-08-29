package strategy;

import java.util.ArrayList;
import java.util.List;

public class FixedNumberGenerator implements NumberGenerator{
    private final List<Integer> numbers;

    public FixedNumberGenerator(List<Integer> numbers){
        this.numbers = new ArrayList<>(numbers);
    }

    @Override
    public int generate() {
        return numbers.remove(0);
    }
}
