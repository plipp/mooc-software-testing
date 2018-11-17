package tudelft.numfinder;

import org.junit.Test;

import static org.junit.Assert.*;


public class NumFinderTest {

  @Test
  public void findLargestAndSmallestOf4Numbers() {
    final NumFinder numFinder = new NumFinder();

    numFinder.find(new int[] {4, 3, 2, 1});

    assertEquals(numFinder.getSmallest(),1);
    assertEquals(numFinder.getLargest(),4);
  }

  @Test
  public void findLargestAndSmallestOf1Number() {
    final NumFinder numFinder = new NumFinder();

    numFinder.find(new int[] {4});

    assertEquals(numFinder.getSmallest(),4);
    assertEquals(numFinder.getLargest(),4);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void findLargestAndSmallestOf0Numbers() {
    final NumFinder numFinder = new NumFinder();

    numFinder.find(new int[] {});
  }
}