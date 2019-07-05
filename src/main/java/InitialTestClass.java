import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import prop.App2;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InitialTestClass extends App2 {

    private String sity = getDb("db_sity");
    private By sityField = By.xpath("//input[@id='ss']");
    private By DataCheckIn = By.xpath("//div[@class='xp__dates-inner xp__dates__checkin']//span[@class='sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb']");
    private By inputDataCheckIn = By.xpath("//td[contains(text(),'15')]");
    private By inputDataCheckOut = By.xpath("//td[contains(text(),'17')]");
    private By allElementList = By.cssSelector(".bui-price-display__value.prco-inline-block-maker-helper");
    private By searchButton =
            By.xpath("//div[contains(@class,'sb-searchbox-submit-col -submit-button')]" +
                    "//button[contains(@class,'')]");
    private By sortButton = By.xpath("//a[contains(text(),'Star rating and price')]");
    private By priceButton = By.partialLinkText ("Show prices");

    static WebDriver driver;

    static int sizeList;
    static int err;

    public WebDriver initializeDriver() {
        driver = new ChromeDriver();
        return driver;
    }

    void delay(long millisec) {
        try {
            Thread.sleep(millisec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void open() {
        String url = getDb("db_url");
        driver.get(url);
        driver.manage().window().maximize();
    }

    void sityField() {
        driver.findElement(sityField).sendKeys(sity, Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    void fieldDataCheckIn() {
        driver.findElement(DataCheckIn).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    void inputDataCheckIn() {
        driver.findElement(By.xpath("//div[contains(text(),'July 2019')]")).findElement(inputDataCheckIn).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    void inputDataCheckOut() {
        driver.findElement(By.xpath("//div[contains(text(),'July 2019')]")).findElement(inputDataCheckOut).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    void searchButton() {
        driver.findElement(searchButton).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    void sortButton() {
        driver.findElement(sortButton).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    WebDriver priceButton() {
        driver.findElement (priceButton).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }
    void hotelList() {
        List<WebElement> allElements = driver.findElements(allElementList);
        sizeList = allElements.size();
        System.out.println("sizeList = " + sizeList);
        String s1 = allElements.get(0).getText();

        Pattern r = Pattern.compile("([0-9]),(\\d+)");
        Matcher m = r.matcher(s1);
        if (m.find( )) {

            String Str1 = m.group(1)+m.group(2);
            int numStr1 = Integer.parseInt(Str1);

            for (int i = 1; i < sizeList; i++) {
                String s2 = allElements.get(i).getText();
                Matcher n = r.matcher(s2);
                if (n.find( )) {
                    String Str2 = n.group(1)+n.group(2);
                    int numStr2 = Integer.parseInt(Str2);
                    System.out.println(numStr1);
                    System.out.println(numStr2);

                    if (numStr1 <= numStr2) {
                        System.out.println("=====================" + i);
                    }
                    else {
                        System.out.println("Error in array string" + i);
                        err = i+1;
                        return;
                    }
                    numStr1=numStr2;
                }
                else {
                    System.out.println("NO MATCH");
                }
            }
        }
            else {
                System.out.println("NO MATCH");
            }
    }

        void closeDriver() {
        driver.close();
    }
}








   /* String actTitle() {
        return driver.getTitle();
    }

    String expTitle() {
        //String expectedValue = "System Dashboard - Hillel IT School JIRA";
        String expectedResultText = "System Dashboard - Hillel IT School JIRA";
        return expectedResultText;
    }


    private String password = getDb("db_password");

    void inputDescription() {
        final String nameSummary1 = "Hello world";
        driver.findElement(inputDescriptionField).sendKeys(nameSummary1, Keys.ENTER);
    }
*/


