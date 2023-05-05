/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISUAL.Pantallas.Administrador;

import java.awt.Toolkit;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import CODE.Clases.Conexion;

/**
 *
 * @author tutaa
 */
public class PantallaCrearUsuario extends javax.swing.JFrame {

    /**
     * Creates new form PantallaPanelDeControlAdministrativo
     */
    public PantallaCrearUsuario() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("CREAR USUARIO");
        this.setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/VISUAL/Imagenes/Logos/icon.png")));

    }

    public void crearUsuario() {
        String nombre = tfNombre.getText();
        String correo = tfCorreo.getText();
        String contraseña = tfContraseña.getText();
        String biografia = tfBiografia.getText();

        Conexion cx = new Conexion();
        try {
            cx.con = Conexion.getConection();
            if (cx.con == null) {
                JOptionPane.showMessageDialog(null,
                        "No se pudo establecer una conexión a la base de datos.");
            } else {
                cx.stmt = cx.con.createStatement();
                cx.stmt.executeUpdate(
                        "INSERT INTO usuarios(nombre, correo, contraseña, biografia) VALUES('"
                                + nombre + "','" + correo + "','"
                                + contraseña + "','"
                                + biografia + "')");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            if (cx.con != null) {
                try {
                    cx.con.close();
                    cx.stmt.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }

        JOptionPane.showMessageDialog(this, "¡REGISTRO EXITOSO!", "¡AVISO!",
                javax.swing.JOptionPane.INFORMATION_MESSAGE);
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
        jPanel2 = new javax.swing.JPanel();
        canvas1 = new java.awt.Canvas();
        btnCancelar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tfNombre = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfCorreo = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tfContraseña = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        tfBiografia = new javax.swing.JTextPane();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(247, 251, 252));

        jPanel1.setForeground(new java.awt.Color(247, 251, 252));

        jPanel2.setBackground(new java.awt.Color(247, 247, 247));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(canvas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(914, 533, -1, -1));

        btnCancelar.setBackground(new java.awt.Color(220, 220, 220));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(51, 51, 51));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 422, -1, -1));

        btnConfirmar.setBackground(new java.awt.Color(220, 220, 220));
        btnConfirmar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnConfirmar.setForeground(new java.awt.Color(51, 51, 51));
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        jPanel2.add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 422, -1, -1));

        tfNombre.setBackground(new java.awt.Color(247, 247, 247));
        tfNombre.setForeground(new java.awt.Color(51, 51, 51));
        jScrollPane2.setViewportView(tfNombre);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 144, 307, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("NOMBRE COMPLETO:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 154, 150, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("CORREO INSTITUCIONAL:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 234, 170, -1));

        tfCorreo.setBackground(new java.awt.Color(247, 247, 247));
        tfCorreo.setForeground(new java.awt.Color(51, 51, 51));
        jScrollPane1.setViewportView(tfCorreo);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 224, 307, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("CONTRASEÑA:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 314, 100, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("BIOGRAFÍA:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 384, 190, -1));

        tfContraseña.setBackground(new java.awt.Color(247, 247, 247));
        tfContraseña.setForeground(new java.awt.Color(51, 51, 51));
        jScrollPane3.setViewportView(tfContraseña);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 304, 307, 30));

        tfBiografia.setBackground(new java.awt.Color(247, 247, 247));
        tfBiografia.setForeground(new java.awt.Color(51, 51, 51));
        jScrollPane4.setViewportView(tfBiografia);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 374, 307, 30));

        jLabel8.setBackground(new java.awt.Color(85, 85, 85));
        jLabel8.setFont(new java.awt.Font("Crabs", 1, 80)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Usuario");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(118, 159, 205));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Logos/imgUMBPequeñoAdministrador.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 772, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        PantallaPanelDeControlAdministrativo pPanCon = new PantallaPanelDeControlAdministrativo();

        pPanCon.setVisible(true);
        this.setVisible(false);
    }

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {
        crearUsuario();
        PantallaPanelDeControlAdministrativo pPanCon = new PantallaPanelDeControlAdministrativo();

        pPanCon.setVisible(true);
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
            java.util.logging.Logger.getLogger(PantallaCrearUsuario.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaCrearUsuario.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaCrearUsuario.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaCrearUsuario.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaCrearUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private java.awt.Canvas canvas1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextPane tfBiografia;
    private javax.swing.JTextPane tfContraseña;
    private javax.swing.JTextPane tfCorreo;
    private javax.swing.JTextPane tfNombre;
    // End of variables declaration//GEN-END:variables
}
