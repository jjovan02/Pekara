/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import java.time.LocalDate;
import java.util.ArrayList;
import style.Stil;
import javax.swing.JOptionPane;
import model.Kupac;
import model.Pecivo;
import model.Pekar;
import model.Racun;
import model.StavkaRacuna;
import ui.logic.UIController;
import validation.Validator;
import view.model.StavkaRacunaTableModel;

/**
 *
 * @author stari
 */
public class AddRacunForm extends javax.swing.JDialog {

    private Racun racun;
    private Pekar prijavljeniPekar;
    private ArrayList<StavkaRacuna> stavke = new ArrayList<>();
    private int rbBrojac = 1;
    
    public AddRacunForm(java.awt.Frame parent, boolean modal, Racun racun, Pekar pekar) {
        super(parent, modal);
        this.racun = racun;
        this.prijavljeniPekar = pekar;
        initComponents();
        setTitle(racun == null ? "Kreiraj račun" : "Promeni račun");
        setLocationRelativeTo(parent);
        tblStavke.setModel(new StavkaRacunaTableModel(stavke));
        stilizuj();
        ucitajKomboe();
    }
    
    private void ucitajKomboe() {
        try {
            ArrayList<Kupac> kupci =UIController.getInstance().vratiListuSviKupac(new Kupac());
            for (Kupac k : kupci) {
                cmbKupac.addItem(k);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Sistem ne može da učita kupce.", "Greška", JOptionPane.ERROR_MESSAGE);
        }

        try {
            ArrayList<Pecivo> peciva =UIController.getInstance().vratiListuSviPecivo(new Pecivo());
            for (Pecivo p : peciva) {
                cmbPecivo.addItem(p);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Sistem ne može da učita peciva.", "Greška", JOptionPane.ERROR_MESSAGE);
        }

        cmbTipPlacanja.addItem("Gotovina");
        cmbTipPlacanja.addItem("Kartica");
        cmbTipPlacanja.addItem("Čekovi");

        if (racun != null) {
            cmbTipPlacanja.setSelectedItem(racun.getTipPlacanja());
            if (racun.getKupac() != null) {
                cmbKupac.setSelectedItem(racun.getKupac());
            }
            if (racun.getStavke() != null) {
                stavke.addAll(racun.getStavke());
                rbBrojac = stavke.size() + 1;
            }
            tblStavke.setModel(new StavkaRacunaTableModel(stavke));
            azurirajIznose();
        }
    }

    private void azurirajIznose() {
        Kupac kupac = (Kupac) cmbKupac.getSelectedItem();
        double ukupno = 0;
        for (StavkaRacuna s : stavke) {
            ukupno += s.getIznos();
        }
        int popust = (kupac != null && kupac.getKategorijaKupca() != null) ? kupac.getKategorijaKupca().getPopust() : 0;
        double saPopustom = ukupno - ukupno * popust / 100.0;

        lblUkupno.setText(String.format("Ukupno: %.2f RSD", ukupno));
        lblPopust.setText("Popust: " + popust + "%");
        lblSaPopustom.setText(String.format("Sa popustom: %.2f RSD", saPopustom));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cmbKupac = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmbTipPlacanja = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cmbPecivo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtKolicina = new javax.swing.JTextField();
        btnDodajStavku = new javax.swing.JButton();
        btnUkloniStavku = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStavke = new javax.swing.JTable();
        lblUkupno = new javax.swing.JLabel();
        lblPopust = new javax.swing.JLabel();
        lblSaPopustom = new javax.swing.JLabel();
        btnSacuvaj = new javax.swing.JButton();
        btnOtkazi = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Kupac:");

        cmbKupac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKupacActionPerformed(evt);
            }
        });

        jLabel2.setText("Tip plaćanja:");

        jLabel3.setText("Pecivo:");

        jLabel4.setText("Količina:");

