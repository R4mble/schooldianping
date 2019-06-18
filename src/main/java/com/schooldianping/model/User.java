package com.schooldianping.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author Ramble
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName(value = "user")
public class User {

    private String id;

    @NotBlank(message = "邮箱不能为空")
    private String email;

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    private String description;

    private Integer age;
}
