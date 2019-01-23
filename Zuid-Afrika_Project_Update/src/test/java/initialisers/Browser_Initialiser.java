package initialisers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class Browser_Initialiser {
    public static List<WebDriver> initialiseBrowsers() {
        List<WebDriver> browsers = new ArrayList<>();
        browsers.add(openFirefox1());
        browsers.add(openFirefox(true));
 //     browsers.add(openChrome1());
//        browsers.add(openChrome(true));
//        browsers.add(openMSEdge());
        return browsers;
    }

    public static FirefoxDriver openFirefox1() {
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium WebDriver\\geckodriver.exe");
        return new FirefoxDriver();
    }

    public static FirefoxDriver openFirefox(boolean headless) {
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium WebDriver\\geckodriver.exe");
        if (headless) return new FirefoxDriver(new FirefoxOptions().addArguments("--headless"));
        else return new FirefoxDriver();
    }


    public static ChromeDriver openChrome1(){
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium WebDriver\\chromedriver.exe");
        return new ChromeDriver();
    }
    public static ChromeDriver openChrome(boolean headless) {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium WebDriver\\chromedriver.exe");

        if (headless) return new ChromeDriver(new ChromeOptions().addArguments("--headless"));
        else return new ChromeDriver();
    }

    public static EdgeDriver openMSEdge() {
        System.setProperty("webdriver.edge.driver", "C:\\Selenium WebDriver\\MicrosoftWebDriver.exe");
        return new EdgeDriver();
    }


//    private static String getDriver(Browser browser) {
//        try (InputStream input = Browser_Initialiser.class.getClassLoader().getResourceAsStream("application.properties")) {
//            Properties properties = new Properties();
//            properties.load(input);
//
//            switch (browser) {
//              case FIREFOX: return properties.getProperty("C:\\Selenium WebDriver\\geckodriver.exe");
//              case CHROME: return properties.getProperty("C:\\Selenium WebDriver\\chromedriver.exe");
//              case MSEDGE: return properties.getProperty("C:\\Selenium WebDriver\\MicrosoftWebDriver.exe");
//                default: return null;
//            }
//        }
//        catch (IOException ex) {
//            ex.printStackTrace();
//            return null;
//        }
//    }

//    private enum Browser {
//        CHROME,
//        FIREFOX,
//        MSEDGE
//    }
}
