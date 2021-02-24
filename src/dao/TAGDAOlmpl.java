package dao;


import java.util.ArrayList;
import java.util.List;
//import java.sql;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import examples.pubhub.dao.BookDAOImpl;
import examples.pubhub.model.Book;
import examples.pubhub.utilities.DAOUtilities;

public class TAGDAOlmpl extends Book implements Tag_Dao{
Connection connection = null;
PreparedStatement stmt = null;


	@Override
	public List<Tag>  getAlltags() {
	List<Tag> tags = new ArrayList<>();
	try {
		// TODO Auto-generated method stub
		connection = DAOUtilities.getConnection();
		String sql = "SELECT * FROM books INNER JOIN book_tags ON books.isbn_13 = book_tags.isbn_13 WHERE book_tags.isbn_13 IS NOT NULL";
		stmt = connection.prepareStatement(sql);	// Creates the prepared statement from the query
		
		ResultSet rs = stmt.executeQuery();		
		// So long as the ResultSet actually contains results...
		while (rs.next()) {
			// We need to populate a Book object with info for each row from our query result
			Tag tag = new Tag();
	
			// Each variable in our Book object maps to a column in a row from our results.
			tag.Setisbn_13(rs.getString("isbn_13"));
			tag.setTagNames(rs.getString("tags_name"));
			tag.setTitle(rs.getString("title"));
			tag.setTagNames(rs.getString("tags_name"));
			tag.setPublishDate(rs.getDate("publish_date").toLocalDate());
			tag.setPrice(rs.getDouble("price"));
			tag.setContent(rs.getBytes("content"));
		
			// The PDF file is tricky; file data is stored in the DB as a BLOB - Binary Large Object. It's
			// literally stored as 1's and 0's, so this one data type can hold any type of file.
			tag.setContent(rs.getBytes("content"));
			
			// Finally we add it to the list of Book objects returned by this query.
			tags.add(tag);

		}
		for (int i = 0; i < tags.size(); i++) {
			System.out.println((tags.get(i).getIsbn_13()));
			System.out.println(tags.get(i).getTitle());
			System.out.println(tags.get(i).getAuthor());
			System.out.println(tags.get(i).getTags_names());
			System.out.println(tags.get(i).getPublishDate());
			System.out.println(tags.get(i).getPrice());
			System.out.println(tags.get(i).getContent());
		
		}rs.close();
	
	
	} catch(Exception e) {
		e.printStackTrace();
	}
	finally {
		closeResources();
	}
	
return tags;

	}

	



	private void closeResources() {
		// TODO Auto-generated method stub
		try {
			if(stmt != null)
				stmt.close();
		}catch(SQLException e) {
			System.out.println("Connection error, connection could not be closed");
			e.printStackTrace();
		}
		try {
			if(connection !=null)
				connection.close();
		}catch (SQLException e) {
			System.out.println(" error has occured when closing connection");
		}
		
	}



	@Override
	public List<Tag> getAllTagsByisbn(String isbn_13) {
		// TODO Auto-generated method stub
		List<Tag> tags = new ArrayList<>();
		//return null;
	try {
		connection = DAOTagUtilities.getConnection();
		String sql = "SELECT isbn_13, tags_name FROM book_tags WHERE isbn_13 = ?";
		stmt = connection.prepareStatement(sql);
		stmt.setString(1, sql);
		//stmt.setString(1,  ISBN_13);
		ResultSet rs = stmt.executeQuery();	
		while(rs.next()) {
			Tag tag = new Tag();
			tag.Setisbn_13((rs.getString("isbn_13")));
			tag.setTagNames(rs.getString("tags_name"));
	}
		rs.close();
		
	
	
		
	}catch (SQLException e){
		e.printStackTrace();
	}finally {
		closeResources();
	}
	return tags;
	}





	@Override
	public boolean addtag(String isbn_13, String tags_name) {
		try {
		connection = DAOTagUtilities.getConnection();
		String sql = "INSERT INTO book_tags VALUES (?, ?)";
	    stmt = connection.prepareStatement(sql);
	    stmt.setString(1, isbn_13);
	    stmt.setString(2, tags_name);
	    if(stmt.executeUpdate() !=0)
	    	return true;
	    else
	    	return false;
	}catch(Exception e) {
		e.printStackTrace();
		return false;
		
	}finally {
		closeResources();
	}

}




	@Override
	public boolean deletetag(String isbn_13) {
		// TODO Auto-generated method stub
		try {
		connection = DAOTagUtilities.getConnection();
		String sql = "DELETE FROM book_tags WHERE isbn_13 = ?";
		 stmt = connection.prepareStatement(sql);
		 stmt.setString(1, isbn_13);
		 if(stmt.executeUpdate() != 0)
			 return true;
		 else 
			 return false;
		
	}catch (Exception e) {
		e.printStackTrace();
		return false;
	}finally {
		closeResources();
	}
	
}




	@Override
	public boolean updatetag(String isbn_13, String tags_name) {
		// TODO Auto-generated method stub
		try {
		connection = DAOTagUtilities.getConnection();
		String sql = "UPDATE book_tags SET tags_name = ? WHERE isbn_13 = ?";
		stmt = connection.prepareStatement(sql);
		stmt.setString(1, tags_name);
		stmt.setString(2, isbn_13);
		if(stmt.executeUpdate() != 0)
			return true;
		else 
			return false;
		
	}catch(Exception e) {
		e.printStackTrace();
		return false;
		
	}finally {
		closeResources();
		
	}
	
}
	public static void main(String[]args) {
		
		//---------ADD BOOK
//		BookDAOImpl bookDao = new BookDAOImpl();
//		Book book = new Book();
//		book.setIsbn13("3333333333333");
//		book.setTitle("title3333333");
//		book.setAuthor("author3333333");
//		book.setPublishDate(LocalDate.now());
//		book.setPrice(30.23);
//		bookDao.addBook(book);
////		
		TAGDAOlmpl tags = new TAGDAOlmpl();
		tags.getAlltags();
		tags.getAllTagsByisbn("2222222222222");
//		tags.addtag("1111111111111", "Drama");
//		tags.addtag("1111111111111", "ABC");
//		tags.addtag("2222222222222", "XYZ");
//		tags.addtag("3333333333333", "AAA");
		tags.addtag("3333333333333", "THREE");
//		tags.deletetag("3333333333333");
//		tags.updatetag("123456789012", "Mistery");
		tags.updatetag("3333333333333", "changed");
		tags.getAlltags();
		
		
	}

}	

