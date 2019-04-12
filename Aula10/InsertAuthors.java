import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class InsertAuthors
{
   // database URL
   static final String DATABASE_URL = "jdbc:mysql://localhost:3306/books?useTimezone=true&serverTimezone=UTC";

   // launch the application
   public static void main( String args[] )
   {
      Connection connection = null; // manages connection
      Statement statement = null; // query statement
      ResultSet resultSet = null; // manages results
      String author = "Andrew";
      String lastName = "Tannembaum";
      String query = "INSERT INTO authors ( firstName, lastName) VALUES ( ?, ?)";

      System.out.println("Connecting database...");
      try {
         connection = DriverManager.getConnection(
            DATABASE_URL, "root", "aluno" );

         PreparedStatement st = connection.prepareStatement(query);
          st.setString(1, author);
          st.setString(2, lastName);

          st.executeUpdate();
          st.close();
      }catch ( SQLException ex ) {
        // handle any errors
          System.out.println("SQLException: " + ex.getMessage());
          System.out.println("SQLState: " + ex.getSQLState());
          System.out.println("VendorError: " + ex.getErrorCode());
          ex.printStackTrace();
      } // end catch
      finally // ensure resultSet, statement and connection are closed
      {
         try
         {
            connection.close();
         } // end try
         catch ( Exception exception )
         {
            exception.printStackTrace();
         } // end catch
      } // end finally
   } // end main
} // end class DisplayAuthors
