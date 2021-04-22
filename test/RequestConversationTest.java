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

      String sql ="      CREATE TABLE `Request` (\n"
          + "          `RID` varchar(255) NOT NULL,\n"
          + "      `PUsername` varchar(255) NOT NULL,\n"
          + "      `Date` varchar(255) NOT NULL,\n"
          + "      `Status` varchar(255) NOT NULL\n"
          + ")";
      pst = conn.prepareStatement(sql);
      pst.execute(sql);

      sql ="     CREATE TABLE `Message` (\n"
          + "          `RID` varchar(255) NOT NULL,\n"
          + "      `DUsername` varchar(255) NOT NULL,\n"
          + "      `TimeStamp` varchar(255) NOT NULL,\n"
          + "      `Message` varchar(255) NOT NULL\n"
          + ")";
      pst = conn.prepareStatement(sql);
      pst.execute(sql);

      sql ="select RID from Request";
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
    try {
      String sql ="drop table Message";
      pst = conn.prepareStatement(sql);
      //delete from message
      pst.setInt(1,count);
      pst.executeUpdate(sql);


      //delete from Request
      sql ="drop table Request";
      pst = conn.prepareStatement(sql);
      pst.setInt(1,count);
      pst.executeUpdate(sql);


//      String sql ="select * from Message where RID=?";
//      try
//        pst=conn.prepareStatement(sql);
//        String temp = Integer.toString(requestNumber);
//        pst.setString(1, temp);
//        rs = pst.executeQuery();
    }
    catch(SQLException e){
      JOptionPane.showMessageDialog(null, e);
    }finally {
      try {
        rs.close();
      } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
      }
    }

  }

  @AfterAll
  public void dropMessageRequestTables() {
    try {
      String sql ="drop table Message";
      pst = conn.prepareStatement(sql);
      //delete from message
      pst.execute(sql);


      //delete from Request
      sql ="drop table Request";
      pst = conn.prepareStatement(sql);
      pst.execute(sql);


//      String sql ="select * from Message where RID=?";
//      try
//        pst=conn.prepareStatement(sql);
//        String temp = Integer.toString(requestNumber);
//        pst.setString(1, temp);
//        rs = pst.executeQuery();
    }
    catch(SQLException e){
      JOptionPane.showMessageDialog(null, e);
    }finally {
      try {
        rs.close();
      } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
      }
    }
  }

  /**
   * Test Case ID:
   * Requirement ID/Description:
   * Purpose:
   * Test Setup:
   * Test Strategy:
   * Input:
   *
   * Expected Output:
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
   * Test Case ID:
   * Requirement ID/Description:
   * Purpose:
   * Test Setup:
   * Test Strategy:
   * Input:
   *
   * Expected Output:
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
   * Test Case ID:
   * Requirement ID/Description:
   * Purpose:
   * Test Setup:
   * Test Strategy:
   * Input:
   *
   * Expected Output:
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
   * Test Case ID:
   * Requirement ID/Description:
   * Purpose:
   * Test Setup:
   * Test Strategy:
   * Input:
   *
   * Expected Output:
   */
  @Test
  public void testValidDoctorRequestID(){
//    doctorView = new DoctorView("doctor");
//    doctorView.newRequestButtonActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));
//    doctorView.requestsList.setSelectedIndex(0);
//    //    doctorView.requestsListValueChanged(new ListSelectionEvent(doctorView.requestsList,1,1,false));
//    RequestConversation r = doctorView.openSelectedButtonActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));
//    r.addToRequest.setText("Test response");
//    r.addButtonActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));

    int requestID = count;
    String username = "doctor";
    String userType = "Doctor";
    requestConversation = new RequestConversation(requestID, username, userType);

    assertTrue(requestConversation.isValidConstructor);
    requestConversation.backButtonActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));
    requestConversation = new RequestConversation(requestID, username, userType);
    requestConversation.closeButtonActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""),"test");



  }


//  @Test
//  public void validPatientLoginTest() {
//    login.txt_username.setText("patient");
//    login.txt_password.setText("123");
//    String output = login.LoginAsPatientActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));
//
//    assertEquals("valid", output);
//  }
//

}
