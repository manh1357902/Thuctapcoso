package com.bookstore.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.dto.OrderDTO;
import com.bookstore.entity.BookEntity;
import com.bookstore.entity.CartItemEntity;
import com.bookstore.entity.OrderDetailEntity;
import com.bookstore.entity.OrderEntity;
import com.bookstore.entity.ShoppingCartEntity;
import com.bookstore.entity.UserEntity;
import com.bookstore.repository.BookRepository;
import com.bookstore.repository.CartItemRepository;
import com.bookstore.repository.OrderDetailRepository;
import com.bookstore.repository.OrderRepository;
import com.bookstore.repository.ShoppingCartRepository;
import com.bookstore.repository.UserRepository;
import com.bookstore.service.IOrderService;
import com.bookstore.service.convert.OrderConvert;

@Service
public class OrderService implements IOrderService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CartItemRepository cartItemRepository;
	@Autowired
	private ShoppingCartRepository cartRepository;
	@Autowired
	private OrderDetailRepository detailRepository;
	@Autowired 
	private OrderRepository orderRepository;
	@Autowired
	private OrderConvert orderConvert;
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	@Transactional
	public void save(String username) {
		UserEntity user = userRepository.findOneByUserName(username);
		ShoppingCartEntity cart = cartRepository.findOneByUser(user);
		OrderEntity order = new OrderEntity();
		order.setTotalPrice(cart.getTotalPrices());
		order.setOrderStatus("Đang chờ duyệt");
		order.setOrderDate(new Date());
		List<CartItemEntity> items = cart.getCartItem();
		cartItemRepository.delete(items);
		List<OrderDetailEntity> orderdetails = new ArrayList<>();
		long dem=0;
		for(CartItemEntity item:items) {
			OrderDetailEntity detail = new OrderDetailEntity();
			if(item.getQuantity()>0) {
				detail.setNameBook(item.getBook().getTitle());
				detail.setImg(item.getBook().getImg());
				detail.setQuantity(item.getQuantity());
				detail.setTotalPrice(item.getTotalPrice());
				detail.setUnitPrice(item.getBook().getPrice());
				detail.setIdBook(item.getBook().getId());
				BookEntity book = bookRepository.findOne(item.getBook().getId());
				book.setQuantity(book.getQuantity()-item.getQuantity());
				book.setCartItem(null);
				detail.setOrder(order);
				bookRepository.save(book);
				detailRepository.save(detail);
				orderdetails.add(detail);
				dem++;
			}
		}
		order.setOrderDetail(orderdetails);
		order.setUser(user);
		List<CartItemEntity> item = new ArrayList<>();
		cart.setCartItem(item);
		cart.setTotalItems(0);
		cart.setTotalPrices(0);
		if(dem>0) {			
			cartRepository.save(cart);	
			orderRepository.save(order);
		}
	}
	@Override
	public List<OrderDTO> findAll() {
		List<OrderEntity> orders = orderRepository.findAll();
		List<OrderDTO> order = new ArrayList<>();
		for(OrderEntity x:orders) {
			OrderDTO dto = orderConvert.toDTO(x);
			order.add(dto);
		}
		return order;
	}
	@Override
	public OrderDTO findById(Long id) {
		return orderConvert.toDTO(orderRepository.findOne(id));
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		OrderEntity order = orderRepository.findOne(id);
		List<OrderDetailEntity> details = order.getOrderDetail();
		for(OrderDetailEntity detail:details) {
			BookEntity book = bookRepository.findOne(detail.getIdBook());
			book.setQuantity(book.getQuantity()+detail.getQuantity());
			bookRepository.save(book);
		}
		orderRepository.delete(id);
	}
	@Override
	public void processOrder(Long id) {
		OrderEntity order= orderRepository.findOne(id);
		order.setOrderStatus("Đang vận chuyển");
		order.setDeliveryDate(new Date());
		orderRepository.save(order);
	}
	@Override
	public void receive(Long id) {
		OrderEntity order= orderRepository.findOne(id);
		order.setOrderReceive(new Date());
		order.setOrderStatus("Đã nhận");
		orderRepository.save(order);
		
	}
	@Override
	public List<OrderDTO> findByUser(UserEntity user) {
		List<OrderEntity> orders = orderRepository.findByUser(user);
		List<OrderDTO> order = new ArrayList<>();
		for(OrderEntity x:orders) {
			OrderDTO dto = orderConvert.toDTO(x);
			order.add(dto);
		}
		return order;
	}
	
}
