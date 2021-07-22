package cn.itsource.springboot.serivce;

import cn.itsource.springboot.domain.Role;
import cn.itsource.springboot.query.RoleQuery;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface IRoleService {
    void add(Role role);

    void del(Long id);

    Role getById(Long id);

    PageInfo<Role> getPageByQuery(RoleQuery roleQuery);

    /**
     * 获取当前所有的权限  以及当前角色拥有的权限
     * @param roleId
     * @return
     */
    Map<String,Object> toPermission(Long roleId);

    /**
     * 添加权限
     * @param permissionIds
     * @param roleId
     */
    void addPermission(Long[] permissionIds, Long roleId);
}