        btnDodajStavku.setText("Dodaj stavku");
        btnDodajStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajStavkuActionPerformed(evt);
            }
        });

        btnUkloniStavku.setText("Ukloni stavku");
        btnUkloniStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUkloniStavkuActionPerformed(evt);
            }
        });

        tblStavke.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblStavke);

        lblUkupno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblUkupno.setText("Ukupno: 0.00 RSD");

        lblPopust.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPopust.setText("Popust: 0%");

        lblSaPopustom.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblSaPopustom.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSaPopustom.setText("Sa popustom: 0.00 RSD");

        btnSacuvaj.setText("Sačuvaj račun");
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
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUkupno)
                        .addGap(46, 46, 46)
                        .addComponent(lblPopust)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSaPopustom))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnOtkazi, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbKupac, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbPecivo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(198, 198, 198)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbTipPlacanja, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(154, 154, 154))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnUkloniStavku)
                                .addGap(18, 18, 18)
                                .addComponent(btnDodajStavku)))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbKupac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbTipPlacanja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUkloniStavku)
                        .addComponent(btnDodajStavku))
                    .addComponent(cmbPecivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUkupno)
                    .addComponent(lblPopust)
                    .addComponent(lblSaPopustom))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOtkazi, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtkaziActionPerformed
        dispose();
    }//GEN-LAST:event_btnOtkaziActionPerformed

    private void btnDodajStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajStavkuActionPerformed
        try {
            Validator.validateNotEmpty(txtKolicina.getText(), "Količina");
            int kolicina = Integer.parseInt(txtKolicina.getText().trim());
            Validator.validatePositiveNumber(kolicina, "Količina");

            Pecivo pecivo = (Pecivo) cmbPecivo.getSelectedItem();
            if (pecivo == null) {
                JOptionPane.showMessageDialog(this, "Izaberite pecivo!");
                return;
            }

            double iznos = pecivo.getCena() * kolicina;
            StavkaRacuna stavka = new StavkaRacuna(pecivo.getCena(), kolicina, iznos, pecivo);
            stavka.setRb(rbBrojac++);
            stavke.add(stavka);
            tblStavke.setModel(new view.model.StavkaRacunaTableModel(stavke));
            txtKolicina.setText("");
            azurirajIznose();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,"Količina mora biti broj!","Greška", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Greška: " + ex.getMessage(),  "Greška", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnDodajStavkuActionPerformed

    private void btnUkloniStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUkloniStavkuActionPerformed
        int row = tblStavke.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Izaberite stavku!");
            return;
        }
        stavke.remove(row);
        tblStavke.setModel(new view.model.StavkaRacunaTableModel(stavke));
        azurirajIznose();

    }//GEN-LAST:event_btnUkloniStavkuActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        try {
            if (stavke.isEmpty()) {
                JOptionPane.showMessageDialog(this,"Dodajte barem jednu stavku!");
                return;
            }
            Kupac kupac = (Kupac) cmbKupac.getSelectedItem();
            if (kupac == null) {
                JOptionPane.showMessageDialog(this, "Izaberite kupca!");
                return;
            }

            Racun r = (racun == null) ? new Racun() : racun;
            r.setKupac(kupac);
            r.setPekar(prijavljeniPekar);
            r.setTipPlacanja((String) cmbTipPlacanja.getSelectedItem());
            r.setDatumIzdavanja(LocalDate.now());
            r.setStavke(stavke);
            r.izracunajIznose();

            if (racun == null) {
                UIController.getInstance().kreirajRacun(r);
            } else {
                UIController.getInstance().promeniRacun(r);
            }
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio račun.");
            dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne može da zapamti račun.", "Greška", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void cmbKupacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKupacActionPerformed
    azurirajIznose();
    }//GEN-LAST:event_cmbKupacActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajStavku;
    private javax.swing.JButton btnOtkazi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JButton btnUkloniStavku;
    private javax.swing.JComboBox<Kupac> cmbKupac;
    private javax.swing.JComboBox<Pecivo> cmbPecivo;
    private javax.swing.JComboBox<String> cmbTipPlacanja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblPopust;
    private javax.swing.JLabel lblSaPopustom;
    private javax.swing.JLabel lblUkupno;
    private javax.swing.JTable tblStavke;
    private javax.swing.JTextField txtKolicina;
    // End of variables declaration//GEN-END:variables

    private void stilizuj() {
        Stil.plavo(btnDodajStavku);
        Stil.plavo(btnSacuvaj);
        Stil.crveno(btnUkloniStavku);
        Stil.crveno(btnOtkazi);
        Stil.labela(jLabel1);
        Stil.labela(jLabel2);
        Stil.labela(jLabel3);
        Stil.labela(jLabel4);
        Stil.polje(txtKolicina);
        Stil.iznosLabela(lblUkupno);
        Stil.iznosLabela(lblPopust);
        Stil.iznosLabela(lblSaPopustom);
        Stil.tabela(tblStavke);
        Stil.kombo(cmbKupac);
        Stil.kombo(cmbPecivo);
        Stil.kombo(cmbTipPlacanja);
        Stil.scrollPanel(jScrollPane1);
        Stil.pozadina(getContentPane());
    }
}
