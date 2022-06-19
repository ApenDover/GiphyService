package ts.andrey.giphy.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ts.andrey.giphy.API.Course;
import ts.andrey.giphy.API.Giphy;
import ts.andrey.giphy.config.AppConfig;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Controller
public class AppController {

    private final Giphy giphy;
    private String url;
    private final Course course;
    private double currencyToday = 0.0;
    private double currencyYesterday = 0.0;
    @Value("${openexchangerates.currency}")
    private String currency;
    @Value("${openexchangerates.app.id}")
    private String id;

    @Autowired
    public AppController(Giphy giphy, Course course) {
        this.giphy = giphy;
        this.course = course;
        }

    public Double jsonParser(JSONObject json) throws ParseException {
        String jsonStr = json.toJSONString();
        JSONParser parser = new JSONParser();
        JSONObject jsonFromStr = (JSONObject) parser.parse(jsonStr);
        JSONObject data = (JSONObject) jsonFromStr.get("rates");
        return Double.parseDouble(data.get(currency).toString());
    }

    @GetMapping("/")
    public String giphyInclude(Model model){

        boolean status = true;
        try {
            JSONObject courseToday = course.courseToday(id);
            if (courseToday != null) {
                this.currencyToday = jsonParser(courseToday);
            } else {
                status = false;
            }

            JSONObject courseYesterday = course.courseYesterday(AppConfig.getdateY(), id);
            if (courseYesterday != null) {
                this.currencyYesterday = jsonParser(courseYesterday);
            } else {
                status = false;
            }

            JSONObject object;
            if (currencyToday < currencyYesterday) {
                object = giphy.getLinkRich();
            } else {
                object = giphy.getLinkBroke();
            }
            if ((object != null) & (status)) {
                String jsonStr = object.toJSONString();
                JSONParser parser = new JSONParser();
                JSONObject json = (JSONObject) parser.parse(jsonStr);
                JSONObject data = (JSONObject) json.get("data");
                JSONObject images = (JSONObject) data.get("images");
                JSONObject downsized = (JSONObject) images.get("original");
                this.url = downsized.get("url").toString();
                model.addAttribute("link", url);

                MathContext context = new MathContext(4, RoundingMode.HALF_UP);
                BigDecimal roundRubY = new BigDecimal(currencyYesterday, context);
                BigDecimal roundRubT = new BigDecimal(currencyToday, context);

                String yesterdayText = "вчера: " + roundRubY + " " + currency;
                String todayText = "сегодня: " + roundRubT + " " + currency;

                model.addAttribute("textY", yesterdayText);
                model.addAttribute("textT", todayText);
            }
            else {
                throw new Exception("oh no");
            }
        } catch (Exception e)
        {
            String yesterdayText = "Ничего не работает";
            String todayText = e.getMessage();
            model.addAttribute("textY", yesterdayText);
            model.addAttribute("textT", todayText);
        }

        return "index";
    }

}
