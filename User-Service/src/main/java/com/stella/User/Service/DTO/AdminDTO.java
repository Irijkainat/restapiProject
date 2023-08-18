package com.stella.User.Service.DTO;

import lombok.Getter;
import org.springframework.data.annotation.Id;
@Getter
public class AdminDTO {
    @Id
    private String admin_id;
    private String name;
    private String contact;
}
