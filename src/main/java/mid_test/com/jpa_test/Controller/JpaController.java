package mid_test.com.jpa_test.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mid_test.com.jpa_test.Entities.JpaEntity;
import mid_test.com.jpa_test.Services.JpaService;

@Controller
public class JpaController {

    @Autowired
    JpaService jService;

    @GetMapping("/")
    public String mainPage(Model model){
        return "main";
    }
    
    @PostMapping("/")
    public @ResponseBody List<JpaEntity> mainPageAll(Model model){
        
        List<JpaEntity> hList = jService.getAllData();
    
        return hList;
    }
}
