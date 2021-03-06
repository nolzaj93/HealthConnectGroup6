
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public final class DoctorView extends javax.swing.JFrame {
  Connection conn = null;
  ResultSet rs = null;
  PreparedStatement pst = null;
  int curRow = 0;
  String username, userType;
  DefaultListModel model = new DefaultListModel();
  int index;
  int requestID;
  int pane;
  Login login;

  /**
   * Creates new form DoctorView
   *
   * @param doctor The username of the doctor who is logged in
   */
  public DoctorView(String doctor) {
    initComponents();
    try {
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection("jdbc:mysql://localhost/health", "root", "");
      //JOptionPane.showMessageDialog (null, "Connected");
      Statement statement = conn.createStatement();
    } catch (ClassNotFoundException | SQLException e) {
      JOptionPane.showMessageDialog(null, e);
    }
    setUsername(doctor);
    setUserType("Doctor");
    welcome.setText("Welcome Back, " + username + "!");
    requestsList.setVisible(false);
  }

  /**
   * Getter for the username field
   * @return The username
   */
  public String getUsername() {
    return this.username;
  }

    /**
     * Sets the username field
     * @param username Value to set the username field to
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter for the requestID field
     * @return The requestID
     */
    public int getRequestID() {
        return this.requestID;
    }

    /**
     * Sets the requestID field
     * @param requestID Value to set the requestID field to
     */
    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    /**
     * Getter for the userType field
     * @return The userType
     */
    public String getUserType() {
        return this.userType;
    }

    /**
     * Sets the userType field
     * @param userType Value to set the userType field to
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        requestsList = new javax.swing.JList();
        viewedRequests = new javax.swing.JLabel();
        welcome = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        newRequestButton = new javax.swing.JButton();
        inProgressButton = new javax.swing.JButton();
        closeRequestButton = new javax.swing.JButton();
        openSelectedButton = new javax.swing.JButton();
        logout = new javax.swing.JButton();

        jLabel5.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 255));
        jLabel5.setText("HealthConnect");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        requestsList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

            public int getSize() {
                return strings.length;
            }

            public Object getElementAt(int i) {
                return strings[i];
            }
        });
        requestsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                requestsListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(requestsList);

        viewedRequests.setFont(new java.awt.Font("Eras Demi ITC", 2, 18)); // NOI18N
        viewedRequests.setText("Requests");

        welcome.setFont(new java.awt.Font("Eras Demi ITC", 2, 24)); // NOI18N
        welcome.setText("Welcome Back");

        jLabel6.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 255));
        jLabel6.setText("HealthConnect");

        newRequestButton.setText("New");
        newRequestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newRequestButtonActionPerformed(evt);
            }
        });

        inProgressButton.setText("In Progress");
        inProgressButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inProgressButtonActionPerformed(evt);
            }
        });

        closeRequestButton.setText("Closed");
        closeRequestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeRequestButtonActionPerformed(evt);
            }
        });

        openSelectedButton.setText("Open Selected Request");
        openSelectedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openSelectedButtonActionPerformed(evt);
            }
        });

        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jSeparator1)
                                                .addContainerGap())
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(viewedRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(39, 39, 39)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(closeRequestButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(inProgressButton, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                                                        .addComponent(newRequestButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                .addGap(0, 34, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(1, 1, 1))))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(201, 201, 201)
                                .addComponent(openSelectedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(289, 658, Short.MAX_VALUE)
                                .addComponent(logout)
                                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(welcome))
                                        .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(logout)
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(viewedRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(newRequestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(79, 79, 79)
                                                .addComponent(inProgressButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(74, 74, 74)
                                                .addComponent(closeRequestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(openSelectedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    /**
     * The method that runs when the new requests button is clicked, it shows only the new requests.
     * @param evt The ActionEvent created by the user clicking the button
     */
    void newRequestButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            viewedRequests.setText("New Requests");
            requestsList.setVisible(true);
            String element;
            String sql = "select * from Request where Status=?";
            model.removeAllElements();
            element = "RID        Date                                        Patient Username";
            model.addElement(element);


            pst = conn.prepareStatement(sql);
            pst.setString(1, "New");
            rs = pst.executeQuery();
            getNewRequests(rs.next());

            rs.close();
            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * This method populates the model with the new requests from the database and returns a value specifying if there
     *      any new requests.
     * @param newRequests Parameter that specifies if there are any new requests
     * @return A string describing if there are any new requests
     */
    String getNewRequests(boolean newRequests) {
        if (newRequests) {
            try {
                //JOptionPane.showMessageDialog(null, "Username and Password is correct");
                String element = rs.getString("RID") + "        " + rs.getString("Date") + "           " + rs.getString("PUsername");
                model.addElement(element);
                while(rs.next()) {
                    element = rs.getString("RID") + "        " + rs.getString("Date") + "           " + rs.getString("PUsername");
                    model.addElement(element);
                }
                requestsList.setModel(model);
            } catch (Exception ignored) {

            }
        } else {
            JOptionPane.showMessageDialog(null, "No new requests created.");
        }
        return "has new requests " + newRequests;
    }


    /**
     * The method that runs when the in progress button is clicked, it shows only the in progress requests.
     * @param evt The ActionEvent created by the user clicking the button
     */
    void inProgressButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        viewedRequests.setText("In Progress Requests");
        requestsList.setVisible(true);
        String element;
        String sql = "select distinct Request.RID, Date, PUsername from Request, Message where Request.RID = Message.RID and Request.Status=? and Message.DUsername=?";
        model.removeAllElements();
        element = "RID        Date                                        Patient Username";
        model.addElement(element);
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, "In Progress");
            pst.setString(2, username);
            rs = pst.executeQuery();
            inProgress(rs.next());
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    /**
     * This method populates the model with the in progress requests from the database and returns a value specifying
     *      if there any in progress requests.
     * @param newRequests Parameter that specifies if there are any in progress requests
     * @return A string describing if there are any in progress requests
     */
    String inProgress(boolean newRequests) {
        String element;
        try {
            if (newRequests) {
                try {
                    //JOptionPane.showMessageDialog(null, "Username and Password is correct");
                    element = rs.getString("RID") + "        " + rs.getString("Date") + "           " + rs.getString("PUsername");
                    model.addElement(element);
                    while (rs.next()) {
                        element = rs.getString("RID") + "        " + rs.getString("Date") + "           " + rs.getString("PUsername");
                        model.addElement(element);
                    }
                    requestsList.setModel(model);
                } catch (Exception ignored) {
                    JOptionPane.showMessageDialog(null, "No requests are in progress");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No requests are in progress");
            }
        } catch (Exception ignored) {

        }
        return "has in progress requests " + newRequests;
    }

    /**
     * The method that runs when the open request button is clicked, it shows the request on the screen.
     * @param evt The ActionEvent created by the user clicking the button
     */
    void openSelectedButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        openRequest(requestsList.getSelectedIndex());
    }

    /**
     * This method opens the selected request and displays it on the screen and returns a value indicating if the
     *      selected index was valid.
     * @param index Parameter that specifies the index of the request that is selected
     * @return A string describing if the index is valid
     */
    String openRequest(int index) {
        boolean validIndex = index != -1;
        try {
            if (validIndex) {
                String temp_requestID = requestsList.getSelectedValue().toString();
                temp_requestID = temp_requestID.substring(0, 3);
                requestID = Integer.parseInt(temp_requestID);
                setRequestID(requestID);
//      try{
//        rs.close();
//        pst.close();
//      }
//      catch(SQLException e){
//        JOptionPane.showMessageDialog(null, e);
//      }
                RequestConversation r = new RequestConversation(requestID, username, userType);
                dispose();
                r.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Please select a request");
            }
        } catch (Exception ignored) {

        }

        return "valid index: " + validIndex;
    }

    /**
     * The method that runs when the close request button is clicked, it shows the request on the screen.
     * @param evt The ActionEvent created by the user clicking the button
     */
    void closeRequestButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        viewedRequests.setText("Closed Requests");
        requestsList.setVisible(true);
        String element;
        String sql = "select Distinct Request.RID, Date, PUsername from Request, Message where Request.RID = Message.RID and Request.Status=? and Message.DUsername=?";
        model.removeAllElements();
        element = "RID        Date                                        Patient Username";
        model.addElement(element);
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, "Closed");
            pst.setString(2, username);
            rs = pst.executeQuery();
            closeRequest(rs.next());
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    /**
     * This method populates the model with the closed requests from the database and returns a value specifying
     *      if there any closed requests.
     * @param moreRequests Parameter that specifies if there are any closed requests
     * @return A string describing if there are any closed requests
     */
    String closeRequest(boolean moreRequests) {
        try {
            if (moreRequests) {
                //JOptionPane.showMessageDialog(null, "Username and Password is correct");
                String element = rs.getString("RID") + "        " + rs.getString("Date") + "           " + rs.getString("PUsername");
                model.addElement(element);
                while (rs.next()) {
                    element = rs.getString("RID") + "        " + rs.getString("Date") + "           " + rs.getString("PUsername");
                    model.addElement(element);
                }
                requestsList.setModel(model);
            } else {
                JOptionPane.showMessageDialog(null, "No requests have been closed.");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No requests have been closed.");
        }
        return "request closed: " + moreRequests;
    }

    /**
     * The method that runs when an item is selected in the list of requests and sets the index field to the value of
     *      the index of the request that was selected.
     * @param evt The ActionEvent created by the user clicking the button
     */
    void requestsListValueChanged(javax.swing.event.ListSelectionEvent evt) {
        // TODO add your handling code here:
        if (requestsList.getSelectedIndex() == -1) {
            //Nothing was selected.  Do nothing
        } else
            index = requestsList.getSelectedIndex();
    }

    /**
     * The method that runs when the logout button is clicked, it shows a dialog asking if the user is sure and if
     *      the 'yes' option is selected the user is taken to the login screen.
     * @param evt The ActionEvent created by the user clicking the button
     */
    void logoutActionPerformed(java.awt.event.ActionEvent evt) {
//    // TODO add your handling code here:
//    try{
//      rs.close();
//      pst.close();
//    }
//    catch(SQLException e){
//      JOptionPane.showMessageDialog(null, e);
//    }
        pane = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
        if (pane == 0) {
            dispose();
            login = new Login();
            login.setVisible(true);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */

        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }

        //</editor-fold>
        final Login s = new Login();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DoctorView(s.username).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton closeRequestButton;
    private javax.swing.JButton inProgressButton;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton logout;
    private javax.swing.JButton newRequestButton;
    private javax.swing.JButton openSelectedButton;
    javax.swing.JList requestsList;
    javax.swing.JLabel viewedRequests;
    private javax.swing.JLabel welcome;
    // End of variables declaration
}
