/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import style.Stil;
import javax.swing.JOptionPane;
import model.Pekar;

/**
 *
 * @author stari
 */
public class LoginForm extends javax.swing.JFrame {

    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
        initComponents();
        setTitle("Pekara - Prijava");
        setLocationRelativeTo(null);
        setResizable(false);
        stilizuj();
        
    }

   
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnExit = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(240, 240, 240));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(26, 58, 92));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Softverski sistem za praćenje rada pekare");

        jLabel2.setText("Korisnicko ime:");

        jLabel3.setText("Lozinka:");

        txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtUsername.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(26, 58, 92)));

        btnExit.setText("Izađi");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(26, 58, 92));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Prijavi se");
        btnLogin.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 15));
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.setFocusPainted(false);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnExit)
                        .addGap(18, 18, 18)
                        .addComponent(btnLogin))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsername)
                            .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit)
                    .addComponent(btnLogin))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String korisnickoIme = txtUsername.getText().trim();
        String lozinka = new String(txtPassword.getPassword()).trim();

        if (korisnickoIme.isEmpty() || lozinka.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Molimo unesite korisničko ime i lozinku!", "Upozorenje", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            Pekar pekar = ui.logic.UIController.getInstance().prijaviPekara(korisnickoIme, lozinka);

            JOptionPane.showMessageDialog(this,"Korisničko ime i šifra su ispravni.","Prijava", JOptionPane.INFORMATION_MESSAGE);

            try {
                //throw new Exception("test"); 
                MainForm mainForm = new MainForm(pekar);
                mainForm.setVisible(true);
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,"Ne može da se otvori glavna forma i meni.", "Greška", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception ex) {
            if (ex.getMessage() != null && ex.getMessage().contains("već ulogovan")) {
                JOptionPane.showMessageDialog(this,"Pekar je već ulogovan na sistemu!", "Greška pri prijavi", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Korisničko ime i šifra nisu ispravni.", "Greška pri prijavi", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    private void stilizuj() {
        Stil.plavo(btnLogin);
        Stil.crveno(btnExit);
        Stil.naslov(jLabel1);
        Stil.labela(jLabel2);
        Stil.labela(jLabel3);
        Stil.polje(txtUsername);
        Stil.lozinka(txtPassword);
    }
}
