package cn.itsource.springboot.mapper;

import cn.itsource.springboot.domain.Permission;

import java.util.List;

public interface PermissionMapper {
    /**
     * 查询所有的一级权限对应的二级权限
     * @return
     */
    List<Permission> loadLevlePermission();

    /**
     * 查询权限根据角色id
     * @param roleId
     * @return
     */
    List<Long> loadPermissionidsByRoleId(Long roleId);

    /**
     * 查询所有的权限
     * @return
     */
    List<String> loadAllPermissionUrl();

    /**
     * 查询当前登陆人拥有的权限
     * @param empid
     * @return
     */
    List<String> loadPermissionByUserid(Long empid);
}
