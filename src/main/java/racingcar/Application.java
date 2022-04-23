package racingcar;

import racingcar.model.Car;
import racingcar.model.Move;
import racingcar.model.RacingCars;
import racingcar.utils.CarGeneratorUtils;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        final List<Car> cars = CarGeneratorUtils.getCars("이런,안돼,중복,한다");
        final RacingCars racingCars = new RacingCars(cars);
        final Move move = new Move("5");
        RacingGame racingGame = new RacingGame(racingCars, move);
        racingGame.start();
    }
}
