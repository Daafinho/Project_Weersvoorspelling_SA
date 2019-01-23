package initialisers;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import Project_Weather_Test.weather_Comparison_XML;

public class Initialiser {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(weather_Comparison_XML.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}