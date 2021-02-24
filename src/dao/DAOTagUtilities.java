package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import dao.Tag_Dao;
//import dao.TagDAOImpl;
//import examples.pubhub.dao.BookDAO;
//import examples.pubhub.dao.BookDAOImpl;

public class DAOTagUtilities {
	private static final String CONNECTION_USERNAME = "postgres";
	private static final String CONNECTION_PASSWORD = "Printer@2007";
	private static final String URL = "jdbc:postgresql://localhost:5432/PubHub";
	private static Connection connection;
	
	public static synchronized Connection getConnection() throws SQLException {
		if (connection == null) {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				try {
					System.out.println("Could not register driver! " 
					+ Class.forName("org.postgresql.Driver").toString());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
			connection = DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
		}
		
		//If connection was closed then retrieve a new connection
		if (connection.isClosed()){
			System.out.println("Opening new connection...");
			//connection = DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
			connection = null;
					getConnection();
		}
		return connection;
	}
	//public static Tag_Dao getTag_Dao(){
		//return new TagDAOImpl();
	//}
	//public static BookDAO getBookDAO() {
		//return new BookDAOImpl();
	//}

}
