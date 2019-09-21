package com.barlo.numista.web;

import com.barlo.numista.model.Collection;
import com.barlo.numista.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
@RequestMapping(value = "/numista")
public class JspNumistaController {

    @Autowired
    private CollectionService collectionService;

    @GetMapping("/collection/create")
    public String createCollection(Model model) {
        model.addAttribute("collections", collectionService.getAllTopLevel());
        model.addAttribute("collection", new Collection());
        return "collectionForm";
    }

    @GetMapping("/collection/update")
    public String updateCollection(Model model, HttpServletRequest request) {
        model.addAttribute("collections", collectionService.getAllTopLevel());
        model.addAttribute("collection", collectionService.get(getId(request)));
        return "collectionForm";
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(paramId);
    }

}