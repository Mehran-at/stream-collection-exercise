package methodreferences;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MethodRerefences {
  public static void main(String[] args) {
    List<String> names = Stream.of("Alex", "Stefan", "Matilda", "Lina")
                               .collect(Collectors.toList());
    names.stream()
         .map(String::toUpperCase)
         .sorted(MethodRerefences::awesomeSort)
         .forEach(MethodRerefences::greet);

    Collections.swap(names, 0, 2);
    System.out.println("\nCollectin of names: " + names);

    names.stream()
         .sorted(Comparator.reverseOrder())
         .forEach(System.out::println);

    names.stream()
         .forEach(MethodRerefences::greet);

    IntStream.range(0, 10)
             .forEach(System.out::println);
  }

  public static void greet(String name) {
    System.out.println("\nHello, " + name + ".");
  }

  public static int awesomeSort(String name1, String name2) {
    if (name1.equalsIgnoreCase("Alex")) {
      return -1;
    }
    return name1.compareTo(name2);
  }
}
