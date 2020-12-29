package lectures;

import beans.Person;

import java.util.List;
import java.util.stream.IntStream;

import mockdata.MockData;
import org.junit.Test;

public class Lecture2 {

    @Test
    public void range() throws Exception {

        for (int i = 0; i < 8; ++i) {
            System.out.println(i);
        }
        System.out.println();
        //exclusive
        IntStream.range(0,10).forEach(i-> System.out.println(i));
        System.out.println();
        //inclusive
        IntStream.rangeClosed(0,10).forEach(i-> System.out.println(i));
    }

    @Test
    public void rangeIteratingLists() throws Exception {
        List<Person> people = MockData.getPeople();

        IntStream.range(0,people.size()).forEach(idx-> System.out.println(people.get(idx)));
    }

    @Test
    public void intStreamIterate() throws Exception {
        List<Person> people = MockData.getPeople();

        IntStream.iterate(0,i->i+1).limit(10).forEach(num-> System.out.println(num));
    }
}
