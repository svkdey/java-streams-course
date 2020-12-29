package lectures;


import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;
import org.junit.Test;

public class Lecture6 {

  final Predicate<Integer> numbersLessThan10 = n -> n > 5 && n < 10;

  @Test
  public void findAny() throws Exception {
    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    Optional<Integer> any=Arrays.stream(numbers).filter(n->n==0).findFirst();
    System.out.println(any.isPresent()?any.get():0);
  }

  @Test
  public void findFirst() throws Exception {
    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int first = Arrays.stream(numbers)
        .filter(numbersLessThan10)
        .findFirst()
        .get();
    System.out.println(first);
  }
}

