/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class LoginDB {
    private static final String DRIVER ="com.mysql.jdbc.Driver";
    private String DBName;  // = "jdbc:odbc:MySQLFleet";
    private String USERID;
    private String PASSWORD;
      
    public LoginDB(String DBName, String USERID, String PASSWORD) {
        this.DBName = DBName;
        this.USERID = USERID;
        this.PASSWORD = PASSWORD;
    }
    
    public Connection getConnection() {
        Connection conn = null;
        try {
            String URL = "jdbc:mysql://localhost:3306/" + DBName;
            Class.forName(DRIVER); // Load ODBC driver
            conn = DriverManager.getConnection(URL, USERID, PASSWORD);
           
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println("ClassNotFound: " + ex.getMessage());
        } 
        return conn;
    }
    //Calculating the size of the resultset
    public int getSizeOfResultSet(ResultSet rs){
        int rowCount = 0;
        try{
            while(rs.next()){
               rowCount = rowCount + 1;
            }
            rs.first();
        }
        catch (SQLException ex){
             System.out.println(ex.getMessage());
             return rowCount;
        }
        System.out.println(rowCount);
        return rowCount;
        
    }
    public ResultSet getResultSet(Connection conn, String SQL) {
        Statement statement ;
        ResultSet rs = null;
        if (conn != null){
             try {
                statement = conn.createStatement();
                rs = statement.executeQuery(SQL);
            } catch (SQLException ex) {
                System.err.println("SQLException: " + ex.getMessage());
            }
        }
        else{
            System.err.println("Connection Object is NULL: Please First Create it using NEW");
        }
       return rs;
    }
        
    public boolean insertUpdateData(Connection conn, String SQL) {
        Statement statement ;
        try {
            statement = conn.createStatement();
            statement.executeUpdate(SQL);
            return true;
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            return false;
        }
    }
}
