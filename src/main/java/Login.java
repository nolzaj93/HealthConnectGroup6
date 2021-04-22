
import java.awt.Toolkit;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.*;
import java.sql.Statement;
import java.sql.ResultSet;

public class Login extends javax.swing.JFrame {
  Connection conn=null;
  ResultSet rs=null;
  PreparedStatement pst=null;
  int curRow=0;
  public String username;
  private String password;

  /**
   * Creates new form Login
   */
  public Login() {
    initComponents();

    Toolkit toolkit = getToolkit();
    Dimension size = toolkit.getScreenSize();
    setLocation(size.width/2 - getWidth()/2,
        size.height/2 - getHeight()/2);
  }

  public void setUsername(String username){
    this.username = this.txt_username.getText();
  }




  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    txt_username = new javax.swing.JTextField();
    jLabel2 = new javax.swing.JLabel();
    LoginAsPatient = new javax.swing.JButton();
    LoginAsDoctor = new javax.swing.JButton();
    jLabel3 = new javax.swing.JLabel();
    txt_password = new javax.swing.JPasswordField();
    jSeparator1 = new javax.swing.JSeparator();
    jLabel4 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jLabel1.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
    jLabel1.setText("Username");

    txt_username.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txt_usernameActionPerformed(evt);
      }
    });

    jLabel2.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
    jLabel2.setText("Password");

    LoginAsPatient.setText("Login as Patient");
    LoginAsPatient.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        LoginAsPatientActionPerformed(evt);
      }
    });

    LoginAsDoctor.setText("Login as Doctor");
    LoginAsDoctor.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        LoginAsDoctorActionPerformed(evt);
      }
    });

    jLabel3.setFont(new java.awt.Font("Eras Demi ITC", 2, 24)); // NOI18N
    jLabel3.setText("Login");

    txt_password.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txt_passwordActionPerformed(evt);
      }
    });

    jLabel4.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(51, 51, 255));
    jLabel4.setText("HealthConnect");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LoginAsPatient)
                                .addGap(18, 18, 18)
                                .addComponent(LoginAsDoctor))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_username)
                                    .addComponent(txt_password, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))))
                        .addContainerGap(84, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_password, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LoginAsDoctor)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addComponent(LoginAsPatient)))
    );

    pack();
  }// </editor-fold>

  public String LoginAsPatientActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:
    String sql ="select * from Patient where username=? and password=?";
    String ret;
    try{

      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection("jdbc:mysql://localhost/health", "root", "");
      //JOptionPane.showMessageDialog (null, "Connected");
      Statement statement = conn.createStatement();


      if(txt_username.getText().equals("sql error")) {sql = "";}
      pst=conn.prepareStatement(sql);
      pst.setString(1, txt_username.getText());
      pst.setString(2, txt_password.getText());
      setUsername(txt_username.getText());

      //JOptionPane.showMessageDialog (null, "Username = " + username);
      rs = pst.executeQuery();


      if(rs.next()){
        //JOptionPane.showMessageDialog(null, "Username and Password is correct");
        Profile s= new Profile(username);
        s.setVisible(true);
        dispose();
        ret = "valid";
      }
      else{
        JOptionPane.showMessageDialog(null, "Incorrect username or password.  Please try again.");
        ret = "invalid";
      }
    }

    catch(ClassNotFoundException | HeadlessException | SQLException e){
      JOptionPane.showMessageDialog(null, e);
      ret = "error";
    }

    return ret;
  }

  public String LoginAsDoctorActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:
    String sql ="select * from Doctor where username=? and password=?";
    String ret;
    try{

      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection("jdbc:mysql://localhost/health", "root", "");
      //JOptionPane.showMessageDialog (null, "Connected");
      Statement statement = conn.createStatement();


      if(txt_username.getText().equals("sql error")) {sql = "";}
      pst=conn.prepareStatement(sql);
      pst.setString(1, txt_username.getText());
      pst.setString(2, txt_password.getText());
      setUsername(txt_username.getText());

      rs = pst.executeQuery();
      if(rs.next()){
        //JOptionPane.showMessageDialog(null, "Username and Password is correct");
        DoctorView d= new DoctorView(username);
        d.setVisible(true);
        dispose();
        ret = "valid";
      }
      else{
        JOptionPane.showMessageDialog(null, "Incorrect username or password.  Please try again.");
        ret = "invalid";

      }
    }

    catch(ClassNotFoundException | HeadlessException | SQLException e){
      JOptionPane.showMessageDialog(null, e);
      ret = "error";
    }

    return ret;
  }

  private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:
  }

  private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
     */
//    try {
//      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//        if ("Nimbus".equals(info.getName())) {
//          javax.swing.UIManager.setLookAndFeel(info.getClassName());
//          break;
//        }
//      }
//    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
//      java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//    }
//    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        new Login().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify
  private javax.swing.JButton LoginAsDoctor;
  private javax.swing.JButton LoginAsPatient;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JSeparator jSeparator1;
  public javax.swing.JPasswordField txt_password;
  public javax.swing.JTextField txt_username;
  // End of variables declaration
}
