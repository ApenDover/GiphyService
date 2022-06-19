package ts.andrey;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import ts.andrey.giphy.GiphyApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Objects;
import java.util.Properties;
import java.util.PropertyResourceBundle;

public class PropertiesTest {

    @Value("${giphy.url.general}")
    private String gifServer;
    @Value("${giphy.api.key}")
    private String gifApiID;
    @Value("${giphy.courseUP}")
    private String gifUpTag;
    @Value("${giphy.courseDOWN}")
    private String gifDownTag;
    @Value("${openexchangerates.url.general}")
    private String exServer;
    @Value("${openexchangerates.app.id}")
    private String exAppID;
    @Value("${openexchangerates.currency}")
    private String curBase;

    @Test
    @DisplayName("All options are assigned")
    void chechValues() {
        Assertions.assertNotEquals("", gifServer);
        Assertions.assertNotEquals("", gifApiID);
        Assertions.assertNotEquals("", gifUpTag);
        Assertions.assertNotEquals("", gifDownTag);
        Assertions.assertNotEquals("", exServer);
        Assertions.assertNotEquals("", exAppID);
        Assertions.assertNotEquals("", curBase);
    }
}
