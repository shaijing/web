package web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
/*　　@RestController注解等价于@ResponseBody ＋ @Controller。@RestController和@Controller的共同点是都用来表示Spring某个类是否可以接收HTTP请求，
二者区别： @RestController无法返回指定页面，而@Controller可以*/
public class WebControllers {
    @GetMapping({"/","/index"})
    public String index(Model model) {
        model.addAttribute("name", "Xiao");
        //跳转页面，由于配置了前缀和后缀，相当于是 /templates/index.html
        return "index";
    }

    @RequestMapping(value = "/getJson", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> getJson() {
        Map<String, String> all = new HashMap<>();
        all.put("remark", "结合注解 @ResponseBody 返回接送");
        return all;
    }
}
