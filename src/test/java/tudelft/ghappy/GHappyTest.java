package tudelft.ghappy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GHappyTest {
  @ParameterizedTest(name = "str={0}, result={1}")
  @CsvSource({
    "'',true",
    "'g',false",
    "'hapgpy',false",
    "'gg',true",
    "'hapggpy',true",
    "'hapggpyg',false"
  })
  void all(String str, boolean result) {
    Assertions.assertEquals(new GHappy().gHappy(str), result);
  }
}
