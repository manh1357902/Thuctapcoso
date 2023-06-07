package com.bookstore.controller.web;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.dto.CartItemDTO;
import com.bookstore.dto.OrderDTO;
import com.bookstore.dto.OrderDetailDTO;
import com.bookstore.dto.ShoppingCartDTO;
import com.bookstore.dto.UsersDTO;
import com.bookstore.service.IOrderDetailService;
import com.bookstore.service.IOrderService;
import com.bookstore.service.IShoppingCartService;
import com.bookstore.service.IUserService;
import com.bookstore.service.convert.UserConvert;

@Controller
public class OrderController {
	
	@Autowired
	private IUserService userService;	
	@Autowired
	private IShoppingCartService cartService;
	@Autowired
	private UserConvert userconvert;
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IOrderDetailService orderDetailService;
	
	@RequestMapping(value = "/thanh-toan",method = RequestMethod.GET)
	public ModelAndView checkout(Principal principal) {
		if(principal==null) {
			return new ModelAndView("redirect:/dang-nhap");
		}else {
			ModelAndView mav = new ModelAndView("web/checkout");
			String userName = principal.getName();
			UsersDTO user = userService.findOneByUserName(userName);
			mav.addObject("user",user);
			ShoppingCartDTO cart = cartService.findByUser(userconvert.toEntity1(user));
			mav.addObject("cart", cart);
		return mav;
		}
	}
	@RequestMapping(value="/don-hang", method = RequestMethod.GET)
	public ModelAndView showOrder(Principal principal, HttpSession session) {
		if(principal==null) {
			return new ModelAndView("redirect:/dang-nhap");
		}
		else {
			ModelAndView mav = new ModelAndView("web/order");
			UsersDTO user = userService.findOneByUserName(principal.getName());
			ShoppingCartDTO cart = cartService.findByUser(userconvert.toEntity1(user));
			if(cart!=null) {
				List<CartItemDTO> cartItem = cart.getCartItem();
				session.setAttribute("totalItems", cartItem.size());
				session.setAttribute("totalPrices", cart.getConverTotalPrices());
			}
			List<OrderDTO> order = orderService.findByUser(userconvert.toEntity1(user));
			mav.addObject("orders", order);
			return mav;
		}
	}
	@RequestMapping(value="/vnpay", method = RequestMethod.GET)
	public ModelAndView checkoutVNPAY() {
		return new ModelAndView("web/vnpay");
	}
	@RequestMapping(value="/chi-tiet-don-hang/{id}", method = RequestMethod.GET)
	public ModelAndView orderDetail(Principal principal,@PathVariable("id") Long id) {
		if(principal==null) {
			return new ModelAndView("redirect:/dang-nhap");
		}
		else {
			ModelAndView mav = new ModelAndView("web/orderdetail");
			userService.findOneByUserName(principal.getName());
			List<OrderDetailDTO> details = orderDetailService.findByOrder(id);
			mav.addObject("details", details);
			return mav;
 		}
	}
	@RequestMapping(value="/add-order", method = RequestMethod.POST)
	public ModelAndView order(Principal principal,@RequestParam(value= "checkout", required=false ) String method) {
		if(principal==null) {
			return new ModelAndView("redirect:/dang-nhap");
		}
		else {
			if(method.equals("CASH")) {
				String userName = principal.getName();
				orderService.save(userName);
				return new ModelAndView("redirect:/don-hang");
			}
			else{
				return new ModelAndView("redirect:/vnpay");
			}			
		}
	}
	@RequestMapping(value="/cancel-order", method = RequestMethod.POST)
	public ModelAndView order(@RequestParam(value= "id", required=false ) Long id) {
		orderService.delete(id);
		return new ModelAndView("redirect:/don-hang");
		
	}

}
