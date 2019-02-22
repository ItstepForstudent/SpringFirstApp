package org.itstep.springfirst.controllers;

import lombok.RequiredArgsConstructor;
import org.itstep.springfirst.entities.User;
import org.itstep.springfirst.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
@RequiredArgsConstructor
public class MainController {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;


    @GetMapping("")
    public String index(Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        model.addAttribute("vasia","!!!!!!!!!");
        System.out.println(auth.getName());
        model.addAttribute("auth",!auth.getName().equals("anonymousUser"));
        if(!auth.getName().equals("anonymousUser")){
            model.addAttribute("name",auth.getName());
        }
        return "main";
    }
    @GetMapping("/users")
    public String users(Model model){
        model.addAttribute("vasia","!!!!!!!!!");

        model.addAttribute("users",repository.findAll());

        return "users";
    }

    @GetMapping("/register")
    public String register(HttpSession session,Model model){

        String error = (String)session.getAttribute("error_register");
        String name = (String)session.getAttribute("name_register");
        session.removeAttribute("error_register");
        session.removeAttribute("name_register");

        model.addAttribute("error",error);
        model.addAttribute("name",name);

        return "register";
    }

    @PostMapping("/register")
    public String registerHandle(String name, String pass, String pass2, HttpSession session){
        try {
            User u = repository.getByName(name);
            if(u!=null) throw new Exception("User already exists");
            if(!pass.equals(pass2)) throw new Exception("Pass error");
            User user = new User();
            user.setName(name);
            user.setPass(passwordEncoder.encode(pass));
            repository.save(user);
            return "redirect:/login";
        }catch (Exception e){

            session.setAttribute("error_register",e.getMessage());
            session.setAttribute("name_register",name);

            return "redirect:/register";
        }
    }

    @GetMapping("/login")
    public String login(String error, Model model){
        model.addAttribute("errors",error);
        return "login";
    }






}
