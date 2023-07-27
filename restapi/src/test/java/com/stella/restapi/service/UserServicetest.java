package com.stella.restapi.service;
import static org.mockito.Mockito.verify;
import com.stella.restapi.repository.UserRepository;
import com.stella.restapi.service.ServiceImpl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
class UserServicetest {

    @ExtendWith(MockitoExtension.class)

    @Mock
    private UserRepository userRepo;

     @Mock
     private UserServiceImpl userService;
     @BeforeEach void setUp()
     {
         this.userService
                 = new UserServiceImpl(this.userRepo);
     }
     @Test void getAllPerson()
     {
         userService.getUsers();
         verify(userRepo).findAll();
     }

}