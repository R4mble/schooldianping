package com.schooldianping.pojo;

import com.schooldianping.model.User;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Ramble
 */
@Data
public class UserPublic {

    private Integer id;

    private String email;

    private String username;

    private String description;

    private Integer age;

    public UserPublic(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.description = user.getDescription();
        this.age = user.getAge();
    }
}
