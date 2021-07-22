package cn.itsource.springboot.serivce;

import cn.itsource.springboot.domain.Employee;
import cn.itsource.springboot.domain.Menu;

import java.util.List;

public interface IMenuService {
    List<Menu> getMenuByLoginUser(Employee employee);
}
