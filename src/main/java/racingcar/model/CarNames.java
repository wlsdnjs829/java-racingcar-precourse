package racingcar.model;

import java.util.List;

public class CarNames {

    private final List<CarName> names;

    public CarNames(List<CarName> names) {
        this.names = names;
    }

    public int enterCars() {
        return names.size();
    }

}
