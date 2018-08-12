package org.monsanto.recipemanager.controller;

import org.monsanto.recipemanager.util.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping(Constants.LANDING)
	public String showWelcome() {
		return "index";
	}
	
	@RequestMapping(Constants.ADD)
	public String showadd() {
		return "add";
	}
	
	@RequestMapping(Constants.VIEW)
	public String showview() {
		return "view";
	}
	
	@RequestMapping(Constants.WELCOME)
	public String showwelcome() {
		return "welcome";
	}

}