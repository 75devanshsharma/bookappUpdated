package dao;
import java.util.List;

import dao.BooksDao;
import model.Books;

public class TestBooksDao {
	public static void main(String[] args) {
//		Books b = new Books();
//		b.setName("Erlang");
//		b.setPrice(550);
//		b.setStatus("Not Available");
//		System.out.println("Added");
		BooksDao dao= new BooksDao();
		List<Books> list = dao.list();
		System.out.println(list);
//		dao.insert(b);
//		Books b = dao.FindbyName("Python");
//		System.out.println(b);
//		b.setPrice(800);
//		dao.update(b);
	}

}
