package cn.itsource.springboot.serivce.impl;

import cn.itsource.springboot.domain.Permission;
import cn.itsource.springboot.domain.Role;
import cn.itsource.springboot.mapper.PermissionMapper;
import cn.itsource.springboot.mapper.RoleMapper;
import cn.itsource.springboot.query.RoleQuery;
import cn.itsource.springboot.serivce.IRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    @Transactional
    public void add(Role role) {
        if (role.getId() != null) {
            roleMapper.update(role);
        }else{
            roleMapper.save(role);
        }
    }

    @Override
    @Transactional
    public void del(Long id) {
        //删除中间表
        roleMapper.removeRolePermissionByRoleId(id);

        //删除角色表
        roleMapper.remove(id);
    }

    @Override
    public Role getById(Long id) {
        return roleMapper.loadById(id);
    }

    @Override
    public PageInfo<Role> getPageByQuery(RoleQuery roleQuery) {
        PageHelper.startPage(roleQuery.getCurrentPage(), roleQuery.getPageSize());
        List<Role> roles = roleMapper.loadAllByQuery(roleQuery);
        return new PageInfo<>(roles);
    }

    @Override
    public Map<String, Object> toPermission(Long roleId) {

        Map<String, Object> map = new HashMap<>();
        //查询所有的一级权限和二级权限
        map.put("permissions", permissionMapper.loadLevlePermission());
        //查询当前角色拥有的权限
        map.put("myPermissionids", permissionMapper.loadPermissionidsByRoleId(roleId));
        //存储角色id
        map.put("rid", roleId);
        return map;
    }

    @Override
    @Transactional
    public void addPermission(Long[] permissionIds, Long roleId) {
        //先删除之前的权限
        roleMapper.removePermissionByRoleid(roleId);
        //然后再添加权限
        roleMapper.saveRolePermission(permissionIds, roleId);
    }

}
