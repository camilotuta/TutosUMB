/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISUAL.Pantallas.General;

import VISUAL.Pantallas.Administrador.PantallaPanelDeControlAdministrativo;
import VISUAL.Pantallas.Estudiante.PantallaBienvenidaEstudiante;
import VISUAL.Pantallas.Profesor.PantallaBienvenidaProfesor;

import java.awt.Toolkit;
import java.sql.*;
import java.util.Calendar;

import javax.swing.JOptionPane;

import CODE.Clases.Conexion;

/**
 *
 * @author tutaa
 */

// TODO: QUITAR CORREO
public class PantallaInicio extends javax.swing.JFrame {

    /**
     * Creates new form PantallaInicio
     */
    Conexion cx;
    Calendar calendario = Calendar.getInstance();

    public PantallaInicio() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("INICIO");
        this.setResizable(false);

        tfCorreo.setText(PantallaRegistro.correoPoner);
        tfContraseña.setText(PantallaRegistro.contraseñaPoner);

        tfCorreo.requestFocus();

        btnRecuperarContraseña.setToolTipText("¿Olvidaste tu contraseña o quieres cambiarla? Click aquí");
        btnErroresComunes.setToolTipText("¿Necesitas ayuda? Click aquí");

        setIconImage(Toolkit.getDefaultToolkit()
                .getImage(getClass().getResource("/VISUAL/Imagenes/Logos/icon.png")));
        Calendar calendario = Calendar.getInstance();
        int añoActual = calendario.get(Calendar.YEAR);
        txtMostrarCopy.setText("© " + añoActual + " TutosUMB. Todos los derechos reservados.");

        tfCorreo.setText("adriantuta.cc@academia.umb.edu.co");

