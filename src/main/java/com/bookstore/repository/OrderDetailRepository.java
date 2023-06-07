package com.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.entity.OrderDetailEntity;
import com.bookstore.entity.OrderEntity;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Long>{
	List<OrderDetailEntity> findByOrder(OrderEntity order);
}
