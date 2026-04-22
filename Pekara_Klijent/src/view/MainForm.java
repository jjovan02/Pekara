/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import style.Stil;
import javax.swing.JOptionPane;
import model.Pekar;

/**
 *
 * @author stari
 */
public class MainForm extends javax.swing.JFrame {

    private Pekar prijavljeniPekar;
    
    public MainForm(Pekar pekar) {
        this.prijavljeniPekar = pekar;
        initComponents();
        setTitle("Pekara - " + pekar.getIme() + " " + pekar.getPrezime());
        setLocationRelativeTo(null);
        setResizable(false);
        lblDobrodosli.setText("Dobrodošli, " + pekar.getIme() + " " + pekar.getPrezime() + "!");

        stilizuj();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHeader = new javax.swing.JPanel();
        lblNazivSistema = new javax.swing.JLabel();
        lblDobrodosli = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblInfo1 = new javax.swing.JLabel();
        lblInfo2 = new javax.swing.JLabel();
        lblInfo3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblAutor = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuDokumenti = new javax.swing.JMenu();
        miRacun = new javax.swing.JMenuItem();
        menuPruzalac = new javax.swing.JMenu();
        miPekar = new javax.swing.JMenuItem();
        menuPrimalac = new javax.swing.JMenu();
        miKupac = new javax.swing.JMenuItem();
        menuSifarnici = new javax.swing.JMenu();
        miPecivo = new javax.swing.JMenuItem();
        miSertifikat = new javax.swing.JMenuItem();
        miKategorijaKupca = new javax.swing.JMenuItem();
        menuOProgramu = new javax.swing.JMenu();
        miOProgramu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pekara");
        setPreferredSize(new java.awt.Dimension(900, 600));
        setResizable(false);

        pnlHeader.setBackground(new java.awt.Color(26, 58, 92));

        lblNazivSistema.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNazivSistema.setForeground(new java.awt.Color(255, 255, 255));
        lblNazivSistema.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNazivSistema.setText("Softverski sistem za praćenje rada pekare");

        lblDobrodosli.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDobrodosli.setForeground(new java.awt.Color(168, 196, 224));
        lblDobrodosli.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDobrodosli.setText("Dobrodošli!");

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDobrodosli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNazivSistema, javax.swing.GroupLayout.DEFAULT_SIZE, 825, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblNazivSistema)
                .addGap(18, 18, 18)
                .addComponent(lblDobrodosli)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        lblInfo1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblInfo1.setForeground(new java.awt.Color(26, 58, 92));
        lblInfo1.setText("Dokumenti — upravljanje računima");

        lblInfo2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblInfo2.setForeground(new java.awt.Color(26, 58, 92));
        lblInfo2.setText("Pružaoci i primaoci usluge — pekari i kupci");

        lblInfo3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblInfo3.setForeground(new java.awt.Color(26, 58, 92));
        lblInfo3.setText("Šifarnici — peciva, sertifikati, kategorije");

        lblAutor.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblAutor.setForeground(new java.awt.Color(136, 136, 136));
        lblAutor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAutor.setText("Jovan Janjušević | 2021/0172 | FON");

        menuDokumenti.setText("1. Dokumenti");

