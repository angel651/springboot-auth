package cn.itsource.springboot.web.controller;

import cn.itsource.springboot.domain.Employee;
import cn.itsource.springboot.serivce.IEmployeeService;
import cn.itsource.springboot.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private IEmployeeService employeeService;
    /**
     * 跳转到login界面
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String toLogin(){
        return "login";
    }

    /**
     * 登陆代码完
     * @param employee
     * @param session
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult login(Employee employee, HttpSession session){

        try {
            Employee loginUser = employeeService.getByUsernameAndPassword(employee.getUsername(), employee.getPassword());
            session.setAttribute("USER_IN_SESSION", loginUser);
            return new JsonResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false, e.getMessage());
        }

    }



}
