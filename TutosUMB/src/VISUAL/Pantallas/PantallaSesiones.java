/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISUAL.Pantallas;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tutaa
 */
public class PantallaSesiones extends javax.swing.JFrame {

    private final class DefaultTableModelExtension extends javax.swing.table.DefaultTableModel {
        Class[] types = new Class[] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
        };
        boolean[] canEdit = new boolean[] {
                false, false, false
        };

        private DefaultTableModelExtension(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }

        public Class getColumnClass(int columnIndex) {
            return types[columnIndex];
        }

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit[columnIndex];
        }
    }

    DefaultTableModel modelo = new DefaultTableModel();

    public PantallaSesiones() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("SESIONES PROGRAMADAS");
        this.setResizable(false);
        cargarModelo();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/VISUAL/Imagenes/Logos/icon.png")));
    }

    private void cargarModelo() {
        try {
            modelo.addColumn("MATERIA");
            modelo.addColumn("LINK");
            modelo.addColumn("FECHA");
            tbSesionesProgramadas.setModel(modelo);
            cargarArchivo();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "DEBE PRIMERO AGENDAR SU SESIÓN.");
        }
    }

    private void cargarArchivo() throws IOException {
        String fila[];
        try {
            FileReader archivo = new FileReader("SesionesProgramadas.txt");
            try (BufferedReader lectura = new BufferedReader(archivo)) {
                String linea = lectura.readLine();

                while (linea != null) {
                    fila = linea.split("%");
                    modelo.addRow(fila);
                    linea = lectura.readLine();
                }
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "DEBE PRIMERO AGENDAR SU SESIÓN.");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        popupMenu2 = new java.awt.PopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSesionesProgramadas = new javax.swing.JTable();
        canvas1 = new java.awt.Canvas();
        btnCuenta = new javax.swing.JButton();
        btnCalendario = new javax.swing.JButton();
        btnSesiones = new javax.swing.JButton();
        btnCambiarCuenta = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        popupMenu1.setLabel("popupMenu1");

        popupMenu2.setLabel("popupMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(247, 251, 252));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(118, 159, 205));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Textos/imgBandejaDeEntrada (Teléfono).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, -1));

        tbSesionesProgramadas.setBackground(new java.awt.Color(214, 230, 242));
        tbSesionesProgramadas.setForeground(new java.awt.Color(51, 51, 51));
        tbSesionesProgramadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "MATERIA", "MENSAJE", "FECHA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbSesionesProgramadas.setColumnSelectionAllowed(true);
        tbSesionesProgramadas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbSesionesProgramadas);
        tbSesionesProgramadas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tbSesionesProgramadas.getColumnModel().getColumnCount() > 0) {
            tbSesionesProgramadas.getColumnModel().getColumn(0).setResizable(false);
            tbSesionesProgramadas.getColumnModel().getColumn(1).setResizable(false);
            tbSesionesProgramadas.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 132, 588, 340));
        jPanel1.add(canvas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(871, 508, -1, -1));

        btnCuenta.setBackground(new java.awt.Color(185, 215, 234));
        btnCuenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCuenta.setForeground(new java.awt.Color(66, 120, 181));
        btnCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivo/notebook.png"))); // NOI18N
        btnCuenta.setText("CUENTA");
        btnCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuentaActionPerformed(evt);
            }
        });
        jPanel1.add(btnCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 15, 209, 97));

        btnCalendario.setBackground(new java.awt.Color(185, 215, 234));
        btnCalendario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCalendario.setForeground(new java.awt.Color(66, 120, 181));
        btnCalendario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivo/calendar.png"))); // NOI18N
        btnCalendario.setText("CALENDARIO");
        btnCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalendarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnCalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 118, 209, 97));

        btnSesiones.setBackground(new java.awt.Color(185, 215, 234));
        btnSesiones.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSesiones.setForeground(new java.awt.Color(66, 120, 181));
        btnSesiones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivo/message.png"))); // NOI18N
        btnSesiones.setText("SESIONES");
        btnSesiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSesionesActionPerformed(evt);
            }
        });
        jPanel1.add(btnSesiones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 221, 209, 97));

        btnCambiarCuenta.setBackground(new java.awt.Color(185, 215, 234));
        btnCambiarCuenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCambiarCuenta.setForeground(new java.awt.Color(66, 120, 181));
        btnCambiarCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivo/arrows.png"))); // NOI18N
        btnCambiarCuenta.setText("CAMBIAR CUENTA");
        btnCambiarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarCuentaActionPerformed(evt);
            }
        });
        jPanel1.add(btnCambiarCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 324, -1, 97));

        btnCerrar.setBackground(new java.awt.Color(185, 215, 234));
        btnCerrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(66, 120, 181));
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivo/close.png"))); // NOI18N
        btnCerrar.setText("CERRAR");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 427, 209, 97));

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(118, 159, 205));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Logos/imgUMBPequeño.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, 100, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCuentaActionPerformed(java.awt.event.ActionEvent evt) {
        PantallaCuenta cuenta = new PantallaCuenta();
        cuenta.setVisible(true);
        this.setVisible(false);
    }

    private void btnCalendarioActionPerformed(java.awt.event.ActionEvent evt) {
        PantallaCalendario cal = new PantallaCalendario();
        cal.setVisible(true);
        this.setVisible(false);
    }

    private void btnSesionesActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(null, "YA SE ENCUENTRA EN ESTA PESTAÑA");
    }

    private void btnCambiarCuentaActionPerformed(java.awt.event.ActionEvent evt) {
        PantallaInicio pantalla = new PantallaInicio();
        pantalla.setVisible(true);
        this.setVisible(false);
    }

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaSesiones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalendario;
    private javax.swing.JButton btnCambiarCuenta;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCuenta;
    private javax.swing.JButton btnSesiones;
    private java.awt.Canvas canvas1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.PopupMenu popupMenu1;
    private java.awt.PopupMenu popupMenu2;
    private javax.swing.JTable tbSesionesProgramadas;
    // End of variables declaration//GEN-END:variables
}
