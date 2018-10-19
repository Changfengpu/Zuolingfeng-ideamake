package com.ideamake.dome.config;

import java.util.LinkedHashMap;



import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.web.servlet.SimpleCookie;




import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;




@Configuration
@Import(ShiroManage.class)
public class ShiroConfig {
	/**
	 这里是shiro框架的一些配置
	 */
	
	@Bean(name = "realm")
    @DependsOn("lifecycleBeanPostProcessor")
    public Realm realm(){return new MyShiroRealm();}
	
	@Bean(name = "shiroCacheManager")
    public CacheManager cacheManager(){return new MemoryConstrainedCacheManager();}

	 @Bean(name = "securityManager")
	    public DefaultSecurityManager securityManager(){
	        //这里注意，需要实现DefaultWebSecurityManager
	        DefaultSecurityManager sm = new DefaultWebSecurityManager();
	        sm.setCacheManager(cacheManager());
	        return sm;
	    }

	/**
	 shiro权限核心，过滤链的配置
	 */
	    @Bean(name = "shiroFilter")
	    @DependsOn("securityManager")
	  public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultSecurityManager securityManager,Realm realm) {
	    	securityManager.setRealm(realm);
	    	ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
	        shiroFilter.setSecurityManager(securityManager);
	        shiroFilter.setLoginUrl("/login.html");//未登录跳转
	        shiroFilter.setSuccessUrl("/manage.html");//成功登录跳转
	        shiroFilter.setUnauthorizedUrl("/error404.html");//未授权跳转

	    //过滤器链，anon为未认证访问，authc为认证访问，roles为需要角色访问
	        LinkedHashMap<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
	        filterChainDefinitionMap.put("/login.html","anon");
	        filterChainDefinitionMap.put("/*.js","anon");
	        filterChainDefinitionMap.put("/logins","anon");
	        filterChainDefinitionMap.put("/countDescByYear","anon");
	        filterChainDefinitionMap.put("/clientmanage.html","roles[admin]");
	        filterChainDefinitionMap.put("/usermanage.html","roles[admin]");
	        filterChainDefinitionMap.put("/count.html","roles[admin]");
	        filterChainDefinitionMap.put("/**","authc");
	        


	        shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMap);
	        return shiroFilter;

	  }
	 
	
	  
}