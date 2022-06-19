package ts.andrey.giphy.API;

import org.json.simple.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URI;

@FeignClient(name = "rubToday", url = "${openexchangerates.url.general}")
public interface Course {
    @GetMapping("/latest.json?app_id={id}")
    JSONObject courseToday(@PathVariable String id);

    @GetMapping("/historical/{date}.json")
    JSONObject courseYesterday(@PathVariable String date, @RequestParam("app_id") String id);
}
