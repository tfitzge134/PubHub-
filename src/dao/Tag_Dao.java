package dao;
import java.util.*;
import examples.pubhub.dao.BookDAO;




public interface Tag_Dao {
	public List<Tag> getAlltags();
	public List<Tag> getAllTagsByisbn(String isbn_13);
	public boolean addtag(String isbn_13, String tags_name);
	public boolean deletetag(String isbn_13);
	public boolean updatetag(String isbn_13, String tags_name);
	//List<Tag> getAlltags();


}

//public List<Book> getAllBooks();
//public List<Book> getBooksByTitle(String title);
//public List<Book> getBooksByAuthor(String author);
//public List<Book> getBooksLessThanPrice(double price);
//public Book getBookByISBN(String isbn);
//
//public boolean addBook(Book book);
//public boolean updateBook(Book book);
//public boolean deleteBookByISBN(String isbn);