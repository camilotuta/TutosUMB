/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISUAL.Pantallas.Profesor;

import VISUAL.Pantallas.General.PantallaInicio;
import VISUAL.Pantallas.General.PantallaRegistro;
import CODE.Clases.Conexion;

import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

import java.sql.*;

/**
 *
 * @author tutaa
 */
public class PantallaCuentaProfesor extends javax.swing.JFrame {

    /**
     * Creates new form Cuenta
     */

    Conexion cx = new Conexion();

    public PantallaCuentaProfesor() {
        initComponents();

        this.setLocationRelativeTo(null);
        this.setTitle("PERFIL");
        this.setResizable(false);

        jTxtMostrarBiografia.setLineWrap(true);
        jTxtMostrarBiografia.setBorder(new EmptyBorder(0, 0, 0, 0));
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/VISUAL/Imagenes/Logos/icon.png")));

        mostrarDatosUsuario();
        habilitarBotonGuardar();
        habilitarBotonCancelar();
    }

    public void habilitarBotonGuardar() {
        if (tfBiografia.getText().length() < 10) {
            btnGuardar.setEnabled(false);
        } else {
            btnGuardar.setEnabled(true);
        }
    }

    public void habilitarBotonCancelar() {
        if (tfBiografia.getText().length() < 1) {
            btnCancelar.setEnabled(false);
        } else {
            btnCancelar.setEnabled(true);
        }
    }

    public void mostrarDatosUsuario() {
        String correoBuscar = PantallaRegistro.correoPoner;
        try {
            cx.con = Conexion.getConection();
            cx.ps = cx.con.prepareStatement("SELECT nombre, correo, biografia FROM usuarios WHERE correo = ?");
            cx.ps.setString(1, correoBuscar);

            cx.rs = cx.ps.executeQuery();
            if (cx.rs.next()) {
                txtMostrarNombre.setText(cx.rs.getString("nombre"));
                txtMostrarCorreo.setText(cx.rs.getString("correo"));
                jTxtMostrarBiografia.setText(cx.rs.getString("biografia"));
            } else {
                JOptionPane.showMessageDialog(null, "NO HAY RESULTADOS.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                if (cx.con != null) {
                    cx.con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void actualizarBiografia() {
        cx.con = Conexion.getConection();
        try {
            String sql = "UPDATE usuarios SET biografia = ? WHERE correo = ?";
            cx.ps = cx.con.prepareStatement(sql);
            cx.ps.setString(1, tfBiografia.getText());
            cx.ps.setString(2, txtMostrarCorreo.getText());

            cx.ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (cx.con != null) {
                    cx.con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        mostrarDatosUsuario();
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        canvas1 = new java.awt.Canvas();
        btnCuenta = new javax.swing.JButton();
        btnSesiones = new javax.swing.JButton();
        btnCambiarCuenta = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnCalendario = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tfBiografia = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        txtMostrarCorreo = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtMostrarNombre = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnPanelDeControl = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTxtMostrarBiografia = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(254, 251, 240));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(101, 67, 33));
        jLabel1.setText("Biografía:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, -1, -1));
        jPanel1.add(canvas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 553, -1, -1));

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
        btnSesiones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Botones/imgSesiones.png"))); // NOI18N
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
        btnCambiarCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Botones/imgCambiarCuenta.png"))); // NOI18N
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
        btnCalendario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Botones/imgCalendario.png"))); // NOI18N
        btnCalendario.setText("CALENDARIO");
        btnCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalendarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnCalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 118, 210, 97));

        tfBiografia.setBackground(java.awt.Color.lightGray);
        tfBiografia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfBiografiaKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tfBiografia);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 419, 311, 60));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(101, 67, 33));
        jLabel3.setText("Correo:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 192, -1, -1));

        txtMostrarCorreo.setFont(new java.awt.Font("Arial Narrow", 2, 18)); // NOI18N
        txtMostrarCorreo.setForeground(new java.awt.Color(101, 67, 33));
        txtMostrarCorreo.setText(" ");
        jPanel1.add(txtMostrarCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 192, 290, -1));

        btnGuardar.setBackground(new java.awt.Color(212, 248, 215));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(101, 67, 33));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 499, 113, 37));

        btnCancelar.setBackground(new java.awt.Color(212, 248, 215));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(101, 67, 33));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 499, 113, 37));

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(101, 67, 33));
        jLabel7.setText("Nombre:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 132, -1, -1));

        txtMostrarNombre.setFont(new java.awt.Font("Arial Narrow", 2, 18)); // NOI18N
        txtMostrarNombre.setForeground(new java.awt.Color(101, 67, 33));
        txtMostrarNombre.setText(" ");
        jPanel1.add(txtMostrarNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 132, 290, -1));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(101, 67, 33));
        jLabel4.setText("Cambiar biografía:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 389, -1, -1));

        btnPanelDeControl.setBackground(new java.awt.Color(212, 248, 215));
        btnPanelDeControl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnPanelDeControl.setForeground(new java.awt.Color(101, 67, 33));
        btnPanelDeControl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Botones/imgComputerPequeño.png"))); // NOI18N
        btnPanelDeControl.setText("Panel de Control");
        btnPanelDeControl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPanelDeControlActionPerformed(evt);
            }
        });
        jPanel1.add(btnPanelDeControl, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 420, 250, 110));

        jTxtMostrarBiografia.setEditable(false);
        jTxtMostrarBiografia.setBackground(java.awt.Color.lightGray);
        jTxtMostrarBiografia.setColumns(1);
        jTxtMostrarBiografia.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jTxtMostrarBiografia.setForeground(new java.awt.Color(101, 67, 33));
        jTxtMostrarBiografia.setRows(3);
        jScrollPane1.setViewportView(jTxtMostrarBiografia);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 390, 80));

        jLabel8.setFont(new java.awt.Font("Crabs", 1, 100)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(101, 67, 33));
        jLabel8.setText("Perfil");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Logos/imgUMBPequeñoProfesor.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPanelDeControlActionPerformed(java.awt.event.ActionEvent evt) {
        PantallaPanelDeControlProfesor pPan = new PantallaPanelDeControlProfesor();
        pPan.setVisible(true);
        this.setVisible(false);
    }

    private void tfBiografiaKeyReleased(java.awt.event.KeyEvent evt) {
        habilitarBotonGuardar();
        habilitarBotonCancelar();
    }

    private void btnCuentaActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(null, "YA SE ENCUENTRA EN ESTA PESTAÑA");
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

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {
        actualizarBiografia();
        JOptionPane.showMessageDialog(null, "GUARDADO CORRECTAMENTE.");
        tfBiografia.setText("");
        habilitarBotonCancelar();
        habilitarBotonGuardar();
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        tfBiografia.setText("");
        habilitarBotonGuardar();
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
            java.util.logging.Logger.getLogger(PantallaCuentaProfesor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaCuentaProfesor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaCuentaProfesor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaCuentaProfesor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new PantallaCuentaProfesor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalendario;
    private javax.swing.JButton btnCambiarCuenta;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCuenta;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnPanelDeControl;
    private javax.swing.JButton btnSesiones;
    private java.awt.Canvas canvas1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTxtMostrarBiografia;
    private javax.swing.JTextPane tfBiografia;
    private javax.swing.JLabel txtMostrarCorreo;
    private javax.swing.JLabel txtMostrarNombre;
    // End of variables declaration//GEN-END:variables
}
