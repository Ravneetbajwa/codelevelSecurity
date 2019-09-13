/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codelevelsecurity;

import codelevelsecurity.beans.UserBean;
import codelevelsecurity.services.LoginServices;
import codelevelsecurity.services.UserActivityServices;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 *
 * @author Taranpreet Kaur
 */
public class LoginFrame extends javax.swing.JFrame {
private int id;
    /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
        initComponents();
        setLocationRelativeTo(this);
        }
    
    
        private void LoginAction()
        {
            if(txtUsername.getText().trim().isEmpty())//to check if usernamed is empty
            {
                 JOptionPane.showMessageDialog(this,"Please Enter username","Title empty field",JOptionPane.WARNING_MESSAGE);
                  // this is used for current class,what to show in msg
            }
             else 
             if(String.valueOf(pwdPassword.getPassword()).isEmpty())
             {
                JOptionPane.showMessageDialog(this,"Please Enter Password","Title empty field",JOptionPane.WARNING_MESSAGE);
             }
             else
                 {
                    String un=txtUsername.getText().trim();
                    String pwd=String.valueOf(pwdPassword.getPassword());
                    LoginServices obj=new LoginServices();
                    UserBean objbean=obj.authenticateUser(un);//bean is passed to profile 
                     if(objbean!=null)
                        {
                           if(objbean.getPassword().equals(pwd))
                            {
                                if(objbean.isUserstatus())
                               {
                   
                                   int i = new UserActivityServices().insertLoginTime(objbean.getUserid());
                                    MainFrame mf=new MainFrame(i,objbean);//   bean is passed    
                                                  //object of main frame class
                                    mf.setVisible(true);//itshows the next page.
                                   this.dispose();//it closes the current page that is login pge
        
                                }
                                  else
                                    {
                                    JOptionPane.showMessageDialog(this,"ur account is locked","Title status",JOptionPane.INFORMATION_MESSAGE);
                                    }
                            }
                             else
                             {
                               JOptionPane.showMessageDialog(this,"username password mismatched","Title status",JOptionPane.INFORMATION_MESSAGE); 
                               pwdPassword.setText("");
                             }
              
                        }
                         else
                         {
                          JOptionPane.showMessageDialog(this,"username Password Mismatched","Title status",JOptionPane.INFORMATION_MESSAGE);
                         }
                 }
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        pwdPassword = new javax.swing.JPasswordField();
        lblPassword = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnForgotPassword = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Login"));

        lblUsername.setText("Username");

        lblPassword.setText("Password");

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnCancel.setText("Reset");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnForgotPassword.setText("Forgot Password");
        btnForgotPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForgotPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                        .addComponent(lblPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnLogin))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancel)
                        .addGap(18, 18, 18)
                        .addComponent(btnForgotPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
                    .addComponent(pwdPassword)
                    .addComponent(txtUsername))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pwdPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(lblPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin)
                    .addComponent(btnCancel)
                    .addComponent(btnForgotPassword))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
       LoginAction();
        /*if(txtUsername.getText().trim().isEmpty())
      {
          JOptionPane.showMessageDialog(this,"Please Enter username","Title empty field",JOptionPane.WARNING_MESSAGE);
          // this is used for current class,what bto show in msg
      }
      else if(String.valueOf(pwdPassword.getPassword()).isEmpty())
      {
          JOptionPane.showMessageDialog(this,"Please Enter Password","Title empty field",JOptionPane.WARNING_MESSAGE);
      }else
      {
          String un=txtUsername.getText().trim();
          String pwd=String.valueOf(pwdPassword.getPassword());
          LoginServices obj=new LoginServices();
         int UserBean=objbean.authenticateUser(un);
         if(objbean!=null)
         {
          if(objbean.getPassword().equals(pwd))
          {
              if(objbean.isUserStatus())
              {
                   MainFrame mf=new MainFrame();//object of main frame class
                     mf.setVisible(true);//itshows the next page.
                    this.dispose();//it closes the current page that is login pge
        
              }
              else
              {
                  JOptionPane.showMessageDialog(this,"ur account is locked","Title status",JOptionPane.INFORMATION_MESSAGE);
              }
          }
          else
          {
              JOptionPane.showMessageDialog(this,"username password mismatched","Title status",JOptionPane.INFORMATION_MESSAGE); 
              pwdPassword.setText("");
          }
              
         }
         else
         {
            JOptionPane.showMessageDialog(this,"username Password Mismatched","Title status",JOptionPane.INFORMATION_MESSAGE);
         }
      }*/

    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
    
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnForgotPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForgotPasswordActionPerformed
     LoginAction();
    }//GEN-LAST:event_btnForgotPasswordActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnForgotPassword;
    private javax.swing.JButton btnLogin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPasswordField pwdPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}