package tudelft.numfinder;

public class NumFinder {
  private int smallest = Integer.MAX_VALUE;
  private int largest = Integer.MIN_VALUE;

  public void find(int[] nums) {
    checkNotEmpty(nums);
    for (int n : nums) {

      if (n < smallest)
        smallest = n;
      if (n > largest)
        largest = n;

    }
  }

  public int getSmallest() {
    return smallest;
  }

  public int getLargest() {
    return largest;
  }

  private static void checkNotEmpty(int[] numbers) {
    if (numbers.length == 0)
      throw new IllegalArgumentException("Array must not be empty");
  }
}
