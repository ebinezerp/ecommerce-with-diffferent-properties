package project.springwebmvcdemo.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dt.b190043.demoproject.dao.UserDao;
import dt.b190043.demoproject.model.User;

@Controller
public class HomeController {

	@Autowired
	private UserDao userDao;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@PostMapping("/signup")
	public String registerUser(@Valid @ModelAttribute("user") User user,BindingResult result, Model model) {
		
		if(!result.hasErrors())
		{
			if (userDao.getUserByEmail(user.getEmail()) == null) {
				userDao.addUser(user);
				return "redirect:/login";
			} else {
				model.addAttribute("message", "Email is Already Existed");
				return "signup";
			}
		}else
		{
			
			return "signup";
		}
			
		
		
		

	}

	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpSession httpSession, Model model) {
		User user = userDao.login(email, password);
		if (user != null) {
			httpSession.setAttribute("user", user);
			if (user.getRole().equalsIgnoreCase("seller")) {
				return "redirect:/seller";
			} else if (user.getRole().equalsIgnoreCase("custormer")) {
				return "redirect:/";
			} else {
				return "redirect:/admin";
			}

		} else {
			model.addAttribute("message", "Invalid Credentials");
			return "login";
		}

	}

	@PostMapping("/update")
	public String updateUser(@ModelAttribute("user") User user) {
		if (userDao.update(user)) {
			return "profile";
		} else {
			return "editprofile";
		}
	}

}
