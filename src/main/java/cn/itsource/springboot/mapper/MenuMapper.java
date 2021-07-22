package cn.itsource.springboot.mapper;

import cn.itsource.springboot.domain.Menu;

import java.util.List;

public interface MenuMapper {

    List<Menu> loadMenuByLoginUserId(Long id);
}
