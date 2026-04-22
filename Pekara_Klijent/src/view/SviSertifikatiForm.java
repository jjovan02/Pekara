/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.util.ArrayList;
import style.Stil;
import javax.swing.JOptionPane;
import model.Sertifikat;
import ui.logic.UIController;
import view.model.SertifikatTableModel;

/**
 *
 * @author stari
 */
public class SviSertifikatiForm extends javax.swing.JFrame {

    public SviSertifikatiForm() {
        initComponents();
        setTitle("Sertifikati");
        setLocationRelativeTo(null);
        ucitajSve();
        stilizuj();
    }
    
    private void ucitajSve() {
        try {
            ArrayList<Sertifikat> lista =UIController.getInstance().vratiListuSviSertifikat(new model.Sertifikat());
            tblSertifikati.setModel(new SertifikatTableModel(lista));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Sistem nije pronašao sertifikate.", "Info", JOptionPane.INFORMATION_MESSAGE);
            tblSertifikati.setModel(new SertifikatTableModel(new ArrayList<>()));
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnOsvezi = new javax.swing.JButton();
        btnPretrazi = new javax.swing.JButton();
        txtInstitucija = new javax.swing.JTextField();
        txtNaziv = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnObrisi = new javax.swing.JButton();
        btnPromeni = new javax.swing.JButton();
        btnDodaj = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSertifikati = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        btnOsvezi.setText("Osveži");
        btnOsvezi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOsveziActionPerformed(evt);
            }
        });

        btnPretrazi.setText("Pretraži");
        btnPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziActionPerformed(evt);
            }
        });

        txtInstitucija.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInstitucijaActionPerformed(evt);
            }
        });

        jLabel1.setText("Naziv:");

        jLabel2.setText("Institucija:");

        btnObrisi.setText("Obriši");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnPromeni.setText("Promeni");
        btnPromeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromeniActionPerformed(evt);
            }
        });

        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        tblSertifikati.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblSertifikati);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(17, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnObrisi)
                                .addGap(18, 18, 18)
                                .addComponent(btnPromeni)
                                .addGap(18, 18, 18)
                                .addComponent(btnDodaj))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtInstitucija, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnPretrazi)
                        .addGap(18, 18, 18)
                        .addComponent(btnOsvezi)))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPretrazi)
                    .addComponent(btnOsvezi)
                    .addComponent(txtInstitucija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodaj)
                    .addComponent(btnPromeni)
                    .addComponent(btnObrisi))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOsveziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOsveziActionPerformed
        ucitajSve();
    }//GEN-LAST:event_btnOsveziActionPerformed

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
        try {
            Sertifikat s = new Sertifikat();
            s.setNaziv(txtNaziv.getText());
            s.setInstitucija(txtInstitucija.getText());
            ArrayList<Sertifikat> lista =UIController.getInstance().vratiListuNekiSertifikat(s);
            tblSertifikati.setModel(new SertifikatTableModel(lista));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Sistem nije pronašao sertifikate po zadatim kriterijumima.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnPretraziActionPerformed

    private void txtInstitucijaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInstitucijaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInstitucijaActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        int row = tblSertifikati.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Izaberite sertifikat iz tabele!", "Upozorenje", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Sertifikat s = ((SertifikatTableModel)tblSertifikati.getModel()).getSertifikat(row);
        int potvrda = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da želite da obrišete sertifikat?", "Brisanje", JOptionPane.YES_NO_OPTION);
        if (potvrda == JOptionPane.YES_OPTION) {
            try {
                UIController.getInstance().obrisiSertifikat(s);
                JOptionPane.showMessageDialog(this, "Sistem je obrisao sertifikat.");
                ucitajSve();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Sistem ne može da obriše sertifikat.", "Greška", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnPromeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromeniActionPerformed
        int row = tblSertifikati.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Izaberite sertifikat iz tabele!","Upozorenje", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Sertifikat s = ((SertifikatTableModel)tblSertifikati.getModel()).getSertifikat(row);
        AddSertifikatForm f = new AddSertifikatForm(this, true, s);
        f.setVisible(true);
        ucitajSve();

    }//GEN-LAST:event_btnPromeniActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        AddSertifikatForm f = new AddSertifikatForm(this, true, null);
        f.setVisible(true);
        ucitajSve();
    }//GEN-LAST:event_btnDodajActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnOsvezi;
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JButton btnPromeni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSertifikati;
    private javax.swing.JTextField txtInstitucija;
    private javax.swing.JTextField txtNaziv;
    // End of variables declaration//GEN-END:variables

    private void stilizuj() {
        Stil.plavo(btnDodaj);
        Stil.plavo(btnPromeni);
        Stil.plavo(btnPretrazi);
        Stil.plavo(btnOsvezi);
        Stil.crveno(btnObrisi);
        Stil.labela(jLabel1);
        Stil.labela(jLabel2);
        Stil.polje(txtNaziv);
        Stil.polje(txtInstitucija);
        Stil.tabela(tblSertifikati);
        Stil.scrollPanel(jScrollPane1);
        Stil.pozadina(getContentPane());    
    }
}
