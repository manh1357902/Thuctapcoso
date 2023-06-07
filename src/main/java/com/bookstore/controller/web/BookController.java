package com.bookstore.controller.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.dto.BookDTO;
import com.bookstore.dto.CategoryDTO;
import com.bookstore.service.IBookService;
import com.bookstore.service.ICategoryService;

@Controller(value ="BookWeb")
public class BookController {
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private IBookService bookService;
	
	@RequestMapping(value="/chi-tiet/{bookId}",method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable Long bookId) {
		ModelAndView mav = new ModelAndView("web/detail");
		List<CategoryDTO> categories = categoryService.findAll();
		BookDTO book = bookService.findById(bookId);
		mav.addObject("book",book);
		mav.addObject("category",categories);
		return mav;
	}
	@RequestMapping(value = "/tim-kiem",method = RequestMethod.GET)
	public ModelAndView search(@RequestParam(value = "keyword",required=false) String keyword,
								@RequestParam(defaultValue = "1") int page,
            					@RequestParam(defaultValue = "12") int size) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView("web/search");
		String decoderKeyword = URLDecoder.decode(keyword,"UTF-8");
		Page<BookDTO> books = bookService.getBookByTitleOrAuthor(decoderKeyword, page, size);
		List<BookDTO> book1 = bookService.findByTitleOrAuthor(decoderKeyword);
		mav.addObject("books",books.getContent());
        mav.addObject("currentPage", page);
        mav.addObject("totalPages", bookService.getTotalPages(size,book1.size()));
		return mav;
	}
	@RequestMapping(value="xu-ly-tim-kiem",method = RequestMethod.POST)
	public ModelAndView processSearch(@RequestParam("keyword") String keyword) throws UnsupportedEncodingException {
		String encodedKeyword  =  URLEncoder.encode(keyword,"UTF-8");
		return new ModelAndView("redirect:/tim-kiem?keyword="+encodedKeyword);
	}
}
