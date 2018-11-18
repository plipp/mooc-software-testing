package tudelft.myroman;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeral {

  public static final Map<Character, Integer> ROMAN_DIGIT_2_INT = new HashMap<>();

  static {
    ROMAN_DIGIT_2_INT.put('I', 1);
    ROMAN_DIGIT_2_INT.put('V', 5);
    ROMAN_DIGIT_2_INT.put('X', 10);
    ROMAN_DIGIT_2_INT.put('L', 50);
    ROMAN_DIGIT_2_INT.put('C', 100);
    ROMAN_DIGIT_2_INT.put('D', 500);
    ROMAN_DIGIT_2_INT.put('M', 1000);
  }

  public int convert(String romanNumber) {
    if (romanNumber==null || romanNumber.trim().isEmpty()) return 0;

    int sum = 0;

    final char[] romanDigits = romanNumber.toCharArray();
    int last = asArabicDigit(romanDigits[0]);
    for (int i = 1; i < romanDigits.length; i++) {
      final int arabic = asArabicDigit(romanDigits[i]);
      sum += withFixedSign(last, arabic);
      last = arabic;
    }

    return sum+last;
  }

  private static int withFixedSign(int value, int lookAheadValue) {
    return value < lookAheadValue ? -value : value;
  }

  private static int asArabicDigit(char romanDigit) {
    return ROMAN_DIGIT_2_INT.get(romanDigit);
  }
}
