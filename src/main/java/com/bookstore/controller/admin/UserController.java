package com.bookstore.controller.admin;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.dto.UsersDTO;
import com.bookstore.service.IUserService;

@Controller
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "/admin/list/user", method = RequestMethod.GET)
	public ModelAndView listUser(@RequestParam(value="mess",required = false) String mess) {
		List<UsersDTO> users = new ArrayList<>();
		ModelAndView mav = new ModelAndView("admin/listuser");
		users.addAll(userService.findAll());
		mav.addObject("users",users);
		if(mess!=null) {
			if(mess.equals("update-erro")) {
				mav.addObject("alert", "danger");
				mav.addObject("mess", "Cập nhập thất bại");
			}
		}
		return mav;
	}
	
	@RequestMapping(value = "/admin/edit/user", method = RequestMethod.GET)
	public ModelAndView editUser(@RequestParam(value = "id",required = false) Long id,@RequestParam(value="mess",required = false) String mess,Principal principal) {
		ModelAndView mav = new ModelAndView("admin/edituser");
		UsersDTO user = new UsersDTO();
		if(id!=null) {
			user = userService.findOneById(id);
		}else {
			user = userService.findOneByUserName(principal.getName());
		}
		mav.addObject("user",user);
		if(mess!=null) {
				if(mess.equals("updatesuccess")) {
				mav.addObject("mess", "Cập nhập thành công");
			}
		}
		return mav;
	}
	
	@RequestMapping(value="/admin/edit/process-user", method = RequestMethod.POST)
	public ModelAndView editUser1(@ModelAttribute UsersDTO user) {
		userService.save(user);
		return new ModelAndView("redirect:/admin/edit/user?id="+user.getId()+"&mess=updatesuccess");
	}
}
