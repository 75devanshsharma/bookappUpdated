package dao;

import model.Order;

import java.util.List;

import dao.OrderDao;

public class TestOrderDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Order o = new Order();
//		o.setCustomerId(23);
//		o.setBookName("Java");
//		o.setQuantity(3);
		OrderDao dao = new OrderDao();
//		dao.insert(o);
		List<Order> list = dao.list();
		System.out.println(list);
		

	}

}
