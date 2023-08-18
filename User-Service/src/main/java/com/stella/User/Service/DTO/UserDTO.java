package com.stella.User.Service.DTO;


import com.stella.User.Service.entity.Doctor;
import com.stella.User.Service.entity.Role;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
public class UserDTO {
    @Id
    private String user_id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Role role;
    private Doctor doctor;
}
