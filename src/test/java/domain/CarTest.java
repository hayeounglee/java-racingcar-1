package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class CarTest {

    @DisplayName("자동차의 이름이 null 이나 공백이면 예외가 발생한다.")
    @NullAndEmptySource
    @ParameterizedTest
    void createWhenNameIsNullOrBlank(String name) {
        // given
        // when
        // then
        assertThatThrownBy(() -> new Car(name))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차의 이름이 6자 이상일 때 예외가 발생한다.")
    @Test
    void createWhenNameLengthIsMoreThanSix() {
        // given
        String name = "A".repeat(6);

        // when
        // then
        assertThatThrownBy(() -> new Car(name))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
