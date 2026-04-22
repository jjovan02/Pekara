
package view;

import javax.swing.JOptionPane;
import style.Stil;
import threads.ServerThread;


public class FrmMain extends javax.swing.JFrame {

    private threads.ServerThread serverThread;
    public FrmMain() {
        initComponents();
        setTitle("Pekara - Server");
        setLocationRelativeTo(null);
        setResizable(false);
        miStopServer.setEnabled(false);
        stilizuj();
        
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblStatus = new javax.swing.JLabel();
        pnlHeader = new javax.swing.JMenuBar();
        menuServer = new javax.swing.JMenu();
        miStartServer = new javax.swing.JMenuItem();
        miStopServer = new javax.swing.JMenuItem();
        menuKonfiguracija = new javax.swing.JMenu();
        miDBConfig = new javax.swing.JMenuItem();
        miServerConfig = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblStatus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatus.setText("Server nije pokrenut");

        menuServer.setText("Server");

        miStartServer.setText("Start server");
        miStartServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miStartServerActionPerformed(evt);
            }
        });
        menuServer.add(miStartServer);

        miStopServer.setText("Stop server");
        miStopServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miStopServerActionPerformed(evt);
            }
        });
        menuServer.add(miStopServer);

        pnlHeader.add(menuServer);

        menuKonfiguracija.setText("Konfiguracija");

        miDBConfig.setText("Konfiguracija baze podataka");
        miDBConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDBConfigActionPerformed(evt);
            }
        });
        menuKonfiguracija.add(miDBConfig);

        miServerConfig.setText("Konfiguracija servera");
        miServerConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miServerConfigActionPerformed(evt);
            }
        });
        menuKonfiguracija.add(miServerConfig);

        pnlHeader.add(menuKonfiguracija);

        setJMenuBar(pnlHeader);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miStopServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miStopServerActionPerformed
        if (serverThread != null && serverThread.getServerSocket() != null) {
            try {
                serverThread.getServerSocket().close();
                miStartServer.setEnabled(true);
                miStopServer.setEnabled(false);
                lblStatus.setText("Server je zaustavljen.");
                lblStatus.setForeground(new java.awt.Color(180, 30, 30));
                JOptionPane.showMessageDialog(this, "Server je zaustavljen.", "Info", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Greška: " + ex.getMessage(),"Greška", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_miStopServerActionPerformed

    private void miStartServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miStartServerActionPerformed
        if (serverThread == null || !serverThread.isAlive()) {
            try {
                serverThread = new threads.ServerThread();
                serverThread.start();
                miStartServer.setEnabled(false);
                miStopServer.setEnabled(true);
                lblStatus.setText("Server je pokrenut i čeka klijente...");
                lblStatus.setForeground(new java.awt.Color(0, 128, 0));
                JOptionPane.showMessageDialog(this,"Server je uspešno pokrenut!", "Info", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,"Greška pri pokretanju servera: " + ex.getMessage(),"Greška", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_miStartServerActionPerformed

    private void miDBConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDBConfigActionPerformed
        DBConfigForm f = new DBConfigForm(this, true);
        f.setVisible(true);

    }//GEN-LAST:event_miDBConfigActionPerformed

    private void miServerConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miServerConfigActionPerformed
        ServerConfigForm f = new ServerConfigForm(this, true);
        f.setVisible(true);

    }//GEN-LAST:event_miServerConfigActionPerformed


public static void main(String args[]) {
    Stil.stilizujOptionPane();
    java.awt.EventQueue.invokeLater(() -> new FrmMain().setVisible(true));
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblStatus;
    private javax.swing.JMenu menuKonfiguracija;
    private javax.swing.JMenu menuServer;
    private javax.swing.JMenuItem miDBConfig;
    private javax.swing.JMenuItem miServerConfig;
    private javax.swing.JMenuItem miStartServer;
    private javax.swing.JMenuItem miStopServer;
    private javax.swing.JMenuBar pnlHeader;
    // End of variables declaration//GEN-END:variables

    private void stilizuj() {
        getContentPane().setBackground(new java.awt.Color(245, 245, 245));
        lblStatus.setForeground(new java.awt.Color(180, 30, 30));
        Stil.stilizujOptionPane();
        Stil.meni(pnlHeader);
        Stil.pozadina(getContentPane());
        pnlHeader.setBackground(Stil.PLAVA);
        Stil.naslov(lblStatus);    
    }
    
    
}
