package com.ideamake.dome.config;




import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.AllowAllCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.ideamake.dome.model.Role;
import com.ideamake.dome.model.User;
import com.ideamake.dome.service.RoleService;
import com.ideamake.dome.service.UserService;


public class MyShiroRealm extends AuthorizingRealm {
	/**
	 自动注入用户和权限的服务
	 */
   @Autowired
   private UserService userservice;
   @Autowired
   private RoleService roleservice;
  
    public MyShiroRealm(){
    	super(new AllowAllCredentialsMatcher());
        setAuthenticationTokenClass(UsernamePasswordToken.class);
        //FIXME:暂时禁用Cache
        setCachingEnabled(false);

    }
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) throws AuthenticationException {
    	
    	
    	String username = (String)principals.getPrimaryPrincipal();
    	User user =userservice.findUserByName(username);
    	 
    	 SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
    	 
    	 try {
    		 
    		
    		 if(user!=null) {
    			 Role role=roleservice.findRole(user.getR_id());
    			 authorizationInfo.addRole(role.getR_name());
    			 return authorizationInfo;
    		 }
    		 
    	 }catch (Exception e) {
    		 e.printStackTrace();
		}
    	 return null;
    }
    /**
     * 认证
     * @param Atoken
     * @return AuthenticationInfo
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken Atoken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)Atoken;
        String username =(String) token.getUsername();
        String password;
        try {
        	User user=userservice.findUserByName(username);
        	 password=new String((char[]) token.getCredentials());
        	if(user == null){
                throw new UnknownAccountException("账号不正确");
            }
        	if(!password.equals(user.getPassword())){
                throw new UnknownAccountException("密码错误");
            }
         }catch (Exception e){
            throw new AuthenticationException();
        }

        SimpleAuthenticationInfo AInfo = new SimpleAuthenticationInfo(username,password,getName());
        return AInfo;
    }
}

