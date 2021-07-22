package cn.itsource.springboot.web.controller;

import cn.itsource.springboot.domain.Role;
import cn.itsource.springboot.query.RoleQuery;
import cn.itsource.springboot.serivce.IRoleService;
import cn.itsource.springboot.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    /**
     * 进入角色首界面
     * @return
     */
    @RequestMapping("/index")
    public String index( RoleQuery roleQuery,Model model){
        model.addAttribute("pageInfo", roleService.getPageByQuery(roleQuery));
        return "views/role/role_list";
    }


    /**
     * 添加或者修改走此方法
     * @param role
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public JsonResult add(@RequestBody Role role){
        try {
            roleService.add(role);
            return new JsonResult("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false,"操作失败");
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(Long id){
        try {
            roleService.del(id);
            return new JsonResult("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false,"操作失败");
        }
    }

    /**
     * 跳转到分配权限页面
     * @param roleId
     * @return
     */
    @RequestMapping("/toPermission")
    public String toPermission(Long roleId,Model model){
        //获取当前所有的权限  以及当前角色拥有的权限
        Map<String,Object> map = roleService.toPermission(roleId);
        model.addAttribute("map", map);

        return "views/role/role_permission";
    }


    /**
     * 添加授权
     * @param permissionIds
     * @param roleId
     * @return
     */
    @RequestMapping("/addPermission")
    @ResponseBody
    public JsonResult addPermission(Long[] permissionIds,Long roleId){
        try {
            roleService.addPermission(permissionIds, roleId);
            return new JsonResult("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false, "操作失败!");
        }
    }

}
