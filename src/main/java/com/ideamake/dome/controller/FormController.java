package com.ideamake.dome.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {
	// 动态跳转页面
	@RequestMapping(value="/{formName}")
	 public String loginForm(@PathVariable String formName){
		return formName;
	}

}
