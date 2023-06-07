package com.bookstore.controller.admin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.dto.BookDTO;
import com.bookstore.service.IBookService;
import com.bookstore.service.ICategoryService;

@Controller
public class BookController {

	@Autowired
	private IBookService bookService;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private ICategoryService categoryService;
	
	@RequestMapping(value = "/admin/list/book", method = RequestMethod.GET)
	public ModelAndView listBook(@RequestParam(value="mess",required = false) String mess) {
		List<BookDTO> books = new ArrayList<>();
		ModelAndView mav = new ModelAndView("admin/listbook");
		books.addAll(bookService.findAll());
		mav.addObject("model",books);
		if(mess!=null) {
			if(mess.equals("create-erro")) {
				mav.addObject("alert", "danger");
				mav.addObject("mess", "Tạo sách thất bại");
			}
			else if(mess.equals("update-erro")) {
				mav.addObject("alert", "danger");
				mav.addObject("mess", "Cập nhập thất bại");
			}
			else if(mess.equals("delete_success")) {
				mav.addObject("alert", "success");
				mav.addObject("mess", "Xóa thành công");
			}
			else if(mess.equals("error_system")) {
				mav.addObject("alert", "danger");
				mav.addObject("mess", "Xóa thất bại");
			}
			if(mess.equals("createsuccess")) {
				mav.addObject("alert", "success");
				mav.addObject("mess", "Tạo sách thành công");
			}
			else if(mess.equals("updatesuccess")) {
				mav.addObject("alert", "success");
				mav.addObject("mess", "Cập nhập thành công");
			}
		}

		return mav;
	}

	@RequestMapping(value = "/admin/createBook", method = RequestMethod.GET)
	public ModelAndView editBook(@RequestParam(value = "id",required = false) Long id,@RequestParam(value="mess",required = false) String mess) {
		ModelAndView mav = new ModelAndView("admin/editbook");
		BookDTO book = new BookDTO();
		if(id!=null) {
			book = bookService.findById(id);
		}	
		mav.addObject("book",book);
		List<String> categories = categoryService.findName();
		if(categories!=null) {
			mav.addObject("categories", categories);
		}
		if(mess!=null) {
			if(mess.equals("createsuccess")) {
				mav.addObject("mess", "Tạo sách thành công");
			}
			else if(mess.equals("updatesuccess")) {
				mav.addObject("mess", "Cập nhập thành công");
			}
		}
		return mav;
	}
	@RequestMapping(value = "/admin/createBook", method = RequestMethod.POST)
	public ModelAndView edit1Book(@ModelAttribute("book") BookDTO book) {
		String url="redirect:/admin/list/book";
		if(!book.getImg1().getOriginalFilename().equals("")) {
		    try {
		        MultipartFile multipartFile = book.getImg1();
		        String fileName = multipartFile.getOriginalFilename();
		        book.setImg(fileName);
		        String path = context.getRealPath("/template/web/images/");
		        File file = new File(path, fileName);
		        multipartFile.transferTo(file);
		      } catch (Exception e) {
		        e.printStackTrace();
		      }
		}
		if(book.getId()!=null) {
			try {
				bookService.save(book);
				url="redirect:/admin/createBook?id="+book.getId()+"&mess=updatesuccess";
			}catch(Exception e) {
				url = "/admin/list/book?mess=update-erro";
			}
		}
		else {
			try {
				bookService.save(book);
				url="redirect:/admin/list/book?mess=createsuccess&alert=success";
			}catch(Exception e) {
				url = "/admin/list/book?mess=update-erro";
			}
		}
		return new ModelAndView(url);
	}
	@RequestMapping(value = "/admin/deleteBook",method = RequestMethod.POST)
	public ModelAndView deleteBook(@RequestParam("id") Long id) {
		bookService.delete(id);
		return new ModelAndView("redirect:/admin/list/book?mess=delete_success");
	}
}