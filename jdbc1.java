import java.sql.*;

public class jdbc1 {

    static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static String DB_URL = "jdbc:mysql://127.0.0.1:3306/rohith";

    static String USER = "root";
    static String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");
            stmt = conn.createStatement();                  
            String sql = "CREATE TABLE REGISTRATION " +
                               "(id INTEGER not NULL, " +
                               " first VARCHAR(255), " +
                               " last VARCHAR(255), " +
                               " age INTEGER, " +
                               " PRIMARY KEY ( id ))";
           
                  stmt.executeUpdate(sql);
            String emp = "create table emp" +
                        "(eno int," +
                        "ename varchar(10)," +
                        "eage int," +
                        "esalary int,"+
                        "departno int," +
                        "supereno int,"+
                        "primary key(eno))";
            stmt.executeUpdate(emp);
            String dep = "create table dep" +
                        "(depno int," +
                         "depname varchar(10)," +
                          "depage int," +
                           "eno int,"+
                           "primary key(depno))";
           stmt.executeUpdate(dep);
            String depart = "create table depart(" +
                    "departno int," +
                    "departname varchar(10),"+
                    "location varchar(10)," +
                     "primary key(departno,departname,location))";
            stmt.executeUpdate(depart);

            System.out.println("Created table in given database...");

            System.out.println("Inserting values in given tables...");
//******************************
            String sql = "INSERT INTO emp " +
                   "VALUES ('follow tables sent by purnima mam')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Registration " +
                   "VALUES ('follow tables sent by purnima mam')";
            stmt.executeUpdate(sql);
 //*******************************
          //follow the same between **** till u insert 60 values or values sent by purnima 
           
            System.out.println("Values inserted in tables successfully...");

          } catch (Exception e){
            System.out.println(e);
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("DONE!");
    }
}
