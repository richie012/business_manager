package ru.business_manager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.business_manager.entities.UserMember;
import ru.business_manager.repos.User_repo;

import java.util.Map;

@Controller
public class RootController {
    private final User_repo user_repo;

    public RootController(User_repo user_repo) {
        this.user_repo = user_repo;
    }

    @GetMapping("/")
    public String main(Map<String, Object> model) {
        return "main";
    }
}
