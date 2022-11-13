package dev.profitsoft;

import dev.profitsoft.model.Shape;
import dev.profitsoft.model.implementation.Cube;
import dev.profitsoft.model.implementation.Cylinder;
import dev.profitsoft.model.implementation.Sphere;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

public class UtilsTest {

    /*
     * Group of tests for method getSortedPositiveNumberByDESC() with int[]
     */
    @Test
    @DisplayName("getSortedPositiveNumbersByDESCW(): Test with an array of unique integer numbers " +
            "should return an array of not negative numbers in DESC order")
    public void getSortedPositiveNumbersByDESC_WithArrayOfUniqueIntegerNumbersTest() {
        int[] input = new int[] {14, -5, 1, 0, -1, 13, 2, 18, 22, -13, 17, -28};
        int[] expected = new int[] {22, 18, 17, 14, 13, 2, 1, 0};

        sortedPositiveNumbersTesting(input, expected);
    }

    @Test
    @DisplayName("getSortedPositiveNumbersByDESCW(): Test with an array of duplicate integer numbers " +
            "should return an array of all duplicate not negative numbers in DESC order")
    public void getSortedPositiveNumbersByDESC_WithArrayOfDuplicateIntegerNumbersTest() {
        int[] input = new int[] {3, 5, 1, 3, -12, 5, -12, 0, 0, 3, 3};
        int[] expected = new int[] {5, 5, 3, 3, 3, 3, 1, 0, 0};

        sortedPositiveNumbersTesting(input, expected);
    }

    @Test
    @DisplayName("getSortedPositiveNumbersByDESCW(): Test with an array of negative numbers " +
            "should return an empty array")
    public void getSortedPositiveNumbersByDESC_WithArrayOfNegativeNumbersTest() {
        int[] input = new int[] {-14, -1, -13, -2, -18, -22, -17, -22, -2};
        int[] expected = new int[] {};

        sortedPositiveNumbersTesting(input, expected);
    }

    @Test
    @DisplayName("getSortedPositiveNumbersByDESCW(): Test with an empty array " +
            "should return an empty array")
    public void getSortedPositiveNumbersByDESC_WithEmptyArrayTest() {
        int[] input = new int[] {};
        int[] expected = new int[] {};

        sortedPositiveNumbersTesting(input, expected);
    }

    @Test
    @DisplayName("getSortedPositiveNumbersByDESCW(): Speed test with an array of big counts of numbers " +
            "should return a result after less than 200 millis")
    public void getSortedPositiveNumbersByDESC_WithArraySpeedTest() {
        int numberOfElements = 1_000_000;
        int numberOfMillis = 200;
        int[] input = getRandomInts(numberOfElements);

        Assertions.assertTimeout(Duration.ofMillis(numberOfMillis), () -> Utils.getSortedPositiveNumbersByDESC(input));
    }

    /*
     * Group of tests for method getSortedPositiveNumberByDESC() with List<Integer>
     */
    @Test
    @DisplayName("getSortedPositiveNumbersByDESCW(): Test with a list of unique integer numbers " +
            "should return a list of not negative numbers in DESC order")
    public void getSortedPositiveNumbersByDESC_WithListOfUniqueIntegerNumbersTest() {
        List<Integer> input = new ArrayList<>(List.of(14, -5, 1, 0, -1, 13, 2, 18, 22, -13, 17, -28));
        List<Integer> expected = new ArrayList<>(List.of(22, 18, 17, 14, 13, 2, 1, 0));

        sortedPositiveNumbersTesting(input, expected);
    }

    @Test
    @DisplayName("getSortedPositiveNumbersByDESCW(): Test with list of duplicate integer numbers " +
            "should return a list of all duplicate not negative numbers in DESC order")
    public void getSortedPositiveNumbersByDESC_WithListOfDuplicateIntegerNumbersTest() {
        List<Integer> input = new ArrayList<>(List.of(3, 5, 1, 3, -12, 5, -12, 0, 0, 3, 3));
        List<Integer> expected = new ArrayList<>(List.of(5, 5, 3, 3, 3, 3, 1, 0, 0));

        sortedPositiveNumbersTesting(input, expected);
    }

    @Test
    @DisplayName("getSortedPositiveNumbersByDESCW(): Test with list of negative numbers " +
            "should return an empty list")
    public void getSortedPositiveNumbersByDESC_WithListOfNegativeNumbersTest() {
        List<Integer> input = new ArrayList<>(List.of(-14, -1, -13, -2, -18, -22, -17, -22, -2));
        List<Integer> expected = new ArrayList<>();

        sortedPositiveNumbersTesting(input, expected);
    }

