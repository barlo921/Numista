package com.barlo.numista.web;

import com.barlo.numista.model.users.User;
import com.barlo.numista.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
@RequestMapping("/signup")
public class JspSignUpController {

    @Autowired
    UserService service;

    @PostMapping
    public String signup(HttpServletRequest request, Model model) {

        User user = new User();

        user.setUsername(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));

        if (!Objects.equals(request.getParameter("password"), request.getParameter("confirmPassword"))) {
            model.addAttribute("username", user.getUsername());
            model.addAttribute("error", "Passwords must be same");
            return "signup";
        }

        if (service.create(user) == null) {
            model.addAttribute("error", "User already exists");
            return "signup";
        }

        return "redirect:/login";
    }

}
