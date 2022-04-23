package racingcar;

import racingcar.constants.ErrorMessage;
import racingcar.model.RacingCars;
import racingcar.model.Move;
import racingcar.utils.ValidationUtils;

import java.util.Map;

public class RacingGame {

    private final RacingCars cars;
    private final Move move;

    public RacingGame(RacingCars cars, Move move) {
        this.cars = cars;
        this.move = move;
    }

    public void start() {
        ValidationUtils.validConditionThrowIfTrue(move.immovable(), ErrorMessage.MUST_HAVE_A_COUNT_TO_MOVE);
        final Map<String, Integer> movableNumberMap = cars.getMovableNumberMap();
        final Map<String, MoveStatus> moveStatusMap = move.moveStatus(movableNumberMap);
        cars.moveCar(moveStatusMap);
        cars.outputResult();
    }

}