        tfContraseña.setText("1234567890");
        btnIngresar.setEnabled(habilitarBotonIngresar());
    }

    public boolean habilitarBotonIngresar() {
        char[] contraseñaEncriptada = tfContraseña.getPassword();
        String contraseña = new String(contraseñaEncriptada);
        return tfCorreo.getText().toLowerCase().contains("@academia.umb.edu.co") && contraseña.length() >= 8;
    }

    public void usuarioIngresar() {
        String correo = tfCorreo.getText().toLowerCase();
        char[] contraseñaEncriptada = tfContraseña.getPassword();
        String contraseña = new String(contraseñaEncriptada);

        try (Connection con = Conexion.getConection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT correo, contraseña FROM usuarios WHERE correo = ? AND contraseña = ?");
            ps.setString(1, correo);
            ps.setString(2, contraseña);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                PantallaRegistro.correoPoner = correo;
                PantallaRegistro.contraseñaPoner = contraseña;

                actualizarUltimaConexion();

                if (tomarTipoUsuario() == 0) {
                    PantallaPanelDeControlAdministrativo PanPanelAdmin = new PantallaPanelDeControlAdministrativo();
                    PanPanelAdmin.setVisible(true);
                    this.setVisible(false);
                } else if (tomarTipoUsuario() == 1) {
                    PantallaBienvenidaEstudiante pBie = new PantallaBienvenidaEstudiante();
                    pBie.setVisible(true);
                    this.setVisible(false);
                } else if (tomarTipoUsuario() == 2) {
                    PantallaBienvenidaProfesor pBieProf = new PantallaBienvenidaProfesor();
                    pBieProf.setVisible(true);
                    this.setVisible(false);
                }

            } else {
                JOptionPane.showMessageDialog(this, "CORREO O CONTRASEÑA NO VALIDOS \n", "AVISO!",
                        javax.swing.JOptionPane.INFORMATION_MESSAGE);
                tfContraseña.setText("");
                btnIngresar.setEnabled(habilitarBotonIngresar());
                tfContraseña.requestFocus();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "OCURRIÓ UN ERROR\n FAVOR COMUNICARSE CON EL ADMINISTRADOR", "AVISO!",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizarUltimaConexion() {
        String correo = tfCorreo.getText().toLowerCase();
        cx = new Conexion();
        cx.con = Conexion.getConection();
        try {
            String sql = "UPDATE ultimaconexion SET conexion = ? WHERE correo = ?";
            cx.ps = cx.con.prepareStatement(sql);
            cx.ps.setInt(1, PantallaRegistro.mesActual);
            cx.ps.setString(2, correo);

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
    }

    public int tomarTipoUsuario() {
        String correoBuscar = tfCorreo.getText().toLowerCase();
        cx = new Conexion();
        int tipo = 1;
        try {
            cx.con = Conexion.getConection();
            cx.ps = cx.con.prepareStatement("SELECT tipo FROM usuarios WHERE correo = ?");
            cx.ps.setString(1, correoBuscar);

            cx.rs = cx.ps.executeQuery();
            if (cx.rs.next()) {
                tipo = (cx.rs.getInt("tipo"));
            } else {
                JOptionPane.showMessageDialog(null, "NO HAY CUENTA ASOCIADA A ESTE CORREO.");
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
        return tipo;
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
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfCorreo = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        tfContraseña = new javax.swing.JPasswordField();
        btnIngresar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnErroresComunes = new javax.swing.JButton();
        btnRecuperarContraseña = new javax.swing.JButton();
        txtMostrarCopy = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(247, 251, 252));
        jPanel1.setPreferredSize(new java.awt.Dimension(936, 550));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(118, 159, 205));
        jLabel1.setText("CORREO:");

        tfCorreo.setBackground(new java.awt.Color(247, 251, 252));
        tfCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfCorreoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tfCorreo);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(118, 159, 205));
        jLabel2.setText("CONTRASEÑA:");

        tfContraseña.setBackground(new java.awt.Color(247, 251, 252));
        tfContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfContraseñaKeyReleased(evt);
            }
        });

        btnIngresar.setBackground(new java.awt.Color(185, 215, 234));
        btnIngresar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(66, 120, 181));
        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(118, 159, 205));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Logos/imgLogoTutos.png"))); // NOI18N
        jLabel3.setText("TUTOS-UMB");
        jLabel3.setMaximumSize(new java.awt.Dimension(600, 150));
        jLabel3.setMinimumSize(new java.awt.Dimension(600, 150));

        btnRegistrar.setBackground(new java.awt.Color(185, 215, 234));
        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(66, 120, 181));
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(118, 159, 205));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Logos/imgUMBPequeño.png"))); // NOI18N

        btnErroresComunes.setBackground(new java.awt.Color(185, 215, 234));
        btnErroresComunes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnErroresComunes.setForeground(new java.awt.Color(66, 120, 181));
        btnErroresComunes.setText("?");
        btnErroresComunes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnErroresComunesActionPerformed(evt);
            }
        });

        btnRecuperarContraseña.setBackground(new java.awt.Color(185, 215, 234));
        btnRecuperarContraseña.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRecuperarContraseña.setForeground(new java.awt.Color(66, 120, 181));
        btnRecuperarContraseña.setText("i");
        btnRecuperarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecuperarContraseñaActionPerformed(evt);
            }
        });

        txtMostrarCopy.setForeground(new java.awt.Color(118, 159, 205));
        txtMostrarCopy.setText("© TutosUMB. Todos los derechos reservados.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnErroresComunes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131,
                                        Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 633,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(330, 330, 330)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addGap(58, 58, 58)
                                                                .addComponent(jScrollPane1,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 270,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel2,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(tfContraseña,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 270,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(12, 12, 12)
                                                                .addComponent(btnRecuperarContraseña))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(btnRegistrar,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 110,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(168, 168, 168)
                                                                .addComponent(btnIngresar,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 110,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(txtMostrarCopy)))
                                .addGap(0, 0, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(btnErroresComunes))
                                        .addComponent(jLabel5)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 210,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel1))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel2))
                                        .addGroup(jPanel1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(tfContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnRecuperarContraseña)))
                                .addGap(80, 80, 80)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48,
                                        Short.MAX_VALUE)
                                .addComponent(txtMostrarCopy)
                                .addContainerGap()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRecuperarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {
        PantallaRecuperarContraseña pRecCon = new PantallaRecuperarContraseña();
        pRecCon.setVisible(true);
        this.setVisible(false);
    }

    private void tfContraseñaKeyReleased(java.awt.event.KeyEvent evt) {
        btnIngresar.setEnabled(habilitarBotonIngresar());
    }

    private void btnErroresComunesActionPerformed(java.awt.event.ActionEvent evt) {
        String texto = "¡Hola! Aquí te dejo un apartado de ayuda con algunos errores comunes y sus\nposibles soluciones:\n\nNo puedes ingresar:\nVerifica tus credenciales de inicio de sesión.\nRestablece tu contraseña si la has olvidado.\nVerifica tu conexión a internet.\nSi el problema persiste, contacta al soporte técnico de la plataforma.\n\nNo puedes registrarte:\nVerifica que completaste todos los campos requeridos y que usaste una\ndirección de correo institucional válida.\nSi el problema persiste, intenta utilizar una dirección de correo electrónico\ndiferente o contacta al soporte técnico de la plataforma.\n\nError al actualizar biografía:\nAsegúrate de seguir los requisitos de longitud y formato para la biografía.\nSi el problema persiste, intenta actualizar tu biografía desde otro\ndispositivo o navegador o contacta al soporte técnico de la plataforma.\n\nError al agendar tutoría:\nVerifica que seleccionaste la fecha y hora correctas.\nVerifica que tienes los permisos necesarios para agendar una tutoría.\nSi el problema persiste, intenta utilizar otro dispositivo o navegador o\ncontacta al soporte técnico de la plataforma.\n\nError al actualizar lista de tareas:\nAsegúrate de seguir los requisitos de longitud y formato para cada tarea en\nla lista.\nVerifica que tienes los permisos necesarios para actualizar la lista de\ntareas en la plataforma.\n\nSi necesitas ayuda adicional, por favor envía un correo especificando tu problema a alguno\nde los siguientes correos de contacto:\n\nAdrian Camilo Tuta Cortes: adriantuta.cc@academia.umb.edu.co\nCristóbal Moncada Duarte: cristobalmoncada.d@academia.umb.edu.co";
        JOptionPane.showMessageDialog(null, texto, "AYUDA", JOptionPane.INFORMATION_MESSAGE);
    }

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {
        usuarioIngresar();
    }

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {
        PantallaRegistro pReg = new PantallaRegistro();
        pReg.setVisible(true);
        this.setVisible(false);
    }

    private void tfCorreoKeyReleased(java.awt.event.KeyEvent evt) {
        btnIngresar.setEnabled(habilitarBotonIngresar());
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
            java.util.logging.Logger.getLogger(PantallaInicio.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaInicio.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaInicio.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaInicio.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnErroresComunes;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnRecuperarContraseña;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPasswordField tfContraseña;
    private javax.swing.JTextPane tfCorreo;
    private javax.swing.JLabel txtMostrarCopy;
    // End of variables declaration//GEN-END:variables
}
