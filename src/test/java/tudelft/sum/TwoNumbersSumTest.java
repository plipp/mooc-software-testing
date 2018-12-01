package tudelft.sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class TwoNumbersSumTest {

  @Test
  public void addTwoNumbersOfEqualLength() {
    // given
    final List<Integer> sum = new TwoNumbersSum().addTwoNumbers(Arrays.asList(1, 2), Arrays.asList(2, 4));

    // when-then
    List<Integer> expected = Arrays.asList(3, 6);
    assertSum(expected, sum);
  }

  @Test
  public void addTwoNumbersOfUnequalLength1() {
    // given
    final List<Integer> sum = new TwoNumbersSum().addTwoNumbers(Arrays.asList(1, 2, 3), Arrays.asList(2, 4));

    // when-then
    List<Integer> expected = Arrays.asList(3, 6, 3);
    assertSum(expected, sum);
  }

  @Test
  public void addTwoNumbersOfUnequalLength2() {
    // given
    final List<Integer> sum = new TwoNumbersSum().addTwoNumbers(Arrays.asList(2, 4), Arrays.asList(1, 2, 3));

    // when-then
    List<Integer> expected = Arrays.asList(3, 6, 3);
    assertSum(expected, sum);
  }

  @Test
  public void addTwoNumbersOfEqualLengthWithUebertrag1() {
    // given
    final List<Integer> sum = new TwoNumbersSum().addTwoNumbers(Arrays.asList(9, 2), Arrays.asList(2, 4));

    // when-then
    List<Integer> expected = Arrays.asList(1, 7);
    assertSum(expected, sum);
  }

  @Test
  public void addTwoNumbersOfEqualLengthWithUebertrag2() {
    // given
    final List<Integer> sum = new TwoNumbersSum().addTwoNumbers(Arrays.asList(2,9), Arrays.asList(4,2));

    // when-then
    List<Integer> expected = Arrays.asList(6, 1, 1);
    assertSum(expected, sum);
  }

  @Test
  public void addTwoNumbersOfEqualLengthWithUebertrags() {
    // given
    final List<Integer> sum = new TwoNumbersSum().addTwoNumbers(Arrays.asList(9, 9), Arrays.asList(2, 4));

    // when-then
    List<Integer> expected = Arrays.asList(1, 4, 1);
    assertSum(expected, sum);
  }

  private void assertSum(List<Integer> expected, List<Integer> actual) {
    Assertions.assertIterableEquals(expected, actual,
      String.format("expected=%s != actual=%s", expected.toString(),actual.toString()));
  }

}
