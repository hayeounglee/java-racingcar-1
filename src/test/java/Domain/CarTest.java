package Domain;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("자동차 이름이 null 이거나 공백일 때 예외가 발생한다")
    void throwWhenNameIsNullOrBlank(){

    }

    @Test
    @DisplayName("자동차 이름이 6자 이상일 때 예외가 발생한다")
    void throwWhenNameLengthMoreThanSix(){
        String name = "-".repeat(6);
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