        miRacun.setText("1.1 Račun");
        miRacun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRacunActionPerformed(evt);
            }
        });
        menuDokumenti.add(miRacun);

        jMenuBar1.add(menuDokumenti);

        menuPruzalac.setText("2. Pružalac usluge");

        miPekar.setText("2.1 Pekar");
        miPekar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPekarActionPerformed(evt);
            }
        });
        menuPruzalac.add(miPekar);

        jMenuBar1.add(menuPruzalac);

        menuPrimalac.setText("3. Primalac usluge");

        miKupac.setText("3.1 Kupac");
        miKupac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miKupacActionPerformed(evt);
            }
        });
        menuPrimalac.add(miKupac);

        jMenuBar1.add(menuPrimalac);

        menuSifarnici.setText("4. Šifarnici");

        miPecivo.setText("4.1 Pecivo");
        miPecivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPecivoActionPerformed(evt);
            }
        });
        menuSifarnici.add(miPecivo);

        miSertifikat.setText("4.2 Sertifikat");
        miSertifikat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSertifikatActionPerformed(evt);
            }
        });
        menuSifarnici.add(miSertifikat);

        miKategorijaKupca.setText("4.3 Kategorija kupca");
        miKategorijaKupca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miKategorijaKupcaActionPerformed(evt);
            }
        });
        menuSifarnici.add(miKategorijaKupca);

        jMenuBar1.add(menuSifarnici);

        menuOProgramu.setText("5. O programu");
        menuOProgramu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOProgramuActionPerformed(evt);
            }
        });

        miOProgramu.setText("O programu");
        miOProgramu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miOProgramuActionPerformed(evt);
            }
        });
        menuOProgramu.add(miOProgramu);

        jMenuBar1.add(menuOProgramu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(lblInfo1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(lblInfo2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(lblInfo3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(lblAutor))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 837, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pnlHeader, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(lblInfo1)
                .addGap(37, 37, 37)
                .addComponent(lblInfo2)
                .addGap(37, 37, 37)
                .addComponent(lblInfo3)
                .addGap(48, 48, 48)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lblAutor)
                .addContainerGap(165, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miRacunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRacunActionPerformed
        new SviRacuniForm(prijavljeniPekar).setVisible(true);
    }//GEN-LAST:event_miRacunActionPerformed

    private void miPekarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPekarActionPerformed
        new SviPekariForm().setVisible(true);
    }//GEN-LAST:event_miPekarActionPerformed

    private void miPecivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPecivoActionPerformed
        new SvaPecivaForm().setVisible(true);
    }//GEN-LAST:event_miPecivoActionPerformed

    private void miSertifikatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSertifikatActionPerformed
        new SviSertifikatiForm().setVisible(true);
    }//GEN-LAST:event_miSertifikatActionPerformed

    private void miKategorijaKupcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miKategorijaKupcaActionPerformed
        new SveKategorijeKupcaForm().setVisible(true);
    }//GEN-LAST:event_miKategorijaKupcaActionPerformed

    private void menuOProgramuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOProgramuActionPerformed
        
    }//GEN-LAST:event_menuOProgramuActionPerformed

    private void miKupacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miKupacActionPerformed
        new SviKupciForm().setVisible(true);
    }//GEN-LAST:event_miKupacActionPerformed

    private void miOProgramuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miOProgramuActionPerformed
        JOptionPane.showMessageDialog(this,
        "Softverski sistem za praćenje rada pekare\n" +
        "Autor: Jovan Janjušević\n" +
        "Broj indeksa: 2021/0172\n" +
        "Mentor: prof. dr Siniša Vlajić",
        "O programu", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_miOProgramuActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblDobrodosli;
    private javax.swing.JLabel lblInfo1;
    private javax.swing.JLabel lblInfo2;
    private javax.swing.JLabel lblInfo3;
    private javax.swing.JLabel lblNazivSistema;
    private javax.swing.JMenu menuDokumenti;
    private javax.swing.JMenu menuOProgramu;
    private javax.swing.JMenu menuPrimalac;
    private javax.swing.JMenu menuPruzalac;
    private javax.swing.JMenu menuSifarnici;
    private javax.swing.JMenuItem miKategorijaKupca;
    private javax.swing.JMenuItem miKupac;
    private javax.swing.JMenuItem miOProgramu;
    private javax.swing.JMenuItem miPecivo;
    private javax.swing.JMenuItem miPekar;
    private javax.swing.JMenuItem miRacun;
    private javax.swing.JMenuItem miSertifikat;
    private javax.swing.JPanel pnlHeader;
    // End of variables declaration//GEN-END:variables

    private void stilizuj() {
        Stil.meni(jMenuBar1);
        Stil.pozadina(getContentPane());

        pnlHeader.setBackground(Stil.PLAVA);

        lblNazivSistema.setForeground(Stil.BELA);
        lblNazivSistema.setFont(Stil.FONT_NASLOV);
        lblDobrodosli.setForeground(new java.awt.Color(168, 196, 224));
        lblDobrodosli.setFont(Stil.FONT_NORMAL);

        Stil.labela(lblInfo1);
        Stil.labela(lblInfo2);
        Stil.labela(lblInfo3);

        lblAutor.setForeground(new java.awt.Color(136, 136, 136));
        lblAutor.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 11));   
    
    }
}
