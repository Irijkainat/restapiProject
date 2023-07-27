package com.stella.restapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.io.Serializable;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class User{


    @Id
    @GeneratedValue

    @NotNull()
    private Integer id;
    @NotEmpty(message ="name shouldn't be empty" )
      private String name;


    @Email(message ="email is invalid" )
      private String email;
    @Min(value = 18,message = "age must be greater than 18")
    @Max(value = 99, message = "age must not exceeds 99")
      private Integer age;





}
