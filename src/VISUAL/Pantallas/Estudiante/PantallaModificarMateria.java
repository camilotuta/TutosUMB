/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISUAL.Pantallas.Estudiante;

import java.awt.Color;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import CODE.Clases.Conexion;
import CODE.Clases.Materia;
import VISUAL.Pantallas.General.PantallaRegistro;

/**
 *
 * @author tutaa
 */
public class PantallaModificarMateria extends javax.swing.JFrame {

    /**
     * Creates new form PantallaCrearUsuario
     */
    Color color;

    private Materia materiaModificar = PantallaMateriasEstudiante.materiaSeleccionada;

    public PantallaModificarMateria() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("MODIFICAR MATERIA");
        this.setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit()
                .getImage(getClass().getResource("/VISUAL/Imagenes/Logos/icon.png")));

        tomarNombres();
        ponerDatosMateria();
        cambiarColores();
    }

    public boolean habilitarBotonConfirmar() {
        return tfNombre.getText().length() > 7 && textFieldContieneNumero()
                && tfDescripcion.getText().length() > 7
                && !cbNombreProfesor.getSelectedItem().toString().equals("Ninguno");

    }

    public void ponerDatosMateria() {
        tfNombre.setText(materiaModificar.getNombre());
        tfNota.setText(String.valueOf(materiaModificar.getNota()));
        cbNombreProfesor.setSelectedItem(materiaModificar.getProfesor());
        tfDescripcion.setText(materiaModificar.getDescripcion());
    }

    public void modificarMateria() {
        String correo = PantallaRegistro.correoPoner;
        Conexion cx = new Conexion();
        cx.con = Conexion.getConection();

        String nombreMateriaAntigua = materiaModificar.getNombre();
        double notaMateriaAntigua = materiaModificar.getNota();
        String descripcionMateriaAntigua = materiaModificar.getDescripcion();
        String profesorMateriaAntigua = materiaModificar.getProfesor();

        String nombreMateriaNueva = tfNombre.getText();
        double notaMateriaNueva = Double.parseDouble(tfNota.getText());
        String descripcionMateriaNueva = tfDescripcion.getText();
        String profesorMateriaNueva = cbNombreProfesor.getSelectedItem().toString();

        try {
            String sql = "UPDATE gestorestudio SET dato1 = ?, dato2 = ?, dato3 = ?, dato4 = ? WHERE correo = ? AND tipo = ? AND dato1 = ? AND dato2 = ? AND dato3 = ? AND dato4 = ?";
            cx.ps = cx.con.prepareStatement(sql);
            cx.ps.setString(1, nombreMateriaNueva);
            cx.ps.setDouble(2, notaMateriaNueva);
            cx.ps.setString(3, profesorMateriaNueva);
            cx.ps.setString(4, descripcionMateriaNueva);
            cx.ps.setString(5, correo);
            cx.ps.setInt(6, 0);
            cx.ps.setString(7, nombreMateriaAntigua);
            cx.ps.setDouble(8, notaMateriaAntigua);
            cx.ps.setString(9, profesorMateriaAntigua);
            cx.ps.setString(10, descripcionMateriaAntigua);

            cx.ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "SU MATERIA HA SIDO ACTUALIZADA.");

            PantallaMateriasEstudiante panMatEst = new PantallaMateriasEstudiante();
            panMatEst.setVisible(true);

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
    }

    public boolean textFieldContieneNumero() {
        String texto = tfNota.getText();

        String patronNumero = "^-?\\d+(\\.\\d+)?$";

        Pattern patron = Pattern.compile(patronNumero);
        Matcher matcher = patron.matcher(texto);

        double numero = 0.0;
        try {
            numero = Double.parseDouble(texto);
        } catch (Exception e) {
            // ! pass
        }

        return matcher.matches() && numero <= 5;
    }

    public void tomarNombres() {
        String sql = "SELECT nombre FROM usuarios WHERE tipo = 2";
        Conexion cx = new Conexion();
        try {
            cx.con = Conexion.getConection();
            cx.stmt = cx.con.createStatement();
            cx.rs = cx.stmt.executeQuery(sql);
            ArrayList<String> nombresProfesores = new ArrayList<String>();
            nombresProfesores.add("Ninguno");
            while (cx.rs.next()) {
                nombresProfesores.add(cx.rs.getString("nombre"));
            }
            if (nombresProfesores.size() > 0) {
                DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(
                        nombresProfesores.toArray(new String[0]));
                cbNombreProfesor.setModel(model);
            } else {
                cbNombreProfesor.setModel(new DefaultComboBoxModel<String>());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar la base de datos: " + e.getMessage());
        } finally {
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

    public void cambiarColores() {
        if (textFieldContieneNumero()) {
            color = new Color(64, 128, 89);
            lbNota.setForeground(color);
        } else {
            color = new Color(255, 102, 102);
            lbNota.setForeground(color);
        }

        if (tfNombre.getText().length() > 7) {
            color = new Color(64, 128, 89);
            lbNombre.setForeground(color);
        } else {
            color = new Color(255, 102, 102);
            lbNombre.setForeground(color);
        }

        if (tfDescripcion.getText().length() > 7) {
            color = new Color(64, 128, 89);
            lbDescripcion.setForeground(color);
        } else {
            color = new Color(255, 102, 102);
            lbDescripcion.setForeground(color);
        }
        btnConfirmar.setEnabled(habilitarBotonConfirmar());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     *
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
        tfNota = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tfDescripcion = new javax.swing.JTextPane();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        lbNota = new javax.swing.JLabel();
        lbDescripcion = new javax.swing.JLabel();
        cbNombreProfesor = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(247, 251, 252));
        setMinimumSize(new java.awt.Dimension(650, 520));

        jPanel1.setForeground(new java.awt.Color(247, 251, 252));
        jPanel1.setMaximumSize(new java.awt.Dimension(839, 520));
        jPanel1.setMinimumSize(new java.awt.Dimension(839, 520));

        jPanel2.setBackground(new java.awt.Color(247, 251, 252));
        jPanel2.setMaximumSize(new java.awt.Dimension(650, 520));
        jPanel2.setMinimumSize(new java.awt.Dimension(650, 520));

        btnCancelar.setBackground(new java.awt.Color(185, 215, 234));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(118, 159, 205));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnConfirmar.setBackground(new java.awt.Color(185, 215, 234));
        btnConfirmar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnConfirmar.setForeground(new java.awt.Color(118, 159, 205));
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        tfNombre.setBackground(new java.awt.Color(247, 251, 252));
        tfNombre.setForeground(new java.awt.Color(118, 159, 205));
        tfNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfNombreKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tfNombre);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(118, 159, 205));
        jLabel2.setText("NOMBRE:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(118, 159, 205));
        jLabel4.setText("NOTA:");

        tfNota.setBackground(new java.awt.Color(247, 251, 252));
        tfNota.setForeground(new java.awt.Color(118, 159, 205));
        tfNota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfNotaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tfNota);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(118, 159, 205));
        jLabel3.setText("PROFESOR:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(118, 159, 205));
        jLabel6.setText("DESCRIPCIÓN:");

        tfDescripcion.setBackground(new java.awt.Color(247, 251, 252));
        tfDescripcion.setForeground(new java.awt.Color(118, 159, 205));
        tfDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfDescripcionKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tfDescripcion);

        jLabel8.setBackground(new java.awt.Color(85, 85, 85));
        jLabel8.setFont(new java.awt.Font("Crabs", 1, 60)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(118, 159, 205));
        jLabel8.setText("Editar Materia");

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(118, 159, 205));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Logos/imgUMBPequeño.png"))); // NOI18N

        lbNombre.setForeground(new java.awt.Color(255, 102, 102));
        lbNombre.setText("Más de 8 carácteres");

        lbNota.setForeground(new java.awt.Color(255, 102, 102));
        lbNota.setText("Debe ser un número entre 0 y 5");

        lbDescripcion.setForeground(new java.awt.Color(255, 102, 102));
        lbDescripcion.setText("Más de 8 carácteres");

        cbNombreProfesor.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbNombreProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNombreProfesorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(58, 58, 58)
                                                .addComponent(btnConfirmar)
                                                .addGap(200, 200, 200)
                                                .addComponent(btnCancelar))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(jLabel6,
                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel3))
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jScrollPane2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                307,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jScrollPane1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                307,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lbNombre)
                                                                        .addComponent(lbNota)))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                jPanel2Layout.createSequentialGroup()
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(
                                                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                        jPanel2Layout
                                                                                                .createParallelGroup(
                                                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(
                                                                                                        lbDescripcion)
                                                                                                .addComponent(
                                                                                                        jScrollPane4,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                        307,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addComponent(cbNombreProfesor,
                                                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        307,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))))));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addComponent(jLabel8)))
                                .addGap(7, 7, 7)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel2))
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbNombre)
                                .addGap(28, 28, 28)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel4))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbNota)
                                .addGap(36, 36, 36)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(cbNombreProfesor, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel6))
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbDescripcion)
                                .addGap(29, 29, 29)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnConfirmar)
                                        .addComponent(btnCancelar))
                                .addContainerGap(55, Short.MAX_VALUE)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbNombreProfesorActionPerformed(java.awt.event.ActionEvent evt) {
        btnConfirmar.setEnabled(habilitarBotonConfirmar());
    }

    private void tfNombreKeyReleased(java.awt.event.KeyEvent evt) {
        cambiarColores();
    }

    private void tfNotaKeyReleased(java.awt.event.KeyEvent evt) {
        cambiarColores();
    }

    private void tfDescripcionKeyReleased(java.awt.event.KeyEvent evt) {
        cambiarColores();
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        PantallaMateriasEstudiante panMatEst = new PantallaMateriasEstudiante();
        panMatEst.setVisible(true);
        this.setVisible(false);
    }

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {
        modificarMateria();
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
            java.util.logging.Logger.getLogger(PantallaModificarMateria.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaModificarMateria.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaModificarMateria.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaModificarMateria.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaModificarMateria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JComboBox<String> cbNombreProfesor;
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbDescripcion;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbNota;
    private javax.swing.JTextPane tfDescripcion;
    private javax.swing.JTextPane tfNombre;
    private javax.swing.JTextPane tfNota;
    // End of variables declaration//GEN-END:variables
}
