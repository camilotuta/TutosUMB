/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISUAL.Pantallas.Profesor;

import VISUAL.Pantallas.General.PantallaInicio;
import VISUAL.Pantallas.Estudiante.*;
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
public class PantallaPanelDeControlProfesor extends javax.swing.JFrame {

    DefaultTableModel modelo;
    Servidor server;
    Thread t;

    /**
     * Creates new form PantallaPanelDeControlProfesor
     */
    public PantallaPanelDeControlProfesor() {
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
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCuenta = new javax.swing.JButton();
        btnSesiones = new javax.swing.JButton();
        btnCambiarCuenta = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnCalendario = new javax.swing.JButton();
        btnTusTareas = new javax.swing.JButton();
        btnNuevoChat = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbListaEstudiantes = new javax.swing.JTable();
        btnJugarTriki = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(254, 251, 240));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCuenta.setBackground(new java.awt.Color(212, 248, 215));
        btnCuenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCuenta.setForeground(new java.awt.Color(101, 67, 33));
        btnCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Botones/imgCuenta.png"))); // NOI18N
        btnCuenta.setText("CUENTA");
        btnCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuentaActionPerformed(evt);
            }
        });
        jPanel1.add(btnCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 15, 210, 97));

        btnSesiones.setBackground(new java.awt.Color(212, 248, 215));
        btnSesiones.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSesiones.setForeground(new java.awt.Color(101, 67, 33));
        btnSesiones
                .setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Botones/imgSesiones.png"))); // NOI18N
        btnSesiones.setText("SESIONES");
        btnSesiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSesionesActionPerformed(evt);
            }
        });
        jPanel1.add(btnSesiones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 221, 210, 97));

        btnCambiarCuenta.setBackground(new java.awt.Color(212, 248, 215));
        btnCambiarCuenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCambiarCuenta.setForeground(new java.awt.Color(101, 67, 33));
        btnCambiarCuenta.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Botones/imgCambiarCuenta.png"))); // NOI18N
        btnCambiarCuenta.setText("CAMBIAR CUENTA");
        btnCambiarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarCuentaActionPerformed(evt);
            }
        });
        jPanel1.add(btnCambiarCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 324, 210, 97));

        btnCerrar.setBackground(new java.awt.Color(212, 248, 215));
        btnCerrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(101, 67, 33));
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Botones/imgCerrar.png"))); // NOI18N
        btnCerrar.setText("CERRAR");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 427, 210, 97));

        btnCalendario.setBackground(new java.awt.Color(212, 248, 215));
        btnCalendario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCalendario.setForeground(new java.awt.Color(101, 67, 33));
        btnCalendario.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Botones/imgCalendario.png"))); // NOI18N
        btnCalendario.setText("CALENDARIO");
        btnCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalendarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnCalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 118, 210, 97));

        btnTusTareas.setBackground(new java.awt.Color(212, 248, 215));
        btnTusTareas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTusTareas.setForeground(new java.awt.Color(101, 67, 33));
        btnTusTareas
                .setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Botones/imgCheck.png"))); // NOI18N
        btnTusTareas.setText("TUS TAREAS");
        btnTusTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTusTareasActionPerformed(evt);
            }
        });
        jPanel1.add(btnTusTareas, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, 240, 100));

        btnNuevoChat.setBackground(new java.awt.Color(212, 248, 215));
        btnNuevoChat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNuevoChat.setForeground(new java.awt.Color(101, 67, 33));
        btnNuevoChat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Botones/img@.png"))); // NOI18N
        btnNuevoChat.setText("NUEVO CHAT");
        btnNuevoChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoChatActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevoChat, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, -1, 100));

        tbListaEstudiantes.setBackground(new java.awt.Color(254, 251, 240));
        tbListaEstudiantes.setForeground(new java.awt.Color(101, 67, 33));
        tbListaEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "NOMBRE"
                }));
        jScrollPane1.setViewportView(tbListaEstudiantes);
        if (tbListaEstudiantes.getColumnModel().getColumnCount() > 0) {
            tbListaEstudiantes.getColumnModel().getColumn(0).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 170, 220, 330));

        btnJugarTriki.setBackground(new java.awt.Color(212, 248, 215));
        btnJugarTriki.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnJugarTriki.setForeground(new java.awt.Color(101, 67, 33));
        btnJugarTriki
                .setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Botones/imgJuego.png"))); // NOI18N
        btnJugarTriki.setText("JUGAR TRIKI");
        btnJugarTriki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarTrikiActionPerformed(evt);
            }
        });
        jPanel1.add(btnJugarTriki, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, -1, 100));

        jLabel12.setFont(new java.awt.Font("Crabs", 1, 75)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(101, 67, 33));
        jLabel12.setText("Panel de Control");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));

        jLabel15.setFont(new java.awt.Font("Crabs", 1, 50)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(101, 67, 33));
        jLabel15.setText("Chat");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, -1, -1));

        jLabel14.setFont(new java.awt.Font("Crabs", 1, 50)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(101, 67, 33));
        jLabel14.setText("Juegos");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, -1, -1));

        jLabel13.setFont(new java.awt.Font("Crabs", 1, 46)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(101, 67, 33));
        jLabel13.setText("Lista");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 120, -1, -1));

        jLabel11.setFont(new java.awt.Font("Crabs", 1, 50)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(101, 67, 33));
        jLabel11.setText("ToDoUMB");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, -1, -1));

        jLabel3.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Logos/imgUMBPequeñoProfesor.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 0, 100, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1010, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 551, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCuentaActionPerformed(java.awt.event.ActionEvent evt) {
        PantallaCuentaProfesor pp = new PantallaCuentaProfesor();
        pp.setVisible(true);
        this.setVisible(false);

    }

    private void btnCalendarioActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void btnSesionesActionPerformed(java.awt.event.ActionEvent evt) {
        PantallaSesionesProfesor ps = new PantallaSesionesProfesor();
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

    @SuppressWarnings("deprecation")
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
        PantallaToDoUMBProfesor ptd = new PantallaToDoUMBProfesor();
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
            java.util.logging.Logger.getLogger(PantallaPanelDeControlProfesor.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPanelDeControlProfesor.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPanelDeControlProfesor.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPanelDeControlProfesor.class.getName())
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
                new PantallaPanelDeControlProfesor().setVisible(true);
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
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbListaEstudiantes;
    // End of variables declaration//GEN-END:variables
}
