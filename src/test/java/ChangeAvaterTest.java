import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ChangeAvaterTest {

        private String expectedPageJira = "System Dashboard - Hillel IT School JIRA";

        /*@BeforeMethod
        public void setup() {
            initializeDriver();
        }

        @Test
        public void loginTestJira() {
            open();
            inputText();
            inputPassword();
            delay(2000);
            String actualTitle = actTitle();
            System.out.println(actualTitle);
            String expectedResultText = expectedPageJira;
            delay(3000);
            assertEquals(actualTitle, expectedResultText);

            clickTopMenu();
            delay(3000);

            inputIssueType();
            inputSummary();
            inputDescription();
            clickCreate();

        }

        @AfterMethod
        public void closeDown() {
            delay(6000);
            closeDriver();
        }

    }
*/
}

