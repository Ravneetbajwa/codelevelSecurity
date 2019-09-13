/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codelevelsecurity;

import codelevelsecurity.beans.ProgramAccessMasterBean;
import codelevelsecurity.jasperreport.JasperReportGenerator;
import codelevelsecurity.beans.ProgramMasterBean;
//import codelevelsecurity.beans.Userbean;
import codelevelsecurity.services.ProgramAccessedServices;
import codelevelsecurity.services.UserDetailServices;
import java.awt.Toolkit;
import java.io.InputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author win8
 */
public class ProgramAccessedReport extends javax.swing.JFrame {
JTable ProgramAccessedReport=null;
    /**
     * Creates new form ProgramAccessedReport
     */
    ArrayList al;
    ProgramAccessedServices aps;
    public ProgramAccessedReport() {
          setUndecorated(true);
        initComponents();
       // setUndecorated(true);
        aps=new ProgramAccessedServices();
        al=aps.accessedProgramsReport();
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.showTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblProgramaccessedreport = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miPrint = new javax.swing.JMenuItem();
        miExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));

        lblProgramaccessedreport.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblProgramaccessedreport.setText("    Program Accessed Report");

        jTable1.setBackground(new java.awt.Color(204, 204, 255));
        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Program id", "Viewer's id", "Programname", "Createdate", "Accessdate"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jMenu1.setText("File");

        miPrint.setText("Print");
        miPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPrintActionPerformed(evt);
            }
        });
        jMenu1.add(miPrint);

        miExit.setText("Exit");
        miExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miExitActionPerformed(evt);
            }
        });
        jMenu1.add(miExit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(238, 238, 238)
                .addComponent(lblProgramaccessedreport, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProgramaccessedreport, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    private void showTable() {
        String h[] = {"Program id", "Viewer's userid", "Program name", "Create date", "Access date"};
        String data[][] = new String[al.size()][h.length];
        System.out.println("array list "+al.size());
        for (int i = 0; i < al.size(); i++) {
            ProgramMasterBean objbean = (ProgramMasterBean) al.get(i);
            data[i][0] = String.valueOf(objbean.getProgramId());
            //data[i][1] = String.valueOf(objbean.getUserId());
            data[i][1]=  String.valueOf(objbean.getUserId());
            data[i][2] = objbean.getProgramName();
            data[i][3] = objbean.getCreateDate();
            data[i][4] = objbean.getAccessDate();
        }

        ProgramAccessedReport = new JTable(data, h);
        jScrollPane1.setViewportView(ProgramAccessedReport);
    }
    private void miExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miExitActionPerformed
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_miExitActionPerformed

    private void miPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPrintActionPerformed
       InputStream isr = getClass().getResourceAsStream("../codelevelsecurity/jasperreport/Programaccessreport.jrxml");
        JasperReportGenerator jrg = new JasperReportGenerator(isr);  
  // TODO add your handling code here:
    }//GEN-LAST:event_miPrintActionPerformed

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
            java.util.logging.Logger.getLogger(ProgramAccessedReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProgramAccessedReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProgramAccessedReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProgramAccessedReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProgramAccessedReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblProgramaccessedreport;
    private javax.swing.JMenuItem miExit;
    private javax.swing.JMenuItem miPrint;
    // End of variables declaration//GEN-END:variables
}