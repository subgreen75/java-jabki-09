import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {
  @Test
    void areAnagramsTest() {
    Assertions.assertEquals(true, Main.areAnagrams("abc", "cab"));
    Assertions.assertEquals(true, Main.areAnagrams("банка", "Кабан"));
  }
}