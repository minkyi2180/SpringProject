package com.mysite.prac.order;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysite.prac.user.SiteUser;

public interface OrderRepository extends JpaRepository<Order, Integer>{
	Order findAllByUser(SiteUser user);
}
