package cn.itsource.springboot.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class Role {
    private Long id;
    private String name;
    private String sn;
    private List<Permission> permissions = new ArrayList<Permission>();
}
