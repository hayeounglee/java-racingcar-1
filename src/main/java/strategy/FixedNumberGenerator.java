package strategy;

import java.util.List;

public class FixedNumberGenerator implements NumberGenerator{
    private final List<Integer> numbers;
    public FixedNumberGenerator(List<Integer> numbers){
        this.numbers = List.copyOf(numbers);
    }
    @Override
    public int generator() {
        return numbers.remove(0);
    }
}
