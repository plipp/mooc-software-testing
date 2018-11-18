package tudelft.myroman;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanNumeralTest {
  @DisplayName("Should convert single roman digit to correct arabic number")
  @ParameterizedTest(name = "{index} ==> roman=''{0}'', arabic={1}")
  @CsvSource({
    "'I', 1",
    "'V', 5",
    "'X', 10",
    "'L', 50",
    "'C', 100",
    "'D', 500",
    "'M', 1000",
  })
  public void shouldHandleSingleRomanDigit(String roman, int arabic){
    assertEquals(arabic, new RomanNumeral().convert(roman));
  }


  @DisplayName("Should convert additive roman digits to correct arabic number")
  @ParameterizedTest(name = "{index} ==> roman=''{0}'', arabic={1}")
  @CsvSource({
    "'II', 2",
    "'III', 3",
    "'XV', 15",
    "'XVIII', 18",
    "'MDCCCLXVIII', 1868",
  })
  public void shouldHandleAdditiveRomanDigits(String roman, int arabic){
    assertEquals(arabic, new RomanNumeral().convert(roman));
  }

  @DisplayName("Should convert substractive roman digits to correct arabic number")
  @ParameterizedTest(name = "{index} ==> roman=''{0}'', arabic={1}")
  @CsvSource({
    "'IV', 4",
    "'IX', 9",
    "'XL', 40",
    "'MCMXC', 1990"
  })
  public void shouldHandleSubstractiveRomanDigits(String roman, int arabic){
    assertEquals(arabic, new RomanNumeral().convert(roman));
  }

  @Test
  public void shouldReturn0ForEmptyString(){
    assertEquals(0, new RomanNumeral().convert("  "));
  }

  @Test
  public void shouldReturn0ForNullString(){
    assertEquals(0, new RomanNumeral().convert(null));
  }
}