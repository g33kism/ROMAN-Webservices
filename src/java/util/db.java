/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Gunraj
 */
import java.sql.*;
public class db {
    static java.util.Date d;
    static
    {
        d= new java.util.Date();
    }
    public static Connection connect()
    {
        try {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/roman", "root", "");
         }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
  
}
