package ru.business_manager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.business_manager.entities.Role;
import ru.business_manager.entities.UserMember;
import ru.business_manager.repos.User_repo;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    User_repo user_repo;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }
    @PostMapping("/registration")
    public String addUser(UserMember user, Map<String, Object> model) {
        UserMember userFromDB = user_repo.findByName(user.getName());
        if(userFromDB != null) {
            model.put("message", "User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user_repo.save(user);

        return "redirect:/login";
    }
}
