package lectures;


import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Optional;

import org.junit.Test;

public class Lecture9 {

    @Test
    public void reduce() throws Exception {
        Integer[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};
        int result = 0;
        int sum = Arrays.stream(integers).reduce(result, (integer, integer2) -> integer + integer2).intValue();
        System.out.println(sum);
        System.out.println(Arrays.stream(integers).mapToInt(p->p).sum());
    }


}

