package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class tagServelet
 */
@WebServlet("/tagServelet")
public class tagServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<tag> tags = new ArrayList<tag>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tagServelet() {
        super();
        tag t = new tag();
       t.setIsbn_13("4444444444444");
       t.setTags_name("Comedy");
       tags.add(t);
      
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setAttribute("tags",  tags);
		request.getRequestDispatcher("ViewTags.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		///doGet(request, response);
		String tags_name = request.getParameter("tags_name");
		String isbn_13 = request.getParameter("isbn_13");
		
		tag tag = new tag();
		tag.setIsbn_13(isbn_13);
		tag.setTags_name(tags_name);
		
		tags.add(tag);
		
		request.setAttribute("tags", tag);
		request.getRequestDispatcher("ViewTags.jsp").forward(request, response);
		
		
	}

}
