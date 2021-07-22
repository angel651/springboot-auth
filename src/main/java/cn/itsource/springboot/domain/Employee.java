package cn.itsource.springboot.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Employee {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String headImage;
    private Integer age;
    private List<Role> roles = new ArrayList<Role>();


}
