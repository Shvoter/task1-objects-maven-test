package dev.profitsoft;

import dev.profitsoft.model.Shape;

import java.util.*;
import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Set of utilities to work with arrays, strings and shapes
 */
public class Utils {

    /**
     * The method that takes an array of ints as input and returns only those that are positive or equal to zero
     *
     */
    public static int[] getSortedPositiveNumbersByDESC(int[] numbers) {
        int[] result = IntStream.of(numbers)
                .filter(number -> number >= 0)
                .sorted()
                .toArray();
        /*
         * We can't  sort in DESC with an array of primitives using a declarative approach,
         * so we sort in ASC and then reverse the array
         */
        return reverse(result);
    }

    /**
     * The method that takes a List of Integers as input and returns only those that are positive or equal to zero
     */
    public static List<Integer> getSortedPositiveNumbersByDESC(List<Integer> numbers) {
        if (numbers == null) {
            return new ArrayList<>();
        }

        return numbers.stream()
                .filter(Objects::nonNull)
                .filter(number -> number >= 0)
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }

    /**
     * The method that takes an array of ints as input and returns copy of input array in reverse order
     */
    private static int[] reverse(int[] numbers) {
        int length = numbers.length;

        return IntStream.range(0, length)
                .map(i -> numbers[length - 1 - i])
                .toArray();
    }

    /**
     * The method accepts a list of row texts as input which can contain hashtags.
     * As a result, the method returns Map with the top 5 most guessed hashtags.
     * The same hashtags in the same row are one mention.
     *
     * @return - Map<String, Integer> where key is tags from top and value is number of occurrences them
     */
    public static Map<String, Integer> getFiveMostCommonTagsFromTexts(List<String> texts) {
        if (texts == null) {
            return new LinkedHashMap<>();
        }

        final Pattern patternOfTag = Pattern.compile("#\\S+");
        Map<String, Integer> tagCounts = getTagCounts(texts, patternOfTag);

        return tagCounts.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue() - entry1.getValue())
                .limit(5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> y, LinkedHashMap::new));
    }

    /**
     * The method that counting all unique tags from List<String> of texts
     * @param patternOfTag - definition of what is tag.
     * @return - Map<String, Integer> where key is tags from all texts and value is number of occurrences them
     */
    private static Map<String, Integer> getTagCounts(List<String> texts, Pattern patternOfTag) {
        return texts.stream()
                .filter(Objects::nonNull)
                .flatMap(text -> patternOfTag.matcher(text).results()
                    .map(MatchResult::group)
                    .distinct())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(s -> 1)));
    }

    /**
     * The method that sorts geometric 3d shapes by volume in DESC order and return List<Shape> of them
     * @param shapes - List<Shape> of shapes
     *
     */
    public static List<Shape> getSortedShapeByVolume(List<Shape> shapes) {
        if (shapes == null) {
            return new ArrayList<>();
        }

        return shapes.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingDouble(Shape::getVolume).reversed())
                .collect(Collectors.toList());
    }
}
