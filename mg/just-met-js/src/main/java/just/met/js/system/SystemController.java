package just.met.js.system;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(("/system"))
public class SystemController {

    private String prefix = "page/";

    @GetMapping("/page1")
    public String page1(Model model){
        model.addAttribute("id","wmg");
        return prefix + "page1";
    }

    @GetMapping("/page2")
    public String page2(Model model){
        model.addAttribute("id","wmg");
        return prefix + "page2";
    }

}