    @Test
    @DisplayName("getSortedPositiveNumbersByDESCW(): Test with empty list " +
            "should return an empty list")
    public void getSortedPositiveNumbersByDESC_WithEmptyListTest() {
        List<Integer>  input = new ArrayList<>();
        List<Integer>  expected = new ArrayList<>();

        sortedPositiveNumbersTesting(input, expected);
    }

    @Test
    @DisplayName("getSortedPositiveNumbersByDESCW(): Test with null " +
            "should return an empty list")
    public void getSortedPositiveNumbersByDESC_WithNullTest() {
        List<Integer>  input = null;
        List<Integer>  expected = new ArrayList<>();

        sortedPositiveNumbersTesting(input, expected);
    }

    @Test
    @DisplayName("getSortedPositiveNumbersByDESCW(): Test with a list with null and integer values " +
            "should return a list of not negative numbers in DESC order")
    public void getSortedPositiveNumbersByDESCWithList_WithNullValuesTest() {
        List<Integer> input = new ArrayList<>(List.of(3, 5, 1, 3, -12, 5, -12, 0, 0, 3, 3));
        input.set(3, null);
        input.add(null);

        List<Integer> expected = new ArrayList<>(List.of(5, 5, 3, 3, 3, 1, 0, 0));
        sortedPositiveNumbersTesting(input, expected);
    }

    @Test
    @DisplayName("getSortedPositiveNumbersByDESCW(): Speed test with a list of big count of numbers " +
            "should return a result after less than 200 millis")
    public void getSortedPositiveNumbersByDESC_WithListSpeedTest() {
        int numberOfElements = 1_000_000;
        int numberOfMillis = 200;
        List<Integer> input = Arrays.stream(getRandomInts(numberOfElements))
                .boxed()
                .collect(Collectors.toList());

        Assertions.assertTimeout(Duration.ofMillis(numberOfMillis), () -> Utils.getSortedPositiveNumbersByDESC(input));
    }

    /*
     * Group of tests for method getFiveMostCommonTagsFromTexts()
     */
    @Test
    @DisplayName("getFiveMostCommonTagsFromTexts(): Test with five unique tags in all texts " +
            "should return a map of all tags and their occurrences")
    public void getFiveMostCommonTagsFromTexts_WithFiveUniqueTagsTest() {
        List<String> input = new ArrayList<>(List.of(
                "_____ _____ _____ #tag1 _____ _____ _____ _____ _____ _____",
                "_____ #tag2 _____ #tag1 _____ _____ _____ _____ _____ _____",
                "#tag3 #tag2 _____ #tag1 _____ _____ _____ _____ _____ _____",
                "#tag3 #tag2 _____ #tag1 _____ #tag4 _____ _____ _____ _____",
                "#tag3 #tag2 _____ #tag1 _____ #tag4 #tag5 _____ _____ _____"
        ));
        Map<String, Integer> expected = new LinkedHashMap<>();
        expected.put("#tag1", 5);
        expected.put("#tag2", 4);
        expected.put("#tag3", 3);
        expected.put("#tag4", 2);
        expected.put("#tag5", 1);

        fiveMostCommonTagsFromTextsTesting(input, expected);
    }

    @Test
    @DisplayName("getFiveMostCommonTagsFromTexts(): Test with less than five unique tags in all texts " +
            "should return a map of all tags")
    public void getFiveMostCommonTagsFromTexts_WithLessThanFiveUniqueTagsTest() {
        List<String> input = new ArrayList<>(List.of(
                "_____ _____ _____ #tag1 _____ _____ _____ _____ _____ _____",
                "_____ _____ _____ #tag1 _____ _____ _____ _____ _____ _____",
                "#tag3 _____ _____ #tag1 _____ _____ _____ _____ _____ _____",
                "#tag3 _____ _____ #tag1 _____ #tag4 _____ _____ _____ _____",
                "#tag3 _____ _____ #tag1 _____ #tag4 #tag5 _____ _____ _____"
        ));
        Map<String, Integer> expected = new LinkedHashMap<>();
        expected.put("#tag1", 5);
        expected.put("#tag3", 3);
        expected.put("#tag4", 2);
        expected.put("#tag5", 1);

        fiveMostCommonTagsFromTextsTesting(input, expected);
    }

