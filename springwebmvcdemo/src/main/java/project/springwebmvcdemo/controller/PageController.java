package project.springwebmvcdemo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dt.b190043.demoproject.model.User;

@Controller
public class PageController {
	
	@GetMapping("/signup")
	public String signUp(Model model)
	{
		model.addAttribute("user", new User());
		return "signup";
	}
	
	@GetMapping("/login")
	public String loginPage()
	{
		return "login";
	}
	
	
	@GetMapping("/profile")
	public String profilePage()
	{
		return "profile";
	}
	
	@GetMapping("/edit")
	public String editProfile(HttpSession httpSession,Model model)
	{
		model.addAttribute("user", httpSession.getAttribute("user"));
		return "editprofile";
	}

}
