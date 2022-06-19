package ts.andrey.giphy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

@Configuration
public class AppConfig {

    private static String dateY;

/**
 * уточняем вчерашнюю дату
 * */

    @Bean("yesterdayDate")
    public static void dateCount()
    {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateY = dateFormat.format(cal.getTime());
    }

    public static String getdateY() {
        return dateY;
    }

}
