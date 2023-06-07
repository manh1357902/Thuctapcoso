package com.bookstore.controller.web;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.dto.BookDTO;
import com.bookstore.dto.CartItemDTO;
import com.bookstore.dto.CategoryDTO;
import com.bookstore.dto.ShoppingCartDTO;
import com.bookstore.dto.UsersDTO;
import com.bookstore.service.IBookService;
import com.bookstore.service.ICategoryService;
import com.bookstore.service.IShoppingCartService;
import com.bookstore.service.IUserService;
import com.bookstore.service.convert.CategoryConvert;
import com.bookstore.service.convert.UserConvert;

@Controller(value ="Web")
public class HomeController {
	
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private IBookService bookService;
	@Autowired
	private IUserService userService;
	@Autowired
	private UserConvert userConvert;
	@Autowired
	private IShoppingCartService cartService;
	@Autowired
	private CategoryConvert categoryConvert;
	
	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage(HttpSession session, Principal principal,
								@RequestParam(defaultValue = "1") int page,
					            @RequestParam(defaultValue = "12") int size) {
		ModelAndView mav = new ModelAndView("web/home");
		List<CategoryDTO> categories = categoryService.findAll();
		Page<BookDTO> books = bookService.getBookByPage(page, size);
		List<BookDTO> book1 = bookService.findAll();
		session.setAttribute("category", categories);
		mav.addObject("books",books.getContent());
        mav.addObject("currentPage", page);
        mav.addObject("totalPages", bookService.getTotalPages(size,book1.size()));
		if(principal!=null) {
			String username = principal.getName();
			UsersDTO user= userService.findOneByUserName(username);
			ShoppingCartDTO shoppingCart = cartService.findByUser(userConvert.toEntity1(user));
			if(shoppingCart!=null) {
				List<CartItemDTO> cartItem = shoppingCart.getCartItem();
				session.setAttribute("totalItems", cartItem.size());
				session.setAttribute("totalPrices", shoppingCart.getConverTotalPrices());
			}
		}
		return mav;
	}
	@RequestMapping(value = "/trang-chu/{category}", method = RequestMethod.GET)
	public ModelAndView categoryPage(@PathVariable String category,
									 @RequestParam(defaultValue = "1") int page,
						             @RequestParam(defaultValue = "12") int size) {
		ModelAndView mav = new ModelAndView("web/home");
		List<CategoryDTO> categories = categoryService.findAll();
		mav.addObject("category",categories);
		CategoryDTO categori = categoryService.findOne(Long.parseLong(category));
		Page<BookDTO> books = bookService.getBookByCategory(page, size, categoryConvert.toEntity(categori));
		List<BookDTO> book1 = bookService.findByCategory(categoryConvert.toEntity(categori));
		mav.addObject("books",books.getContent());
        mav.addObject("currentPage", page);
        mav.addObject("totalPages", bookService.getTotalPages(size,book1.size()));
		return mav;
	}

}