import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.event.ActionEvent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * LoginTest class
 *
 * @author austin nolz
 */
public class LoginTest {

  private Login login;

  /**
   * Creates instance of login before each test.
   */
  @BeforeEach
  public void setup() {
    login = new Login();
  }

  /**
   * Cleans up memory by setting login object reference to null.
   */
  @AfterEach
  public void tearDown() {
    login = null;
  }

  /**
   * Test Case ID: TC-L-01 Purpose: Test that a valid login is accepted by the query to the MySQL
   * database Test Setup: An instance of Login name login is created Input: 
   * -txt_username is set to patient 
   * -txt_password is set to 123 - (valid test credentials in schema) Expected Output:
   * "valid"
   */
  @Test
  public void validPatientLoginTest() {
    login.txt_username.setText("patient");
    login.txt_password.setText("123");
    String output = login
        .LoginAsPatientActionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ""));

    assertEquals("valid", output);
  }

  /**
   * Test Case ID: TC-L-02 
   * Purpose: Test that an empty patient login is not accepted by the query to
   * the MySQL database 
   * Test Setup: An instance of Login name login is created 
   * Input: -txt_username is set to "" empty string 
   *        -txt_password is set to "" - (empty test credentials in schema)
   * Expected Output: "invalid"
   */
  @Test
  public void emptyPatientLoginTest() {
    login.txt_username.setText("");
    login.txt_password.setText("");
    String output = login
        .LoginAsPatientActionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ""));

    assertEquals("invalid", output);
  }

  /**
   * Test Case ID: TC-L-03 
   * Purpose: Test that a valid doctor login is accepted by the query to the
   * MySQL database 
   * Test Setup: An instance of Login name login is created 
   * Input: -txt_username is set to doctor
   * -txt_password is set to 123 - (valid test credentials in schema) 
   * Expected Output: "valid"
   */
  @Test
  public void validDoctorLoginTest() {
    login.txt_username.setText("doctor");
    login.txt_password.setText("123");
    String output = login
        .LoginAsDoctorActionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ""));

    assertEquals("valid", output);
  }

  /**
   * Test Case ID: TC-L-04 
   * Purpose: Test that an empty doctor login is not accepted by the query to
   * the MySQL database 
   * Test Setup: An instance of Login name login is created 
   * Input: -txt_username is set to "" empty string 
   *       -txt_password is set to "" - (empty test credentials) 
   * Expected Output: "invalid"
   */
  @Test
  public void emptyDoctorLoginTest() {
    login.txt_username.setText("");
    login.txt_password.setText("");
    String output = login
        .LoginAsDoctorActionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ""));

    assertEquals("invalid", output);
  }

  /**
   * Test Case ID: TC-L-05 
   * Purpose: Test that invalid patient login returns "error" by the query to
   * the MySQL database 
   * Test Setup: An instance of Login name login is created 
   * Input: -txt_username is set to "sql error" 
   * -txt_password is set to empty string "" - (invalid test credentials)
   * Expected Output: "error"
   */
  @Test
  public void invalidDoctorSqlDriverTest() {
    login.txt_username.setText("sql error");
    login.txt_password.setText("");
    String output = login
        .LoginAsDoctorActionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ""));

    assertEquals("error", output);
  }

  /**
   * Test Case ID: TC-L-06 
   * Purpose: Test that invalid patient login returns "error" by the query to
   * the MySQL database 
   * Test Setup: An instance of Login name login is created 
   * Input: -txt_username is set to "sql error" 
   * -txt_password is set to empty string "" - (invalid test credentials)
   * Expected Output: "error"
   */
  @Test
  public void invalidPatientSqlDriverTest() {
    login.txt_username.setText("sql error");
    login.txt_password.setText("");
    String output = login
        .LoginAsPatientActionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ""));

    assertEquals("error", output);
  }
}
