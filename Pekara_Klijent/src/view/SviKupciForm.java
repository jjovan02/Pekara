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
import ui.logic.UIController;
import view.model.KupacTableModel;


public class SviKupciForm extends javax.swing.JFrame {

    public SviKupciForm() {
        initComponents();
        setTitle("Kupci");
        setLocationRelativeTo(null);
        ucitajSve();
        ucitajKategorije();
        stilizuj();
    }
    
    private void ucitajSve() {
        try {
            ArrayList<Kupac> lista = UIController.getInstance().vratiListuSviKupac(new Kupac());
            tblKupci.setModel(new KupacTableModel(lista));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem nije pronašao kupce.","Info", JOptionPane.INFORMATION_MESSAGE);
            tblKupci.setModel(
                new KupacTableModel(new ArrayList<>()));
        }
    }



    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPrezime = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKupci = new javax.swing.JTable();
        btnObrisi = new javax.swing.JButton();
        btnPromeni = new javax.swing.JButton();
        btnDodaj = new javax.swing.JButton();
        btnPretrazi = new javax.swing.JButton();
        btnOsvezi = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cmbKategorija = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

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

        tblKupci.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblKupci);

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

        jLabel4.setText("Kategorija:");

        jButton1.setText("Detalji");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnObrisi)
                        .addGap(18, 18, 18)
                        .addComponent(btnPromeni)
                        .addGap(18, 18, 18)
                        .addComponent(btnDodaj))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtIme, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(txtPrezime, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addComponent(btnPretrazi)
                        .addGap(18, 18, 18)
                        .addComponent(btnOsvezi))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbKategorija, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbKategorija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPretrazi)
                    .addComponent(btnOsvezi))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodaj)
                    .addComponent(btnPromeni)
                    .addComponent(btnObrisi)
                    .addComponent(jButton1))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrezimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrezimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrezimeActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
    int row = tblKupci.getSelectedRow();
    if (row < 0) {
        JOptionPane.showMessageDialog(this, "Izaberite kupca iz tabele!", "Upozorenje", JOptionPane.WARNING_MESSAGE);
        return;
    }
    try {
        Kupac izabrani = ((KupacTableModel) tblKupci.getModel()).getKupac(row);
        Kupac filter = new model.Kupac();
        filter.setIdKupac(izabrani.getIdKupac());
        ArrayList<Kupac> rezultat = UIController.getInstance().vratiListuNekiKupac(filter);
        Kupac k = rezultat.get(0);

        JOptionPane.showMessageDialog(this, "Sistem je našao kupca.", "Pretraga", JOptionPane.INFORMATION_MESSAGE);

        int potvrda = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da želite da obrišete kupca?", "Brisanje", JOptionPane.YES_NO_OPTION);
        if (potvrda == JOptionPane.YES_OPTION) {
            try {
                //throw new Exception("test");
                UIController.getInstance().obrisiKupac(k);
                JOptionPane.showMessageDialog(this, "Sistem je obrisao kupca.");
                ucitajSve();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Sistem ne može da obriše kupca.", "Greška", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Sistem ne može da nađe kupca.", "Greška", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnPromeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromeniActionPerformed
        int row = tblKupci.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this,  "Izaberite kupca iz tabele!",  "Upozorenje", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            Kupac izabrani = ((KupacTableModel)tblKupci.getModel()).getKupac(row);
            Kupac filter = new model.Kupac();
            filter.setIdKupac(izabrani.getIdKupac());
            ArrayList<Kupac> rezultat = UIController.getInstance().vratiListuNekiKupac(filter);
            Kupac k = rezultat.get(0);

            JOptionPane.showMessageDialog(this, "Sistem je našao kupca.","Pretraga", JOptionPane.INFORMATION_MESSAGE);

            AddKupacForm f = new AddKupacForm(this, true, k, false);
            f.setVisible(true);
            ucitajSve();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Sistem ne može da nađe kupca.","Greška", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnPromeniActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        AddKupacForm f = new AddKupacForm(this, true, null, false);
        f.setVisible(true);
        ucitajSve();
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
        try {
            model.Kupac k = new model.Kupac();
            k.setIme(txtIme.getText());
            k.setPrezime(txtPrezime.getText());
            k.setEmail(txtEmail.getText());

            if (cmbKategorija != null && cmbKategorija.getSelectedItem() != null) {
                k.setKategorijaKupca((KategorijaKupca) cmbKategorija.getSelectedItem());
            }

            ArrayList<Kupac> lista =UIController.getInstance().vratiListuNekiKupac(k);
            tblKupci.setModel(new KupacTableModel(lista));
            JOptionPane.showMessageDialog(this, "Sistem je našao kupci po zadatim kriterijumima.","Pretraga", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne može da nađe kupci po zadatim kriterijumima.", "Info", JOptionPane.INFORMATION_MESSAGE);
            tblKupci.setModel(new KupacTableModel(new ArrayList<>()));
        }
    }//GEN-LAST:event_btnPretraziActionPerformed

    private void btnOsveziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOsveziActionPerformed
        ucitajSve();
    }//GEN-LAST:event_btnOsveziActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    int row = tblKupci.getSelectedRow();
    if (row < 0) {
        JOptionPane.showMessageDialog(this,"Izaberite kupca iz tabele!", "Upozorenje", JOptionPane.WARNING_MESSAGE);
        return;
    }
    try {
        Kupac izabrani = ((KupacTableModel) tblKupci.getModel()).getKupac(row);
        Kupac filter = new Kupac();
        //filter.setIdKupac(999999);
        filter.setIdKupac(izabrani.getIdKupac());
        ArrayList<Kupac> rezultat =UIController.getInstance().vratiListuNekiKupac(filter);
        Kupac k = rezultat.get(0);

        JOptionPane.showMessageDialog(this, "Sistem je našao kupca.",  "Pretraga", JOptionPane.INFORMATION_MESSAGE);

        AddKupacForm f = new AddKupacForm(this, true, k, true);
        f.setVisible(true);

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Sistem ne može da nađe kupca.","Greška", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton1ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnOsvezi;
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JButton btnPromeni;
    private javax.swing.JComboBox<KategorijaKupca> cmbKategorija;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblKupci;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtPrezime;
    // End of variables declaration//GEN-END:variables

        private void ucitajKategorije() {
        try {
            ArrayList<model.KategorijaKupca> kategorije =UIController.getInstance().vratiListuSviKategorijaKupca(new KategorijaKupca());
            cmbKategorija.addItem(null);
            for (KategorijaKupca kk : kategorije) cmbKategorija.addItem(kk);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Sistem ne može da učita kategorije.","Greška", JOptionPane.ERROR_MESSAGE);
        }
    }

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
        Stil.polje(txtEmail);
        Stil.tabela(tblKupci);
        Stil.scrollPanel(jScrollPane1);
        Stil.pozadina(getContentPane());
        Stil.kombo(cmbKategorija);
        Stil.plavo(jButton1);
    }
}
