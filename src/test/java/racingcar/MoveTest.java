package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Move;

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

    @Test
    void 랜덤_값을_통해_이동한다() {
        final Move move = new Move("3");
        final MoveStatus stayCase = move.moveStatus(3);
        assertThat(stayCase).isEqualTo(MoveStatus.STAY);

        final MoveStatus moveCase = move.moveStatus(4);
        assertThat(moveCase).isEqualTo(MoveStatus.MOVE);

        final ThrowingCallable notAllowedCase = () -> move.moveStatus(10);
        assertThatThrownBy(notAllowedCase).isInstanceOf(IllegalArgumentException.class);

        final MoveStatus leastMoveCase = move.moveStatus(1);
        assertThat(leastMoveCase).isEqualTo(MoveStatus.STAY);

        final ThrowingCallable overCountCase = () -> move.moveStatus(3);
        assertThatThrownBy(overCountCase).isInstanceOf(IllegalArgumentException.class);
    }
}
