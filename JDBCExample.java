//STEP 1. Import required packages
import java.sql.*;

public class JDBCExample {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/r1?serverTimezone=UTC";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Inserting records into the table...");
      stmt = conn.createStatement();
     
      String sql = "INSERT INTO emp " +
                   "VALUES (1, 'akhil', 200000, 12,13,12)";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO emp " +
                   "VALUES (2, 'rohith', 20000, 13,14,13)";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO emp " +
                   "VALUES (1, 'sharath', 2002000, 14,15,19)";
      stmt.executeUpdate(sql);
     
     
     
     
     
     
     
      sql = "INSERT INTO dep " +
                   "VALUES (10, 'cse', 22, 21)";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO dep " +
                   "VALUES (11, 'ece', 22, 23)";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO dep " +
                   "VALUES (12, 'mech', 22, 25)";
      stmt.executeUpdate(sql);
     
     
     
     
     
     
     
     
     
     
      sql = "INSERT INTO depart " +
                   "VALUES (12, 'cse', 'Kurnool')";
      stmt.executeUpdate(sql);
     
     
       sql = "INSERT INTO depart " +
                   "VALUES (13, 'ece', 'hyderabad')";
      stmt.executeUpdate(sql);
       sql = "INSERT INTO depart " +
                   "VALUES (14, 'cse', 'Khamam')";
      stmt.executeUpdate(sql);

      
      System.out.println("Inserted records into the table...");

   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end JDBCExample



      