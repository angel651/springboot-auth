package cn.itsource.springboot.mapper;

import cn.itsource.springboot.domain.Employee;

public interface EmployeeMapper {
    Employee loadByUsername(String username);
}
