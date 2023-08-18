package com.stella.User.Service.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User  {
        @Id
        private String user_id;
        private String firstname;
        private String lastname;
        private String email;
        private String password;
        private Role role;
        private Doctor doctor;

    }
