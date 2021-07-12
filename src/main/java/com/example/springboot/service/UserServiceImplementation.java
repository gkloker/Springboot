package com.example.springboot.service;

import com.example.springboot.dao.UserDAO;
import com.example.springboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
  @Autowired
  private UserDAO userDAO;

  @Override
  @Transactional(readOnly = true)
  public List<User> listUsers() {
    return (List<User>) userDAO.findAll();
  }

  @Override
  @Transactional
  public void save(User user) {
    userDAO.save(user);
  }

  @Override
  @Transactional
  public void delete(User user) {
    userDAO.delete(user);
  }

  @Override
  @Transactional(readOnly = true)
  public User findUser(User user) {
    return userDAO.findById(user.getId()).orElse(null);
  }
}