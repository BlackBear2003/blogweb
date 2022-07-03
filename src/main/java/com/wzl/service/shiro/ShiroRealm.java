package com.wzl.service.shiro;

import com.wzl.entity.User;
import com.wzl.mapper.UserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShiroRealm extends AuthenticatingRealm {

    @Autowired
    private UserMapper userMapper;
    /**
     *  登录的验证实现方法
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken token2 = (UsernamePasswordToken) token;
        String name = token2.getUsername();
        List<User> user =userMapper.getUsersByName(name);
        if(user == null) {
            throw new UnknownAccountException("用户名或密码有误！");
        }

        //利用新建的类来创建对象
        ShiroUser shiroUser=new ShiroUser();
        shiroUser.setUsername(name); //将页面中的username值设置进去

        /*if(userMapper.getUserRoleById(user.get(0).getId())==0){
            shiroUser.getRoles().add("admin");
            shiroUser.getRoles().add("user");
        }
        else if(userMapper.getUserRoleById(user.get(0).getId())==1){
            shiroUser.getRoles().add("user");
        }*/


        /**
         * principals: 可以使用户名，或d登录用户的对象
         * hashedCredentials: 从数据库中获取的密码
         * credentialsSalt：密码加密的盐值
         * RealmName:  类名（ShiroRealm）
         */
        AuthenticationInfo info = new SimpleAuthenticationInfo(shiroUser, user.get(0).getPassword(), null, getName());
        return info; //框架完成验证
    }

    //新建一个类定义用户角色和权限
    class ShiroUser implements Serializable {
        private static final long serialVersionUID = 1L;
        private String username;
        private Set<String> roles=new HashSet<String>();

        public String getUsername() {
            return username;
        }
        public void setUsername(String username) {
            this.username = username;
        }
        public Set<String> getRoles() {
            return roles;
        }
        public void setRoles(Set<String> roles) {
            this.roles = roles;
        }
    }



}