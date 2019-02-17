package org.itstep.springfirst.controllers;

import lombok.RequiredArgsConstructor;
import org.itstep.springfirst.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequiredArgsConstructor
public class MainController {

    private final UserRepository repository;


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

    @GetMapping("/login")
    public String login(){
        return "login";
    }






}
