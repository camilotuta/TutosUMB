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
public class PantallaModificarUsuario extends javax.swing.JFrame {

        /**
         * Creates new form PantallaModificarUsuario
         */
        public String correoGuardar = "";

        public PantallaModificarUsuario() {
                initComponents();
                this.setLocationRelativeTo(null);
                this.setTitle("MODIFICAR USUARIO");
                this.setResizable(false);
                setIconImage(Toolkit.getDefaultToolkit()
                                .getImage(getClass().getResource("/VISUAL/Imagenes/Logos/icon.png")));

                mostrarDatosUsuario();

                correoGuardar = tfCorreo.getText();
        }

        public void mostrarDatosUsuario() {
                Conexion cx = new Conexion();
                String nombreBuscar = PantallaPanelDeControlAdministrativo.nombreEditar;
                try {
                        cx.con = Conexion.getConection();
                        cx.ps = cx.con
                                        .prepareStatement(
                                                        "SELECT nombre, correo, contraseña, biografia, tipo FROM usuarios WHERE nombre = ?");
                        cx.ps.setString(1, nombreBuscar);

                        cx.rs = cx.ps.executeQuery();
                        if (cx.rs.next()) {
                                tfNombre.setText(cx.rs.getString("nombre"));
                                tfCorreo.setText(cx.rs.getString("correo"));
                                tfContraseña.setText(cx.rs.getString("contraseña"));
                                tfBiografia.setText(cx.rs.getString("biografia"));
                                cbTipoUsuario.setSelectedIndex(cx.rs.getInt("tipo"));
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

        public void actualizarDatos() {
                Conexion cx = new Conexion();
                cx.con = Conexion.getConection();

                String nombre = tfNombre.getText();
                String correo = tfCorreo.getText();
                String contraseña = tfContraseña.getText();
                String biografia = tfBiografia.getText();
                String tipoSeleccion[] = cbTipoUsuario.getSelectedItem().toString().split(" ");
                int tipoUsuario = Integer.parseInt(tipoSeleccion[0]);
                try {
                        String sql = "UPDATE usuarios SET nombre = ?, correo = ?, contraseña = ?, biografia = ?, tipo = ? WHERE correo = ?";
                        cx.ps = cx.con.prepareStatement(sql);
                        cx.ps.setString(1, nombre);
                        cx.ps.setString(2, correo);
                        cx.ps.setString(3, contraseña);
                        cx.ps.setString(4, biografia);
                        cx.ps.setInt(5, tipoUsuario);
                        cx.ps.setString(6, correoGuardar);
                        cx.ps.executeUpdate();
                        // Asegurarse de cerrar el PreparedStatement después de su uso
                        cx.ps.executeUpdate();
                        cx.ps.close();

                        JOptionPane.showMessageDialog(null,
                                        "EL USUARIO " + correo.toUpperCase() + " HA SIDO ACTUALIZADO CORRECTAMENTE.");

                        PantallaPanelDeControlAdministrativo pPanCon = new PantallaPanelDeControlAdministrativo();

                        pPanCon.setVisible(true);
                        this.setVisible(false);
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
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jPanel2 = new javax.swing.JPanel();
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
                cbTipoUsuario = new javax.swing.JComboBox<>();
                jLabel7 = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setBackground(new java.awt.Color(247, 251, 252));

                jPanel1.setForeground(new java.awt.Color(247, 251, 252));

                jPanel2.setBackground(new java.awt.Color(247, 247, 247));

                btnCancelar.setBackground(new java.awt.Color(220, 220, 220));
                btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                btnCancelar.setForeground(new java.awt.Color(51, 51, 51));
                btnCancelar.setText("Cancelar");
                btnCancelar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCancelarActionPerformed(evt);
                        }
                });

                btnConfirmar.setBackground(new java.awt.Color(220, 220, 220));
                btnConfirmar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                btnConfirmar.setForeground(new java.awt.Color(51, 51, 51));
                btnConfirmar.setText("Confirmar");
                btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnConfirmarActionPerformed(evt);
                        }
                });

                tfNombre.setBackground(new java.awt.Color(247, 247, 247));
                tfNombre.setForeground(new java.awt.Color(51, 51, 51));
                jScrollPane2.setViewportView(tfNombre);

                jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                jLabel2.setForeground(new java.awt.Color(51, 51, 51));
                jLabel2.setText("NOMBRE COMPLETO:");

                jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                jLabel4.setForeground(new java.awt.Color(51, 51, 51));
                jLabel4.setText("CORREO INSTITUCIONAL:");

                tfCorreo.setBackground(new java.awt.Color(247, 247, 247));
                tfCorreo.setForeground(new java.awt.Color(51, 51, 51));
                jScrollPane1.setViewportView(tfCorreo);

                jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                jLabel3.setForeground(new java.awt.Color(51, 51, 51));
                jLabel3.setText("CONTRASEÑA:");

                jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                jLabel6.setForeground(new java.awt.Color(51, 51, 51));
                jLabel6.setText("BIOGRAFÍA:");

                tfContraseña.setBackground(new java.awt.Color(247, 247, 247));
                tfContraseña.setForeground(new java.awt.Color(51, 51, 51));
                jScrollPane3.setViewportView(tfContraseña);

                tfBiografia.setBackground(new java.awt.Color(247, 247, 247));
                tfBiografia.setForeground(new java.awt.Color(51, 51, 51));
                jScrollPane4.setViewportView(tfBiografia);

                jLabel8.setBackground(new java.awt.Color(85, 85, 85));
                jLabel8.setFont(new java.awt.Font("Crabs", 1, 80)); // NOI18N
                jLabel8.setForeground(new java.awt.Color(51, 51, 51));
                jLabel8.setText("Usuario");

                jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
                jLabel5.setForeground(new java.awt.Color(118, 159, 205));
                jLabel5.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource("/VISUAL/Imagenes/Logos/imgUMBPequeñoAdministrador.png"))); // NOI18N

                cbTipoUsuario.setBackground(new java.awt.Color(220, 220, 220));
                cbTipoUsuario.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
                cbTipoUsuario.setForeground(new java.awt.Color(51, 51, 51));
                cbTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(
                                new String[] { "0 Administrador", "1 Estudiante", "2 Profesor" }));
                cbTipoUsuario.setSelectedItem("1 Estudiante");
                cbTipoUsuario.setToolTipText("");

                jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                jLabel7.setForeground(new java.awt.Color(51, 51, 51));
                jLabel7.setText("TIPO DE USUARIO:");

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(200, 200, 200)
                                                                .addComponent(btnConfirmar)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(btnCancelar)
                                                                .addGap(178, 178, 178))
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel2Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(270, 270, 270)
                                                                                                .addComponent(jLabel8)
                                                                                                .addGap(128, 128, 128)
                                                                                                .addComponent(jLabel5))
                                                                                .addGroup(jPanel2Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(129, 129, 129)
                                                                                                .addComponent(jLabel2,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                150,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(60, 60, 60)
                                                                                                .addComponent(jScrollPane2,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                307,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(jPanel2Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(129, 129, 129)
                                                                                                .addComponent(jLabel4,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                170,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(40, 40, 40)
                                                                                                .addComponent(jScrollPane1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                307,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(jPanel2Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(129, 129, 129)
                                                                                                .addComponent(jLabel3,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                100,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(110, 110, 110)
                                                                                                .addComponent(jScrollPane3,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                307,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(jPanel2Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(129, 129, 129)
                                                                                                .addGroup(jPanel2Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                .addGroup(jPanel2Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(jLabel7,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                190,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGap(18, 18, 18)
                                                                                                                                .addComponent(cbTipoUsuario,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                306,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                .addGroup(jPanel2Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(jLabel6,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                190,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGap(18, 18, 18)
                                                                                                                                .addComponent(jScrollPane4,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                307,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                                .addGap(0, 0, Short.MAX_VALUE)));
                jPanel2Layout.setVerticalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel2Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(20, 20, 20)
                                                                                                .addComponent(jLabel8))
                                                                                .addComponent(jLabel5))
                                                                .addGap(24, 24, 24)
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel2Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(10, 10, 10)
                                                                                                .addComponent(jLabel2))
                                                                                .addComponent(jScrollPane2,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                30,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(50, 50, 50)
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel2Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(10, 10, 10)
                                                                                                .addComponent(jLabel4))
                                                                                .addComponent(jScrollPane1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                30,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(50, 50, 50)
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel2Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(10, 10, 10)
                                                                                                .addComponent(jLabel3))
                                                                                .addComponent(jScrollPane3,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                30,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(40, 40, 40)
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel2Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(10, 10, 10)
                                                                                                .addComponent(jLabel6))
                                                                                .addComponent(jScrollPane4,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                30,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(38, 38, 38)
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jLabel7)
                                                                                .addComponent(cbTipoUsuario,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                52,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(btnConfirmar)
                                                                                .addComponent(btnCancelar))
                                                                .addGap(23, 23, 23)));

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jPanel2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                772,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {
                PantallaPanelDeControlAdministrativo pPanCon = new PantallaPanelDeControlAdministrativo();

                pPanCon.setVisible(true);
                this.setVisible(false);
        }

        private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {
                actualizarDatos();

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
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                                        .getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(PantallaModificarUsuario.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(PantallaModificarUsuario.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(PantallaModificarUsuario.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(PantallaModificarUsuario.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                }
                // </editor-fold>
                // </editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new PantallaModificarUsuario().setVisible(true);
                        }
                });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnCancelar;
        private javax.swing.JButton btnConfirmar;
        private javax.swing.JComboBox<String> cbTipoUsuario;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel jLabel7;
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
