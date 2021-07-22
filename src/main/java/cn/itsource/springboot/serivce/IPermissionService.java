package cn.itsource.springboot.serivce;

import cn.itsource.springboot.domain.Employee;
import cn.itsource.springboot.domain.Permission;

import java.util.List;

public interface IPermissionService {
    /**
     * 查询所有的权限
     * @return
     */
    List<String> getPermissions();

    List<String> getPermissionsByLoginUser(Employee employee);
}
