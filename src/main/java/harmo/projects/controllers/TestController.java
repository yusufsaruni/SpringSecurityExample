package harmo.projects.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String greet(HttpServletRequest request){
        return "Welcome to harmo projects: " + request.getSession().getId();
    }
}
