/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.util.ArrayList;
import style.Stil;
import javax.swing.JOptionPane;
import model.Pecivo;
import view.model.PecivoTableModel;
import ui.logic.UIController;


public class SvaPecivaForm extends javax.swing.JFrame {


    public SvaPecivaForm() {
        initComponents();
        setTitle("Peciva");
        setLocationRelativeTo(null);
        stilizuj();
    }

    private void ucitajSve() {
        try {
            ArrayList<Pecivo> lista = UIController.getInstance().vratiListuSviPecivo(new Pecivo());
            tblPeciva.setModel(new PecivoTableModel(lista));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem nije pronašao peciva.", "Info", JOptionPane.INFORMATION_MESSAGE);
            tblPeciva.setModel(new PecivoTableModel(new ArrayList<>()));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        btnPretrazi = new javax.swing.JButton();
        btnOsvezi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPeciva = new javax.swing.JTable();
        btnDodaj = new javax.swing.JButton();
        btnPromeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Naziv:");

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

        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnPromeni.setText("Promeni");
        btnPromeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obriši");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnObrisi)
                        .addGap(18, 18, 18)
                        .addComponent(btnPromeni)
                        .addGap(18, 18, 18)
                        .addComponent(btnDodaj))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnPretrazi)
                            .addGap(18, 18, 18)
                            .addComponent(btnOsvezi))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPretrazi)
                    .addComponent(btnOsvezi))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodaj)
                    .addComponent(btnPromeni)
                    .addComponent(btnObrisi))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOsveziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOsveziActionPerformed
        ucitajSve();
    }//GEN-LAST:event_btnOsveziActionPerformed

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
        
        try {
            Pecivo p = new model.Pecivo();
            p.setNaziv(txtNaziv.getText());
            ArrayList<Pecivo> lista =UIController.getInstance().vratiListuNekiPecivo(p);
            tblPeciva.setModel(new PecivoTableModel(lista));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                "Sistem nije pronašao peciva po zadatim kriterijumima.",
                "Info", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnPretraziActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        
        AddPecivoForm f = new AddPecivoForm(this, true, null);
        f.setVisible(true);
        ucitajSve();

    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnPromeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromeniActionPerformed

        int row = tblPeciva.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this,"Izaberite pecivo iz tabele!", "Upozorenje", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Pecivo p = ((PecivoTableModel) tblPeciva.getModel()).getPecivo(row);
        AddPecivoForm f = new AddPecivoForm(this, true, p);
        f.setVisible(true);
        ucitajSve();

    }//GEN-LAST:event_btnPromeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed

        int row = tblPeciva.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Izaberite pecivo iz tabele!","Upozorenje", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Pecivo p = ((PecivoTableModel)tblPeciva.getModel()).getPecivo(row);
        int potvrda = JOptionPane.showConfirmDialog(this,"Da li ste sigurni da želite da obrišete pecivo?","Brisanje", JOptionPane.YES_NO_OPTION);
        if (potvrda == JOptionPane.YES_OPTION) {
            try {
                UIController.getInstance().obrisiPecivo(p);
                JOptionPane.showMessageDialog(this, "Sistem je obrisao pecivo.");
                ucitajSve();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,"Sistem ne može da obriše pecivo.","Greška", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnObrisiActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnOsvezi;
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JButton btnPromeni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPeciva;
    private javax.swing.JTextField txtNaziv;
    // End of variables declaration//GEN-END:variables

    private void stilizuj() {
        Stil.plavo(btnDodaj);
        Stil.plavo(btnPromeni);
        Stil.plavo(btnPretrazi);
        Stil.plavo(btnOsvezi);
        Stil.crveno(btnObrisi);
        Stil.labela(jLabel1);
        Stil.polje(txtNaziv);
        Stil.tabela(tblPeciva);
        ucitajSve();
        Stil.scrollPanel(jScrollPane1);
        Stil.pozadina(getContentPane());    }
}
