package cn.itsource.springboot.web.interceptor;

import cn.itsource.springboot.domain.Employee;
import cn.itsource.springboot.domain.Permission;
import cn.itsource.springboot.serivce.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component
public class PermissionInterceptor implements HandlerInterceptor {

    @Autowired
    private IPermissionService permissionService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取当前访问的url地址请求
        String uri = request.getRequestURI();
        List<String> permissions = permissionService.getPermissions();
        if(permissions.contains(uri)){
            List<String> ownPermissions = permissionService.getPermissionsByLoginUser((Employee) request.getSession().getAttribute("USER_IN_SESSION"));
            System.out.println(ownPermissions);
            if(ownPermissions.contains(uri)){
                return true;
            }
            response.sendRedirect("/nopermission");
            return false;

        }else{
            return true;
        }

    }
}
