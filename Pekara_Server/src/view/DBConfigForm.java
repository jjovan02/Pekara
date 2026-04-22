/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import java.util.Properties;
import javax.swing.JOptionPane;
import style.Stil;

/**
 *
 * @author stari
 */
public class DBConfigForm extends javax.swing.JDialog {

    public DBConfigForm(java.awt.Frame parent, boolean modal) {
       super(parent, modal);
       initComponents();
       setTitle("Konfiguracija baze podataka");
       setLocationRelativeTo(parent);
       setResizable(false);
       stilizuj();
        
       ucitajPodatke();
   }
    
    private void ucitajPodatke() {
        try {
            java.util.Properties p = new java.util.Properties();
            p.load(new java.io.FileInputStream("config/dbconfig.properties"));
            txtUrl.setText(p.getProperty("url"));
            txtUsername.setText(p.getProperty("username"));
            txtPassword.setText(p.getProperty("password"));
        } catch (Exception ex) {
            txtUrl.setText("jdbc:mysql://localhost:3306/pekara?useSSL=false&serverTimezone=UTC");
            txtUsername.setText("root");
            txtPassword.setText("");
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUrl = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnSacuvaj = new javax.swing.JButton();
        btnOtkazi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("URL:");

        jLabel2.setText("Korisničko ime:");

        jLabel3.setText("Lozinka: ");

        btnSacuvaj.setText("Sačuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        btnOtkazi.setText("Otkaži");
        btnOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtkaziActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOtkazi)
                        .addGap(18, 18, 18)
                        .addComponent(btnSacuvaj))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSacuvaj)
                    .addComponent(btnOtkazi))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtkaziActionPerformed
        dispose();
    }//GEN-LAST:event_btnOtkaziActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        try {
            Properties p = new Properties();
            p.setProperty("url", txtUrl.getText().trim());
            p.setProperty("username", txtUsername.getText().trim());
            p.setProperty("password", txtPassword.getText().trim());
            p.store(new java.io.FileOutputStream("config/dbconfig.properties"), null);
            JOptionPane.showMessageDialog(this,"Sistem je zapamtio konfiguraciju baze podataka.","Info", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,  "Sistem ne može da zapamti konfiguraciju.", "Greška", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnSacuvajActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOtkazi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUrl;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    private void stilizuj() {

        Stil.pozadina(getContentPane());
        Stil.plavo(btnSacuvaj);
        Stil.crveno(btnOtkazi);
        Stil.labela(jLabel1); 
        Stil.labela(jLabel2); 
        Stil.labela(jLabel3); 
        Stil.polje(txtUrl);
        Stil.polje(txtUsername);
        Stil.polje(txtPassword);

    }

}
