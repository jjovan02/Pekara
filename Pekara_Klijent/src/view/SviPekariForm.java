/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.util.ArrayList;
import style.Stil;
import javax.swing.JOptionPane;
import model.Pekar;
import ui.logic.UIController;
import view.model.PekarTableModel;

/**
 *
 * @author stari
 */
public class SviPekariForm extends javax.swing.JFrame {

    public SviPekariForm() {
        initComponents();
        setTitle("Pekari");
        setLocationRelativeTo(null);
        ucitajSve();
        stilizuj();
    }
    
    private void ucitajSve() {
        try {
            ArrayList<model.Pekar> lista =UIController.getInstance().vratiListuSviPekar(new model.Pekar());
            tblPekari.setModel(new PekarTableModel(lista));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Sistem nije pronašao pekare.","Info", JOptionPane.INFORMATION_MESSAGE);
            tblPekari.setModel(new PekarTableModel(new ArrayList<>()));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtIme = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPrezime = new javax.swing.JTextField();
        btnPretrazi = new javax.swing.JButton();
        btnOsvezi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPekari = new javax.swing.JTable();
        btnObrisi = new javax.swing.JButton();
        btnPromeni = new javax.swing.JButton();
        btnDodaj = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtKorisnickoIme = new javax.swing.JTextField();
        txtTelefon = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Ime:");

        jLabel2.setText("Prezime:");

        txtPrezime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrezimeActionPerformed(evt);
            }
        });

        btnPretrazi.setText("Pretraži");
        btnPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziActionPerformed(evt);
            }
        });

        btnOsvezi.setText("Osveži");
        btnOsvezi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOsveziActionPerformed(evt);
            }
        });

        tblPekari.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPekari);

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

        jLabel3.setText("Korisničko ime:");

        jLabel4.setText("Telefon:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(67, 67, 67)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtKorisnickoIme, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                                .addComponent(txtTelefon)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(579, 579, 579)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnObrisi)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnPromeni)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnDodaj))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnPretrazi)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnOsvezi)))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(txtKorisnickoIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOsvezi)
                    .addComponent(btnPretrazi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnObrisi)
                    .addComponent(btnPromeni)
                    .addComponent(btnDodaj))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrezimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrezimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrezimeActionPerformed

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
        try {
            Pekar p = new Pekar();
            p.setIme(txtIme.getText());
            p.setPrezime(txtPrezime.getText());
            p.setKorisnickoIme(txtKorisnickoIme.getText());
            p.setTelefon(txtTelefon.getText());
            ArrayList<Pekar> lista =UIController.getInstance().vratiListuNekiPekar(p);
            tblPekari.setModel(new PekarTableModel(lista));
            JOptionPane.showMessageDialog(this,"Sistem je našao pekare po zadatim kriterijumima.","Pretraga", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Sistem ne može da nađe pekare po zadatim kriterijumima.", "Info", JOptionPane.INFORMATION_MESSAGE);
            tblPekari.setModel(new PekarTableModel(new ArrayList<>()));
        }
    }//GEN-LAST:event_btnPretraziActionPerformed

    private void btnOsveziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOsveziActionPerformed
        ucitajSve();
    }//GEN-LAST:event_btnOsveziActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        int row = tblPekari.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Izaberite pekara iz tabele!", "Upozorenje", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Pekar p = ((PekarTableModel) tblPekari.getModel()).getPekar(row);
        int potvrda = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da želite da obrišete pekara?", "Brisanje", JOptionPane.YES_NO_OPTION);
        if (potvrda == JOptionPane.YES_OPTION) {
            try {
                ui.logic.UIController.getInstance().obrisiPekar(p);
                JOptionPane.showMessageDialog(this,"Sistem je obrisao pekara.");
                ucitajSve();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,"Sistem ne može da obriše pekara.",  "Greška", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnPromeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromeniActionPerformed
        int row = tblPekari.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Izaberite pekara iz tabele!","Upozorenje", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Pekar p = ((PekarTableModel)tblPekari.getModel()).getPekar(row);
        AddPekarForm f = new AddPekarForm(this, true, p);
        f.setVisible(true);
        ucitajSve();

    }//GEN-LAST:event_btnPromeniActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        AddPekarForm f = new AddPekarForm(this, true, null);
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPekari;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtKorisnickoIme;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JTextField txtTelefon;
    // End of variables declaration//GEN-END:variables

    private void stilizuj() {
        Stil.plavo(btnDodaj);
        Stil.plavo(btnPromeni);
        Stil.plavo(btnPretrazi);
        Stil.plavo(btnOsvezi);
        Stil.crveno(btnObrisi);
        Stil.labela(jLabel1);
        Stil.labela(jLabel2);
        Stil.labela(jLabel3);
        Stil.labela(jLabel4);
        Stil.polje(txtIme);
        Stil.polje(txtPrezime);
        Stil.polje(txtKorisnickoIme);
        Stil.polje(txtTelefon);
        Stil.tabela(tblPekari);
        Stil.scrollPanel(jScrollPane1);
        Stil.pozadina(getContentPane());
    }
}
