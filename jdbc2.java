import java.sql.*;

public class jdbc2 {

    static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static String DB_URL = "jdbc:mysql://localhost/r1?serverTimezone=UTC";

    static final String USER = "root";
    static final String PASS = "";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            stmt = conn.createStatement();

            System.out.println("Running Query number (i)...\n");
            String query1 = "select departno,avg(depage) as avg_age from emp group by departno";

            ResultSet rs1 = stmt.executeQuery(query1);

            while (rs1.next()) {

                int departno = rs1.getInt("departno");
                int avg_age = rs1.getInt("avg_age");


                System.out.print("Department Number: " + departno + "\n");
                System.out.print("Average Age: " + avg_age + "\n\n");
            }

            rs1.close();

            System.out.println("Running Query number (ii)...\n");
            String query2 = "select D.departno, D.departname, D.location, min(X.salary_sum) as least_salary from( select D.departno, sum(E.salary) as salary_sum from depart as D left join emp as E on D.departno = E.departno group by (D.departno)) as X, depart as D where D.departno = X.departno;";

            ResultSet rs2 = stmt.executeQuery(query2);

            while (rs2.next()) {

                int departno = rs2.getInt("departno");
                String departname = rs2.getString("departname");
                String location = rs2.getString("location");
                int least_salary = rs2.getInt("least_salary");

                System.out.print("Department Number: " + departno + "\n");
                System.out.print("Department: " + departname + "\n");
                System.out.print("Location: " + location + "\n");
                System.out.print("Salary Sum: " + least_salary + "\n\n");
            }

            rs2.close();
        } catch (Exception e) {
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
        System.out.println("Done!");
    }
}