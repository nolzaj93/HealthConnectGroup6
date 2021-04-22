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

public class ProfileTest {

  private Profile profile;
  private RequestConversation requestConversation;
  private NewRequests newRequests;
  Connection conn=null;
  ResultSet rs=null;
  PreparedStatement pst=null;

  @BeforeEach
  public void setUp(){
    profile = new Profile("patient");
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

    }
    catch(ClassNotFoundException | SQLException e){
      JOptionPane.showMessageDialog(null, e);
    }

    //Create new patient request, which inserts to Message and Request table
    newRequests = new NewRequests("patient");
    newRequests.createButtonActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));

  }

  @AfterEach
  public void cleanUp(){
    profile = null;

  }

  @Test
  public void makeRequestTest(){
    NewRequests newRequests =profile.makeRequestButtonActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));
    assertTrue(newRequests != null);
  }

  @Test
  public void viewRequestsTest() {
    PatientView patientView =profile.viewRequestButtonActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));
    assertTrue(patientView != null);
  }

  @Test
  public void logoutTestValid() {
    Login login =profile.logoutActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""),false);
    assertTrue(login != null);

  }

  @Test
  public void logoutTestInvalid() {
    Login login =profile.logoutActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""),true);
    assertTrue(login == null);

  }

}
