package dao;
import java.util.List;

import dao.CustomerDAO;
import model.Customer;
public class TestCustomerDao {
	public static void main(String[] args) 
	{
//		Customer c = new Customer();
//		c.setName("James");
//		c.setCity("Kanpur");
//		c.setMobileNo(9876543212l);
//		c.setUserId("james45@gmail.com");
//		c.setPassword("4james2");
		CustomerDAO dao = new CustomerDAO();
//		dao.save(c);
		List<Customer> list = dao.list();
		System.out.println(list);
	}
	

}
