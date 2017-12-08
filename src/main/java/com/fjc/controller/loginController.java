package com.fjc.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fjc.entity.SmbmsUser;
import com.fjc.service.SmbmsUserService;

@Controller
public class loginController {
	@Autowired
	private SmbmsUserService us;
	@RequestMapping(value="login.do",method={RequestMethod.POST})
	public String login(SmbmsUser user,HttpSession session,Map<String, Object> model){
		/*System.out.println("===========================");
		System.out.println("user"+ user);*/
		//int a = 10/0;
		SmbmsUser logined = us.login(user);
		if (logined != null) {
			session.setAttribute("user", logined);
			return "jsp/frame";
		}
		model.put("error", "用户名或密码不正确");
		return "login";
	}
	@RequestMapping("logout.do")
	public String logout(HttpSession session){
		session.removeAttribute("user");
		return "login";
		
	}
	/*@ExceptionHandler(RuntimeException.class)
	public String exceptionHandler(RuntimeException exception,HttpServletRequest req){
		req.setAttribute("exception", exception);
		return "jsp/error";
		
	}*/
}
