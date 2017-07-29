package dao;

import model.Customer;
import util.ConnectionUtil;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.core.*;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.*;

public class CustomerDAO {
	JdbcTemplate jdbctemplate = ConnectionUtil.getJdbcTemplate();

	public void save(Customer cust) {
		String sql = "insert into Customers5(name,city,mobile,username,password) values (?,?,?,?,?) ";
		Object params[] = { cust.getName(), cust.getCity(), cust.getMobileNo(), cust.getUserId(), cust.getPassword() };
		int rows = jdbctemplate.update(sql, params);
		System.out.println(" No. of rows inserted :" + rows);
	}
	
	public void update(Customer cust)
	{
		String sql = "update Customers5 set password= ? where username = ?";
		Object params[] = { cust.getPassword(), cust.getUserId() };
		int rows = jdbctemplate.update(sql, params);
		System.out.println("No. of rows updated :" + rows);
	}
	
	public void delete(String userId)
	{
		String sql = "delete from Customers5 where username = ? ";
		int rows = jdbctemplate.update(sql, userId);
		System.out.println("No. of rows deleted :" +rows);
	}
	
	public List<Customer> list()
	{
		String sql = "select id,name,city,mobile,username from Customers5 ";
		List<Customer> list = jdbctemplate.query(sql, (rs, rowNum) -> {
			Customer cust = new Customer();
			cust.setId(rs.getInt("id"));
			cust.setName(rs.getString("name"));
			cust.setCity(rs.getString("city"));
			cust.setMobileNo(rs.getLong("mobile"));
			cust.setUserId(rs.getString("username"));
			return cust;
		});
		return list;
	}
	
	
	public Customer findById(int id)
	{
		String sql = "select id,name,city,mobile,username from Customers5 where id = ? ";
		Object params[] = {id};
		Customer c = null;
		try {
			c = jdbctemplate.queryForObject(sql, params,(rs, rowNum) -> {
				Customer cust = new Customer();
				cust.setId(rs.getInt("id"));
				cust.setName(rs.getString("name"));
				cust.setCity(rs.getString("city"));
				cust.setMobileNo(rs.getLong("mobile"));
				cust.setUserId(rs.getString("username"));
				return cust;
			});
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
	public Customer findByUsernameAndPassword(String username, String password)
	{
		String sql = "select id,name,city,mobile,username from Customers5 where username =? and password = ? ";
		Object params[] = {username, password};
		Customer c = null;
		try {
			c = jdbctemplate.queryForObject(sql, params,(rs, rowNum) -> {
				Customer cust = new Customer();
				cust.setId(rs.getInt("id"));
				cust.setName(rs.getString("name"));
				cust.setCity(rs.getString("city"));
				cust.setMobileNo(rs.getLong("mobile"));
				cust.setUserId(rs.getString("username"));
				return cust;
			});
		} catch (EmptyResultDataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
		
	
		
	}


