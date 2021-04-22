import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DoctorViewTest {
  /**
   * Doctor view used for testing
   */
  DoctorView doctorView;

  /**
   * Assign a new object of the DoctorView class to setup for the test
   */
  @BeforeEach
  void beforeEach() {
    doctorView = new DoctorView("Test Doctor");
  }

  /**
   * Make the DoctorView null to cleanup after test
   */
  @AfterEach
  void afterEach() {
    doctorView = null;
  }

  /**
   * Test Case ID: TC-D-01
   * Purpose: Test that clicking the new request button will show new requests
   * Test Setup: An instance of the DoctorView class is created and the newRequestButtonActionPerformed method is
   *              called with null passed in as a parameter
   * Input: ActionEvent: null
   * Expected Output: "New Requests"
   */
  @Test
  void getNewRequestButtonClickTest() {
    doctorView.newRequestButtonActionPerformed(null);
    assertEquals("New Requests", doctorView.viewedRequests.getText());
  }

  /**
   * Test Case ID: TC-D-02
   * Purpose: Test that the new request functionality will work with valid data
   * Test Setup: An instance of the DoctorView class is created and the getNewRequests method is
   *              called with null and true passed in as parameters
   * Input: ActionEvent: null
   *        newRequests: true
   * Expected Output: "New Requests"
   */
  @Test
  void getNewRequestTrueTest() {
    String ret;
    try {
      ret = doctorView.getNewRequests(true);
    } catch (Exception e) {
      ret = "";
    }
    assertEquals("has new requests true", ret);
  }

  /**
   * Test Case ID: TC-D-03
   * Purpose: Test that the new request functionality will work with no new requests
   * Test Setup: An instance of the DoctorView class is created and the getNewRequests method is
   *              called with null and false passed in as parameters
   * Input: ActionEvent: null
   *        newRequests: false
   * Expected Output: "New Requests"
   */
  @Test
  void getNewRequestFalseTest() {
    String ret;
    try {
      ret = doctorView.getNewRequests(false);
    } catch (Exception e) {
      ret = "";
    }
    assertEquals("has new requests false", ret);
  }

  /**
   * Test Case ID: TC-D-04
   * Purpose: Test that clicking the in progress button will show in progress requests
   * Test Setup: An instance of the DoctorView class is created and the inProgressButtonActionPerformed method is
   *              called with null passed in as a parameter
   * Input: ActionEvent: null
   * Expected Output: "In Progress Requests"
   */
  @Test
  void inProgressActionTest() {
    doctorView.inProgressButtonActionPerformed(null);
    assertEquals("In Progress Requests", doctorView.viewedRequests.getText());
  }

  /**
   * Test Case ID: TC-D-05
   * Purpose: Test that the in progress requests functionality will work with some in progress requests
   * Test Setup: An instance of the DoctorView class is created and the inProgress method is
   *              called with true passed in as a parameter
   * Input: newRequests: true
   * Expected Output: "has in progress requests true"
   */
  @Test
  void inProgressSuccess() {
    String ret = doctorView.inProgress(true);
    assertEquals("has in progress requests true", ret);
  }

  /**
   * Test Case ID: TC-D-06
   * Purpose: Test that the in progress requests functionality will work with no in progress requests
   * Test Setup: An instance of the DoctorView class is created and the inProgress method is
   *              called with false passed in as a parameter
   * Input: newRequests: false
   * Expected Output: "has in progress requests false"
   */
  @Test
  void inProgressFail() {
    String ret = doctorView.inProgress(false);
    assertEquals("has in progress requests false", ret);
  }

  /**
   * Test Case ID: TC-D-07
   * Purpose: Test that clicking the in closed will show closed requests
   * Test Setup: An instance of the DoctorView class is created and the closeRequestButtonActionPerformed method is
   *              called with null passed in as a parameter
   * Input: ActionEvent: null
   * Expected Output: "Closed Requests"
   */
  @Test
  void closeRequestButtonAction() {
    doctorView.closeRequestButtonActionPerformed(null);
    assertEquals("Closed Requests", doctorView.viewedRequests.getText());
  }

  /**
   * Test Case ID: TC-D-08
   * Purpose: Test that the closed requests functionality will work with some closed requests
   * Test Setup: An instance of the DoctorView class is created and the closeRequest method is
   *              called with true passed in as a parameter
   * Input: newRequests: true
   * Expected Output: "request closed: true"
   */
  @Test
  void closeRequestSuccess() {
    String ret = doctorView.closeRequest(true);
    assertEquals("request closed: true", ret);
  }

  /**
   * Test Case ID: TC-D-09
   * Purpose: Test that the closed requests functionality will work with no closed requests
   * Test Setup: An instance of the DoctorView class is created and the closeRequest method is
   *              called with false passed in as a parameter
   * Input: newRequests: false
   * Expected Output: "request closed: false"
   */
  @Test
  void closeRequestFailure() {
    String ret = doctorView.closeRequest(false);
    assertEquals("request closed: false", ret);
  }

  /**
   * Test Case ID: TC-D-10
   * Purpose: Test that the openRequest functionality will work when a request is selected
   * Test Setup: An instance of the DoctorView class is created and the first request is selected from the list
   *              then the openRequest method is called with 0 passed in as a parameter
   * Input: Index: 0
   * Expected Output: "valid index: true"
   */
  @Test
  void openRequestSuccess() {
    doctorView.requestsList.setSelectedIndex(0);
    String value = doctorView.openRequest(0);
    assertEquals("valid index: true",  value);
  }

  /**
   * Test Case ID: TC-D-11
   * Purpose: Test that the openRequest functionality will work with an invalid request selected
   * Test Setup: An instance of the DoctorView class is created the openRequest method is called with -1 passed in as
   *              a parameter
   * Input: Index: -1
   * Expected Output: "valid index: false"
   */
  @Test
  void openRequestFailure() {
    String value = doctorView.openRequest(-1);
    assertEquals("valid index: false",  value);
  }

  /**
   * Test Case ID: TC-D-12
   * Purpose: Test that the logoutActionPerformed functionality will work when the 'yes' option is selected to sign out
   * Test Setup: An instance of the DoctorView class is created and the logoutActionPerformed method is called, the
   *              tester must then select the 'yes' option when prompted
   * Input: ActionEvent: null
   * Expected Output: 0
   */
  @Test
  void testLogoutYes() {
    doctorView.logoutActionPerformed(null);
    assertEquals(0, doctorView.pane);
  }

  /**
   * Test Case ID: TC-D-13
   * Purpose: Test that the logoutActionPerformed functionality will work when the 'no' option is selected to sign out
   * Test Setup: An instance of the DoctorView class is created and the logoutActionPerformed method is called, the
   *              tester must then select the 'no' option when prompted
   * Input: ActionEvent: null
   * Expected Output: 1
   */
  @Test
  void testLogoutNo() {
    doctorView.logoutActionPerformed(null);
    assertEquals(1, doctorView.pane);
  }

  /**
   * Test Case ID: TC-D-14
   * Purpose: Test that the get and set methods from the DoctorView class work as expected
   * Test Setup: An instance of the DoctorView class is created and the get and set methods are called with and then
   *              the outputs of the gets are compared to the inputs of the sets
   * Input: RequestID: 1
   *        Username: "Test Doctor"
   *        UserType: "Doctor"
   * Expected Output: "Doctor"
   *                  "Test Doctor"
   *                  1
   */
  @Test
  void getsAndSetsTest() {
    doctorView.setRequestID(1);
    doctorView.setUsername("Test Doctor");
    doctorView.setUserType("Doctor");

    assertEquals("Doctor", doctorView.getUserType());
    assertEquals("Test Doctor", doctorView.getUsername());
    assertEquals(1, doctorView.getRequestID());
  }
}