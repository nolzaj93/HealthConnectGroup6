import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientViewTest {

    private PatientView patientView;
    private String username;
    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;


    /**
     * Instantiates new patient for testing and creates connection to DB.
     */
    @BeforeEach
    public void setup() {
        username = "patient";
        patientView = new PatientView(username);
        conn = patientView.conn;
    }

    /**
     * Test Case ID: TC-PV-01
     * Purpose: Test that clicking the closed request button will show closed requests
     * Test Setup: An instance of the PatientView is created and the setClosedRequestsDisplay()
     * method is called with the ResultSet of closed requests passed as a parameter.
     * Input: ResultSet containing the closed requests
     * Expected Output: "closed requests displayed"
     */
    @Test
    public void closedRequestsMenuTest() {
        String sql = "select RID,Date from Request where Status=? and PUsername=?";

        patientView.closedButtonActionPerformed(new ActionEvent
                (this,ActionEvent.ACTION_PERFORMED,""));

        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, "Closed");
            pst.setString(2, username);
            rs = pst.executeQuery();
            assertEquals("closed requests displayed", patientView.setClosedRequestsDisplay(rs));

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * Test Case ID: TC-PV-02
     * Purpose: Test that clicking the closed request button will not show closed requests.
     * Test Setup: An instance of the PatientView is created and the setClosedRequestsDisplay()
     * method is called with the ResultSet of closed requests passed as a parameter.
     * Input: empty ResultSet
     * Expected Output: "no closed requests"
     */
    @Test
    public void emptyClosedRequestMenuTest() {
        String sql = "select RID,Date from Request where Status=? and PUsername=?";

        patientView.closedButtonActionPerformed(new ActionEvent
                (this,ActionEvent.ACTION_PERFORMED,""));
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, "Closed");
            pst.setString(2, "john");
            rs = pst.executeQuery();
            assertEquals("no closed requests", patientView.setClosedRequestsDisplay(rs));

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * Test Case ID: TC-PV-03
     * Purpose: Test that clicking the new request button will show new requests.
     * Test Setup: An instance of the PatientView is created and the setNewRequestsDisplay()
     * method is called with the ResultSet of new requests passed as a parameter.
     * Input: ResultSet containing new requests
     * Expected Output: "new requests displayed"
     */
    @Test
    public void newRequestsMenuTest(){
        String sql = "select RID,Date from Request where Status=? and PUsername=?";

        patientView.newButtonActionPerformed(new ActionEvent
                (this,ActionEvent.ACTION_PERFORMED,""));
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, "New");
            pst.setString(2, username);
            rs = pst.executeQuery();
            assertEquals("new requests displayed", patientView.setNewRequestsDisplay(rs));

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * Test Case ID: TC-PV-04
     * Purpose: Test that clicking the new request button will not show new requests.
     * Test Setup: An instance of the PatientView is created and the setNewRequestsDisplay()
     * method is called with the ResultSet of new requests passed as a parameter.
     * Input: empty ResultSet
     * Expected Output: "no new requests"
     */
    @Test
    public void emptyNewRequestsMenuTest(){
        String sql = "select RID,Date from Request where Status=? and PUsername=?";

        patientView.newButtonActionPerformed(new ActionEvent
                (this,ActionEvent.ACTION_PERFORMED,""));
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, "New");
            pst.setString(2, "john");
            rs = pst.executeQuery();
            assertEquals("no new requests", patientView.setNewRequestsDisplay(rs));

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * Test Case ID: TC-PV-05
     * Purpose: Test that clicking the in progress request button will show in progress
     * requests.
     * Test Setup: An instance of the PatientView is created and the setInProgressRequestsDisplay()
     * method is called with the ResultSet of new requests passed as a parameter.
     * Input: ResultSet containing in progress requests
     * Expected Output: "in progress requests displayed"
     */
    @Test
    public void inProgressRequestsMenuTest(){
        String sql = "select RID,Date from Request where Status=? and PUsername=?";

        patientView.InProgressButtonActionPerformed(new ActionEvent
                (this,ActionEvent.ACTION_PERFORMED,""));
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, "In Progress");
            pst.setString(2, username);
            rs = pst.executeQuery();
            assertEquals("in progress requests displayed", patientView.setInProgressRequestsDisplay(rs));

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * Test Case ID: TC-PV-06
     * Purpose: Test that clicking the in progress request button will not show in
     * progress requests.
     * Test Setup: An instance of the PatientView is created and the setInProgressRequestsDisplay()
     * method is called with the ResultSet of new requests passed as a parameter.
     * Input: empty ResultSet
     * Expected Output: "no in progress requests"
     */
    @Test
    public void emptyInProgressRequestsMenuTest(){
        String sql = "select RID,Date from Request where Status=? and PUsername=?";

        patientView.InProgressButtonActionPerformed(new ActionEvent
                (this,ActionEvent.ACTION_PERFORMED,""));
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, "In Progress");
            pst.setString(2, "john");
            rs = pst.executeQuery();
            assertEquals("no in progress requests", patientView.setInProgressRequestsDisplay(rs));

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * Discards patient instance and closes connection to DB upon testing tear down.
     */
    @AfterEach
    public void tearDown() {
        patientView = null;
        try{
            conn.close();
        }catch(SQLException msg){
            msg.printStackTrace();
        }
    }


}
