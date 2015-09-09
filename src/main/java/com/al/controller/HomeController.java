package com.al.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class HomeController {

	@RequestMapping("/")
	public ModelAndView home()
	{
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String home2(){
		return "success";
	}
	
}
