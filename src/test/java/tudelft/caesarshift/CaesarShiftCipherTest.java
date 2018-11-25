package tudelft.caesarshift;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CaesarShiftCipherTest {

  @ParameterizedTest(name = "str={0}, shift={1}, result={2}")
  @CsvSource({
    "'',0,''",
    "'',1,''",
    "'a',-1,'z'",
    "'a',0,'a'",
    "'a',1,'b'",
    "'ab',0,'ab'",
    "'ab',2,'cd'",
    "'z',1,'a'",
  })
  void all(String str, int shift, String result) {
    Assertions.assertEquals(result, new CaesarShiftCipher().CaesarShiftCipher(str,shift));
  }
}
