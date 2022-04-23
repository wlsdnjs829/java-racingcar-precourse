package racingcar;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import racingcar.model.CarName;

import static org.assertj.core.api.ThrowableAssert.*;

public class CarNameTest {

    @Test
    void 유효한_이름인지_테스트() {
        ThrowingCallable OVER_MAX_LENGTH = () -> new CarName("여섯글자지롱");
        Assertions.assertThatThrownBy(OVER_MAX_LENGTH)
                .isInstanceOf(IllegalArgumentException.class);

        ThrowingCallable EMPTY = () -> new CarName("");
        Assertions.assertThatThrownBy(EMPTY)
                .isInstanceOf(IllegalArgumentException.class);

        ThrowingCallable NULL_CHECK = () -> new CarName(null);
        Assertions.assertThatThrownBy(NULL_CHECK)
                .isInstanceOf(IllegalArgumentException.class);
    }

}
