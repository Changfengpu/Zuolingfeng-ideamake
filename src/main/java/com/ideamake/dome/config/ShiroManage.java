package com.ideamake.dome.config;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;


public class ShiroManage {
	/**
	 * 这里是shiro的一些配置
	 * 
	 * */
	@Bean
	  public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
	    return new LifecycleBeanPostProcessor();
	  }
	
	
	@Bean(name = "defaultAdvisorAutoProxyCreator")
  @DependsOn("lifecycleBeanPostProcessor")
  public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
      DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
      defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
      return defaultAdvisorAutoProxyCreator;
  }

	@Bean
  public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(DefaultSecurityManager securityManager){
      AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
      aasa.setSecurityManager(securityManager);
      return aasa;
  }
}
