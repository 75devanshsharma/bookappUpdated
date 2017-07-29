package dao;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import model.Order;
import util.ConnectionUtil;
public class OrderDao {

	JdbcTemplate jdbctemplate= ConnectionUtil.getJdbcTemplate();
	
	public void insert(Order o)
	{
		String sql = " insert into order1 (custId,name,quantity) values (?,?,?)";
		Object params[]= {o.getCustomerId(),o.getBookName(),o.getQuantity()};
		int rows = jdbctemplate.update(sql, params);
		System.out.println("No. of rows inserted :" +rows);
	}
	
	public void delete(int id)
	{
		String sql = " delete from order1 where id = ?";
		int rows = jdbctemplate.update(sql, id);
		System.out.println("No. of rows deleted :" +rows);
	}
	
	public List<Order> list()
	{
		String sql ="select id,custId,name, quantity from order1";
		List<Order> list = jdbctemplate.query(sql, (rs,rowNum)-> {
		Order o = new Order();
		o.setId(rs.getInt("id"));
		o.setCustomerId(rs.getInt("custId"));
		o.setBookName(rs.getString("name"));
		o.setQuantity(rs.getInt("quantity"));
		return o; 
		});
	return list;
	}
	
	public Order findByCustomerId(int id)
	{
		String sql ="select id,custId,name, quantity from order1 where id = ?";
		Object params[]= {id};
		Order order = null;
		try {
			order = jdbctemplate.queryForObject(sql, params,(rs,rowNum)-> {
			Order o = new Order();
			o.setId(rs.getInt("id"));
			o.setCustomerId(rs.getInt("custId"));
			o.setBookName(rs.getString("name"));
			o.setQuantity(rs.getInt("quantity"));
			return o; 
			});
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return order;
	}
	
	
}
