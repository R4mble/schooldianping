package com.schooldianping.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Ramble
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName(value = "user")
public class User {

    private Integer id;

    @Email(message = "邮箱格式不对")
    private String email;

    @Size(max = 12, min = 3, message = "用户名长度应当在3-12个字符之间")
    @Pattern(regexp = "[a-zA-Z0-9]+", message = "用户名只能包含英文字母和数字")
    private String username;

    @Size(max = 18, min = 6, message = "密码长度应当在6-18个字符之间")
    private String password;

    private String description;

    private Integer age;

    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }
}
