package com.bookstore.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.dto.OrderDTO;
import com.bookstore.service.IOrderService;

@Controller("orderAdmin")
public class OrderController {
	
	@Autowired
	private IOrderService orderService;
	
	@RequestMapping(value ="/admin/list/order", method = RequestMethod.GET)
	public ModelAndView listOrder() {
		ModelAndView mav = new ModelAndView("admin/listorder");
		List<OrderDTO> orders = new ArrayList<>();
		orders.addAll(orderService.findAll());			
		mav.addObject("orders",orders);
		return mav;
	}
	
	@RequestMapping(value="/admin/process-order", method = RequestMethod.POST)
	public ModelAndView processOrder(@RequestParam(value="id", required = false) Long id,
									@RequestParam(value="action",required = false) String action) {
		if(action.equals("duyet"))
			orderService.processOrder(id);
		else if(action.equals("huy")){
			orderService.delete(id);
		}
		else {
			orderService.receive(id);
		}
		return new ModelAndView("redirect:/admin/list/order");
	}
}
