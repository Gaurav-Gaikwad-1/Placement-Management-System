/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseConnectivity.AdminDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lenovo
 */
public class AdminInfo {
    static final String JDBC_driver="oracle.jdbc.driver.OracleDriver";
    static final String DB_URL="jdbc:oracle:thin:@localhost:1521:XE";
    static final String user="gaurav";
    static final String pass="gaurav";
    
    Connection con;
    Statement stmt;
    
    public AdminInfo() throws ClassNotFoundException, SQLException{
        Class.forName(JDBC_driver);
        con=null;stmt=null;
        con=DriverManager.getConnection(DB_URL,user,pass);
        stmt=con.createStatement();
    }
    public void insert(String name,String email,String phone) throws SQLException,ClassNotFoundException{
        stmt.execute("Insert into admin_info values('"+name+"','"+email+"','"+phone+"')");
        stmt.execute("commit");
    }
    
    public void update(String name,String website,String email,String phone,String desc) throws SQLException,ClassNotFoundException{
        stmt.executeQuery("update email,phone from admin_info where name='"+name+"'");
        stmt.execute("commit");
    }

    public void fetch() {
         try{
        stmt.executeQuery("select * from admin_info");
        }catch(SQLException e){
            System.out.println("record not found");
        }
    }
}
