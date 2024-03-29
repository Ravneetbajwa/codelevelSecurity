/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codelevelsecurity;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import codelevelsecurity.beans.UserBean;
import codelevelsecurity.services.UserDetailServices;

/**
 *
 * @author Taranpreet Kaur
 */
public class ManageUsers extends javax.swing.JPanel {
private ArrayList<UserBean> al;
private UserDetailServices objmus;
private int count;
private int AddUpdateFlag=0;
    /**
     * Creates new form ManageUsers
     */
    public ManageUsers() {
        initComponents();
        objmus=new UserDetailServices();
        al=objmus.getAllRecords();
        if(al.size()==0)
        {
             JOptionPane.showMessageDialog(this,"no record found","Title empty field",JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            count=0;
            showRecord(count);
        }
    }
private void showRecord(int count)
{
    UserBean objbean=al.get(count);
    lblUserid1.setText(String.valueOf(objbean.getUserid()));
    txtUsername.setText(objbean.getUsername());
    pwdPassword.setText(objbean.getPassword());
    ddlUsertype.setSelectedItem(objbean.getUsertype());
    if(objbean.isUserstatus())
    {
        rbActive.setSelected(true);
    }
    else
    {
        rbInactive.setSelected(true);
    }
    txtName.setText(objbean.getName());
    txtcontact.setText(objbean.getContact());
    txtEmail.setText(objbean.getEmail());
    txtareaAddress.setText(objbean.getAddress());
    txtDOB.setText(objbean.getDOB());
    if(objbean.isGender())
    {
        rbMale.setSelected(true);
    }
    else
    {
        rbFemale.setSelected(true);
    }
  enableAll(false);
  if(count==0)
  {
      btnFirst.setEnabled(false);//my first and last
      btnPrevious.setEnabled(false);
      btnLast.setEnabled(true);
      //btnPrevious.setEnabled(true);
      btnNext.setEnabled(true);
  }
  if(count==al.size()-1)
  {
      btnLast.setEnabled(false);
      btnPrevious.setEnabled(true);
      btnFirst.setEnabled(true);
      btnNext.setEnabled(false);
  }
               // txtUserstatus.setText(objbean.getUserstatus());
}
private void enableAll(boolean flag)
{
   
    txtUsername.setEditable(flag);
    pwdPassword.setEditable(flag);
    txtName.setEditable(flag);
    txtcontact.setEditable(flag);
    txtEmail.setEditable(flag);
    txtareaAddress.setEditable(flag);
     txtDOB.setEditable(flag);
    rbActive.setEnabled(flag);
    rbInactive.setEnabled(flag);
    ddlUsertype.setEnabled(flag);
    rbMale.setEnabled(flag);
    rbFemale.setEnabled(flag); 
}
private void AfterSave()
{
    al=objmus.getAllRecords();
    if(AddUpdateFlag==1)
    {
        count=al.size()-1;
        showRecord(count);
    }
    else
    {
        showRecord(count);
    }
      btnSave.setEnabled(false);
        btnAdd.setEnabled(true);
          btnEdit.setEnabled(true);
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        jButton4 = new javax.swing.JButton();
        lblManageUsers = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblUserid = new javax.swing.JLabel();
        lblUserid1 = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        lblUsertype = new javax.swing.JLabel();
        ddlUsertype = new javax.swing.JComboBox();
        lblUserstatus = new javax.swing.JLabel();
        rbActive = new javax.swing.JRadioButton();
        rbInactive = new javax.swing.JRadioButton();
        pwdPassword = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtareaAddress = new javax.swing.JTextArea();
        lblcontact = new javax.swing.JLabel();
        txtcontact = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblGender = new javax.swing.JLabel();
        rbMale = new javax.swing.JRadioButton();
        rbFemale = new javax.swing.JRadioButton();
        lblDOB = new javax.swing.JLabel();
        txtDOB = new javax.swing.JTextField();
        btnFirst = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jButton4.setText("jButton4");

        lblManageUsers.setText("Manage Users");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Company info"));

        lblUserid.setText("UserId");

        lblUsername.setText("UserName");

        lblPassword.setText("Password");

        lblUsertype.setText("UserType");

        ddlUsertype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrator", "User" }));
        ddlUsertype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddlUsertypeActionPerformed(evt);
            }
        });

        lblUserstatus.setText("UserStatus");

        buttonGroup1.add(rbActive);
        rbActive.setText("Active");
        rbActive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbActiveActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbInactive);
        rbInactive.setText("Inactive");
        rbInactive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbInactiveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUserid)
                    .addComponent(lblUsername)
                    .addComponent(lblPassword)
                    .addComponent(lblUsertype)
                    .addComponent(lblUserstatus))
                .addGap(77, 77, 77)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rbActive)
                        .addGap(18, 18, 18)
                        .addComponent(rbInactive))
                    .addComponent(lblUserid1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUsername)
                    .addComponent(ddlUsertype, 0, 196, Short.MAX_VALUE)
                    .addComponent(pwdPassword)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblUserid1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUserid))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(pwdPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsertype)
                    .addComponent(ddlUsertype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserstatus)
                    .addComponent(rbActive)
                    .addComponent(rbInactive)))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Personal info"));

        lblName.setText("Name");

        lblAddress.setText("Address");

        txtareaAddress.setColumns(20);
        txtareaAddress.setRows(5);
        jScrollPane1.setViewportView(txtareaAddress);

        lblcontact.setText("Contact");

        txtcontact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontactActionPerformed(evt);
            }
        });

        lblEmail.setText("Email");

        lblGender.setText("Gender");

        buttonGroup2.add(rbMale);
        rbMale.setText("Male");
        rbMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMaleActionPerformed(evt);
            }
        });

        buttonGroup2.add(rbFemale);
        rbFemale.setText("Female");
        rbFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFemaleActionPerformed(evt);
            }
        });

        lblDOB.setText("DOB");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblName)
                    .addComponent(lblAddress)
                    .addComponent(lblcontact)
                    .addComponent(lblEmail)
                    .addComponent(lblGender)
                    .addComponent(lblDOB))
                .addGap(92, 92, 92)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbMale)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rbFemale))
                    .addComponent(txtName)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(txtEmail)
                    .addComponent(txtcontact)
                    .addComponent(txtDOB)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAddress)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcontact)
                    .addComponent(txtcontact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbMale)
                    .addComponent(lblGender)
                    .addComponent(rbFemale))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDOB)
                    .addComponent(txtDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnFirst.setText("First");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setText("Last");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(lblManageUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addComponent(btnCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAdd)
                            .addComponent(btnFirst))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPrevious)
                                .addGap(18, 18, 18)
                                .addComponent(btnNext)
                                .addGap(18, 18, 18)
                                .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSave)))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblManageUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFirst)
                            .addComponent(btnPrevious)
                            .addComponent(btnNext)
                            .addComponent(btnLast))
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEdit)
                            .addComponent(btnSave)
                            .addComponent(btnAdd))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(btnCancel)
                .addContainerGap(35, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rbActiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbActiveActionPerformed
       
    }//GEN-LAST:event_rbActiveActionPerformed

    private void rbFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbFemaleActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        btnFirst.setEnabled(false);
        btnPrevious.setEnabled(false);
        btnNext.setEnabled(false);
        btnLast.setEnabled(false);
        btnSave.setEnabled(true);
        btnEdit.setEnabled(true); 
        txtUsername.setEditable(true);
    pwdPassword.setEditable(true);
    txtName.setEditable(true);
    txtcontact.setEditable(true);
    txtEmail.setEditable(true);
    txtareaAddress.setEditable(true);
    rbActive.setEnabled(true);
    rbInactive.setEnabled(true);
    ddlUsertype.setEnabled(true);
    rbMale.setEnabled(true);
    rbFemale.setEnabled(true);
        AddUpdateFlag=0;
    }//GEN-LAST:event_btnEditActionPerformed

    private void ddlUsertypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddlUsertypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ddlUsertypeActionPerformed

    private void rbInactiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbInactiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbInactiveActionPerformed

    private void rbMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbMaleActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
         count=0;
          
              showRecord(count);
          
              // TODO add your handling code here:
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
      count--;
           showRecord(count);
       
                     // TODO add your handling code here:
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
   count++;

    showRecord(count);

                     // TODO add your handling code here:
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
     count=al.size()-1;
        
            showRecord(count);
            AfterSave();
        
                      // TODO add your handling code here:
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
           enableAll(true);
           txtUsername.setText("");
           txtDOB.setText("");
           pwdPassword.setText("");
           txtName.setText("");
           txtareaAddress.setText("");
           txtEmail.setText("");
           txtcontact.setText("");
           btnFirst.setEnabled(false);
           btnPrevious.setEnabled(false);
           btnSave.setEnabled(true);
           btnNext.setEnabled(false);
           btnLast.setEnabled(false);
           btnEdit.setEnabled(false);
           lblUserid1.setText(""+(objmus.getMaxID()));
           AddUpdateFlag=1;
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if(txtUsername.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Enter username","Title empty field",JOptionPane.INFORMATION_MESSAGE);
    
        }
      
    else
{
UserBean objbean=new UserBean();
objbean.setUserid(Integer.parseInt(lblUserid1.getText()));
objbean.setUsername(txtUsername.getText());
//objbean.setUsertype(String.valueOf(ddlUsertype.getSelectedItem()));
objbean.setPassword(pwdPassword.getText());
objbean.setName((txtName.getText()));
objbean.setContact(txtcontact.getText());
objbean.setAddress(txtareaAddress.getText());
objbean.setEmail(txtEmail.getText());
objbean.setDOB(txtDOB.getText());
        if(AddUpdateFlag==1)
        {
            if(objmus.AddRecord(objbean))
            {
                 JOptionPane.showMessageDialog(this," record inserted","Title empty field",JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                 JOptionPane.showMessageDialog(this,"record not inserted","Title empty field",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else
        {
         if(objmus.UpdateById(objbean))
            {
                 JOptionPane.showMessageDialog(this," record updated","Title empty field",JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                 JOptionPane.showMessageDialog(this,"record not updated","Title empty field",JOptionPane.INFORMATION_MESSAGE);
            }   
        }
}
        AfterSave();
        btnNext.setEnabled(true);
        btnLast.setEnabled(true);
//btnLast.setEnabled(true);
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
if(AddUpdateFlag==0)
{
    MainFrame.c.removeAll();
    MainFrame.c.setVisible(false);
}
else if(AddUpdateFlag==1)
{
    count=al.size()-1;
    showRecord(count);
}
else
{
    showRecord(count);
}
AddUpdateFlag=0;

    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtcontactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontactActionPerformed
     // txtcontact.setText(Integer.parseInt());
    }//GEN-LAST:event_txtcontactActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JComboBox ddlUsertype;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblDOB;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblManageUsers;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUserid;
    private javax.swing.JLabel lblUserid1;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblUserstatus;
    private javax.swing.JLabel lblUsertype;
    private javax.swing.JLabel lblcontact;
    private javax.swing.JPasswordField pwdPassword;
    private javax.swing.JRadioButton rbActive;
    private javax.swing.JRadioButton rbFemale;
    private javax.swing.JRadioButton rbInactive;
    private javax.swing.JRadioButton rbMale;
    private javax.swing.JTextField txtDOB;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextArea txtareaAddress;
    private javax.swing.JTextField txtcontact;
    // End of variables declaration//GEN-END:variables
}
