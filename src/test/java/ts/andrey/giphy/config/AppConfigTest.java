package ts.andrey.giphy.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class AppConfigTest {

    private static String dateY;
    private static String dateAp;

    @BeforeEach
    void setUp() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateY = dateFormat.format(cal.getTime());
        AppConfig.dateCount();
        dateAp = AppConfig.getdateY();
    }

    @Test
    void dateCount() {
        assertEquals(dateAp, dateY);
    }

}