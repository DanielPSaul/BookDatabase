/**
 * 
 */
package dbHelpers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Book;
/**
 * @author danielsaul
 *
 */

//this new dbHelper is similar to BookdbHelper
public class NewDbHelper {
	private Connection connection;
	
	public NewDbHelper() {
		connection = MyDbConnection.getConnection();
	}
	
	
	public Book doReadOne(int bookId) {
		String query = "SELECT * FROM books WHERE bookID = ?";
		
		Book book = null;
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, bookId);
			ResultSet results = ps.executeQuery();
			
			results.next();
			
			
			book = new Book(
					results.getInt("bookID"),
					results.getString("title"),
					results.getString("author"),
					results.getInt("pages"),
					results.getInt("rating")
					);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return book;
	}
	
	
	public ResultSet doSelectAuthor(Book book){
	
		
		String query = "SELECT bookID, title, author, pages, rating FROM books WHERE author = ?"; // <-- Better
		
		ResultSet selectResults = null;
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			
			ps.setString(1, book.getAuthor());
			selectResults = ps.executeQuery();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block; add real error handling!
			e.printStackTrace();
		}
		
		return selectResults;
	}	
	
	public String getAuthorTable(ResultSet selectResults){
		String table ="";
		table += "<table>\n";

		try {
			
			table += "<tr>";
			table += "<td>";
			table += "Title";
			table += "</td>";
			table += "<td>";
			table += "Author";
			table += "</td>";
			table += "<td>";
			table += "Number of Pages";
			table += "</td>";
			table += "<td>";
			table += "Rating";
			table += "</td>";
			table += "<td colspan='2'>";
			table += "Modify";
			table += "</td>";
			table += "</tr>";
			
			
			while(selectResults.next()) {


				Book book = new Book(
						selectResults.getInt("bookID"),
						selectResults.getString("title"),
						selectResults.getString("author"),
						selectResults.getInt("pages"),
						selectResults.getInt("rating")
						);

				table +="<tr>";
				table +="\t<td>";
				table += book.getTitle();
				table +="</td>";
				table +="<td>";
				table += book.getAuthor();
				table +="</td>";
				table +="<td>";
				table += book.getPages();
				table +="</td>";
				table +="<td>";
				table += book.getRating();
				table +="</td>";
				table +="\n\t<td>";
				table += "<a class='update' href=update?bookID=" + book.getBookID() + " >Update</a>";
				table += "</td>";
				table += "<td>";
				table += "<form class='delete' action=\"delete\" method=\"post\">";
				table += "<input type=\"hidden\" name=\"bookID\" value=\"" + book.getBookID() + "\">";
				table += "<input class='delete' type=\"submit\" value=\"Delete\"></form>";
				table +="</td>\n";
				table +="</tr>\n";

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		table += "</table>";
		return table;
	}

}