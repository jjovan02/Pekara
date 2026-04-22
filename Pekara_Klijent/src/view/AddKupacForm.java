/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import java.util.ArrayList;
import style.Stil;
import javax.swing.JOptionPane;
import model.KategorijaKupca;
import model.Kupac;
import ui.logic.UIController;
import validation.Validator;

/**
 *
 * @author stari
 */
public class AddKupacForm extends javax.swing.JDialog {

    private Kupac kupac;

    public AddKupacForm(java.awt.Frame parent, boolean modal, Kupac kupac, boolean detaljiMod) {
        super(parent, modal);
        this.kupac = kupac;
        initComponents();
        setLocationRelativeTo(parent);
        stilizuj();
        ucitajKategorije();
        if (kupac != null) {
            txtIme.setText(kupac.getIme());
            txtPrezime.setText(kupac.getPrezime());
            txtEmail.setText(kupac.getEmail());
            if (kupac.getKategorijaKupca() != null) {
                cmbKategorija.setSelectedItem(kupac.getKategorijaKupca());
            }
        }

        if (detaljiMod) {
            setTitle("Detalji kupca");
            txtIme.setEditable(false);
            txtPrezime.setEditable(false);
            txtEmail.setEditable(false);
            cmbKategorija.setEnabled(false);
            btnSacuvaj.setVisible(false);
        } else {
            setTitle(kupac == null ? "Dodaj kupca" : "Promeni kupca");
        }
    }
    
    private void ucitajKategorije() {
    try {
        ArrayList<KategorijaKupca> lista =
            UIController.getInstance().vratiListuSviKategorijaKupca(new KategorijaKupca());
        for (KategorijaKupca kk : lista) {
            cmbKategorija.addItem(kk);
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this,"Sistem ne može da učita kategorije kupca.", "Greška", JOptionPane.ERROR_MESSAGE);
    }
    
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPrezime = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbKategorija = new javax.swing.JComboBox<>();
        btnSacuvaj = new javax.swing.JButton();
        btnOtkazi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Ime:");

        jLabel2.setText("Prezime:");

        txtPrezime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrezimeActionPerformed(evt);
            }
        });

        jLabel3.setText("Email:");

        jLabel4.setText("Kategorija:");

        btnSacuvaj.setText("Sacuvaj");
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
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                                        .addComponent(cmbKategorija, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txtPrezime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbKategorija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSacuvaj)
                    .addComponent(btnOtkazi))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrezimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrezimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrezimeActionPerformed

    private void btnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtkaziActionPerformed
        dispose();
    }//GEN-LAST:event_btnOtkaziActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        try {
            //throw new Exception("test"); 
            Validator.validateNotEmpty(txtIme.getText(), "Ime");
            Validator.validateNotEmpty(txtPrezime.getText(), "Prezime");
            Validator.validateEmail(txtEmail.getText());

            KategorijaKupca kk =(KategorijaKupca) cmbKategorija.getSelectedItem();
            if (kk == null) {
                JOptionPane.showMessageDialog(this,"Izaberite kategoriju kupca!", "Upozorenje", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (kupac == null) {
                Kupac k = new Kupac(txtIme.getText().trim(),txtPrezime.getText().trim(), txtEmail.getText().trim(),kk);
                UIController.getInstance().kreirajKupac(k);
            } else {
                kupac.setIme(txtIme.getText().trim());
                kupac.setPrezime(txtPrezime.getText().trim());
                kupac.setEmail(txtEmail.getText().trim());
                kupac.setKategorijaKupca(kk);
                UIController.getInstance().promeniKupac(kupac);
            }
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio kupca.");
            dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Sistem ne može da zapamti kupca.","Greška", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSacuvajActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOtkazi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox<KategorijaKupca> cmbKategorija;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtPrezime;
    // End of variables declaration//GEN-END:variables

    private void stilizuj() {
        Stil.plavo(btnSacuvaj);
        Stil.crveno(btnOtkazi);
        Stil.labela(jLabel1);
        Stil.labela(jLabel2);
        Stil.labela(jLabel3);
        Stil.labela(jLabel4);
        Stil.polje(txtIme);
        Stil.polje(txtPrezime);
        Stil.polje(txtEmail);
        Stil.kombo(cmbKategorija);
        Stil.pozadina(getContentPane());
    }
}
