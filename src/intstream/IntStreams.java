package intstream;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreams {
  public static void main(String[] args) {
    List<Integer> range = IntStream.range(0, 4)
                                   .boxed()
                                   .collect(Collectors.toList());
    System.out.println("range" + range);
    List<Integer> rangeClosed = IntStream.rangeClosed(0, 4)
                                         .boxed()
                                         .collect(Collectors.toList());
    System.out.println("range closed" + rangeClosed);

    List<String> names = Stream.of("Jason", "David", "Jack", "Klara")
                               .collect(Collectors.toList());
    Random random = new Random();
    IntStream.iterate(0, n -> n + 7)
//             .skip(5)
             .limit(names.size())
             .mapToObj(n -> random.nextInt(names.size()))
             .map(n -> n % names.size())
             .map(n -> names.get(n))
//             .map(n -> names.get(n))
             .forEach(n -> System.out.println(n));

    OptionalInt max = IntStream.iterate(0, n -> n + 1)
                               .limit(100)
                               .filter(n -> n > 1000)
//                             .average();
//                             .min();
                               .max();
    if (max.isPresent()) {
      System.out.println("number " + max.getAsInt());
    } else {
      System.out.println("number is not present.");
    }

    OptionalDouble average = names.stream()
                                  .map(e -> e.split(""))
                                  .flatMap(e -> Stream.of(e))
                                  .mapToInt(e -> (int) e.charAt(0))
                                  .average();
    if (average.isPresent()) {
      System.out.println("Average " + average.getAsDouble());
    } else {
      System.out.println("AVERAGE IS NOT PRESENT");
    }

    IntStream.range(0, 4)
             .filter(n -> n % 2 == 0)
             .forEach(n -> System.out.println("we will we will rock you."));
  }
}
