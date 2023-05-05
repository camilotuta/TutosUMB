/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISUAL.Pantallas.Estudiante;

import VISUAL.Pantallas.General.PantallaInicio;
import CODE.Clases.Conexion;
import java.awt.Toolkit;
import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import CODE.Clases.Servidor;
import java.io.IOException;

/**
 *
 * @author tutaa
 */
public class PantallaPanelDeControlEstudiante extends javax.swing.JFrame {

    DefaultTableModel modelo;
    Servidor server;
    Thread t;

    /**
     * Creates new form PantallaListaEstudiantes
     */
    public PantallaPanelDeControlEstudiante() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("PANEL DE CONTROL ESTUDIANTIL");
        this.setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/VISUAL/Imagenes/Logos/icon.png")));

        setLocationRelativeTo(null);
        consultar();

        pararServer();

        server = new Servidor(6000);
        t = new Thread(server);
        t.start();
    }

    void consultar() {
        Conexion cx = new Conexion();
        String sql = "select * from usuarios";
        try {
            cx.con = Conexion.getConection();
            cx.stmt = cx.con.createStatement();
            cx.rs = cx.stmt.executeQuery(sql);
            Object[] cliente = new Object[1];
            modelo = (DefaultTableModel) tbListaEstudiantes.getModel();
            modelo.setRowCount(0); // limpiar la tabla antes de agregar nuevas filas
            while (cx.rs.next()) {
                cliente[0] = cx.rs.getString("nombre");
                modelo.addRow(cliente);
            }
            tbListaEstudiantes.setModel(modelo);
            tbListaEstudiantes.setEnabled(false);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar la base de datos: " + e.getMessage());
        } finally {
            // cerrar la conexión y liberar los recursos
            try {
                if (cx.rs != null) {
                    cx.rs.close();
                }
                if (cx.stmt != null) {
                    cx.stmt.close();
                }
                if (cx.con != null) {
                    cx.con.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage());
            }
        }
    }

    public void pararServer() {
        if (server != null && t != null) {
            try {
                // Cierra el socket del servidor
                Servidor.server.close();
                // Detiene el hilo del servidor
                t.interrupt();
            } catch (IOException e) {
                // Manejar excepción en caso de error al cerrar el socket
                e.printStackTrace();
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        canvas1 = new java.awt.Canvas();
        btnCuenta = new javax.swing.JButton();
        btnSesiones = new javax.swing.JButton();
        btnCambiarCuenta = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnCalendario = new javax.swing.JButton();
        btnTusTareas = new javax.swing.JButton();
        btnNuevoChat = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbListaEstudiantes = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        btnJugarTriki = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(247, 251, 252));

        btnCuenta.setBackground(new java.awt.Color(185, 215, 234));
        btnCuenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCuenta.setForeground(new java.awt.Color(66, 120, 181));
        btnCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Botones/imgCuenta.png"))); // NOI18N
        btnCuenta.setText("CUENTA");
        btnCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuentaActionPerformed(evt);
            }
        });

        btnSesiones.setBackground(new java.awt.Color(185, 215, 234));
        btnSesiones.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSesiones.setForeground(new java.awt.Color(66, 120, 181));
        btnSesiones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Botones/imgSesiones.png"))); // NOI18N
        btnSesiones.setText("SESIONES");
        btnSesiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSesionesActionPerformed(evt);
            }
        });

        btnCambiarCuenta.setBackground(new java.awt.Color(185, 215, 234));
        btnCambiarCuenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCambiarCuenta.setForeground(new java.awt.Color(66, 120, 181));
        btnCambiarCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Botones/imgCambiarCuenta.png"))); // NOI18N
        btnCambiarCuenta.setText("CAMBIAR CUENTA");
        btnCambiarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarCuentaActionPerformed(evt);
            }
        });

        btnCerrar.setBackground(new java.awt.Color(185, 215, 234));
        btnCerrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(66, 120, 181));
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Botones/imgCerrar.png"))); // NOI18N
        btnCerrar.setText("CERRAR");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnCalendario.setBackground(new java.awt.Color(185, 215, 234));
        btnCalendario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCalendario.setForeground(new java.awt.Color(66, 120, 181));
        btnCalendario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Botones/imgCalendario.png"))); // NOI18N
        btnCalendario.setText("CALENDARIO");
        btnCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalendarioActionPerformed(evt);
            }
        });

        btnTusTareas.setBackground(new java.awt.Color(185, 215, 234));
        btnTusTareas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTusTareas.setForeground(new java.awt.Color(66, 120, 181));
        btnTusTareas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Botones/imgCheck.png"))); // NOI18N
        btnTusTareas.setText("TUS TAREAS");
        btnTusTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTusTareasActionPerformed(evt);
            }
        });

        btnNuevoChat.setBackground(new java.awt.Color(185, 215, 234));
        btnNuevoChat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNuevoChat.setForeground(new java.awt.Color(66, 120, 181));
        btnNuevoChat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Botones/img@.png"))); // NOI18N
        btnNuevoChat.setText("NUEVO CHAT");
        btnNuevoChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoChatActionPerformed(evt);
            }
        });

        tbListaEstudiantes.setBackground(new java.awt.Color(247, 251, 252));
        tbListaEstudiantes.setForeground(new java.awt.Color(118, 159, 205));
        tbListaEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE"
            }
        ));
        jScrollPane1.setViewportView(tbListaEstudiantes);
        if (tbListaEstudiantes.getColumnModel().getColumnCount() > 0) {
            tbListaEstudiantes.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(118, 159, 205));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Logos/imgUMBPequeño.png"))); // NOI18N

        btnJugarTriki.setBackground(new java.awt.Color(185, 215, 234));
        btnJugarTriki.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnJugarTriki.setForeground(new java.awt.Color(66, 120, 181));
        btnJugarTriki.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Botones/imgJuego.png"))); // NOI18N
        btnJugarTriki.setText("JUGAR TRIKI");
        btnJugarTriki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarTrikiActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Crabs", 1, 50)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(118, 159, 205));
        jLabel11.setText("ToDoUMB");

        jLabel12.setFont(new java.awt.Font("Crabs", 1, 75)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(118, 159, 205));
        jLabel12.setText("Panel de Control");

        jLabel13.setFont(new java.awt.Font("Crabs", 1, 46)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(118, 159, 205));
        jLabel13.setText("Lista");

        jLabel14.setFont(new java.awt.Font("Crabs", 1, 50)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(118, 159, 205));
        jLabel14.setText("Juegos");

        jLabel15.setFont(new java.awt.Font("Crabs", 1, 50)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(118, 159, 205));
        jLabel15.setText("Chat");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSesiones, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCambiarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnNuevoChat)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(70, 70, 70)
                                        .addComponent(jLabel15)))
                                .addGap(13, 13, 13)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(jLabel14))
                                    .addComponent(btnJugarTriki)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel11))
                                    .addComponent(btnTusTareas, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel13))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 24, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnSesiones, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnCambiarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel12))
                    .addComponent(jLabel9))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnNuevoChat, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnJugarTriki, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(btnTusTareas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel13)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1010, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 551, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCuentaActionPerformed(java.awt.event.ActionEvent evt) {
        PantallaCuentaEstudiante pp = new PantallaCuentaEstudiante();
        pp.setVisible(true);
        this.setVisible(false);

    }

    private void btnCalendarioActionPerformed(java.awt.event.ActionEvent evt) {
        PantallaCalendarioEstudiante pc = new PantallaCalendarioEstudiante();
        pc.setVisible(true);
        this.setVisible(false);
    }

    private void btnSesionesActionPerformed(java.awt.event.ActionEvent evt) {
        PantallaSesionesEstudiante ps = new PantallaSesionesEstudiante();
        ps.setVisible(true);
        this.setVisible(false);
    }

    private void btnCambiarCuentaActionPerformed(java.awt.event.ActionEvent evt) {
        PantallaInicio pi = new PantallaInicio();
        pi.setVisible(true);
        this.setVisible(false);
    }

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void btnNuevoChatActionPerformed(java.awt.event.ActionEvent evt) {
        PantallaChatEstudiante pc = new PantallaChatEstudiante();

        server.addObserver(pc);
        pc.setVisible(true);
    }

    private void btnJugarTrikiActionPerformed(java.awt.event.ActionEvent evt) {
        PantallaTrikiEstudiante pt = new PantallaTrikiEstudiante();
        pt.setVisible(true);
        this.setVisible(false);
    }

    private void btnTusTareasActionPerformed(java.awt.event.ActionEvent evt) {
        PantallaToDoUMBEstudiante ptd = new PantallaToDoUMBEstudiante();
        ptd.setVisible(true);
        this.setVisible(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaPanelDeControlEstudiante.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPanelDeControlEstudiante.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPanelDeControlEstudiante.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPanelDeControlEstudiante.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaPanelDeControlEstudiante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalendario;
    private javax.swing.JButton btnCambiarCuenta;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCuenta;
    private javax.swing.JButton btnJugarTriki;
    private javax.swing.JButton btnNuevoChat;
    private javax.swing.JButton btnSesiones;
    private javax.swing.JButton btnTusTareas;
    private java.awt.Canvas canvas1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbListaEstudiantes;
    // End of variables declaration//GEN-END:variables
}
