/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISUAL.Pantallas.General;

import java.awt.Toolkit;
import java.sql.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import CODE.Clases.Archivo;
import CODE.Clases.Conexion;
import CODE.Clases.EnviarCorreo;

/**
 *
 * @author tutaa
 */
public class PantallaRegistro extends javax.swing.JFrame {

    /**
     * Creates new form PantallaRegistro
     */
    private String codigo;
    public static String correoPoner = "", contraseñaPoner = "";
    public static int intentos = 3;

    public static Archivo archivoSesiones = new Archivo(), archivoMaterias = new Archivo(),
            archivoTareas = new Archivo();

    public PantallaRegistro() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("REGISTRO");
        this.setResizable(false);
        btnRegistrarse.setEnabled(habilitarBotonRegistrarse());
        setIconImage(Toolkit.getDefaultToolkit()
                .getImage(getClass().getResource("/VISUAL/Imagenes/Logos/icon.png")));

        tfContraseña.setEnabled(false);
        tfConfirmarContraseña.setEnabled(false);

        btnVerificar.setEnabled(habilitarBotonVerificar());
        btnEnviarCodigo.setEnabled(habilitarBotonEnviarCodigo());

        tfNombre.requestFocus();

        if (intentos == 0) {
            JOptionPane.showMessageDialog(rootPane, "VUELVA MÁS TARDE.");
            tfCodigo.setEnabled(false);
            tfCorreo.setEnabled(false);
            btnEnviarCodigo.setEnabled(false);
            btnVerificar.setEnabled(false);
        }
    }

    public boolean habilitarBotonRegistrarse() {
        char[] contraseñaEncriptada = tfContraseña.getPassword();
        char[] confirmarContraseñaEncriptada = tfContraseña.getPassword();
        String contraseña = new String(contraseñaEncriptada);
        String confirmarContraseña = new String(confirmarContraseñaEncriptada);
        return tfCorreo.getText().toLowerCase().contains("@academia.umb.edu.co") && tfNombre.getText().length() >= 10
                && contraseña.length() >= 8
                && confirmarContraseña.length() >= 8;
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
                String nombre = cx.rs.getString("nombre");
                String correo = cx.rs.getString("correo");
                bool = nombre.equals(tfNombre.getText()) || correo.equals(tfCorreo.getText().toLowerCase());
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

    public void registrarUsuario() {
        String nombre = "", correo = "", contraseña = "", biografia = "";
        int tipo = 1;
        nombre = tfNombre.getText();
        correo = tfCorreo.getText().toLowerCase();

        char[] contraseñaEncriptada = tfContraseña.getPassword();
        char[] confirmarContraseñaEncriptada = tfContraseña.getPassword();
        contraseña = new String(contraseñaEncriptada);
        String confirmarContraseña = new String(confirmarContraseñaEncriptada);
        if (contraseña.equals(confirmarContraseña)) {
            Conexion cx = new Conexion();
            try {
                cx.con = Conexion.getConection();
                if (cx.con == null) {
                    JOptionPane.showMessageDialog(null,
                            "No se pudo establecer una conexión a la base de datos.");
                } else {
                    cx.stmt = cx.con.createStatement();
                    cx.stmt.executeUpdate(
                            "INSERT INTO usuarios(nombre, correo, contraseña, biografia, tipo) VALUES('"
                                    + nombre + "','" + correo + "','"
                                    + contraseña + "','"
                                    + biografia + "','" + tipo + "')");

                    correoPoner = correo;
                    contraseñaPoner = contraseña;

                    archivoSesiones.crearArchivo("Sesiones");

                    archivoMaterias.crearArchivo("Materias");

                    archivoTareas.crearArchivo("Tareas");

                    JOptionPane.showMessageDialog(this, "¡REGISTRO EXITOSO!", "¡AVISO!",
                            javax.swing.JOptionPane.INFORMATION_MESSAGE);

                    PantallaInicio pi = new PantallaInicio();
                    pi.setVisible(true);

                    this.setVisible(false);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PantallaRegistro.class.getName()).log(Level.SEVERE, null, ex);
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
        } else {
            JOptionPane.showMessageDialog(this, "LAS CONTRASEÑAS DEBEN COINCIDIR", "AVISO!",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public boolean habilitarBotonVerificar() {
        return tfCodigo.getText().length() == 6;
    }

    public boolean habilitarBotonEnviarCodigo() {
        return tfCorreo.getText().toLowerCase().contains("@academia.umb.edu.co")
                && tfCorreo.getText().toLowerCase().length() >= 15
                && tfNombre.getText().length() > 10;
    }

    public void enviarCodigoCorreo() {
        if (!usuarioRegistrado()) {

            String nombre = tfNombre.getText();
            String correo = tfCorreo.getText().toLowerCase();
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

            String asunto = "Verificación de correo electrónico en TutosUMB";
            String mensaje = "&#x1F44B; Hola, " + nombre + ".<br><br>"
                    + "¡Bienvenido/a a TutosUMB! Antes de que puedas comenzar a utilizar tu cuenta, necesitamos verificar que tu correo electrónico sea válido. "
                    + "Para ello, utiliza el siguiente código de verificación:<br><br>"
                    + "&#128273; <strong style=\"font-size: 24px;\">" + text + "</strong><br><br>"
                    + "Por favor, ingresa este código en la página de verificación de correo electrónico y sigue las instrucciones para verificar tu cuenta.<br><br>"
                    + "Si no has creado una cuenta en TutosUMB, por favor ignora este correo electrónico y asegúrate de proteger tu cuenta.<br><br>"
                    + "Si tienes alguna pregunta o necesitas ayuda, no dudes en contactar a nuestro equipo de soporte. &#128516;<br><br>"
                    + "¡Que tengas un excelente día! &#128077;<br><br>"
                    + "Atentamente,<br>"
                    + "El equipo de TutosUMB. &#128170;";

            new EnviarCorreo(correo, asunto, mensaje);
            // System.out.println(mensaje);
        } else {
            JOptionPane.showMessageDialog(null, "YA EXISTE UNA CUENTA CON ESTE CORREO.");
        }
    }

    public void verificarCodigo() {
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
            JOptionPane.showMessageDialog(null,
                    "EL CÓDIGO NO ES CORRECTO.\nTIENE " + intentos + " INTENTOS.");
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfCorreo = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        btnRegistrarse = new javax.swing.JButton();
        tfContraseña = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tfNombre = new javax.swing.JTextPane();
        tfConfirmarContraseña = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnEnviarCodigo = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tfCodigo = new javax.swing.JTextPane();
        btnVerificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(247, 251, 252));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(118, 159, 205));
        jLabel1.setText("NOMBRE COMPLETO:");

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

        btnRegresar.setBackground(new java.awt.Color(185, 215, 234));
        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(66, 120, 181));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnRegistrarse.setBackground(new java.awt.Color(185, 215, 234));
        btnRegistrarse.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegistrarse.setForeground(new java.awt.Color(66, 120, 181));
        btnRegistrarse.setText("Registrarse");
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });

        tfContraseña.setBackground(new java.awt.Color(247, 251, 252));
        tfContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfContraseñaKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(118, 159, 205));
        jLabel4.setText("CORREO INSTITUCIONAL:");

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(118, 159, 205));
        jLabel5.setIcon(new javax.swing.ImageIcon(
                getClass().getResource("/VISUAL/Imagenes/Logos/imgUMBPequeño.png"))); // NOI18N

        tfNombre.setBackground(new java.awt.Color(247, 251, 252));
        tfNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfNombreKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tfNombre);

        tfConfirmarContraseña.setBackground(new java.awt.Color(247, 251, 252));
        tfConfirmarContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfConfirmarContraseñaKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(118, 159, 205));
        jLabel6.setText("CONFIRMAR CONTRASEÑA:");

        jLabel8.setFont(new java.awt.Font("Crabs", 1, 100)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(118, 159, 205));
        jLabel8.setText("Registro");

        btnEnviarCodigo.setBackground(new java.awt.Color(185, 215, 234));
        btnEnviarCodigo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEnviarCodigo.setForeground(new java.awt.Color(66, 120, 181));
        btnEnviarCodigo.setText("Enviar Código");
        btnEnviarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarCodigoActionPerformed(evt);
            }
        });

        tfCodigo.setBackground(new java.awt.Color(247, 251, 252));
        tfCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfCodigoKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tfCodigo);

        btnVerificar.setBackground(new java.awt.Color(185, 215, 234));
        btnVerificar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVerificar.setForeground(new java.awt.Color(66, 120, 181));
        btnVerificar.setText("Verificar");
        btnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(325, 325, 325)
                                .addComponent(jLabel8)
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        145, Short.MAX_VALUE)
                                .addComponent(jLabel5,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(192, 192, 192)
                                .addGroup(jPanel1Layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout
                                                .createSequentialGroup()
                                                .addComponent(btnEnviarCodigo)
                                                .addGap(40, 40, 40)
                                                .addComponent(jScrollPane3,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        200,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20)
                                                .addComponent(btnVerificar))
                                        .addGroup(jPanel1Layout
                                                .createSequentialGroup()
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel6,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                190,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnRegresar,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                110,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(217, 217, 217)
                                                .addComponent(btnRegistrarse,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        110,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(tfConfirmarContraseña,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                307,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout
                                                .createParallelGroup(
                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                        false)
                                                .addGroup(jPanel1Layout
                                                        .createSequentialGroup()
                                                        .addComponent(jLabel2,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                100,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                        .addComponent(tfContraseña,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                307,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout
                                                        .createSequentialGroup()
                                                        .addComponent(jLabel4,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                170,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(40, 40, 40)
                                                        .addComponent(jScrollPane1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                307,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout
                                                        .createSequentialGroup()
                                                        .addComponent(jLabel1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                150,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(60, 60, 60)
                                                        .addComponent(jScrollPane2))))
                                .addGap(0, 0, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout
                                                .createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel8))
                                        .addComponent(jLabel5))
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane2,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane1,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane3,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout
                                                .createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(btnEnviarCodigo)
                                                        .addComponent(btnVerificar))))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(tfContraseña,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tfConfirmarContraseña,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnRegistrarse,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnRegresar,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 34, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarCodigoActionPerformed(java.awt.event.ActionEvent evt) {
        enviarCodigoCorreo();
    }

    private void tfCodigoKeyReleased(java.awt.event.KeyEvent evt) {
        btnVerificar.setEnabled(habilitarBotonVerificar());
    }

    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {
        verificarCodigo();
    }

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {
        PantallaInicio pi = new PantallaInicio();
        pi.setVisible(true);
        this.setVisible(false);
    }

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {
        registrarUsuario();
    }

    private void tfNombreKeyReleased(java.awt.event.KeyEvent evt) {
        btnRegistrarse.setEnabled(habilitarBotonRegistrarse());
        btnEnviarCodigo.setEnabled(habilitarBotonEnviarCodigo());
    }

    private void tfCorreoKeyReleased(java.awt.event.KeyEvent evt) {
        btnRegistrarse.setEnabled(habilitarBotonRegistrarse());
        btnEnviarCodigo.setEnabled(habilitarBotonEnviarCodigo());
        btnVerificar.setEnabled(habilitarBotonVerificar());
    }

    private void tfContraseñaKeyReleased(java.awt.event.KeyEvent evt) {
        btnRegistrarse.setEnabled(habilitarBotonRegistrarse());
    }

    private void tfConfirmarContraseñaKeyReleased(java.awt.event.KeyEvent evt) {
        btnRegistrarse.setEnabled(habilitarBotonRegistrarse());
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
    private javax.swing.JButton btnEnviarCodigo;
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnVerificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextPane tfCodigo;
    private javax.swing.JPasswordField tfConfirmarContraseña;
    private javax.swing.JPasswordField tfContraseña;
    private javax.swing.JTextPane tfCorreo;
    private javax.swing.JTextPane tfNombre;
    // End of variables declaration//GEN-END:variables
}
