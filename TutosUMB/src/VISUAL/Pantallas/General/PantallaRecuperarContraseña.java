/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISUAL.Pantallas.General;

import java.awt.Toolkit;
import java.sql.*;
import java.util.Random;

import javax.swing.JOptionPane;

import CODE.Clases.Conexion;
import CODE.Clases.EnviarCorreo;

/**
 *
 * @author tutaa
 */

// TODO: MEJORAR LOS METODOS USUARIOREGISTRADO Y TOMAR NOMBRE PARA QUE NO HAGAN
// LO MISMO
public class PantallaRecuperarContraseña extends javax.swing.JFrame {

    /**
     * Creates new form PantallaInicio
     */
    String codigo;
    public static int intentos = 3;

    public PantallaRecuperarContraseña() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("RECUPERAR CONTRASEÑA");
        this.setResizable(false);
        btnConfirmar.setEnabled(habilitarBotonConfirmar());
        btnEnviarCodigo.setEnabled(habilitarBotonEnviarCodigo());
        btnVerificar.setEnabled(habilitarBotonVerificar());

        tfContraseña.setEnabled(false);
        tfConfirmarContraseña.setEnabled(false);

        if (intentos == 0) {
            JOptionPane.showMessageDialog(rootPane, "VUELVA MÁS TARDE.");
            tfCodigo.setEnabled(false);
            tfCorreo.setEnabled(false);
            btnEnviarCodigo.setEnabled(false);
            btnVerificar.setEnabled(false);
        }

