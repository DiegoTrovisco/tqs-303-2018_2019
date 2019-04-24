package com.tqs303.clouddeliveries.entity_control;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class test {

    @Value("${welcome.message}")
    private String message;

    @GetMapping(path = "/")
    public String main(Model model) {
        model.addAttribute("message", message);
        //model.addAttribute("tasks", tasks);

        return "welcome"; //view
    }
}
