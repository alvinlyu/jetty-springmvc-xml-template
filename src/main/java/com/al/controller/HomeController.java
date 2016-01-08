package com.al.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class HomeController {

    @Value("${log4j.file.path}")
    private String logsPath;

	@RequestMapping("/")
	public ModelAndView home()
	{
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String home2(){
		return logsPath;
	}
	
}
