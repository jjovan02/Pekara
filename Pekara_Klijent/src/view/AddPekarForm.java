/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import style.Stil;
import javax.swing.JOptionPane;
import model.Pekar;
import ui.logic.UIController;
import validation.Validator;


public class AddPekarForm extends javax.swing.JDialog {

    private Pekar pekar;

    public AddPekarForm(java.awt.Frame parent, boolean modal, Pekar pekar) {
        super(parent, modal);
        this.pekar = pekar;
        initComponents();
        setLocationRelativeTo(parent);
        stilizuj();
        if (pekar != null) {
            setTitle("Promeni pekara");
            txtIme.setText(pekar.getIme());
            txtPrezime.setText(pekar.getPrezime());
            txtKorisnickoIme.setText(pekar.getKorisnickoIme());
            txtTelefon.setText(pekar.getTelefon());
            txtLozinka.setText("");
        } else {
            setTitle("Dodaj pekara");
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPrezime = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtKorisnickoIme = new javax.swing.JTextField();
        txtLozinka = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTelefon = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnOtkazi = new javax.swing.JButton();
        btnSacuvaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Ime:");

        jLabel2.setText("Prezime:");

        jLabel3.setText("Korisničko ime:");

        jLabel4.setText("Lozinka:");

        jLabel5.setText("Telefon:");

        btnOtkazi.setText("Otkaži");
        btnOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtkaziActionPerformed(evt);
            }
        });

        btnSacuvaj.setText("Sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(228, Short.MAX_VALUE)
                        .addComponent(btnOtkazi)
                        .addGap(18, 18, 18)
                        .addComponent(btnSacuvaj))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKorisnickoIme, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLozinka, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtKorisnickoIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtLozinka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSacuvaj)
                    .addComponent(btnOtkazi))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtkaziActionPerformed
        dispose();
    }//GEN-LAST:event_btnOtkaziActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
    try {
        Validator.validateNotEmpty(txtIme.getText(), "Ime");
        Validator.validateNotEmpty(txtPrezime.getText(), "Prezime");
        Validator.validateNotEmpty(txtKorisnickoIme.getText(), "Korisničko ime");

        if (pekar == null) {
            Validator.validateNotEmpty(txtLozinka.getText(), "Lozinka");
            Pekar p = new Pekar(txtIme.getText().trim(),txtPrezime.getText().trim(),txtKorisnickoIme.getText().trim(), txtLozinka.getText().trim(),txtTelefon.getText().trim());
            UIController.getInstance().kreirajPekar(p);
        } else {
            pekar.setIme(txtIme.getText().trim());
            pekar.setPrezime(txtPrezime.getText().trim());
            pekar.setKorisnickoIme(txtKorisnickoIme.getText().trim());
            pekar.setTelefon(txtTelefon.getText().trim());
            if (!txtLozinka.getText().trim().isEmpty()) {
                pekar.setLozinka(txtLozinka.getText().trim());
            }
            UIController.getInstance().promeniPekar(pekar);
        }
        JOptionPane.showMessageDialog(this, "Sistem je zapamtio pekara.");
        dispose();

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this,"Sistem ne može da zapamti pekara: " + ex.getMessage(),"Greška", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_btnSacuvajActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOtkazi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtKorisnickoIme;
    private javax.swing.JTextField txtLozinka;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JTextField txtTelefon;
    // End of variables declaration//GEN-END:variables

    private void stilizuj() {
        Stil.plavo(btnSacuvaj);
        Stil.crveno(btnOtkazi);
        Stil.labela(jLabel1);
        Stil.labela(jLabel2);
        Stil.labela(jLabel3);
        Stil.labela(jLabel4);
        Stil.labela(jLabel5);
        Stil.polje(txtIme);
        Stil.polje(txtPrezime);
        Stil.polje(txtKorisnickoIme);
        Stil.polje(txtLozinka);
        Stil.polje(txtTelefon);
        Stil.pozadina(getContentPane());
    }
}
