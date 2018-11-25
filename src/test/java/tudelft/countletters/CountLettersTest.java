package tudelft.countletters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountLettersTest {

    @Test
    public void multipleMatchingWordsWithS() {
        int words = new CountLetters().count("cats|dogs");
        Assertions.assertEquals(2, words);
    }

    @Test
    public void multipleMatchingWordsWithR() {
        int words = new CountLetters().count("catr|dogr");
        Assertions.assertEquals(2, words);
    }

    @Test
    public void firstWordSAndlastWordDoesNotMatchSOrR() {
        int words = new CountLetters().count("cats|dog");
        Assertions.assertEquals(1, words);
    }

    @Test
    public void firstWordRAndlastWordDoesNotMatchSOrR() {
        int words = new CountLetters().count("ratr|dog");
        Assertions.assertEquals(1, words);
    }

    @Test
    public void doesNotMatchAtAll() {
        int words = new CountLetters().count("cat|dog");
        Assertions.assertEquals(0, words);
    }

}