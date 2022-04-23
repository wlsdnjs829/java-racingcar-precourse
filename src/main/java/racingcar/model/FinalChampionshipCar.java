package racingcar.model;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class FinalChampionshipCar {

    private static final String REST_SPACE = ", ";

    private final AtomicInteger topDistance;
    private final Map<String, Integer> distanceByName;
    private final StringBuilder builder;

    public FinalChampionshipCar(AtomicInteger topDistance, Map<String, Integer> distanceByName) {
        this.topDistance = topDistance;
        this.distanceByName = distanceByName;
        this.builder = new StringBuilder();
    }

    public String getFinalChampionshipCarNames() {
        final int topDistanceCount = topDistance.get();

        for (Map.Entry<String, Integer> entry : distanceByName.entrySet()) {
            final String carName = entry.getKey();
            final int count = entry.getValue();
            appendCarName(topDistanceCount, count, carName);
        }

        return builder.toString();
    }

    private void appendCarName(int topDistanceCount, int count, String carName) {
        if (topDistanceCount > count) {
            return;
        }

        if (builder.length() > 0) {
            builder.append(REST_SPACE);
        }

        builder.append(carName);
    }

}
