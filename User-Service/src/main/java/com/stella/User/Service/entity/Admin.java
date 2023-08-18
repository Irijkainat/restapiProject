package com.stella.User.Service.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    @Id
    private String admin_id;
    private String name;
    private String contact;
}
