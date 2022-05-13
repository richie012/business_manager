package ru.business_manager;

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
        Iterable<UserMember> users = user_repo.findAll();
        model.put("users", users);
        return "main";
    }

    @PostMapping("/")
    public String add(@RequestParam String name, @RequestParam String login, @RequestParam String pass, Map<String, Object> model) {
        UserMember user = new UserMember(name, login, pass);
        user_repo.save(user);
        Iterable<UserMember> users = user_repo.findAll();
        model.put("messages", users);
        return "main";
    }
}