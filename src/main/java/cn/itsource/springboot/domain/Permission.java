package cn.itsource.springboot.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Permission {
    private Long id;
    private String name;
    private String url;
    private String descs;
    private String sn;
    private Menu menu;
    //一级权限对应的二级权限
    private List<Permission> children = new ArrayList<>();

    //权限是否选中
    private Boolean isChecked = false;



}
