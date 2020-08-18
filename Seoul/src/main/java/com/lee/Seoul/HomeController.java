package com.lee.Seoul;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private Map<String, String> map;
	public HomeController() {
		map = new HashMap<String, String>();
		map.put("login","/member/");
		map.put("myPage","/member/");
		map.put("email","/member/");
		map.put("intro","/seoul/");
		map.put("join","/seoul/");
		map.put("home","/");
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		return "home";
	}
	
	@RequestMapping(value="/{pathName}")
	public String home(@PathVariable String pathName,
			@ModelAttribute("cate") Categories categories) {
		String path =  map.get(pathName)+pathName;
		
		logger.info(categories.getCategoryName());
		
		return path;
	}

	
}
