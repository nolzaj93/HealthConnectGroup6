import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.rmi.runtime.Log;

/**
 * Unit Test for Profile class
 * @author austinnolz
 */
public class ProfileTest {

  private Profile profile;
  private RequestConversation requestConversation;
  private NewRequests newRequests;
  Connection conn=null;
  ResultSet rs=null;
  PreparedStatement pst=null;

  /**
   * Sets up profile instance and newRequests instance to create a new Request for tests.
   */
  @BeforeEach
  public void setUp(){
    profile = new Profile("patient");
    //Create new patient request, which inserts to Message and Request table
    newRequests = new NewRequests("patient");
    newRequests.createButtonActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));
  }

  /**
   * Cleanup sets Profile instance to null
   */
  @AfterEach
  public void cleanUp(){
    profile = null;

  }

  /**
   * Test Case ID: TC-Profile-01
   * Purpose: Test that clicking the make request button creates an instance of NewRequests
   * Test Setup: An instance of Login name login is created
   * Input: profile.makeRequestButtonActionPerformed(new ActionEvent(...))
   * Expected Output: True == (newRequests != null)
   */
  @Test
  public void makeRequestTest(){
    NewRequests newRequests =profile.makeRequestButtonActionPerformed(
        new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));
    assertTrue(newRequests != null);
  }

  /**
   * Test Case ID: TC-Profile-02
   * Purpose: Test that clicking the view requests button creates an instance of PatientView
   * Test Setup: An instance of Login name login is created
   * Input: profile.viewRequestButtonActionPerformed(new ActionEvent(...))
   * Expected Output: True == (patientView != null)
   */
  @Test
  public void viewRequestsTest() {
    PatientView patientView =profile.viewRequestButtonActionPerformed(
        new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));
    assertTrue(patientView != null);
  }

  /**
   * Test Case ID: TC-Profile-03
   * Purpose: Test a valid logout to reach coverage.
   * Test Setup: An instance of Login name login is created
   * Input: profile.logoutActionPerformed(new ActionEvent(...))
   * Expected Output: True == (login != null)
   */
  @Test
  public void logoutTestValid() {
    Login login =profile.logoutActionPerformed(
        new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""),false);
    assertTrue(login != null);

  }

  /**
   * Test Case ID: TC-Profile-04
   * Purpose: Test a invalid logout to reach coverage.
   * Test Setup: An instance of Login named login is created
   * Input: profile.logoutActionPerformed(new ActionEvent(...)
   * Expected Output: True == (login == null)
   */
  @Test
  public void logoutTestInvalid() {
    Login login =profile.logoutActionPerformed(
        new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""),true);
    assertTrue(login == null);
  }
}
