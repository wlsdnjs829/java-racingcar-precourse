package racingcar;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import racingcar.model.CarName;
import racingcar.model.CarNames;
import racingcar.model.Move;
import racingcar.utils.CarGeneratorUtils;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.ThrowableAssert.*;

class MoveTest {

    @Test
    void 사용자는_몇_번_이동할_것인지_입력한다() {
        final Move move = new Move("3");
        int moves = move.remainMoves();
        assertThat(moves).isEqualTo(3);

        final ThrowingCallable overAllowedNumberCase = () -> new Move("31231232132132131");
        assertThatThrownBy(overAllowedNumberCase).isInstanceOf(IllegalArgumentException.class);

        final ThrowingCallable lessAllowedNumberCase = () -> new Move("-1");
        assertThatThrownBy(lessAllowedNumberCase).isInstanceOf(IllegalArgumentException.class);

        final ThrowingCallable notNumberCase = () -> new Move("이건몰랐징?");
        assertThatThrownBy(notNumberCase).isInstanceOf(IllegalArgumentException.class);
    }

}
