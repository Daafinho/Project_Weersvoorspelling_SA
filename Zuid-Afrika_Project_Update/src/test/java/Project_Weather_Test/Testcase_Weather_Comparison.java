package Project_Weather_Test;

import PageObjects.TabelWeerObject2;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class Testcase_Weather_Comparison {
    private static boolean isElementPresent;
    private String baseUrl;
    private String expectedTitle;
    private boolean acceptNextAlert = true;
    private static StringBuffer verificationErrors = new StringBuffer();
    weather_Comparison_XML werkthet;

    public static void testWeatherForeCast(WebDriver browser) throws Exception {
        browser.get("http://weather.news24.com");
        browser.findElement(By.linkText("Bloemfontein")).click();
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (isElementPresent)
                    By.cssSelector("#ext-gen28"); break;

            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        browser.findElement(By.cssSelector("#div7DayForecast")).click(); //verify the 7day element box
        try {
            if(isElementPresent) {
          //  assertTrue(isElementPresent);
            By.xpath(".//*[@id='7dayforecast']");
        }
        } catch (Error e) {
          verificationErrors.append(e.toString());
        }
        browser.findElement(By.id("ext-gen28")).click();
/***
 * Met List webelement wordt via xpath de column van de website gehaald. Daarna wordt het webelement omgezet in een String arraylist.
 * In de arraylist worden 6 waardes opgeslagen
 */

        List<WebElement> max_Temp_News24 = browser.findElements(By.xpath("//div[@id='forecastContent']/table/tbody/tr[*]/td[4]"));
        List<String> max_Temp_News24_text = new ArrayList<>();
        for (int i = 1; i < max_Temp_News24.size() - 1; i++) {
            max_Temp_News24_text.add(max_Temp_News24.get(i).getText());
        }

        List<WebElement> min_Temp_News24 = browser.findElements(By.xpath(".//*[@id='forecastContent']/table/tbody/tr[*]/td[5]"));
        List<String> min_Temp_News24_text = new ArrayList<>();
        for (int j = 1; j < min_Temp_News24.size() - 1; j++) {
            min_Temp_News24_text.add(min_Temp_News24.get(j).getText());
        }

        List<WebElement> day_element = browser.findElements(By.xpath("//div[@id='forecastContent']/table/tbody/tr[*]/td[1]"));
        List<String> day_element_text = new ArrayList<>();
        for (int k = 2; k < day_element.size() - 1; k++) {
            day_element_text.add(day_element.get(k).getText());
        }

        browser.get("http://www.weathersa.co.za/");
        browser.findElement(By.xpath("//div[@id='inSearch']/input")).clear();
        browser.findElement(By.xpath("//div[@id='inSearch']/input")).sendKeys("Bloemfontein City");
        browser.findElement(By.xpath("//div[@id='akeeba-renderjoomla']/div[3]/table/tbody/tr[3]/th/span[3]")).click();

        try {
              if(isElementPresent);
               By.xpath("//div[@id='akeeba-renderjoomla']/div[3]/table/tbody/tr[3]/th/span[3]");
            //Max-temp bloemfontein object verification
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        TabelWeerObject2 tabelWeerObject1 = PageFactory.initElements(browser, TabelWeerObject2.class);
        tabelWeerObject1.ZoekTabelNaam();
        tabelWeerObject1.Openhouden();

        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {

                if (isElementPresent)
                    By.xpath("//div[@id='akeeba-renderjoomla']/div[3]/table/tbody/tr[3]/th");
                    break;
                //search bloemfontein table object
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        System.out.println("\nComparing website 1: http://weather.news24.com with website2: http://www.weathersa.co.za/\n");

        List<WebElement> max_Temp_Weathersa = browser.findElements(By.xpath("//tr[3]/td"));
        List<String> max_Temp_Weathersa_text = new ArrayList<>();
        for (int l = 1; l < max_Temp_Weathersa.size() - 28; l++) {
            max_Temp_Weathersa_text.add(max_Temp_Weathersa.get(l).getText() + "°C");
        }

        List<WebElement> min_Temp_Weathersa = browser.findElements(By.xpath(".//*[@id='tabs']/ul/li[*]/a/div/div[2]/span[2]"));
        List<String> min_Temp_Weathersa_text = new ArrayList<>();
        for (int m = 1; m < min_Temp_Weathersa.size(); m++) {
            min_Temp_Weathersa_text.add(min_Temp_Weathersa.get(m).getText() + "C");
        }

        /***
         * Hieronder worden twee verschillende ArrayList met elkaar vergeleken(van verschillende websites). In beide lijsten zitten 6 waardes.
         * Tijdens de vergelijking wordt er ook een XML-file aangemaakt met de waardes die uit de website worden gehaald.
         */

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("Weersvoorspelling_Zuid-Afrika");
            doc.appendChild(rootElement);

            Element dagen = doc.createElement("test");

            Attr attr = doc.createAttribute("B");
            attr.setValue("1");
            dagen.setAttributeNode(attr);

            Element stad = doc.createElement("Stad");
            stad.appendChild(doc.createTextNode("Bloemfontein"));
            rootElement.appendChild(stad);

            Element test = doc.createElement("Maximale_Temperatuur");
            rootElement.appendChild(test);

            Element test2 = doc.createElement("Minimale_Temperatuur");
            rootElement.appendChild(test2);

            System.out.println("|" + "Max temperature comparison" + "|\n" + "|--------------------------------------------------------------------------");

            for (int t = 0; t < max_Temp_News24_text.size(); t++) {

                dagen = doc.createElement(day_element_text.get(t));
                test.appendChild(dagen);

                Element maxTemp_news24 = doc.createElement("max_temp_News24");
                maxTemp_news24.appendChild(doc.createTextNode(max_Temp_News24_text.get(t)));
                dagen.appendChild(maxTemp_news24);

                Element maxTemp_weathersa = doc.createElement("max_temp_Weathersa");
                maxTemp_weathersa.appendChild(doc.createTextNode(max_Temp_Weathersa_text.get(t)));
                dagen.appendChild(maxTemp_weathersa);

                if (max_Temp_News24_text.get(t).equals(max_Temp_Weathersa_text.get(t))) {
                    System.out.println("|" + day_element_text.get(t) + "|" + " Max-temp| News24.com " + "|" + max_Temp_News24_text.get(t) + "|" + " is gelijk met     " + "|" +
                            " Weathersa.co.za " + "|" + max_Temp_Weathersa_text.get(t) + "|\n" +
                            "|---|---------|------------|----|-------------------|-----------------|----|");
                    Element result = doc.createElement("Resultaat");
                    result.appendChild(doc.createTextNode("True"));
                    dagen.appendChild(result);
                } else {
                    System.out.println("|" + day_element_text.get(t) + "|" + " Max-temp| News24.com " + "|" + max_Temp_News24_text.get(t) + "|" + " is niet gelijk met" + "|" +
                            " Weathersa.co.za " + "|" + max_Temp_Weathersa_text.get(t) + "|\n" +
                            "|---|---------|------------|----|-------------------|-----------------|----|");
                    Element nickname = doc.createElement("Resultaat");
                    nickname.appendChild(doc.createTextNode("False"));
                    dagen.appendChild(nickname);
                }
            }

            System.out.println("\n|" + "Min temperature comparison" + "|\n" + "|---------------------------------------------------------------------------");
            for (int s = 0; s < min_Temp_News24_text.size(); s++) {

                dagen = doc.createElement(day_element_text.get(s));
                test2.appendChild(dagen);

                // minimale temperatuur
                Element minTemp = doc.createElement("min_temp_News24");
                minTemp.appendChild(doc.createTextNode(min_Temp_News24_text.get(s)));
                dagen.appendChild(minTemp);

                Element minTempWeathersa = doc.createElement("min_temp_Weathersa");
                minTempWeathersa.appendChild(doc.createTextNode(min_Temp_Weathersa_text.get(s)));
                dagen.appendChild(minTempWeathersa);

                if (min_Temp_News24_text.get(s).equals(min_Temp_Weathersa_text.get(s))) {
                    System.out.println("|" + day_element_text.get(s) + "|" + " Min-temp| News24.com " + "|" + min_Temp_News24_text.get(s) + "|" + " is gelijk met      " + "|" +
                            " Weathersa.co.za " + "|" + min_Temp_Weathersa_text.get(s) + "|\n" +
                            "|---|---------|------------|----|--------------------|-----------------|----|");

                    Element nickname = doc.createElement("Resultaat");
                    nickname.appendChild(doc.createTextNode("True"));
                    dagen.appendChild(nickname);

                } else {
                    System.out.println("|" + day_element_text.get(s) + "|" + " Min-temp| News24.com " + "|" + min_Temp_Weathersa_text.get(s) + "|" + " is niet gelijk met " + "|" +
                            " Weathersa.co.za " + "|" + min_Temp_News24_text.get(s) + "|\n" +
                            "|---|---------|------------|----|--------------------|-----------------|----|");
                    Element nickname = doc.createElement("Resultaat");
                    nickname.appendChild(doc.createTextNode("False"));
                    dagen.appendChild(nickname);
                }
            }
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\Zuid-Afrika_project\\weersverwachting1.xml"));
            //XML-file wordt in de map Zuid-Afrika_project opgeslagen
            transformer.transform(source, result);
            System.out.println("Bestand is opgeslagen!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
        assertTrue(1 < 2);
    }
    public static boolean isElementPresent(WebDriver browser) {
        try {
            if(isElementPresent){
            }
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
