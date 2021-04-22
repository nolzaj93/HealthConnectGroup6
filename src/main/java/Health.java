
  /*
   * To change this license header, choose License Headers in Project Properties.
   * To change this template file, choose Tools | Templates
   * and open the template in the editor.
   */

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;


  public class Health {
    static Login login;
    static String sqlError;

    /**
     * The Main method that runs when the program is started
     * @param args the command line arguments
     */
    public static void main(String[] args) {

      @SuppressWarnings("UnusedAssignment")
      //test connection
          Connection conn = null;

      String sqlString = "com.mysql.jdbc.Driver";

      try {
        if (args != null) {
          sqlString = args[0];
        }

        Class.forName(sqlString);
        conn = DriverManager.getConnection("jdbc:mysql://localhost/health", "root", "");
        //JOptionPane.showMessageDialog (null, "Connected");
        Statement statement = conn.createStatement();
        ResultSet hc = statement.executeQuery("select * from Patient");

        while (hc.next()){
          System.out.println("Username = " + hc.getString("Username"));
          System.out.println("Password = " + hc.getString("Password"));
        }

        hc = statement.executeQuery("select * from Doctor");

        while (hc.next()){
          System.out.println("Username = " + hc.getString("Username"));
          System.out.println("Password = " + hc.getString("Password"));
        }
        //open login page
        login = new Login();
        login.setVisible(true);
      }
      catch(ClassNotFoundException | SQLException e){
        sqlError = e.toString();
        JOptionPane.showMessageDialog(null, e);
      }
    }
  }


