import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.event.ActionEvent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {

  private Login login;

  @BeforeEach
  public void setup() {
    login = new Login();
  }

  @AfterEach
  public void tearDown() {
    login = null;
  }


  @Test
  public void validPatientLoginTest() {
    login.txt_username.setText("patient");
    login.txt_password.setText("123");
    String output = login.LoginAsPatientActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));

    assertEquals("valid", output);
  }


  @Test
  public void emptyPatientLoginTest() {
    login.txt_username.setText("");
    login.txt_password.setText("");
    String output = login.LoginAsPatientActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));

    assertEquals("invalid", output);
  }


  @Test
  public void validDoctorLoginTest() {
    login.txt_username.setText("doctor");
    login.txt_password.setText("123");
    String output = login.LoginAsDoctorActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));

    assertEquals("valid", output);
  }


  @Test
  public void emptyDoctorLoginTest() {
    login.txt_username.setText("");
    login.txt_password.setText("");
    String output = login.LoginAsDoctorActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));

    assertEquals("invalid", output);
  }

  @Test
  public void invalidDoctorSqlDriverTest() {
    login.txt_username.setText("sql error");
    login.txt_password.setText("");
    String output = login.LoginAsDoctorActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));

    assertEquals("error", output);
  }

  @Test
  public void invalidPatientSqlDriverTest() {
    login.txt_username.setText("sql error");
    login.txt_password.setText("");
    String output = login.LoginAsPatientActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));

    assertEquals("error", output);
  }
}
