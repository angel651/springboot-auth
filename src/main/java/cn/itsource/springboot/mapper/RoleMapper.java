package cn.itsource.springboot.mapper;

import cn.itsource.springboot.domain.Role;
import cn.itsource.springboot.query.RoleQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    void save(Role role);

    void remove(Long id);

    void update(Role role);

    Role loadById(Long id);

    List<Role> loadAllByQuery(RoleQuery roleQuery);

    /**
     * 删除角色和权限的中间表，根据角色id
     * @param roleId  角色id
     */
    void removeRolePermissionByRoleId(Long roleId);

    /**
     * 先删除之前权限
     * @param roleId
     */
    void removePermissionByRoleid(Long roleId);


    /**
     * 添加角色和权限
     * @param permissionIds  权限id
     * @param roleId  角色id
     */
    void saveRolePermission(@Param("ids") Long[] permissionIds, @Param("roleId") Long roleId);
}
