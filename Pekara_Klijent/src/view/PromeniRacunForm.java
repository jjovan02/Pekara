
package view;

import view.model.KupacTableModel;
import view.model.PekarTableModel;
import view.model.StavkaRacunaTableModel;
import style.Stil;
import model.*;
import ui.logic.UIController;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PromeniRacunForm extends javax.swing.JDialog {

    private Racun racun;
    private int naredniRb = 1;

    public PromeniRacunForm(java.awt.Window parent, boolean modal, Racun racun) {
        super(parent, ModalityType.APPLICATION_MODAL);
        this.racun = racun;
        initComponents();
        setTitle("Promena računa");
        setLocationRelativeTo(null);
        setResizable(false);

        tblStavke.setModel(new StavkaRacunaTableModel(racun.getStavke()));

        for (StavkaRacuna s : racun.getStavke()) {
            if (s.getRb() > naredniRb) naredniRb = s.getRb();
        }

        ucitajTabelePekaraIKupaca();
        popuniPolja();
        azurirajIznose();
        stilizuj();
        
    }

    public Racun getRacun() {
        return racun;
    }

    private void ucitajTabelePekaraIKupaca() {
        try {
            ArrayList<Pekar> pekari = UIController.getInstance()
                .vratiListuSviPekar(new Pekar());
            tblPekari.setModel(new PekarTableModel(pekari));
            txtPekar.setText(racun.getPekar().getIme() + " " +
                racun.getPekar().getPrezime());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                "Sistem ne može da učita pekare.", "Greška",
                JOptionPane.ERROR_MESSAGE);
        }
        try {
            ArrayList<Kupac> kupci = UIController.getInstance()
                .vratiListuSviKupac(new Kupac());
            tblKupci.setModel(new KupacTableModel(kupci));
            txtKupac.setText(racun.getKupac().getIme() + " " +
                racun.getKupac().getPrezime());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                "Sistem ne može da učita kupce.", "Greška",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void popuniPolja() {
        txtPekar.setText(racun.getPekar().getIme() + " " +
            racun.getPekar().getPrezime());
        txtKupac.setText(racun.getKupac().getIme() + " " +
            racun.getKupac().getPrezime());
    }

    private void azurirajIznose() {
        double ukupno = 0;
        for (StavkaRacuna s : racun.getStavke()) {
            ukupno += s.getIznos();
        }
        double popust = racun.getKupac() != null &&
            racun.getKupac().getKategorijaKupca() != null
            ? racun.getKupac().getKategorijaKupca().getPopust() : 0;
        double saPopustom = ukupno * (1 - popust / 100.0);
        lblUkupno.setText("Ukupno: " + String.format("%.2f", ukupno));
        lblPopust.setText("Popust: " + popust + "%");
        lblSaPopustom.setText("Sa popustom: " + String.format("%.2f", saPopustom));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtPekar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPekari = new javax.swing.JTable();
        btnIzaberiPekara = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtKupac = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKupci = new javax.swing.JTable();
        btnIzaberiKupca = new javax.swing.JButton();
        btnUkloniStavku = new javax.swing.JButton();
        btnPromeniStavku = new javax.swing.JButton();
        btnDodajStavku = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblStavke = new javax.swing.JTable();
        lblUkupno = new javax.swing.JLabel();
        lblPopust = new javax.swing.JLabel();
        lblSaPopustom = new javax.swing.JLabel();
        btnSacuvaj = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("Izabrani pekar:");

        txtPekar.setEditable(false);

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

        btnIzaberiPekara.setText("Izaberi pekara");
        btnIzaberiPekara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzaberiPekaraActionPerformed(evt);
            }
        });

        jLabel3.setText("Izabrani kupac:");

        txtKupac.setEditable(false);

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
        jScrollPane2.setViewportView(tblKupci);

        btnIzaberiKupca.setText("Izaberi kupca");
        btnIzaberiKupca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzaberiKupcaActionPerformed(evt);
            }
        });

        btnUkloniStavku.setText("Ukloni stavku");
        btnUkloniStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUkloniStavkuActionPerformed(evt);
            }
        });

        btnPromeniStavku.setText("Promeni stavku");
        btnPromeniStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromeniStavkuActionPerformed(evt);
            }
        });

        btnDodajStavku.setText("Dodaj stavku");
        btnDodajStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajStavkuActionPerformed(evt);
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
        jScrollPane3.setViewportView(tblStavke);

        lblUkupno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblUkupno.setText("Ukupno: 0.00 RSD");

        lblPopust.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPopust.setText("Popust: 0%");

        lblSaPopustom.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblSaPopustom.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSaPopustom.setText("Sa popustom: 0.00 RSD");

        btnSacuvaj.setText("Sačuvaj izmene");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblUkupno)
                                .addGap(33, 33, 33)
                                .addComponent(lblPopust)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblSaPopustom))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPromeniStavku)
                            .addComponent(btnDodajStavku)
                            .addComponent(btnUkloniStavku)
                            .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnIzaberiPekara)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtPekar))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtKupac))
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnIzaberiKupca, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPekar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtKupac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIzaberiPekara)
                    .addComponent(btnIzaberiKupca))
                .addGap(19, 19, 19)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUkloniStavku)
                        .addGap(18, 18, 18)
                        .addComponent(btnPromeniStavku)
                        .addGap(18, 18, 18)
                        .addComponent(btnDodajStavku)
                        .addGap(44, 44, 44))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUkupno)
                            .addComponent(lblPopust)
                            .addComponent(lblSaPopustom)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPromeniStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromeniStavkuActionPerformed
    int row = tblStavke.getSelectedRow();
    if (row >= 0) {
        StavkaRacunaTableModel model =
            (StavkaRacunaTableModel) tblStavke.getModel();
        StavkaRacuna sr = model.getStavka(row);
        PromenaStavkeForm forma = new PromenaStavkeForm(this, true, sr);
        forma.setVisible(true);
        // sr je vec azuriran kroz referencu
        tblStavke.setModel(new StavkaRacunaTableModel(racun.getStavke()));
        azurirajIznose();
    } else {
        JOptionPane.showMessageDialog(this, "Izaberite stavku!",
            "Upozorenje", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_btnPromeniStavkuActionPerformed

    private void btnIzaberiPekaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzaberiPekaraActionPerformed
        int row = tblPekari.getSelectedRow();
        if (row >= 0) {
            Pekar p = ((PekarTableModel) tblPekari.getModel()).getPekar(row);
            racun.setPekar(p);
            txtPekar.setText(p.getIme() + " " + p.getPrezime());
        } else {
            JOptionPane.showMessageDialog(this, "Izaberite pekara iz tabele!",
                "Upozorenje", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnIzaberiPekaraActionPerformed

    private void btnIzaberiKupcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzaberiKupcaActionPerformed
        int row = tblKupci.getSelectedRow();
        if (row >= 0) {
            Kupac k = ((KupacTableModel) tblKupci.getModel()).getKupac(row);
            racun.setKupac(k);
            txtKupac.setText(k.getIme() + " " + k.getPrezime());
            azurirajIznose();
        } else {
            JOptionPane.showMessageDialog(this, "Izaberite kupca iz tabele!",
                "Upozorenje", JOptionPane.WARNING_MESSAGE);
        }

        
        
    }//GEN-LAST:event_btnIzaberiKupcaActionPerformed

    private void btnDodajStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajStavkuActionPerformed
    
        AddStavkaRacunaForm forma = new AddStavkaRacunaForm(this, true);
        forma.setVisible(true);

        StavkaRacuna s = forma.getStavka();
        if (s.getPecivo() != null) {
            s.setRb(++naredniRb);
            racun.getStavke().add(s);
            tblStavke.setModel(new StavkaRacunaTableModel(racun.getStavke()));
            Stil.tabela(tblStavke);
            azurirajIznose();
        }
        
    }//GEN-LAST:event_btnDodajStavkuActionPerformed

    private void btnUkloniStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUkloniStavkuActionPerformed
    int row = tblStavke.getSelectedRow();
    if (row >= 0) {
        racun.getStavke().remove(row);
        tblStavke.setModel(new StavkaRacunaTableModel(racun.getStavke()));
        azurirajIznose();
    } else {
        JOptionPane.showMessageDialog(this, "Izaberite stavku!",
            "Upozorenje", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_btnUkloniStavkuActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        
        try {
            if (racun.getStavke().isEmpty()) {
                JOptionPane.showMessageDialog(this,"Dodajte barem jednu stavku!","Upozorenje", JOptionPane.WARNING_MESSAGE);
                return;
            }
            racun.izracunajIznose();
            UIController.getInstance().promeniRacun(racun);
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio račun.");
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Sistem ne može da zapamti račun.","Greška", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSacuvajActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajStavku;
    private javax.swing.JButton btnIzaberiKupca;
    private javax.swing.JButton btnIzaberiPekara;
    private javax.swing.JButton btnPromeniStavku;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JButton btnUkloniStavku;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblPopust;
    private javax.swing.JLabel lblSaPopustom;
    private javax.swing.JLabel lblUkupno;
    private javax.swing.JTable tblKupci;
    private javax.swing.JTable tblPekari;
    private javax.swing.JTable tblStavke;
    private javax.swing.JTextField txtKupac;
    private javax.swing.JTextField txtPekar;
    // End of variables declaration//GEN-END:variables

    private void stilizuj() {

        Stil.plavo(btnIzaberiPekara);
        Stil.plavo(btnIzaberiKupca);
        Stil.plavo(btnDodajStavku);
        Stil.plavo(btnPromeniStavku);
        Stil.plavo(btnSacuvaj);
        Stil.crveno(btnUkloniStavku);
        Stil.iznosLabela(lblUkupno);
        Stil.iznosLabela(lblPopust);
        Stil.iznosLabela(lblSaPopustom);
        Stil.tabela(tblPekari);
        Stil.tabela(tblKupci);
        Stil.tabela(tblStavke);
        Stil.pozadina(getContentPane());

    }


}
