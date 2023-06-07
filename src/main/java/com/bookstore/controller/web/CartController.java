package com.bookstore.controller.web;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.dto.CartItemDTO;
import com.bookstore.dto.ShoppingCartDTO;
import com.bookstore.dto.UsersDTO;
import com.bookstore.service.ICartItemService;
import com.bookstore.service.IShoppingCartService;
import com.bookstore.service.IUserService;
import com.bookstore.service.convert.UserConvert;

@Controller
public class CartController {
	
	@Autowired
	private IUserService userService;	
	@Autowired
	private IShoppingCartService cartService;
	@Autowired
	private UserConvert userConvert;
	@Autowired
	private ICartItemService cartItemService;
	
	@RequestMapping(value="/gio-hang", method = RequestMethod.GET)
	public ModelAndView cart(Principal principal, HttpSession session) {	
		ModelAndView mav = new ModelAndView("web/cart");
		if (principal == null) {
			mav =  new ModelAndView("redirect:/dang-nhap");
		}
		else {
			String username = principal.getName();
			UsersDTO user= userService.findOneByUserName(username);
			ShoppingCartDTO shoppingCart =  cartService.findByUser(userConvert.toEntity1(user));
			if(shoppingCart!=null) {
				List<CartItemDTO> cartItem = shoppingCart.getCartItem();
				session.setAttribute("totalItems", cartItem.size());
				session.setAttribute("totalPrices", shoppingCart.getConverTotalPrices());
				mav.addObject("shoppingCart", shoppingCart);
			}
		}		
		return mav;
	}
	
	@RequestMapping(value="/gio-hang/add", method = RequestMethod.POST)
    public ModelAndView addToCart(
            @RequestParam("id") Long bookId,
            @RequestParam(value = "quantity", required = false) int quantity,
            Principal principal){
    	String url="";
        if(principal != null){
            String username = principal.getName();
            cartService.addToCart(bookId, quantity, username);
            url = "redirect:/gio-hang";
        }else {
        	url ="redirect:/dang-nhap";
        }
        return new ModelAndView(url);
    }
	
	@RequestMapping(value="/gio-hang/update-and-delete", method = RequestMethod.POST)
    public ModelAndView updateAndDeleteCart(
            @RequestParam("id") Long bookId,
            @RequestParam("action") String action,
            @RequestParam(value = "quantity", required = false) int quantity,
            Principal principal){
    	String url="";
        if(principal != null){
            String username = principal.getName();
            if(action.equals("update")) {
            	cartService.update(bookId, quantity, username);
            }
            else if(action.equals("delete")) {
            	cartItemService.deleteItem(bookId, username);
            }
            url = "redirect:/gio-hang";
        }else {
        	url ="redirect:/dang-nhap";
        }
        return new ModelAndView(url);
    }
	
}
