/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISUAL.Pantallas.Profesor;

import VISUAL.Pantallas.General.PantallaInicio;
import java.awt.Toolkit;

/**
 *
 * @author tutaa
 */
// TODO: EDITAR EL ARCHIVO DEL ESTUDIANTE, PARA ESTO SE DEBE PONER UN COMO-BOX
// CON EL NOMBRE Y OTRO CON SUS MATERIAS
// TODO: PERMITIR CREAR TAREAS PERSONALIZADAS PARA EL ESTUDIANTE SELECCIONADO

public class PantallaToDoUMBProfesor extends javax.swing.JFrame {
    /**
     * Creates new form PantallaListaEstudiantes
     */
    public PantallaToDoUMBProfesor() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("TO DO UMB");
        this.setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/VISUAL/Imagenes/Logos/icon.png")));

        setLocationRelativeTo(null);
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        canvas1 = new java.awt.Canvas();
        btnCuenta = new javax.swing.JButton();
        btnSesiones = new javax.swing.JButton();
        btnCambiarCuenta = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnCalendario = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(936, 550));

        jPanel1.setBackground(new java.awt.Color(254, 251, 240));
        jPanel1.setMinimumSize(new java.awt.Dimension(936, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(canvas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

        jLabel8.setFont(new java.awt.Font("Crabs", 1, 100)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(101, 67, 33));
        jLabel8.setText("ToDoUMB");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 15, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Logos/imgUMBPequeñoProfesor.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 936, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 936, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
            java.util.logging.Logger.getLogger(PantallaToDoUMBProfesor.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaToDoUMBProfesor.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaToDoUMBProfesor.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaToDoUMBProfesor.class.getName())
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
                new PantallaToDoUMBProfesor().setVisible(true);
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
