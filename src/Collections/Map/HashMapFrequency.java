package Collections.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HashMapFrequency {
    public static void main(String[] args) {
        String[] chars = {"A", "B", "C", "A", "C", "A"};
        System.out.println(createFrequencyMapUsingStream(chars));
        System.out.println(createFrequencyMapUsingMerge(chars));
        System.out.println(createFrequencyMapSimplestWay(chars));
    }

    //frequency map in Java 8 and above
    private static Map<String, Long> createFrequencyMapUsingStream(String[] chars) {
        return Stream.of(chars).collect(Collectors.groupingBy(Function.identity(),
                Collectors.counting()));
    }

    //version without using streams
    private static Map<String, Long> createFrequencyMapUsingMerge(String[] chars) {
        Map<String, Long> freq = new HashMap<>();
        for (String s: chars) {
            freq.merge(s, 1L, Long::sum);
        }
        return freq;
    }

    private static Map<String, Long> createFrequencyMapSimplestWay(String[] chars) {
        Map<String, Long> freq = new HashMap<>();
        for (String s: chars) {
            long frequency = freq.getOrDefault(s, 0L);
            freq.put(s, ++frequency);
        }
        return freq;
    }


}
