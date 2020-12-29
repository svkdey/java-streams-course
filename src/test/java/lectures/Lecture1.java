package lectures;

import beans.Person;
import com.google.common.collect.ImmutableList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;


public class Lecture1 {

    @Test
    public void declarativeApproachUsingStreams() throws Exception {
   List<Person> people = MockData.getPeople();
//        List<Person> teen = people.stream().filter(p->p.getAge() <= 18).collect(Collectors.toList());

        List<Person> teen = people.stream().filter(p -> p.getAge() <= 18).collect(
                () -> new ArrayList<Person>(),
                (teenList, person) -> teenList.add(person),
                (teenList1, teenList2) -> teenList1.addAll(teenList2));
        System.out.println(teen);
        List<Person> first10teen = people.stream().filter(p -> p.getAge() <= 18).limit(10).collect(Collectors.toList());
        System.out.println(first10teen);
    }

    @Test
    public void imperativeApproach() throws IOException {
        List<Person> people = MockData.getPeople();
        List<Person> teen = new ArrayList<>();

        for (Person person : people) {
            if (person.getAge() <= 18) {
                teen.add(person);
            }
        }
//        System.out.println(teen);
//        System.out.println(teen.size());

        List<Person> first10teen = new ArrayList<>();
        for (int i = 0; i < 10 && i < teen.size(); ++i) {
            first10teen.add(teen.get(i));
        }
//        System.out.println(first10teen);
//        System.out.println(first10teen.size());

    }

    @Test
    public void howItWorks() throws Exception {
  List<Person> people = MockData.getPeople();
//        List<Person> teen = people.stream().filter(p->p.getAge() <= 18).collect(Collectors.toList());


        System.out.println(
                people.stream().filter(p -> {
                    //intermediate operator --->lazy operator --> so these are worked by multi threaded.
                    System.out.println("at filter" +p.getGender());
                    return p.getGender().equalsIgnoreCase("female");
                }).map(p -> {
                    System.out.println("at map");
                    return p.getAge();
                 })
                        .collect(
                                () -> new ArrayList<Integer>(),
                                (numberList, num) -> numberList.add(num),
                                (numberList1, numberList2) -> numberList1.addAll(numberList1)
                        ) //terminal operator
        );
//        List<Person> first10teen = people.stream().filter(p->p.getAge() <= 18).limit(10).collect(Collectors.toList());
//        System.out.println(first10teen);
    }

}
