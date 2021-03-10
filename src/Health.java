
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      // TODO code application logic here

      @SuppressWarnings("UnusedAssignment")
      //test connection
          Connection conn = null;
      try {
        Class.forName("com.mysql.jdbc.Driver");
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
        NewJFrame s= new NewJFrame();
        s.setVisible(true);
      }
      catch(ClassNotFoundException | SQLException e){
        JOptionPane.showMessageDialog(null, e);
      }
    }
  }


