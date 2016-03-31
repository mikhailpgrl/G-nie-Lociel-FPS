
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateFlightTestIHM {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8000/flight/CreateFlight/createFlight.html";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCreateFlightTestIHM() throws Exception {
    driver.get(baseUrl + "/flight/CreateFlight/createFlight.html");
    driver.findElement(By.id("num")).clear();
    driver.findElement(By.id("num")).sendKeys("TVF1234");
    driver.findElement(By.id("atc")).clear();
    driver.findElement(By.id("atc")).sendKeys("TO12C");
    driver.findElement(By.id("dep_aprt_code")).clear();
    driver.findElement(By.id("dep_aprt_code")).sendKeys("LFPO");
    driver.findElement(By.id("arr_arpt_code")).clear();
    driver.findElement(By.id("arr_arpt_code")).sendKeys("LFPG");
    driver.findElement(By.id("dep_date")).clear();
    driver.findElement(By.id("dep_date")).sendKeys("03/01/2016");
    driver.findElement(By.id("dep_time")).clear();
    driver.findElement(By.id("dep_time")).sendKeys("8:50 GMT");
    driver.findElement(By.id("arr_date")).clear();
    driver.findElement(By.id("arr_date")).sendKeys("03/01/2016");
    driver.findElement(By.id("arr_time")).clear();
    driver.findElement(By.id("arr_time")).sendKeys("12:00 GMT");
    driver.findElement(By.id("buttonAddFlight")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
