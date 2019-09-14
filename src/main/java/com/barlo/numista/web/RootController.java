package com.barlo.numista.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/", method = RequestMethod.GET)
public class RootController {

    public String numista(Model model, @RequestParam(value = "name") String name) {
        model.addAttribute("name", name);
        return "index";
    }

}
