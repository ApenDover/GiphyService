package ts.andrey.giphy.API;


import org.json.simple.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "our", url = "${giphy.url.general}")
public interface Giphy {
    @GetMapping("/random?api_key=${giphy.api.key}&tag=${giphy.courseUP}&rating=r")
    JSONObject getLinkRich();
    @GetMapping("/random?api_key=${giphy.api.key}&tag=${giphy.courseDOWN}&rating=r")
    JSONObject getLinkBroke();
}
