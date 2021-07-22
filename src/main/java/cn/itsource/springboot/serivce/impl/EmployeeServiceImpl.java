package cn.itsource.springboot.serivce.impl;

import cn.itsource.springboot.domain.Employee;
import cn.itsource.springboot.mapper.EmployeeMapper;
import cn.itsource.springboot.serivce.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee getByUsernameAndPassword(String username, String password) {
        Employee employee = employeeMapper.loadByUsername(username);
        if (employee == null) {
            throw new RuntimeException("用户名不存在!!");
        }
        if(!employee.getPassword().equals(password)){
            throw new RuntimeException("密码错误!!");
        }
        return employee;
    }

}
