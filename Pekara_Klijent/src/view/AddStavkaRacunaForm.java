/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import style.Stil;
import model.Pecivo;
import model.StavkaRacuna;
import view.model.PecivoTableModel;
import ui.logic.UIController;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author stari
 */
public class AddStavkaRacunaForm extends javax.swing.JDialog {

    
    private StavkaRacuna stavka;
    private Pecivo odabranoPecivo;

    public AddStavkaRacunaForm(java.awt.Window parent, boolean modal) {
        super(parent, ModalityType.APPLICATION_MODAL);
        initComponents();
        setTitle("Dodaj stavku računa");
        setLocationRelativeTo(null);
        setResizable(false);
        stavka = new StavkaRacuna();
        txtKolicina.setText("1");
        txtOdabranoPecivo.setEditable(false);
        ucitajSvaPeciva();

        stilizuj();
        
    }

    public StavkaRacuna getStavka() {
        return stavka;
    }

    private void ucitajSvaPeciva() {
        try {
            ArrayList<Pecivo> lista = UIController.getInstance()
                .vratiListuSviPecivo(new Pecivo());
            tblPeciva.setModel(new PecivoTableModel(lista));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                "Sistem ne može da učita peciva.",
                "Greška", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }
    
    

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCena = new javax.swing.JTextField();
        btnPretrazi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPeciva = new javax.swing.JTable();
        btnOdaberi = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtOdabranoPecivo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtKolicina = new javax.swing.JTextField();
        btnDodajStavku = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Naziv:");

        jLabel2.setText("Cena:");

        btnPretrazi.setText("Pretraži");
        btnPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziActionPerformed(evt);
            }
        });

        tblPeciva.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPeciva);

        btnOdaberi.setText("Odaberi pecivo");
        btnOdaberi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdaberiActionPerformed(evt);
            }
        });

        jLabel3.setText("Odabrano pecivo:");

        txtOdabranoPecivo.setEditable(false);

        jLabel4.setText("Kolicina:");

        txtKolicina.setText("1");

        btnDodajStavku.setText("Dodaj stavku");
        btnDodajStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajStavkuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addComponent(btnOdaberi, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCena, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btnPretrazi))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtOdabranoPecivo, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDodajStavku, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jSeparator2))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPretrazi))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnOdaberi)
                .addGap(21, 21, 21)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtOdabranoPecivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(btnDodajStavku, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
        
        try {
            Pecivo p = new Pecivo();
            if (!txtNaziv.getText().trim().isEmpty())
                p.setNaziv(txtNaziv.getText().trim());
            if (!txtCena.getText().trim().isEmpty())
                p.setCena(Double.parseDouble(txtCena.getText().trim()));

            ArrayList<Pecivo> lista = UIController.getInstance().vratiListuNekiPecivo(p);
            tblPeciva.setModel(new PecivoTableModel(lista));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,"Cena mora biti broj!", "Greška", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Sistem nije pronašao peciva po zadatim kriterijumima.","Info", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnPretraziActionPerformed

    private void btnOdaberiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdaberiActionPerformed
        int row = tblPeciva.getSelectedRow();
        if (row >= 0) {
            odabranoPecivo = ((PecivoTableModel) tblPeciva.getModel()).getPecivo(row);
            txtOdabranoPecivo.setText( odabranoPecivo.getNaziv() + " | Cena: " + odabranoPecivo.getCena());
        } else {
            JOptionPane.showMessageDialog(this,"Izaberite pecivo iz tabele!","Upozorenje", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnOdaberiActionPerformed

    private void btnDodajStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajStavkuActionPerformed
        if (odabranoPecivo == null) {
            JOptionPane.showMessageDialog(this,"Morate odabrati pecivo pre dodavanja stavke!", "Upozorenje", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            if (txtKolicina.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Unesite količinu!", "Upozorenje", JOptionPane.WARNING_MESSAGE);
                return;
            }
            int kolicina = Integer.parseInt(txtKolicina.getText().trim());
            if (kolicina <= 0) {
                JOptionPane.showMessageDialog(this, "Količina mora biti pozitivan broj!", "Upozorenje", JOptionPane.WARNING_MESSAGE);
                return;
            }
            stavka.setPecivo(odabranoPecivo);
            stavka.setCena(odabranoPecivo.getCena());
            stavka.setKolicina(kolicina);
            stavka.setIznos(odabranoPecivo.getCena() * kolicina);
            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,"Količina mora biti ceo broj!", "Greška", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnDodajStavkuActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajStavku;
    private javax.swing.JButton btnOdaberi;
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tblPeciva;
    private javax.swing.JTextField txtCena;
    private javax.swing.JTextField txtKolicina;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtOdabranoPecivo;
    // End of variables declaration//GEN-END:variables

    private void stilizuj() {
        Stil.plavo(btnPretrazi);
        Stil.plavo(btnOdaberi);
        Stil.plavo(btnDodajStavku);
        Stil.labela(jLabel1); 
        Stil.labela(jLabel2); 
        Stil.labela(jLabel3); 
        Stil.labela(jLabel4); 
        Stil.polje(txtNaziv);
        Stil.polje(txtCena);
        Stil.polje(txtKolicina);
        Stil.tabela(tblPeciva);
        Stil.pozadina(getContentPane());
    }
}
