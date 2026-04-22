/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import style.Stil;
import javax.swing.JOptionPane;
import model.Sertifikat;


public class AddSertifikatForm extends javax.swing.JDialog {

    private Sertifikat sertifikat;
    
    public AddSertifikatForm(java.awt.Frame parent, boolean modal, Sertifikat sertifikat) {
        super(parent, modal);
        this.sertifikat = sertifikat;
        initComponents();
        setLocationRelativeTo(parent);
        stilizuj();
        if (sertifikat != null) {
            setTitle("Promeni sertifikat");
            txtNaziv.setText(sertifikat.getNaziv());
            txtInstitucija.setText(sertifikat.getInstitucija());
        } else {
            setTitle("Dodaj sertifikat");
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtInstitucija = new javax.swing.JTextField();
        btnOtkazi = new javax.swing.JButton();
        btnSacuvaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Naziv:");

        jLabel2.setText("Institucija:");

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
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOtkazi)
                        .addGap(18, 18, 18)
                        .addComponent(btnSacuvaj))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtInstitucija, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNaziv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtInstitucija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSacuvaj)
                    .addComponent(btnOtkazi))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtkaziActionPerformed
        dispose();
    }//GEN-LAST:event_btnOtkaziActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        try {
            //throws new Exception("Test");
            validation.Validator.validateNotEmpty(txtNaziv.getText(), "Naziv");
            validation.Validator.validateNotEmpty(txtInstitucija.getText(), "Institucija");

            if (sertifikat == null) {
                Sertifikat s = new Sertifikat(
                    txtNaziv.getText().trim(),
                    txtInstitucija.getText().trim());
                ui.logic.UIController.getInstance().ubaciSertifikat(s);
            } else {
                sertifikat.setNaziv(txtNaziv.getText().trim());
                sertifikat.setInstitucija(txtInstitucija.getText().trim());
                ui.logic.UIController.getInstance().promeniSertifikat(sertifikat);
            }
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio sertifikat.");
            dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne može da zapamti sertifikat.", "Greška", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnSacuvajActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOtkazi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtInstitucija;
    private javax.swing.JTextField txtNaziv;
    // End of variables declaration//GEN-END:variables

    private void stilizuj() {
        Stil.plavo(btnSacuvaj);
        Stil.crveno(btnOtkazi);
        Stil.labela(jLabel1);
        Stil.labela(jLabel2);
        Stil.polje(txtNaziv);
        Stil.polje(txtInstitucija);
        Stil.pozadina(getContentPane());

    }
}
