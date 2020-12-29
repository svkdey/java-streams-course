package lectures;


import beans.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;

public class Lecture8 {

    @Test
    public void simpleGrouping() throws Exception {
        List<Car> cars = MockData.getCars();
        Map<String, List<Car>> grouping = cars.stream().collect(Collectors.groupingBy(car -> car.getColor()));
        for (String color : grouping.keySet()) {
            System.out.println(color + " " + grouping.get(color).size());
        }
    }

    @Test
    public void groupingAndCounting() throws Exception {
        List<Car> cars = MockData.getCars();
        Map<String, Long> grouping = cars.stream().collect(Collectors.groupingBy((car -> car.getMake()), Collectors.counting()));
        for (String maker : grouping.keySet()) {
            System.out.println(maker + " " + grouping.get(maker));
        }
    }

}