    @Test
    @DisplayName("getFiveMostCommonTagsFromTexts(): Test with more than five unique tags in all texts " +
            "should return a map of the top five tags by their occurrences in texts")
    public void getFiveMostCommonTagsFromTexts_WithMoreThanFiveUniqueTagsTest() {
        List<String> input = new ArrayList<>(List.of(
                "_____ _____ _____ #tag1 _____ _____ _____ _____ _____ _____",
                "_____ #tag2 _____ #tag1 _____ _____ _____ _____ _____ _____",
                "#tag3 #tag2 _____ #tag1 _____ _____ _____ _____ _____ _____",
                "#tag3 #tag2 _____ #tag1 _____ #tag4 #tag5 _____ _____ #tag7",
                "#tag3 #tag2 _____ #tag1 _____ #tag4 #tag5 _____ #tag6 _____"
        ));
        Map<String, Integer> expected = new LinkedHashMap<>();
        expected.put("#tag1", 5);
        expected.put("#tag2", 4);
        expected.put("#tag3", 3);
        expected.put("#tag4", 2);
        expected.put("#tag5", 2);

        fiveMostCommonTagsFromTextsTesting(input, expected);
    }

    @Test
    @DisplayName("getFiveMostCommonTagsFromTexts(): Test with the duplicate tags in one text " +
            "should ignore duplicate occurrence of a tag in one text and return a map of the top five tags")
    public void getFiveMostCommonTagsFromTexts_WithDuplicateTagsInOneTextTest() {
        List<String> input = new ArrayList<>(List.of(
                "_____ _____ _____ #tag1 #tag1 #tag1 _____ _____ _____ _____",
                "#tag2 #tag2 #tag2 #tag1 _____ _____ _____ _____ _____ _____",
                "#tag3 #tag2 _____ #tag1 _____ _____ _____ _____ _____ _____",
                "#tag3 #tag2 _____ #tag1 _____ #tag4 #tag5 _____ _____ #tag7",
                "#tag3 #tag2 _____ #tag1 _____ #tag4 #tag5 _____ #tag6 _____"
        ));
        Map<String, Integer> expected = new LinkedHashMap<>();
        expected.put("#tag1", 5);
        expected.put("#tag2", 4);
        expected.put("#tag3", 3);
        expected.put("#tag4", 2);
        expected.put("#tag5", 2);

        fiveMostCommonTagsFromTextsTesting(input, expected);
    }

    @Test
    @DisplayName("getFiveMostCommonTagsFromTexts(): Test with specific tags " +
            "should detect specific tags and return a map of the top five tags")
    public void getFiveMostCommonTagsFromTexts_WithSpecificTagsTest() {
        List<String> input = new ArrayList<>(List.of(
                "_____ _____ _____ #tag1-!@_\\ _____ _____ _____ _____ _____ _____",
                "_____ #tag2AaB _____ #tag1-!@_\\ _____ _____ _____ _____ _____ _____",
                "#tag3 #tag2AaB _____ #tag1-!@_\\ _____ _____ _____ _____ _____ _____",
                "#tag3 #tag2AaB _____ #tag1-!@_\\ _____ #tag4-tag4 _____ _____ _____ _____",
                "#tag3 #tag2AaB _____ #tag1-!@_\\ _____ #tag4-tag4 #tag5 _____ _____ _____"
        ));
        Map<String, Integer> expected = new LinkedHashMap<>();
        expected.put("#tag1-!@_\\", 5);
        expected.put("#tag2AaB", 4);
        expected.put("#tag3", 3);
        expected.put("#tag4-tag4", 2);
        expected.put("#tag5", 1);

        fiveMostCommonTagsFromTextsTesting(input, expected);
    }

    @Test
    @DisplayName("getFiveMostCommonTagsFromTexts(): Test with the same number of occurrences of tags " +
            "should return a map of the top five tags considering the same occurrence of different tags")
    public void getFiveMostCommonTagsFromTexts_WithSameNumberOfOccurrencesTagsTest() {
        List<String> input = new ArrayList<>(List.of(
                "_____ #tag2 _____ #tag1 _____ _____ _____ _____ _____ _____",
                "_____ #tag2 _____ #tag1 _____ _____ _____ _____ _____ _____",
                "#tag3 #tag2 _____ #tag1 _____ #tag4 #tag5 _____ _____ _____",
                "#tag3 #tag2 _____ #tag1 _____ #tag4 #tag5 _____ #tag6 _____",
                "#tag3 #tag2 _____ #tag1 _____ #tag4 #tag5 _____ #tag6 _____"
        ));
        Map<String, Integer> expected = new LinkedHashMap<>();
        expected.put("#tag1", 5);
        expected.put("#tag2", 5);
        expected.put("#tag3", 3);
        expected.put("#tag4", 3);
        expected.put("#tag5", 3);

        Map<String, Integer> actual = Utils.getFiveMostCommonTagsFromTexts(input);
        Assertions.assertTrue(expected.entrySet().containsAll(actual.entrySet()));
    }

