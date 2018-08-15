package com.yc.web.controllers;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yc.bean.Person;

@Controller
public class PersonController {
	@RequestMapping(value = "/person.action")
	public String show(@RequestHeader(value = "Host", required = true) String host,
			@RequestHeader("User-Agent") String userAgent, String username, Integer age,
			@CookieValue(value = "JSESSIONID") String sessionid,Person p,HttpSession  session ) {
		System.out.println("host" + host + "--" + userAgent);
		System.out.println(username + "-" + age);
		System.out.println(sessionid);
		System.out.println(p);
		
		session.setAttribute("person", p);
		return "success";
	}

	@RequestMapping(value = "/person1.action")
	public String  show1(Model  model ,  Person  p){//Map存数据  model保存  request作用域  
		//spring创建了一个model对象  然后di进来 
		System.out.println(model);
		//当请求过来时  调用show2  由spring  容器创建一个model对象  request.setAttribute("model",model);
		//再注入到show2（）的方法中做参数
		//model设置age   p2  再由request.getRequestDispacther("/pages/success.jsp").forward();
		model.addAttribute("age" , 22);
		model.addAttribute("p2", p);
		return  "success" ;
	}
	
	@RequestMapping(value = "/person2.action")
	public ModelAndView  show2(ModelAndView  mav ,  Person  p){//Map存数据  model保存  request作用域  
		 mav.addObject("person", p);
		 mav.setViewName("success");
		return  mav ;
	}
	
	//以流的方式输出
	@RequestMapping(value = "/person3.action")
	public void  show3(Person person ,   Writer  out) {//Map存数据  model保存  request作用域  
		 
		  try {
			  out.write(person.getUsername() +" --" + person.getAge() );
			  out.flush();
			  out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		  
	}
	
		@RequestMapping(value = "/person4.action")
		@ResponseBody
		public Person  show4(Person person) {//Map存数据  model保存  request作用域  
			 person.setAge(person.getAge()+ 20);
		 
			  return  person ;
		}
}
