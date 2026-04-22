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

public class PromenaStavkeForm extends javax.swing.JDialog {

    private StavkaRacuna stavkaZaPromenu;

    public PromenaStavkeForm(java.awt.Window parent, boolean modal, StavkaRacuna stavkaZaPromenu) {
        super(parent, ModalityType.APPLICATION_MODAL);
        this.stavkaZaPromenu = stavkaZaPromenu;
        initComponents();
        setTitle("Promena stavke");
        setLocationRelativeTo(null);
        setResizable(false);
        ucitajPeciva();
        popuniPolja();

        Stil.plavo(btnSacuvaj);
        Stil.plavo(btnIzaberiPecivo);
        Stil.labela(jLabel1); 
        Stil.labela(jLabel2); 
        Stil.polje(txtKolicina);
        Stil.tabela(tblPeciva);
        Stil.pozadina(getContentPane());
    }

    public StavkaRacuna getStavkaZaPromenu() {
        return stavkaZaPromenu;
    }

    private void ucitajPeciva() {
        try {
            ArrayList<Pecivo> lista = UIController.getInstance().vratiListuSviPecivo(new Pecivo());
            tblPeciva.setModel(new PecivoTableModel(lista));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Sistem ne može da učita peciva.", "Greška", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }

    private void popuniPolja() {
        txtKolicina.setText(String.valueOf(stavkaZaPromenu.getKolicina()));
        if (stavkaZaPromenu.getPecivo() != null) {
            txtIzabranoPecivo.setText(stavkaZaPromenu.getPecivo().getNaziv());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtIzabranoPecivo = new javax.swing.JTextField();
        txtKolicina = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPeciva = new javax.swing.JTable();
        btnIzaberiPecivo = new javax.swing.JButton();
        btnSacuvaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Pecivo:");

        jLabel2.setText("Količina:");

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

        btnIzaberiPecivo.setText("Izaberi pecivo");
        btnIzaberiPecivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzaberiPecivoActionPerformed(evt);
            }
        });

        btnSacuvaj.setText("Sačuvaj promenu");
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
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtIzabranoPecivo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnIzaberiPecivo)
                        .addGap(34, 34, 34)
                        .addComponent(btnSacuvaj)))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIzabranoPecivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSacuvaj)
                    .addComponent(btnIzaberiPecivo))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIzaberiPecivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzaberiPecivoActionPerformed
        int row = tblPeciva.getSelectedRow();
        if (row >= 0) {
            Pecivo p = ((PecivoTableModel) tblPeciva.getModel()).getPecivo(row);
            stavkaZaPromenu.setPecivo(p);
            stavkaZaPromenu.setCena(p.getCena());
            txtIzabranoPecivo.setText(p.getNaziv());
        } else {
            JOptionPane.showMessageDialog(this, "Izaberite pecivo iz tabele!", "Upozorenje", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnIzaberiPecivoActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        try {
            if (txtKolicina.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Unesite količinu!","Upozorenje", JOptionPane.WARNING_MESSAGE);
                return;
            }
            int kolicina = Integer.parseInt(txtKolicina.getText().trim());
            if (kolicina <= 0) {
                JOptionPane.showMessageDialog(this,"Količina mora biti pozitivan broj!", "Upozorenje", JOptionPane.WARNING_MESSAGE);
                return;
            }
            stavkaZaPromenu.setKolicina(kolicina);
            stavkaZaPromenu.setIznos(stavkaZaPromenu.getCena() * kolicina);
            JOptionPane.showMessageDialog(this, "Stavka je uspešno promenjena.");
            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,"Količina mora biti ceo broj!", "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSacuvajActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzaberiPecivo;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPeciva;
    private javax.swing.JTextField txtIzabranoPecivo;
    private javax.swing.JTextField txtKolicina;
    // End of variables declaration//GEN-END:variables
}
