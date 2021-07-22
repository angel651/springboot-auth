package cn.itsource.springboot.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
public class Menu {
    private Long id;
    private String name;
    private String url;
    private String icon;
    private Menu parent;
    private List<Menu> children = new ArrayList<>();

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
