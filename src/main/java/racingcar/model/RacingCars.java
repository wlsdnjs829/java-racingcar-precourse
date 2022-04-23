package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.MoveStatus;
import racingcar.constants.ErrorMessage;
import racingcar.utils.ValidationUtils;
import racingcar.view.GameView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingCars {

    private static final String COLON = " : ";

    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public int enterCars() {
        return cars.size();
    }

    public Map<String, Integer> getMovableNumberMap() {
        final Map<String, Integer> movableNumberMap = new HashMap<>();

        for (Car car : cars) {
            final String carName = car.carName();
            int number = Randoms.pickNumberInRange(0, 9);
            movableNumberMap.putIfAbsent(carName, number);
        }

        return movableNumberMap;
    }

    public void moveCar(Map<String, MoveStatus> moveStatusMap) {
        ValidationUtils.validObjectThrowIfNull(moveStatusMap, ErrorMessage.MOVE_STATUS_MAP_IS_REQUIRED);

        for (Car car : cars) {
            final String carName = car.carName();
            final MoveStatus moveStatus = moveStatusMap.get(carName);
            car.actByMoveStatus(moveStatus);
        }
    }

    public void outputResult() {
        for (Car car : cars) {
            final String carName = car.carName();
            final String distanceDash = car.getDistanceDash();
            GameView.printMessage(carName + COLON + distanceDash);
        }
    }

}
