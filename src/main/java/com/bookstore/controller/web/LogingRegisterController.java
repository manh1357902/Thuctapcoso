package com.bookstore.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.dto.UsersDTO;
import com.bookstore.service.IUserService;

@Controller(value ="Login")
public class LogingRegisterController {
	
	@Autowired
	IUserService userService;
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView loginPage(@RequestParam(value = "mess",required=false) String mess,Authentication authentication) {
		if(authentication!=null) {
			if(authentication.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN")))
				return new ModelAndView("redirect:/admin/trang-chu");
			else
				return new ModelAndView("redirect:/trang-chu");
		}
		ModelAndView mav = new ModelAndView("login");
		if(mess!=null) {
			if(mess.equals("thanhcong")) {
				mav.addObject("mess","Đăng ký thành công");
			}
		}
		return mav;
	}
	@RequestMapping(value = "/thoat", method = RequestMethod.GET)
	public ModelAndView logoutPage(HttpServletRequest request, HttpServletResponse response) {
		String url = "";
		Authentication authen = SecurityContextHolder.getContext().getAuthentication();
		if (authen != null) {
			new SecurityContextLogoutHandler().logout(request, response, authen);
			url = "redirect:/trang-chu";
		}
		return new ModelAndView(url);
	}
	@RequestMapping(value = "/khongcoquyentruynhap", method = RequestMethod.GET)
	public ModelAndView erroPage() {
		ModelAndView mav = new ModelAndView("redirect:/dang-nhap?khongcoquyentruynhap");
		return mav;
	}
	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView registerPage(@RequestParam(value = "mess",required=false) String mess,Authentication authentication) {
		if(authentication!=null) {
			if(authentication.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN")))
				return new ModelAndView("redirect:/admin/trang-chu");
			else
				return new ModelAndView("redirect:/trang-chu");
		}
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("user", new UsersDTO());
		if(mess!=null) {
			if(mess.equals("passworderro")) {
				mav.addObject("mess","Xác nhận mật khẩu không đúng");
			}else if(mess.equals("taikhoandatontai")) {
				mav.addObject("mess","Tài khoản đã tồn tại");
			}
		}
		return mav;
	}
	@RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
	public ModelAndView addregister(@ModelAttribute("user") UsersDTO user) {
		String url = "";
		UsersDTO model = userService.findOneByUserName(user.getUserName());
		if(model.getUserName()!=null) {
			url = "redirect:/dang-ky?mess=taikhoandatontai";
		}
		else {
			url = "redirect:/dang-ky?mess=taikhoandatontai";
			if(!user.getPassWord().equals(user.getRepassWord())) {
				url = "redirect:/dang-ky?mess=passworderro";
			}
			else {
				userService.save(user);
				url = "redirect:/dang-nhap?mess=thanhcong";
			}
		}
		
		return new ModelAndView(url);
		
	}
}
