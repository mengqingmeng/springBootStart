package com.example.demo.shiroSecurity;

import com.example.demo.model.Permission;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//自定义realm

public class AuthRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;

    //用于授权
    @Override
        protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) principalCollection.fromRealm(this.getClass().getName()).iterator().next();

        List<String> permissionList = new ArrayList<String>();
        List<String> roleList = new ArrayList<String>();

        Set<Role> roleSet = user.getRoles();
        if(!CollectionUtils.isEmpty(roleSet)){
            for(Role role:roleSet){
                Set<Permission> permissions = role.getPermissions();
                roleList.add(role.getRname());
                if(!CollectionUtils.isEmpty(permissions)){
                    for(Permission permission:permissions){
                        String permissionName = permission.getName();
                        permissionList.add(permissionName);
                    }
                }
            }
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissionList);//将用户拥有的权限存在授权信息中
        info.addRoles(roleList);    //将用户拥有的角色放在授权信息中
        return info;
    }

    //用于认证登陆
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName = token.getUsername();
        User user = userService.findByUserName(userName);
        return new SimpleAuthenticationInfo(user,user.getPassword(),this.getClass().getName());
    }
}
