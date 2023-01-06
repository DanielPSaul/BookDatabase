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
public class StarHelper {
	private Connection connection;
	
	public StarHelper() {
		connection = MyDbConnection.getConnection();
	}

	public ResultSet doReadStar(int bookRating){

			//added greater than sign and order by
		String query = "SELECT bookID, title, author, pages, rating FROM books WHERE rating >= ? ORDER BY rating"; 
		
		ResultSet selectResults = null;
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			
			ps.setInt(1, bookRating);
			selectResults = ps.executeQuery();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return selectResults;
	}	
	
	public String getSelectTable(ResultSet selectResults){
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
				table +="<a href=select?bookID=" + book.getBookID() + ">" + book.getAuthor();
				table +="</td>";
				table +="<td>";
				table += book.getPages();
				table +="</td>";
				table +="<td>";
				table += book.getRating();
				table +="</td>";
				table +="\n\t<td>";
				table += "<form class='update' action=\"update\" method=\"post\">";
				table += "<input type=\"hidden\" name=\"bookID\" value=\"" + book.getBookID() + "\">";
				table += "<input class='update' type=\"submit\" value=\"Update\"></form>";
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
