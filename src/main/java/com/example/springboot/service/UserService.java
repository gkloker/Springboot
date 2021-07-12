package com.example.springboot.service;

import com.example.springboot.domain.User;
import java.util.List;

public interface UserService {
  public List<User> listUsers();
  public void save(User user);
  public void delete(User user);
  public User findUser(User user);
}
