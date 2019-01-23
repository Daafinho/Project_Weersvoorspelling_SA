package Project_Weather_Test;

import Html_log.JUnitHTMLReporter;
import initialisers.Browser_Initialiser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import java.util.Collection;
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class weather_Comparison_XML extends JUnitHTMLReporter{
    protected WebDriver browser;
    private String baseUrl;
    private String expectedTitle;
    private boolean acceptNextAlert = true;
    protected StringBuffer verificationErrors = new StringBuffer();

    public weather_Comparison_XML(WebDriver browser) {
        super();
        this.browser = browser;
    }

    @Before
    public void setUp() throws Exception {
        baseUrl = "";
        expectedTitle = "News24";
    }

    @Parameterized.Parameters
    public static Collection browsers() {
        return Browser_Initialiser.initialiseBrowsers();
    }

    @Test
    public void herhaalTestcase() throws Exception {
        int runtime =0;
        for (int i = runtime; runtime < 4; runtime++) {
            if (runtime == 3) {
                System.out.println("Test wordt afgesloten");
                tearDown();
            }else{
            Testcase_Weather_Comparison.testWeatherForeCast(browser);
            System.out.println("RunTime = "+runtime);
            }
        }
    }

    @After
    public void tearDown() {
        browser.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}


