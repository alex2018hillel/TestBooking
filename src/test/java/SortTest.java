import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

   public class SortTest extends InitialTestClass{

        @BeforeMethod
        public void initialize() {
            initializeDriver();
        }

        @Test
        public void SortTest() {
            open();
            fieldDataCheckIn();
            inputDataCheckIn();
            inputDataCheckOut();
            sityField();
            sortButton();
            delay(3000);
            hotelList();
            delay(1000);
            assertEquals(InitialTestClass.err, InitialTestClass.sizeList);
        }

        @AfterMethod
        public void closeDown() {
            closeDriver();
        }
    }

