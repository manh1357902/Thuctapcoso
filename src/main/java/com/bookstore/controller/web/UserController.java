package com.bookstore.controller.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.dto.UsersDTO;
import com.bookstore.service.IUserService;

@Controller(value = "user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "/thong-tin-ca-nhan",method = RequestMethod.GET)
	private ModelAndView profile(Principal principal,@RequestParam(value = "mess",required = false) String mess) {
		ModelAndView mav = new ModelAndView("web/profile");
		if(principal==null) {
			return new ModelAndView("redirect:/dang-nhap");
		}
		UsersDTO user = userService.findOneByUserName(principal.getName());
		mav.addObject("user",user);
		if(mess!=null) {
			if(mess.equals("updatesuccess")) {
			mav.addObject("mess", "Cập nhập thành công");
		}
	}
		return mav;
	}
	@RequestMapping(value="/process-user", method = RequestMethod.POST)
	public ModelAndView editUser1(@ModelAttribute UsersDTO user) {
		userService.save(user);
		return new ModelAndView("redirect:/thong-tin-ca-nhan?mess=updatesuccess");
	}
}
