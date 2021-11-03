import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class TestProperties {
    private final Properties properties = new Properties();
    private static TestProperties INSTANCE = null;
    private TestProperties(){
        try {
            properties.load(new FileInputStream(new File("./" +
                    System.getProperty("environment") + ".properties")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static TestProperties getInstance() {
        if (INSTANCE == null){
            INSTANCE = new TestProperties();
        }
        return INSTANCE;
    }
    public Properties getProperties() {
        return properties;
    }
}
