package org.itstep.springfirst.controllers;

import lombok.RequiredArgsConstructor;
import org.itstep.springfirst.dao.UsersDAO;
import org.itstep.springfirst.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class MainController {

    private final UsersDAO usersDAO;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("vasia","!!!!!!!!!");

        model.addAttribute("users",usersDAO.getAll());

        return "main";
    }





}
