/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import java.io.FileOutputStream;
import java.util.Properties;
import javax.swing.JOptionPane;
import style.Stil;

/**
 *
 * @author stari
 */
public class ServerConfigForm extends javax.swing.JDialog {

 
    public ServerConfigForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);  
        initComponents();
        setTitle("Konfiguracija servera");
        setLocationRelativeTo(parent);
        setResizable(false);
        stilizuj();
        ucitajPodatke();
    }
    
    
    private void ucitajPodatke() {
        try {
            java.util.Properties p = new java.util.Properties();
            p.load(new java.io.FileInputStream("config/server.properties"));
            txtPort.setText(p.getProperty("port"));
        } catch (Exception ex) {
            txtPort.setText("9000");
        }
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPort = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnOtkazi = new javax.swing.JButton();
        btnSacuvaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Port:");

        btnOtkazi.setText("Otkaži");
        btnOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtkaziActionPerformed(evt);
            }
        });

        btnSacuvaj.setText("Sačuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOtkazi)
                        .addGap(18, 18, 18)
                        .addComponent(btnSacuvaj))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSacuvaj)
                    .addComponent(btnOtkazi))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtkaziActionPerformed
        dispose();
    }//GEN-LAST:event_btnOtkaziActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        try {
            if (txtPort.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Unesite broj porta!",  "Upozorenje", JOptionPane.WARNING_MESSAGE);
                return;
            }
            int port = Integer.parseInt(txtPort.getText().trim());
            if (port < 1024 || port > 65535) {
                JOptionPane.showMessageDialog(this,"Port mora biti između 1024 i 65535!","Upozorenje", JOptionPane.WARNING_MESSAGE);
                return;
            }
            Properties p = new Properties();
            p.setProperty("port", txtPort.getText().trim());
            p.store(new FileOutputStream("config/server.properties"), null);
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio konfiguraciju servera.", "Info", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Port mora biti ceo broj!", "Greška",JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Sistem ne može da zapamti konfiguraciju: " + ex.getMessage(),"Greška", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSacuvajActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOtkazi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtPort;
    // End of variables declaration//GEN-END:variables

    private void stilizuj() {
        Stil.pozadina(getContentPane());
        Stil.plavo(btnSacuvaj);
        Stil.crveno(btnOtkazi);
        Stil.labela(jLabel1); 
        Stil.polje(txtPort);
    }
}
