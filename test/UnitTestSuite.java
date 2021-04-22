import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

/**
 * This class serves as a test suite to run all of the unit tests
 */

@RunWith(JUnitPlatform.class)
@SelectClasses({
    DoctorViewTest.class,
    HealthTest.class,
    LoginTest.class,
    NewRequestsTest.class,
    PatientViewTest.class,
    ProfileTest.class,
    RequestConversationTest.class
})
public class UnitTestSuite {

}
