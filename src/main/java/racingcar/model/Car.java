package racingcar.model;

import racingcar.enums.MoveStatus;
import racingcar.constants.ErrorMessage;
import racingcar.utils.ValidationUtils;

public class Car {

    private static final int ZERO = 0;
    private static final String DASH = "-";

    private final CarName name;
    private final CarDistance distance;

    public Car(CarName name) {
        this.name = name;
        this.distance = new CarDistance(ZERO);
    }

    public String carName() {
        ValidationUtils.validObjectThrowIfNull(name, ErrorMessage.NAME_IS_REQUIRED);
        return name.getName();
    }

    public void actByMoveStatus(MoveStatus moveStatus) {
        if (MoveStatus.MOVE.equals(moveStatus)) {
            distance.increaseDistance();
        }
    }

    public String getDistanceDash() {
        final StringBuilder builder = new StringBuilder();

        for (int repeat = 0; repeat < this.distance.getDistance(); repeat++) {
            builder.append(DASH);
        }

        return builder.toString();
    }

}
