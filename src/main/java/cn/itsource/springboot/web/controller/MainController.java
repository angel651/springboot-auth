package cn.itsource.springboot.web.controller;

import cn.itsource.springboot.domain.Employee;
import cn.itsource.springboot.serivce.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @Autowired
    private IMenuService menuService;

    @RequestMapping("/main")
    public String main(Model model, HttpSession session){
        model.addAttribute("menulist", menuService.getMenuByLoginUser((Employee)session.getAttribute("USER_IN_SESSION")));
        return "main";
    }
}
