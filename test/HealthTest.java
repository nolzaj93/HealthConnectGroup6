import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HealthTest {

  /**
   * Test Case ID: TC-H-02
   * Purpose: Test that when run the Health system will make the login screen visible to the user
   * Test Setup: The main method of the Health class is called with null passed in as a parameter
   * Input: args: null
   * Expected Output: true
   */
  @Test
  void testHealth() {
    Health.main(null);
    assertTrue(Health.login.isVisible());
  }

  /**
   * Test Case ID: TC-H-02
   * Purpose: Test that when run without a connection to the database the Health system will show a message with
   *          error text describing the issue to the user
   * Test Setup: The main method of the Health class is called with a string array containing "sqlTest" as the first
   *              index, indicating that a test is being run to see the error handling capabilities of the method
   * Input: args: {"sqlTest"}
   * Expected Output: "java.lang.ClassNotFoundException: sqlTest"
   */
  @Test
  void testHealthSqlException() {
    String[] sqlTest = {"sqlTest"};
    Health.main(sqlTest);
    assertEquals("java.lang.ClassNotFoundException: sqlTest", Health.sqlError);
  }
}