        setIconImage(Toolkit.getDefaultToolkit()
                .getImage(getClass().getResource("/VISUAL/Imagenes/Logos/icon.png")));
    }

    public boolean habilitarBotonConfirmar() {
        return tfContraseña.getText().length() >= 8 && tfConfirmarContraseña.getText().length() >= 8;
    }

    public boolean habilitarBotonEnviarCodigo() {
        return tfCorreo.getText().contains("@academia.umb.edu.co") && tfCorreo.getText().length() >= 15;
    }

    public boolean habilitarBotonVerificar() {
        return tfCodigo.getText().length() == 6;
    }

    public void actualizarContraseña() {
        if (tfContraseña.getText().equals(tfConfirmarContraseña.getText())) {
            Conexion cx = new Conexion();
            cx.con = Conexion.getConection();
            try {
                String sql = "UPDATE usuarios SET contraseña = ? WHERE correo = ?";
                cx.ps = cx.con.prepareStatement(sql);
                cx.ps.setString(1, tfContraseña.getText());
                cx.ps.setString(2, tfCorreo.getText());

                cx.ps.executeUpdate();
                PantallaRegistro.correoPoner = tfCorreo.getText();
                PantallaRegistro.contraseñaPoner = tfContraseña.getText();
                JOptionPane.showMessageDialog(null, "SU CONTRASEÑA HA SIDO ACTUALIZADA.");

                PantallaInicio pi = new PantallaInicio();
                pi.setVisible(true);

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
        } else {
            JOptionPane.showMessageDialog(this, "LAS CONTRASEÑAS DEBEN COINCIDIR", "AVISO!",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public String tomarNombre() {
        String correoBuscar = tfCorreo.getText();
        Conexion cx = new Conexion();
        String nombre = "";
        try {
            cx.con = Conexion.getConection();
            cx.ps = cx.con.prepareStatement("SELECT nombre FROM usuarios WHERE correo = ?");
            cx.ps.setString(1, correoBuscar);

            cx.rs = cx.ps.executeQuery();
            if (cx.rs.next()) {
                nombre = (cx.rs.getString("nombre"));
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
        return nombre;

    }

    public boolean usuarioRegistrado() {
        Conexion cx = new Conexion();
        String sql = "select * from usuarios";
        boolean bool = false;

        try {
            cx.con = Conexion.getConection();
            cx.stmt = cx.con.createStatement();
            cx.rs = cx.stmt.executeQuery(sql);
            while (cx.rs.next()) {
                String correo = cx.rs.getString("correo");
                bool = correo.equals(tfCorreo.getText());
                if (bool) {
                    break;
                }
            }
            return bool;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar la base de datos: " + e.getMessage());
            return bool;
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        canvas1 = new java.awt.Canvas();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfCorreo = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        tfContraseña = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tfCodigo = new javax.swing.JTextPane();
        tfConfirmarContraseña = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        btnVerificar = new javax.swing.JButton();
        btnEnviarCodigo = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(247, 251, 252));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(canvas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        tfCorreo.setBackground(new java.awt.Color(247, 251, 252));
        tfCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfCorreoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tfCorreo);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 138, 307, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(118, 159, 205));
        jLabel2.setText("NUEVA CONTRASEÑA:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 296, -1, -1));

        btnRegresar.setBackground(new java.awt.Color(185, 215, 234));
        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(66, 120, 181));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, 110, 40));

        btnConfirmar.setBackground(new java.awt.Color(185, 215, 234));
        btnConfirmar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnConfirmar.setForeground(new java.awt.Color(66, 120, 181));
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        jPanel1.add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 420, 110, 40));

        tfContraseña.setBackground(new java.awt.Color(247, 251, 252));
        tfContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfContraseñaKeyReleased(evt);
            }
        });
        jPanel1.add(tfContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 286, 307, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(118, 159, 205));
        jLabel4.setText("CORREO INSTITUCIONAL:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 148, 170, -1));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(118, 159, 205));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Logos/imgUMBPequeño.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 100, -1));

        tfCodigo.setBackground(new java.awt.Color(247, 251, 252));
        tfCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfCodigoKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tfCodigo);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 186, 200, 30));

        tfConfirmarContraseña.setBackground(new java.awt.Color(247, 251, 252));
        tfConfirmarContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfConfirmarContraseñaKeyReleased(evt);
            }
        });
        jPanel1.add(tfConfirmarContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 366, 307, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(118, 159, 205));
        jLabel6.setText("CONFIRMAR CONTRASEÑA:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 376, 190, -1));

        btnVerificar.setBackground(new java.awt.Color(185, 215, 234));
        btnVerificar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVerificar.setForeground(new java.awt.Color(66, 120, 181));
        btnVerificar.setText("Verificar");
        btnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnVerificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 189, -1, -1));

        btnEnviarCodigo.setBackground(new java.awt.Color(185, 215, 234));
        btnEnviarCodigo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEnviarCodigo.setForeground(new java.awt.Color(66, 120, 181));
        btnEnviarCodigo.setText("Enviar Código");
        btnEnviarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarCodigoActionPerformed(evt);
            }
        });
        jPanel1.add(btnEnviarCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 189, -1, -1));

        jLabel8.setFont(new java.awt.Font("Crabs", 1, 80)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(118, 159, 205));
        jLabel8.setText("Restablecer");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfCodigoKeyReleased(java.awt.event.KeyEvent evt) {
        btnVerificar.setEnabled(habilitarBotonVerificar());
    }

    private void btnEnviarCodigoActionPerformed(java.awt.event.ActionEvent evt) {
        String correo = tfCorreo.getText();
        Random rand = new Random();
        codigo = String.valueOf(rand.nextInt(100_000, 999_999));

        String listaCodigo[] = codigo.split(""), text = "";

        for (int i = 0; i < listaCodigo.length; i++) {
            if (i != listaCodigo.length - 1) {
                text += listaCodigo[i] + "-";
            } else {
                text += listaCodigo[i];
            }
        }

        String asunto = "Restablecer tu contraseña en TutosUMB.";
        String mensaje = "&#x1F44B; Hola, " + tomarNombre() + ".<br><br>" +
                "Has recibido este correo electrónico porque has solicitado restablecer tu contraseña en TutosUMB. Para continuar, utiliza el siguiente código de verificación:<br><br>"
                +
                "&#128273; <strong style=\"font-size: 24px;\">" + text + "</strong><br><br>" +
                "Por favor, ingresa este código en la página de restablecimiento de contraseña y sigue las instrucciones para crear una nueva contraseña segura.<br><br>"
                +
                "Si no has solicitado el restablecimiento de tu contraseña, por favor ignora este correo electrónico y asegúrate de proteger tu cuenta.<br><br>"
                +
                "Si tienes alguna pregunta o necesitas ayuda, no dudes en contactar a nuestro equipo de soporte. &#128516;<br><br>"
                +
                "¡Que tengas un excelente día! &#128077;<br><br>" +
                "Atentamente,<br>" +
                "El equipo de TutosUMB. &#128170;";

        new EnviarCorreo(correo, asunto, mensaje);
    }

    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {
        if (usuarioRegistrado()) {
            if (tfCodigo.getText().equals(codigo) && intentos > 0) {
                JOptionPane.showMessageDialog(null, "EL CÓDIGO ES CORRECTO.");
                tfContraseña.setEnabled(true);
                tfConfirmarContraseña.setEnabled(true);
                intentos = 3;
            } else if (intentos == 0) {
                JOptionPane.showMessageDialog(rootPane, "NO TIENE MÁS INTENTOS.");
                tfCodigo.setEnabled(false);
                tfCorreo.setEnabled(false);
                btnEnviarCodigo.setEnabled(false);
                btnVerificar.setEnabled(false);
            } else {
                intentos--;
                JOptionPane.showMessageDialog(null, "EL CÓDIGO NO ES CORRECTO.\nTIENE " + intentos + " INTENTOS.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "NO EXISTE UNA CUENTA CON ESE CORREO.");
        }
    }

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {
        PantallaInicio pi = new PantallaInicio();
        pi.setVisible(true);
        this.setVisible(false);
    }

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {
        actualizarContraseña();

    }

    private void tfCorreoKeyReleased(java.awt.event.KeyEvent evt) {
        btnConfirmar.setEnabled(habilitarBotonConfirmar());
        btnEnviarCodigo.setEnabled(habilitarBotonEnviarCodigo());
        btnVerificar.setEnabled(habilitarBotonVerificar());
    }

    private void tfContraseñaKeyReleased(java.awt.event.KeyEvent evt) {
        btnConfirmar.setEnabled(habilitarBotonConfirmar());
        btnEnviarCodigo.setEnabled(habilitarBotonEnviarCodigo());
        btnVerificar.setEnabled(habilitarBotonVerificar());
    }

    private void tfConfirmarContraseñaKeyReleased(java.awt.event.KeyEvent evt) {
        btnConfirmar.setEnabled(habilitarBotonConfirmar());
        btnEnviarCodigo.setEnabled(habilitarBotonEnviarCodigo());
        btnVerificar.setEnabled(habilitarBotonVerificar());
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
            java.util.logging.Logger.getLogger(PantallaRecuperarContraseña.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaRecuperarContraseña.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaRecuperarContraseña.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaRecuperarContraseña.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaRecuperarContraseña().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnEnviarCodigo;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnVerificar;
    private java.awt.Canvas canvas1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane tfCodigo;
    private javax.swing.JPasswordField tfConfirmarContraseña;
    private javax.swing.JPasswordField tfContraseña;
    private javax.swing.JTextPane tfCorreo;
    // End of variables declaration//GEN-END:variables
}
