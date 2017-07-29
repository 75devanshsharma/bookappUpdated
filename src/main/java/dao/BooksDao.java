package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import model.Books;
import util.ConnectionUtil;

public class BooksDao {

	JdbcTemplate jdbctemplate = ConnectionUtil.getJdbcTemplate();
	
	public void insert(Books b)
	{
		String sql = " insert into book1 (name,price, status) values (?,?,?)";
		Object params[] = { b.getName(), b.getPrice(), b.getStatus()};
		int rows = jdbctemplate.update(sql, params);
		System.out.println("No. of rows inserted :" +rows);
}
	public void update(Books b)
	{
		String sql = " update book1 set price = ? where id = ?";
		Object params[] = { b.getPrice(), b.getId()};
		int rows = jdbctemplate.update(sql, params);
		System.out.println("No. of rows updated :" +rows);
	}
	
	public void delete(Books b)
	{
		String sql = " delete from book1 where id = ?";
		Object params[] = { b.getId()};
		int rows = jdbctemplate.update(sql, params);
		System.out.println("No. of rows delteted :" +rows);
	}
	
	public List<Books> list()
	{
		String sql = "select name,price,status from book1";
		List<Books> list = jdbctemplate.query(sql, (rs,rowNum)-> {
			Books bo = new Books();
			bo.setName(rs.getString("name"));
			bo.setPrice(rs.getInt("price"));
			bo.setStatus(rs.getString("status"));
			return bo;
		});
		return list;
	}

	public List<Books> FindbyName(String name)
	{
		String sql = "select id,name,price,status from book1 where name = ?";
		Object params[] = {name};
		List <Books> book = null;
		try {
			 book= jdbctemplate.query(sql, params,(rs,rowNum)-> {
				Books bo = new Books();
				bo.setId(rs.getInt("id"));
				bo.setName(rs.getString("name"));
				bo.setPrice(rs.getInt("price"));
				bo.setStatus(rs.getString("status"));
				return bo;
			});
		} catch (EmptyResultDataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}

	
}