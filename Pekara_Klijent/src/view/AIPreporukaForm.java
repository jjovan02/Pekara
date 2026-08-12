package view;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.Pecivo;
import ai.PekaraAIRequest;
import style.Stil;
import ui.logic.UIController;

public class AIPreporukaForm extends javax.swing.JFrame {


    public AIPreporukaForm() {
        initComponents();
        stilizuj();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbTipDogadjaja = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        tfBrojGostiju = new javax.swing.JTextField();
        btnPreporuci = new javax.swing.JButton();
        btnZatvori = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taRezultat = new javax.swing.JTextArea();
        lblStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AI Preporuka");

        jLabel1.setText("Tip dogadjaja");

        cbTipDogadjaja.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "rođendan", "venčanje", "poslovni ručak", "proslava", "seminar", "druga vrsta događaja" }));

        jLabel2.setText("Broj gostiju:");

        tfBrojGostiju.setText("10");

        btnPreporuci.setText("Preporuči");
        btnPreporuci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreporuciActionPerformed(evt);
            }
        });

        btnZatvori.setText("Zatvori");
        btnZatvori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZatvoriActionPerformed(evt);
            }
        });

        taRezultat.setEditable(false);
        taRezultat.setColumns(20);
        taRezultat.setLineWrap(true);
        taRezultat.setRows(12);
        taRezultat.setWrapStyleWord(true);
        jScrollPane1.setViewportView(taRezultat);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnZatvori)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbTipDogadjaja, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfBrojGostiju, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btnPreporuci))
                    .addComponent(jScrollPane1)
                    .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbTipDogadjaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(tfBrojGostiju, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPreporuci))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(btnZatvori)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnZatvoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZatvoriActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnZatvoriActionPerformed

    private void btnPreporuciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreporuciActionPerformed
        
        
            String brojStr = tfBrojGostiju.getText().trim();
            if (brojStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Unesite broj gostiju!", "Greška", JOptionPane.WARNING_MESSAGE);
                return;
            }
            int brojGostiju;
            try {
                brojGostiju = Integer.parseInt(brojStr);
                if (brojGostiju <= 0) throw new NumberFormatException();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Broj gostiju mora biti pozitivan ceo broj!", "Greška", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // 2. Dobavljanje peciva preko kontrolera logike
            List<String> imenaPeciva = new ArrayList<>();
            try {
                ArrayList<Pecivo> peciva = UIController.getInstance().vratiListuSviPecivo(new Pecivo());
                for (Pecivo p : peciva) {
                    imenaPeciva.add(p.getNaziv());
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Greška pri učitavanju peciva iz baze:\n" + ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (imenaPeciva.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nema peciva u bazi!", "Upozorenje", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String tipDogadjaja = (String) cbTipDogadjaja.getSelectedItem();

            // 3. Blokiranje interfejsa (UI) radi sprečavanja višestrukih klikova tokom mrežnog rada
            btnPreporuci.setEnabled(false);
            cbTipDogadjaja.setEnabled(false);
            tfBrojGostiju.setEditable(false);
            btnZatvori.setEnabled(false);

            lblStatus.setText("Čekam odgovor od AI servisa preko servera...");
            taRezultat.setText("");

            // 4. Pokretanje pozadinske niti za komunikaciju
            new Thread(() -> {
                try {
                    // Kreiramo objekat zahteva koji se nalazi u zajedničkom projektu
                    PekaraAIRequest request = new PekaraAIRequest(imenaPeciva, tipDogadjaja, brojGostiju);

                    // Pozivamo isključivo metodu iz tvog UIController-a prateći arhitektonski šablon
                    String rezultat = UIController.getInstance().vratiAIPreporuku(request);

                    // Povratak u Swing Thread radi bezbednog ažuriranja komponenti interfejsa
                    SwingUtilities.invokeLater(() -> {
                        taRezultat.setText(rezultat);
                        lblStatus.setText("Gotovo! Preporuka je uspešno preuzeta.");
                        odblokirajUI();
                    });

                } catch (Exception ex) {
                    SwingUtilities.invokeLater(() -> {
                        taRezultat.setText("Greška pri obradi zahteva:\n" + ex.getMessage());
                        lblStatus.setText("Došlo je do greške na serveru.");
                        JOptionPane.showMessageDialog(this, "Greška pri komunikaciji sa serverom:\n" + ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
                        odblokirajUI();
                    });
                }
            }).start();
                                            

    

        
        
    }//GEN-LAST:event_btnPreporuciActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPreporuci;
    private javax.swing.JButton btnZatvori;
    private javax.swing.JComboBox<String> cbTipDogadjaja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTextArea taRezultat;
    private javax.swing.JTextField tfBrojGostiju;
    // End of variables declaration//GEN-END:variables

    private void stilizuj() {
        Stil.plavo(btnPreporuci);
        Stil.crveno(btnZatvori);
        Stil.labela(jLabel1);
        Stil.labela(jLabel2);
        Stil.labela(lblStatus);
        Stil.kombo(cbTipDogadjaja);
        Stil.polje(tfBrojGostiju);
        Stil.pozadina(getContentPane());
        Stil.scrollPanel(jScrollPane1);
        Stil.tekstualnaZona(taRezultat);
                
    }
    
    private void odblokirajUI() {
        btnPreporuci.setEnabled(true);
        cbTipDogadjaja.setEnabled(true);
        tfBrojGostiju.setEditable(true);
        btnZatvori.setEnabled(true);
    }
        

}
