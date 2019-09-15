package com.barlo.numista.web;

import com.barlo.numista.service.CoinService;
import com.barlo.numista.service.CollectionService;
import com.barlo.numista.utils.CoinUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/", method = RequestMethod.GET)
public class RootController {

    @Autowired
    private CoinUtil coinUtil;
    @Autowired
    private CoinService coinService;

    public String start(Model model, @RequestParam(value = "name") String name) {
        model.addAttribute("name", name);
        return "index";
    }

    @GetMapping("/numista")
    public String numista(Model model) {
        model.addAttribute("coins", coinUtil.convertToCoinTO(coinService.getAll()));
        return "numista";
    }

}
