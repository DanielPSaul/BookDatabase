/**
 * 
 */
package controllers;

import java.io.IOException;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dbHelpers.NewDbHelper;
import model.Book;
/**
 * @author danielsaul
 *
 */
@WebServlet("/author")
public class SelectAuthor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectAuthor() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookID = Integer.parseInt(request.getParameter("bookID"));
		
		NewDbHelper bdb = new NewDbHelper();
		Book book = bdb.doReadOne(bookID);
		ResultSet selectAuthor = bdb.doSelectAuthor(book);
		String authorTable = bdb.getAuthorTable(selectAuthor);
		request.setAttribute("table", authorTable);
		String url = "/author.jsp";	
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
