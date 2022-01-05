import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DivisionTests {
    @Test
   public void TestDivision()
    {
        Division division=new Division();
        int actual=division.divisionMethod(20,10);
        int expected=2;
        Assertions.assertEquals(actual,expected);
    }
}
