package com.stella.restapi.service.ServiceImpl;

import com.stella.restapi.entity.User;
import com.stella.restapi.repository.UserRepository;
import com.stella.restapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
    private UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepo) {
    this.userRepository=userRepo;
  }

  @Override
    public void addUser( @Valid User user){
      userRepository.save(user);
    }


  @Override
  public List<User> getUsers() {

    return userRepository.findAll();
  }

  @Override
  public User getUser(Integer id) {
    User user=userRepository.findById(id).orElseThrow(()->new
            ResponseStatusException(HttpStatus.NOT_FOUND,"invalid User Id"+id));
    return user;
  }

  @Override
  public void updateUser(Integer id, User user) {
    userRepository.findById(id).orElseThrow(()->new
            ResponseStatusException(HttpStatus.NOT_FOUND,"invalid User Id"+id));
          user.setId(id);
    userRepository.save(user);
  }


  @Override
  public void deleteUser(Integer id) {
    User user=userRepository.findById(id).orElseThrow(()->new
            ResponseStatusException(HttpStatus.NOT_FOUND,"invalid User Id"+id));
    userRepository.delete(user);

  }

}
