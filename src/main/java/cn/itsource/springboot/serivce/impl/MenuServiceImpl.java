package cn.itsource.springboot.serivce.impl;

import cn.itsource.springboot.domain.Employee;
import cn.itsource.springboot.domain.Menu;
import cn.itsource.springboot.mapper.MenuMapper;
import cn.itsource.springboot.serivce.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getMenuByLoginUser(Employee employee) {

        /**
         * 该集合只存储一级菜单
         */
        List<Menu> parents = new ArrayList<>();

        List<Menu> menus = menuMapper.loadMenuByLoginUserId(employee.getId());
        Map<Long, Menu> map = new HashMap<>();
        for (Menu menu : menus) {
            Menu parent = menu.getParent();
            if(!map.containsKey(parent.getId())){
                map.put(parent.getId(), parent);
            }
            map.get(parent.getId()).getChildren().add(menu);
        }
        parents.addAll(map.values());
        return parents;
    }
}
