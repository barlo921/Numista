package com.barlo.numista.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/", method = RequestMethod.GET)
public class RootController extends AbstractController {

    @GetMapping("/numista")
    public String numista(Model model) {
        model.addAttribute("coins", coinUtil.convertToCoinTO(coinService.getAll()));
        return "numista";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/connect")
    public String connect() {
        return "connect";
    }

}