    @Test
    @DisplayName("getFiveMostCommonTagsFromTexts(): Test with no tags " +
            "should return an empty map")
    public void getFiveMostCommonTagsFromTexts_WithNoTagsTest() {
        List<String> input = new ArrayList<>(List.of(
                "_____ _____ _____ _____ _____ _____ _____ _____ _____ _____",
                "_____ _____ _____ _____ _____ _____ _____ _____ _____ _____",
                "_____ _____ _____ _____ _____ _____ _____ _____ _____ _____",
                "_____ _____ _____ _____ _____ _____ _____ _____ _____ _____",
                "_____ _____ _____ _____ _____ _____ _____ _____ _____ _____"
        ));
        Map<String, Integer> expected = new LinkedHashMap<>();

        fiveMostCommonTagsFromTextsTesting(input, expected);
    }

    @Test
    @DisplayName("getFiveMostCommonTagsFromTexts(): Test with null " +
            "should return an empty map")
    public void getFiveMostCommonTagsFromTexts_WithNullTest() {
        List<String> input = null;
        Map<String, Integer> expected = new LinkedHashMap<>();

        fiveMostCommonTagsFromTextsTesting(input, expected);
    }

    @Test
    @DisplayName("getFiveMostCommonTagsFromTexts(): Test with null elements of a list " +
            "should ignore null values and return a map of the top five tags")
    public void getFiveMostCommonTagsFromTexts_WithNullElementsOfListTest() {
        List<String> input = new ArrayList<>();
        input.add("#tag1 #tag2");
        input.add(null);
        input.add("#tag1");

        Map<String, Integer> expected = new LinkedHashMap<>();
        expected.put("#tag1", 2);
        expected.put("#tag2", 1);

        fiveMostCommonTagsFromTextsTesting(input, expected);
    }

    /*
     * Group of tests for method getSortedShapeByVolume()
     */
    @Test
    @DisplayName("getSortedShapeByVolume(): Test with a list of shapes " +
            "should return a list of shapes ordered by their volume in DESC order")
    public void sortShapeByVolumeTest() {
        List<Shape> input = new ArrayList<>(List.of(
                new Cube(3),
                new Cylinder(5, 3),
                new Sphere(3)
        ));
        List<Shape> expected = new ArrayList<>(List.of(
                new Cylinder(5, 3),
                new Sphere(3),
                new Cube(3)
        ));

        sortedShapeByVolumeTesting(input, expected);
    }

    @Test
    @DisplayName("getSortedShapeByVolume(): Test with a list of shapes with null elements " +
            "should ignore null values and return a list of shapes ordered by their volume in DESC order")
    public void sortShapeByVolume_WithNullElementsOfListTest() {
        List<Shape> input = new ArrayList<>(List.of(
                new Cube(3),
                new Cylinder(5, 3),
                new Sphere(3)
        ));
        input.add(null);

        List<Shape> expected = new ArrayList<>(List.of(
                new Cylinder(5, 3),
                new Sphere(3),
                new Cube(3)
        ));

        sortedShapeByVolumeTesting(input, expected);
    }

    @Test
    @DisplayName("getSortedShapeByVolume(): Test with null " +
            "should return an empty list")
    public void sortShapeByVolume_WithNullTest() {
        List<Shape> input = null;
        List<Shape> expected = new ArrayList<>();

        sortedShapeByVolumeTesting(input, expected);
    }

    @Test
    @DisplayName("getSortedShapeByVolume(): Test with empty list " +
            "should return an empty list")
    public void sortShapeByVolume_WithEmptyListTest() {
        List<Shape> input = new ArrayList<>();
        List<Shape> expected = new ArrayList<>();

        sortedShapeByVolumeTesting(input, expected);
    }

    /*
     * Addition methods
     */
    private int[] getRandomInts(int countOfInts) {
        int[] input = new int[countOfInts];

        for(int i = 0; i < countOfInts; i++) {
            input[i] = new Random().nextInt(99) - 49;
        }
        return input;
    }

    private void sortedShapeByVolumeTesting(List<Shape> input, List<Shape> expected) {
        List<Shape> actual = Utils.getSortedShapeByVolume(input);
        Assertions.assertEquals(expected, actual);
    }

    private void fiveMostCommonTagsFromTextsTesting(List<String> input, Map<String, Integer> expected) {
        Map<String, Integer> actual = Utils.getFiveMostCommonTagsFromTexts(input);
        Assertions.assertEquals(expected, actual);
    }

    private void sortedPositiveNumbersTesting(List<Integer> input, List<Integer> expected) {
        List<Integer> actual = Utils.getSortedPositiveNumbersByDESC(input);

        Assertions.assertEquals(expected.size(), actual.size());
        Assertions.assertEquals(expected, actual);
    }

    private void sortedPositiveNumbersTesting(int[] input, int[] expected) {
        int[] actual = Utils.getSortedPositiveNumbersByDESC(input);

        Assertions.assertEquals(expected.length, actual.length);
        Assertions.assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }


}
