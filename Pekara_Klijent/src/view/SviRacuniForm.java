/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.util.ArrayList;
import style.Stil;
import javax.swing.JOptionPane;
import model.KategorijaKupca;
import model.Kupac;
import model.Pekar;
import model.Racun;
import ui.logic.UIController;
import view.model.RacunTableModel;

/**
 *
 * @author stari
 */
public class SviRacuniForm extends javax.swing.JFrame {

   private model.Pekar prijavljeniPekar;
   
   public SviRacuniForm(model.Pekar pekar) {
    this.prijavljeniPekar = pekar;
        initComponents();
        setTitle("Računi");
        setLocationRelativeTo(null);
        ucitajKomboe();
        ucitajSve();
        stilizuj();
        
}

    private void ucitajSve() {
        try {
            ArrayList<Racun> lista = UIController.getInstance().vratiListuSviRacun(new model.Racun());
            tblRacuni.setModel(new RacunTableModel(lista));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Sistem nije pronašao račune.","Info", JOptionPane.INFORMATION_MESSAGE);
            tblRacuni.setModel(
                new RacunTableModel(new ArrayList<>()));
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPretrazi = new javax.swing.JButton();
        btnOsvezi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRacuni = new javax.swing.JTable();
        btnPromeni = new javax.swing.JButton();
        btnKreiraj = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDatum = new javax.swing.JTextField();
        cmbKupac = new javax.swing.JComboBox<>();
        cmbPekar = new javax.swing.JComboBox<>();
        btnDetalji = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

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

        tblRacuni.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblRacuni);

        btnPromeni.setText("Promeni");
        btnPromeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromeniActionPerformed(evt);
            }
        });

        btnKreiraj.setText("Kreiraj račun");
        btnKreiraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKreirajActionPerformed(evt);
            }
        });

        jLabel2.setText("Kupac:");

        jLabel3.setText("Pekar:");

        jLabel4.setText("Datum (yyyy-MM-dd):");

        cmbPekar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPekarActionPerformed(evt);
            }
        });

        btnDetalji.setText("Detalji");
        btnDetalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetaljiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDetalji, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 504, Short.MAX_VALUE)
                        .addComponent(btnPromeni)
                        .addGap(32, 32, 32)
                        .addComponent(btnKreiraj, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                    .addComponent(txtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cmbKupac, 0, 225, Short.MAX_VALUE)
                                        .addComponent(cmbPekar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPretrazi)
                            .addGap(18, 18, 18)
                            .addComponent(btnOsvezi))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbKupac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbPekar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPretrazi)
                    .addComponent(btnOsvezi))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnPromeni)
                        .addComponent(btnKreiraj, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnDetalji))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
    try {
        Racun r = new Racun();

        Kupac izabraniKupac = (Kupac) cmbKupac.getSelectedItem();
        if (izabraniKupac != null) {
            r.setKupac(izabraniKupac);
        }

        Pekar izabraniPekar = (Pekar) cmbPekar.getSelectedItem();
        if (izabraniPekar != null) {
            r.setPekar(izabraniPekar);
        }

        if (!txtDatum.getText().trim().isEmpty()) {
            try {
                r.setDatumIzdavanja(java.time.LocalDate.parse(txtDatum.getText().trim()));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Format datuma mora biti: yyyy-MM-dd", "Upozorenje", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }

        ArrayList<Racun> lista =UIController.getInstance().vratiListuNekiRacun(r);
        tblRacuni.setModel(new RacunTableModel(lista));
        JOptionPane.showMessageDialog(this,  "Sistem je našao račune po zadatim kriterijumima.", "Pretraga", JOptionPane.INFORMATION_MESSAGE);

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this,"Sistem ne može da nađe račune po zadatim kriterijumima.",  "Info", JOptionPane.INFORMATION_MESSAGE);
        tblRacuni.setModel(new RacunTableModel(new ArrayList<>()));
    }
    }//GEN-LAST:event_btnPretraziActionPerformed

    private void btnOsveziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOsveziActionPerformed
        ucitajSve();
    }//GEN-LAST:event_btnOsveziActionPerformed

    private void btnPromeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromeniActionPerformed
        int row = tblRacuni.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this,"Izaberite račun iz tabele!", "Upozorenje", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            Racun izabrani = ((RacunTableModel) tblRacuni.getModel()).getRacun(row);
            Racun filter = new model.Racun();
            //filter.setIdRacun(999999); - sistem ne moze da nadje racun greska
            filter.setIdRacun(izabrani.getIdRacun());
            ArrayList<Racun> rezultat = UIController.getInstance().vratiListuNekiRacun(filter);
            Racun r = rezultat.get(0);

            JOptionPane.showMessageDialog(this,"Sistem je našao račun.","Pretraga", JOptionPane.INFORMATION_MESSAGE);

            PromeniRacunForm f = new PromeniRacunForm(this, true, r);
            f.setVisible(true);
            ucitajSve();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne može da nađe račun.","Greška", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnPromeniActionPerformed

    private void btnKreirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKreirajActionPerformed
        AddRacunForm f = new AddRacunForm(this, true, null, prijavljeniPekar);
        f.setVisible(true);
        ucitajSve();
    }//GEN-LAST:event_btnKreirajActionPerformed

    private void cmbPekarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPekarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPekarActionPerformed

    private void btnDetaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetaljiActionPerformed
        int row = tblRacuni.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this,"Izaberite račun iz tabele!","Upozorenje", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            Racun izabrani = ((RacunTableModel)tblRacuni.getModel()).getRacun(row);
            Racun filter = new Racun();
            filter.setIdRacun(izabrani.getIdRacun());
            ArrayList<model.Racun> rezultat =UIController.getInstance().vratiListuNekiRacun(filter);
            Racun r = rezultat.get(0);

            JOptionPane.showMessageDialog(this,"Sistem je našao račun.","Pretraga", JOptionPane.INFORMATION_MESSAGE);

            DetaljiRacunaForm f = new DetaljiRacunaForm(this, true, r);
            f.setVisible(true);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne može da nađe račun.", "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDetaljiActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetalji;
    private javax.swing.JButton btnKreiraj;
    private javax.swing.JButton btnOsvezi;
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JButton btnPromeni;
    private javax.swing.JComboBox<Kupac> cmbKupac;
    private javax.swing.JComboBox<Pekar> cmbPekar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRacuni;
    private javax.swing.JTextField txtDatum;
    // End of variables declaration//GEN-END:variables

    private void ucitajKomboe() {

        try {
            ArrayList<Kupac> kupci =UIController.getInstance().vratiListuSviKupac(new Kupac());
            cmbKupac.addItem(null);
            for (Kupac k : kupci) cmbKupac.addItem(k);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne može da učita kupce.", "Greška", JOptionPane.ERROR_MESSAGE);
        }

        try {
            ArrayList<model.Pekar> pekari =UIController.getInstance().vratiListuSviPekar(new model.Pekar());
            cmbPekar.addItem(null);
            for (Pekar p : pekari) cmbPekar.addItem(p);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Sistem ne može da učita pekare.", "Greška", JOptionPane.ERROR_MESSAGE);
        }

       


    }

    private void stilizuj() {
        Stil.plavo(btnKreiraj);
        Stil.plavo(btnPromeni);
        Stil.plavo(btnPretrazi);
        Stil.plavo(btnOsvezi);
        Stil.polje(txtDatum);
        Stil.tabela(tblRacuni);
        Stil.scrollPanel(jScrollPane1);
        Stil.pozadina(getContentPane());
        Stil.labela(jLabel2);
        Stil.labela(jLabel3);
        Stil.labela(jLabel4);
        Stil.kombo(cmbKupac);
        Stil.kombo(cmbPekar);
        Stil.plavo(btnDetalji);
    }
}
