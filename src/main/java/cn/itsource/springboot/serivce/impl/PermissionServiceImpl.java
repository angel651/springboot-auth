package cn.itsource.springboot.serivce.impl;

import cn.itsource.springboot.domain.Employee;
import cn.itsource.springboot.domain.Permission;
import cn.itsource.springboot.mapper.PermissionMapper;
import cn.itsource.springboot.serivce.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<String> getPermissions() {
        return permissionMapper.loadAllPermissionUrl();
    }

    @Override
    public List<String> getPermissionsByLoginUser(Employee employee) {
        return permissionMapper.loadPermissionByUserid(employee.getId());
    }

}
