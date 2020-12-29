package exercises;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import mockdata.MockData;
import org.junit.Test;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MoreExercises {

    private static final List<ArrayList<String>> arrayListOfNames = Lists.newArrayList(
            Lists.newArrayList("Mariam", "Alex", "Ismail"),
            Lists.newArrayList("John", "Alex", "Andre"),
            Lists.newArrayList("Susy", "Ali")
    );
   /* final Integer id;
    final String firstName;
    final String lastName;
    final String email;
    final String gender;
    final Integer age;*/
    private PersonDTO makePersonDTO(Integer id,String name,Integer age){
        return new PersonDTO(id,name,age);
    }
    @Test
    public void useStream() throws Exception {
        List<Car> cars=MockData.getCars();
        List<Person> people=new ArrayList<>(MockData.getPeople());
//        //find all the females
//        people.stream().filter(person -> person.getGender()
//                                    .equalsIgnoreCase("female")).limit(20)
//                                    .forEach(female -> System.out.println(female));
//
//        //find all the males count
//        double avgFemaleAge=people.stream().filter(person -> person.getGender()
//                .equalsIgnoreCase("female"))
//                .mapToDouble(f->f.getAge()).average().orElseGet(()->0);
//        System.out.println(avgFemaleAge);
//        //find all the cars prices
//        List<Double> priceList=cars.stream().map(car->car.getPrice()).collect(Collectors.toList());
//        System.out.println();
        //group them by company

//        Comparator<Person> rule=(person1,person2)->{
//           if(person1.getAge()==person2.getAge()) return person2.getId()-person1.getId();
//           return person1.getAge()-person2.getAge();
//        };
//        Collections.sort(people,rule);
//       people.stream().forEach(p-> System.out.println(p));
        List<PersonDTO> personDTOList=people.stream().map(p ->{
            return  makePersonDTO(p.getId(),p.getFirstName(), p.getAge());
//          return new PersonDTO();
        }).collect(Collectors.toList());
//
        System.out.println(personDTOList);
//        //find the car details of minimum price
//        double minPriceOfCar=cars.stream().mapToDouble(car->car.getPrice()).min().orElseGet(()->0);
//        Car car=cars.stream().filter(car1 -> car1.getPrice()==minPriceOfCar).findFirst().orElseGet(()->null);
//        Function<String,String> doGreet=(String name)->{
//            return "Hi "+name;
//        };
//
//        System.out.println(car);
        //find stats
   /*     DoubleSummaryStatistics stats= cars.stream().mapToDouble(car->car.getPrice()).summaryStatistics();
        System.out.println(stats);

        //find all the distinct company list
        List<String> companyList=cars.stream().map(car->car.getMake()).distinct().collect(Collectors.toList());
        System.out.println(companyList);

        Map<String,List<Car>> map=new HashMap<>();

        companyList.stream().forEach(companyname->{
            map.put(companyname,cars.stream().filter(car -> car.getMake().equalsIgnoreCase(companyname)).collect(Collectors.toList()));
        });

        map.forEach((str, car) -> {
            System.out.println(str +"-->"+car.size());
        });
        System.out.println();
        System.out.println();
        Map<String,List<Car>> groupByCompanyName=cars.stream().collect(Collectors.groupingBy((car)->car.getMake(),Collectors.toList()));
        groupByCompanyName.forEach((str, car) -> {
            System.out.println(str +"-->"+car.size());
        });
        //min,max,count ,average ,sum

        //flatten the array names
        System.out.println(arrayListOfNames.stream().flatMap(list->list.stream()).distinct().collect(Collectors.toList()));
        //find all the number cars name whose price is  >70000 (print as String)
        String carNames=cars.stream().filter(car -> car.getPrice()>7000).map(eachCar->eachCar.getModel()).collect(Collectors.joining(","));
        System.out.println(carNames);

    */
    }
}
