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
import javax.swing.event.ListSelectionEvent;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * Unit test class for RequestConversation
 * @author austin nolz
 */
@TestInstance(Lifecycle.PER_CLASS)
public class RequestConversationTest {

  private RequestConversation requestConversation;
  private NewRequests newRequests;
  Connection conn=null;
  ResultSet rs=null;
  PreparedStatement pst=null;
  int count = 100;

  /**
   * Sets up connection to database to create a test patient request.
   */
  @BeforeEach
  public void setUp() {

    try {
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection("jdbc:mysql://localhost/health", "root", "");
      //JOptionPane.showMessageDialog (null, "Connected");
      Statement statement = conn.createStatement();
      String sql ="select RID from Request";
      rs = statement.executeQuery(sql);
      while(rs.next())
        count++;

    }
    catch(ClassNotFoundException | SQLException e){
      JOptionPane.showMessageDialog(null, e);
    }

  //Create new patient request, which inserts to Message and Request table
  newRequests = new NewRequests("patient");
  newRequests.createButtonActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));

  }

  /**
   * cleans up memory by setting RequestConversation object to null and deleting added records
   */
  @AfterEach
  public void tearDown() {
    requestConversation = null;
  }

  /**
   * Test Case ID: TC-RC-01
   * Purpose: Test that invalid Patient RID is found to be invalid in constructor
   * Test Setup: setUp method connects to database and finds next count
   *  instances of RequestConversation and NewRequests created
   * Input: int requestID = 0;
   *     String username = "patient";
   *     String userType = "Patient";
   * Expected Output: True == !requestConversation.isValidConstructor
   */
  @Test
  public void testInvalidPatientRequestID(){
    int requestID = 0;
    String username = "patient";
    String userType = "Patient";
    requestConversation = new RequestConversation(requestID, username, userType);
    assertTrue(!requestConversation.isValidConstructor);

    requestConversation.closeButtonActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""),"test");

    requestConversation = new RequestConversation(requestID, username, userType);
    requestConversation.closeButtonActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""),"");

  }

  /**
   * Test Case ID: TC-RC-02
   * Purpose: Test that valid patient RID is accepted in constructor.
   * Test Setup: SetUp method connects to database and finds next count
   *     instances of RequestConversation and NewRequests created
   * Input: int requestID = count;
   *     String username = "doctor";
   *     String userType = "Doctor";
   * Expected Output: True == requestConversation.isValidConstructor
   */
  @Test
  public void testValidPatientRequestID(){
    int requestID = count;
    String username = "patient";
    String userType = "Patient";
    requestConversation = new RequestConversation(requestID, username, userType);
    assertTrue(requestConversation.isValidConstructor);

    //Update to Closed
    String sql = "update Request set status=? where RID =?";
    try{
      pst=conn.prepareStatement(sql);
      String temp = Integer.toString(requestID);
      pst.setString(1, "Closed");
      pst.setString(2,temp);

      pst.executeUpdate();


    }
    catch(SQLException e){
      JOptionPane.showMessageDialog(null, e);
    }

    requestConversation = new RequestConversation(requestID, username, userType);
    assertTrue(requestConversation.isValidConstructor);
    requestConversation.addButtonActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""),"");

    requestConversation.backButtonActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));
    requestConversation = new RequestConversation(requestID, username, userType);
    requestConversation.closeButtonActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""),"");


  }

  /**
   * Test Case ID: TC-RC-03
   * Purpose: Test that invalid Doctor RID is found to be invalid in constructor
   * Test Setup: setUp method connects to database and finds next count
   *  instances of RequestConversation and NewRequests created
   * Input: int requestID = 0;
   *     String username = "doctor";
   *     String userType = "Doctor";
   * Expected Output: True == !requestConversation.isValidConstructor
   */
  @Test
  public void testInvalidDoctorRequestID(){
    int requestID = 0;
    String username = "doctor";
    String userType = "Doctor";
    requestConversation = new RequestConversation(requestID, username, userType);

    assertTrue(!requestConversation.isValidConstructor);

    requestConversation.addButtonActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""),"test");
    requestConversation.closeButtonActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""),"test");


  }

  /**
   * Test Case ID: TC-RC-04
   * Purpose: Test that valid Doctor RID is accepted in the constructor
   * Test Setup: SetUp method connects to database and finds next count
   *      instances of RequestConversation and NewRequests created
   * Input: int requestID = count;
   *     String username = "doctor";
   *     String userType = "Doctor";
   * Expected Output: True == requestConversation.isValidConstructor
   */
  @Test
  public void testValidDoctorRequestID(){

    int requestID = count;
    String username = "doctor";
    String userType = "Doctor";
    requestConversation = new RequestConversation(requestID, username, userType);

    assertTrue(requestConversation.isValidConstructor);
    requestConversation.backButtonActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));
    requestConversation = new RequestConversation(requestID, username, userType);
    requestConversation.closeButtonActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""),"test");
  }
}
