
import org.junit.*;
import static org.junit.Assert.*;

public class AppTest {

  @Test
  public void VowelReplace_ReturnString_String(){
    String expected = "qwrt";
    assertEquals(expected, VowelReplace.vowelsToDash("qwrt"));
  }

  @Test
  public void VowelReplace_ReturnStringWithReplacedVowel_String(){
    String expected = "-";
    assertEquals(expected, VowelReplace.vowelsToDash("a"));
  }

  @Test
  public void VowelReplace_ReturnStringWithReplacedVowels_String(){
    String expected = "s-p-rc-l-FR-G-L-st-c-xp--l-d-c---s";
    assertEquals(expected, VowelReplace.vowelsToDash("supercaliFRAGIListicexpialidocious"));
  }

}
