package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import com.google.common.collect.ImmutableList;
import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture7 {

  @Test
  public void count() throws Exception {
    List<Car> cars = MockData.getCars();
    long countOfFemale=cars.stream().filter(car->car.getColor().equalsIgnoreCase("yellow")).count();
    System.out.println(countOfFemale);

  }

  @Test
  public void min() throws Exception {
    List<Car> cars = MockData.getCars();
   double min= cars.stream().filter(car->car.getColor().equalsIgnoreCase("yellow")).mapToDouble(car->car.getPrice()).min().getAsDouble();
    System.out.println(min);
  }

  @Test
  public void max() throws Exception {
    List<Car> cars = MockData.getCars();
    double max= cars.stream().filter(car->car.getColor().equalsIgnoreCase("yellow")).mapToDouble(car->car.getPrice()).max().getAsDouble();
    System.out.println(max);
  }


  @Test
  public void average() throws Exception {
    List<Car> cars = MockData.getCars();
    double avg= cars.stream().filter(car->car.getColor().equalsIgnoreCase("yellow")).mapToDouble(car->car.getPrice()).average().orElse(0);
    System.out.println(avg);

  }

  @Test
  public void sum() throws Exception {
    List<Car> cars = MockData.getCars();

    double sum= cars.stream().filter(car->car.getColor().equalsIgnoreCase("yellow")).mapToDouble(car->car.getPrice()).sum();
    System.out.println(sum);

  }

  @Test
  public void statistics() throws Exception {
    List<Car> cars = MockData.getCars();
    DoubleSummaryStatistics stats=cars.stream().filter(car->car.getColor().equalsIgnoreCase("yellow")).mapToDouble(car->car.getPrice()).summaryStatistics();
    System.out.println(stats);
    count();
    sum();
    min();
    average();
    max();

  }

}