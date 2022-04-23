package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.CarName;
import racingcar.model.CarNames;
import racingcar.utils.CarGeneratorUtils;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.*;

class CarNameTest {

    private static final String JIN_WON = "진원";

    @Test
    void 유효한_이름인지_테스트() {
        ThrowingCallable overMaxLengthCase = () -> new CarName("여섯글자지롱");
        assertThatThrownBy(overMaxLengthCase).isInstanceOf(IllegalArgumentException.class);

        ThrowingCallable emptyCase = () -> new CarName("");
        assertThatThrownBy(emptyCase).isInstanceOf(IllegalArgumentException.class);

        ThrowingCallable nullCheckCase = () -> new CarName(null);
        assertThatThrownBy(nullCheckCase).isInstanceOf(IllegalArgumentException.class);

        CarName carName = new CarName(JIN_WON);
        String name = carName.getName();
        assertThat(name).isEqualTo(JIN_WON);
    }

    @Test
    void 각_자동차에게_이름_부여_및_중복_체크() {
        final List<CarName> names = CarGeneratorUtils.getCarNames("이런,안돼,중복,한다");
        final CarNames carNames = new CarNames(names);
        assertThat(carNames.enterCars()).isEqualTo(4);

        final List<CarName> multiRestNames = CarGeneratorUtils.getCarNames("이런,안돼,,");
        final CarNames multiCarNames = new CarNames(multiRestNames);
        assertThat(multiCarNames.enterCars()).isEqualTo(2);

        final ThrowingCallable duplicateCase = () -> CarGeneratorUtils.getCarNames("이런,이런");
        assertThatThrownBy(duplicateCase).isInstanceOf(IllegalArgumentException.class);

        final ThrowingCallable nullCase = () -> CarGeneratorUtils.getCarNames(null);
        assertThatThrownBy(nullCase).isInstanceOf(IllegalArgumentException.class);
    }

}
