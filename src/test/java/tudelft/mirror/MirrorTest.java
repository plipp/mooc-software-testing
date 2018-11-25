package tudelft.mirror;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MirrorTest {
  @ParameterizedTest(name = "str={0}, result={1}")
  @CsvSource({
    "'',''",
    "'a',''",
    "'ab',''",
    "'aba','a'",
    "'abc',''",
    "'abcba','ab'",
    "'abcdba','ab'"
  })
  void all(String str, String result) {
    Assertions.assertEquals(new Mirror().mirrorEnds(str), result);
  }
}
