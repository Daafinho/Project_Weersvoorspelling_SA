package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;


public class TabelWeerObject2 {
    @FindBy(how = How.XPATH, using = "//div[@id='inSearch']/input[2]")
    private WebElement ZoekBalk;
    @FindBy(how = How.XPATH, using = "//div[@id='akeeba-renderjoomla']/div[3]/table/tbody/tr[3]/th")
    private WebElement Openhouden;
    @FindBy(how = How.XPATH, using = "//div[@id='forecastContent']/table/tbody/tr[*]/td[4]")
    private WebElement test;

    public void ZoekTabelNaam() {
        ZoekBalk.submit();

    }

//    public void ZoekTabel2() {
//        List<WebElement> max_Temp_News24 = test.findElements(By.xpath("//div[@id='forecastContent']/table/tbody/tr[*]/td[4])"));
//        List<String> max_Temp_News24_text = new ArrayList<>();
//        for(int i = 1; i<max_Temp_News24.size()-1; i++){
//            max_Temp_News24_text.add(max_Temp_News24.get(i).getText());
//        }
//        System.out.println("Dit is een test!!!!"+max_Temp_News24_text);
//    }

    public void Openhouden() {
        Openhouden.getLocation();
    }

}
