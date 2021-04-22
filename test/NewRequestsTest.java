import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.ActionEvent;

public class NewRequestsTest {

    private NewRequests request;
    private String userID;

    /**
     * Instantiates new request for testing.
     */
    @BeforeEach
    public void setUp() {
        userID = "patient";
        request = new NewRequests(userID);
    }

    /**
     * Discards new request instance upon testing tear down.
     */
    @AfterEach
    public void tearDown(){
        request = null;
    }

    /**
     * Test Case ID: TC-NR-01
     * Purpose: Test that clicking the create request button will submit the new request.
     * Test Setup: An instance of the NewRequest is created and the createNewRequest()
     * method is called with int result of confirmation dialog passed as a parameter.
     * Input: pane = 0 ("Yes")
     * Expected Output: "request created"
     */
    @Test
    public void newRequestCreatedTest(){
        int pane = 0;
        request.createButtonActionPerformed(new ActionEvent
                (this,ActionEvent.ACTION_PERFORMED,""));

        assertEquals("request created", request.createNewRequest(pane));
    }

    /**
     * Test Case ID: TC-NR-02
     * Purpose: Test that clicking the create request button will not submit the new request.
     * Test Setup: An instance of the NewRequest is created and the createNewRequest()
     * method is called with int result of confirmation dialog passed as a parameter.
     * Input: pane = 1 ("No")
     * Expected Output: "request cancelled"
     */
    @Test
    public void newRequestCanceledTest(){
        int pane = 1;
        request.createButtonActionPerformed(new ActionEvent
                (this,ActionEvent.ACTION_PERFORMED,""));

        assertEquals("request canceled", request.createNewRequest(pane));
    }

    /**
     * Test Case ID: TC-NR-03
     * Purpose: Test that clicking the cancel request button will return to the user's profile.
     * Test Setup: An instance of the NewRequest is created and the cancelButtonActionPerformed()
     * method is called with an ActionEvent passed as a parameter.
     * Input: ActionEvent created when cancel button clicked.
     * Expected Output: isVisible = true
     */
    @Test
    public void cancelButtonTest(){
        boolean isVisible = true;

        assertEquals(isVisible, request.CancelButtonActionPerformed(new ActionEvent
                (this,ActionEvent.ACTION_PERFORMED,"")));
    }


}
