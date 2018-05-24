package com.gc.spring.Lab21.Lab21;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@Autowired
	Person p;

	@RequestMapping("/")
	public ModelAndView testing() {
		return new ModelAndView("index", "register", "Welcome to GC Coffee");
	}

	// this is just to render the view for the form.jsp
	@RequestMapping("form")
	public String form() {
		return "form";
	}

	@RequestMapping("form1")
	public ModelAndView formTest(@RequestParam("fName") String firstName, @RequestParam("lName") String lastName, @RequestParam("email") String email, @RequestParam("phoneNum") String phoneNum, @RequestParam("password") String password) {

		p.setFirstName(firstName);
		p.setLastName(lastName);
		p.setEmail(email);
		p.setPhoneNum(phoneNum);
		p.setPassword(password);

		return new ModelAndView("summary", "person", p);

	}

}
