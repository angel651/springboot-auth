package cn.itsource.springboot.serivce;

import cn.itsource.springboot.domain.Employee;

public interface IEmployeeService {

    /**
     * 查询员工根据用户名和密码
     * @param username
     * @param password
     * @return
     */
    Employee getByUsernameAndPassword(String username, String password);
}
