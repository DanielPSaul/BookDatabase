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
import dbHelpers.StarHelper;
/**
 * @author danielsaul
 *
 */
@WebServlet("/star")
public class StarFilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StarFilterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookRating = Integer.parseInt(request.getParameter("bookRating"));
		
		
		StarHelper bdb = new StarHelper();
		ResultSet selectResults = bdb.doReadStar(bookRating);
		String selectTable = bdb.getSelectTable(selectResults);
		request.setAttribute("table", selectTable);
		request.setAttribute("rating", bookRating);
		
		//dispatcher
		String url = "/readNewStarFilter.jsp";	
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}