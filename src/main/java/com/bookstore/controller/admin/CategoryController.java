package com.bookstore.controller.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.dto.CategoryDTO;
import com.bookstore.service.ICategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	private ICategoryService categoryService;
	
	@RequestMapping(value = "/admin/list/category",method = RequestMethod.GET)
	public ModelAndView listCategory(@RequestParam(value = "mess", required=false) String mess) {
		ModelAndView mav = new ModelAndView("admin/listcategory");
		if(mess!=null) {
			if(mess.equals("createsuccess")) {
				mav.addObject("alert", "success");
				mav.addObject("mess", "Thêm thể loại thành công");
			}
			if(mess.equals("delete_success")) {
				mav.addObject("alert", "success");
				mav.addObject("mess", "Xóa thành công");
			}
		}
		List<CategoryDTO> categories = categoryService.findAll();
		if(categories!=null) {
			mav.addObject("categories",categories);
		}
		return mav;
	}
	@RequestMapping(value = "/admin/edit/category", method = RequestMethod.GET)
	public ModelAndView editBook(@RequestParam(value = "id",required = false) Long id,@RequestParam(value="mess",required = false) String mess, HttpSession session) {
		ModelAndView mav = new ModelAndView("admin/editcategory");
		CategoryDTO category = new CategoryDTO();
		String name = (String) session.getAttribute("nameCategory");
		if(name!=null)
			category.setName(name);
		mav.addObject("category",category);
		if(mess!=null) {
			if(mess.equals("error")) {
				mav.addObject("alert", "danger");
				mav.addObject("mess", "Thể loại đã tồn tại");
			}
		}
		return mav;
	}
	@RequestMapping(value = "/admin/createCategory",method = RequestMethod.POST)
	public ModelAndView editCategory(@ModelAttribute CategoryDTO category, HttpSession session) {
		CategoryDTO category1 = categoryService.findOneByName(category.getName());
		if(category1!=null) {
			session.setAttribute("nameCategory", category.getName());
			return new ModelAndView("redirect:/admin/edit/category?mess=error");
		}
		categoryService.save(category);
		return new ModelAndView("redirect:/admin/list/category?mess=createsuccess&alert=success");
	}
	@RequestMapping(value = "/admin/deleteCategory",method = RequestMethod.POST)
	public ModelAndView deleteBook(@RequestParam("id") Long id) {
		categoryService.delete(id);
		return new ModelAndView("redirect:/admin/list/category?mess=delete_success");
	}
}
