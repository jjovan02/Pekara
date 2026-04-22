package style;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class Stil {


    public static final Color PLAVA         = new Color(26, 58, 92);
    public static final Color PLAVA_HOVER   = new Color(41, 91, 145);
    public static final Color PLAVA_SVETLA  = new Color(235, 241, 248);
    public static final Color CRVENA        = new Color(180, 30, 30);
    public static final Color CRVENA_HOVER  = new Color(220, 50, 50);
    public static final Color POZADINA      = new Color(245, 245, 245);
    public static final Color SIVA_BORDER   = new Color(180, 180, 180);
    public static final Color BELA          = Color.WHITE;
    public static final Color TEKST_TAMNI   = new Color(30, 30, 30);


    public static final Font FONT_NORMAL  = new Font("Segoe UI", Font.PLAIN, 13);
    public static final Font FONT_BOLD    = new Font("Segoe UI", Font.BOLD, 13);
    public static final Font FONT_NASLOV  = new Font("Segoe UI", Font.BOLD, 16);
    public static final Font FONT_DUGME   = new Font("Segoe UI", Font.BOLD, 12);
    public static final Font FONT_TABELA  = new Font("Segoe UI", Font.PLAIN, 12);
    public static final Font FONT_HEADER  = new Font("Segoe UI", Font.BOLD, 12);


    public static void plavo(JButton btn) {
        primeniDugme(btn, PLAVA, PLAVA_HOVER);
    }


    public static void crveno(JButton btn) {
        primeniDugme(btn, CRVENA, CRVENA_HOVER);
    }


    private static void primeniDugme(JButton btn, Color osnovna, Color hover) {
        btn.setBackground(osnovna);
        btn.setForeground(BELA);
        btn.setFont(FONT_DUGME);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setOpaque(true);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btn.setBackground(hover);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                btn.setBackground(osnovna);
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                btn.setBackground(osnovna.darker());
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
                btn.setBackground(hover);
            }
        });
    }

    
    public static void labela(JLabel lbl) {
        lbl.setFont(FONT_BOLD);
        lbl.setForeground(PLAVA);
    }


    public static void naslov(JLabel lbl) {
        lbl.setFont(FONT_NASLOV);
        lbl.setForeground(PLAVA);
        lbl.setHorizontalAlignment(JLabel.CENTER);
    }


    public static void iznosLabela(JLabel lbl) {
        lbl.setFont(FONT_BOLD);
        lbl.setForeground(PLAVA);
        lbl.setBackground(PLAVA_SVETLA);
        lbl.setOpaque(true);
        lbl.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(SIVA_BORDER, 1, true),
            BorderFactory.createEmptyBorder(4, 10, 4, 10)
        ));
    }


    public static void polje(JTextField txt) {
        txt.setFont(FONT_NORMAL);
        txt.setForeground(TEKST_TAMNI);
        txt.setBackground(BELA);
        txt.setCaretColor(PLAVA);
        txt.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(SIVA_BORDER, 1),
            BorderFactory.createEmptyBorder(5, 8, 5, 8)
        ));
    }


    public static void lozinka(JPasswordField txt) {
        txt.setFont(FONT_NORMAL);
        txt.setForeground(TEKST_TAMNI);
        txt.setBackground(BELA);
        txt.setCaretColor(PLAVA);
        txt.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(SIVA_BORDER, 1),
            BorderFactory.createEmptyBorder(5, 8, 5, 8)
        ));
    }


    public static void tabela(JTable tbl) {
        tbl.setFont(FONT_TABELA);
        tbl.setRowHeight(30);

        tbl.setBackground(BELA);
        tbl.setForeground(TEKST_TAMNI);
        tbl.setSelectionBackground(PLAVA);
        tbl.setSelectionForeground(BELA);
        tbl.setGridColor(new Color(220, 220, 220));

        tbl.setShowHorizontalLines(true);
        tbl.setShowVerticalLines(false);

        tbl.getTableHeader().setReorderingAllowed(false);

        tbl.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column);
                if (!isSelected) {
                    setBackground(row % 2 == 0 ? BELA : PLAVA_SVETLA);
                    setForeground(TEKST_TAMNI);
                } else {
                    setBackground(PLAVA);
                    setForeground(BELA);
                }
                setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 8));
                return this;
            }
        });

        
        JTableHeader header = tbl.getTableHeader();
        header.setFont(FONT_HEADER);
        header.setBackground(PLAVA);
        header.setForeground(BELA);
        header.setPreferredSize(new Dimension(header.getWidth(), 35));
        header.setBorder(BorderFactory.createLineBorder(PLAVA));
        ((DefaultTableCellRenderer) header.getDefaultRenderer())
            .setHorizontalAlignment(JLabel.LEFT);
    }
    

    public static void stilizujOptionPane() {

        javax.swing.UIManager.put("OptionPane.background", POZADINA);
        javax.swing.UIManager.put("Panel.background", POZADINA);

        javax.swing.UIManager.put("OptionPane.messageForeground", TEKST_TAMNI);
        javax.swing.UIManager.put("OptionPane.messageFont",new Font("Segoe UI", Font.PLAIN, 13));

        javax.swing.UIManager.put("OptionPane.buttonFont",new Font("Segoe UI", Font.BOLD, 12));
        javax.swing.UIManager.put("Button.background", PLAVA);
        javax.swing.UIManager.put("Button.foreground", BELA);
        javax.swing.UIManager.put("Button.focus",new Color(26, 58, 92, 0)); // ukloni focus border
        javax.swing.UIManager.put("Button.select", PLAVA.darker());

        javax.swing.UIManager.put("OptionPane.titleFont",new Font("Segoe UI", Font.BOLD, 13));


        javax.swing.UIManager.put("TextField.background", BELA);
        javax.swing.UIManager.put("TextField.foreground", TEKST_TAMNI);
        javax.swing.UIManager.put("TextField.font",new Font("Segoe UI", Font.PLAIN, 13));
        javax.swing.UIManager.put("TextField.caretForeground", PLAVA);
        
        
        javax.swing.UIManager.put("OptionPane.yesButtonText", "Da");
        javax.swing.UIManager.put("OptionPane.noButtonText", "Ne");
        javax.swing.UIManager.put("OptionPane.okButtonText", "U redu");
        javax.swing.UIManager.put("OptionPane.cancelButtonText", "Otkaži");
        
    }
    

    public static void kombo(javax.swing.JComboBox<?> cmb) {
        cmb.setFont(FONT_NORMAL);
        cmb.setBackground(BELA);
        cmb.setForeground(TEKST_TAMNI);
        cmb.setBorder(BorderFactory.createLineBorder(SIVA_BORDER, 1));
        cmb.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmb.setRenderer(new DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(
                    javax.swing.JList<?> list, Object value,
                    int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(
                    list, value, index, isSelected, cellHasFocus);
                setFont(FONT_NORMAL);
                setBorder(BorderFactory.createEmptyBorder(5, 8, 5, 8));
                if (isSelected) {
                    setBackground(PLAVA);
                    setForeground(BELA);
                } else {
                    setBackground(BELA);
                    setForeground(TEKST_TAMNI);
                }
                return this;
            }
        });
    }

    
    public static void meni(javax.swing.JMenuBar menuBar) {
        menuBar.setBackground(PLAVA);
        menuBar.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));
        menuBar.setOpaque(true);

        for (int i = 0; i < menuBar.getMenuCount(); i++) {
            javax.swing.JMenu menu = menuBar.getMenu(i);
            stilizujMenu(menu);
        }
    }


    private static void stilizujMenu(javax.swing.JMenu menu) {
        menu.setFont(FONT_BOLD);
        menu.setForeground(BELA);
        menu.setBackground(PLAVA);
        menu.setOpaque(true);
        menu.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        menu.setCursor(new Cursor(Cursor.HAND_CURSOR));

        menu.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                menu.setBackground(PLAVA_HOVER);
                menu.setOpaque(true);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                menu.setBackground(PLAVA);
            }
        });

        menu.getPopupMenu().setBackground(POZADINA);
        menu.getPopupMenu().setBorder(
            BorderFactory.createLineBorder(SIVA_BORDER, 1));

        for (int j = 0; j < menu.getItemCount(); j++) {
            javax.swing.JMenuItem item = menu.getItem(j);
            if (item != null) {
                stilizujMenuItem(item);
            }
        }
    }

    
    private static void stilizujMenuItem(javax.swing.JMenuItem item) {
        item.setFont(FONT_NORMAL);
        item.setForeground(TEKST_TAMNI);
        item.setBackground(POZADINA);
        item.setBorder(BorderFactory.createEmptyBorder(6, 15, 6, 15));
        item.setCursor(new Cursor(Cursor.HAND_CURSOR));
        item.setOpaque(true);

        item.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                item.setBackground(PLAVA_SVETLA);
                item.setForeground(PLAVA);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                item.setBackground(POZADINA);
                item.setForeground(TEKST_TAMNI);
            }
        });
    }

    
    public static void scrollPanel(javax.swing.JScrollPane scroll) {
        scroll.setBorder(BorderFactory.createLineBorder(SIVA_BORDER, 1));
        scroll.getViewport().setBackground(BELA);
        scroll.setBackground(BELA);
    }


    public static void pozadina(java.awt.Container container) {
        container.setBackground(POZADINA);
    }
    
    
}
