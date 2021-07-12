package com.example.springboot.web;

import com.example.springboot.domain.User;
import com.example.springboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class InitController {
  @Autowired
  private UserService userService;

  @GetMapping("/")
  public String init(Model model) {
    log.info("Exect Spring MVC Controller");

    var users = userService.listUsers();

    model.addAttribute("users", users);

    return "index";
  }

  @GetMapping("/add")
  public String add(User user) {
    return "add-update";
  }

  @PostMapping("/add")
  public String save(User user) {
    userService.save(user);

    return "redirect:/";
  }

  @GetMapping("/edit/{id}")
  public String edit(User user, Model model) {
    user = userService.findUser(user);
    model.addAttribute("user", user);

    return "add-update";
  }

  // With Query Parameter
  @GetMapping("/delete")
  public String delete(User user) {
    userService.delete(user);

    return "redirect:/";
  }
}
