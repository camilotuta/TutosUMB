/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISUAL.Pantallas.Estudiante;

import VISUAL.Pantallas.General.PantallaInicio;
import VISUAL.Pantallas.General.PantallaRegistro;
import CODE.Clases.Conexion;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author tutaa
 */
// TODO: HACER UN GENERADOR DE LINKS PARA SESIONES DE TEAMS
public class PantallaCalendarioEstudiante extends javax.swing.JFrame {

    String materia, fecha, hora, fechaHoraMateria, estado = "En proceso", link = "Pendiente";
    Conexion cx;

    String correo = PantallaRegistro.correoPoner;

    /**
     * Creates new form PantallaCalendarioEstudiante
     */
    public PantallaCalendarioEstudiante() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit()
                .getImage(getClass().getResource("/VISUAL/Imagenes/Logos/icon.png")));

        this.setLocationRelativeTo(null);
        this.setTitle("CALENDARIO");
        this.setResizable(false);

        tfFechaNuevaSesion.setEditable(false);
        tfFechaNuevaSesion.setHorizontalAlignment(JTextField.CENTER);
        btnSolicitar.setEnabled(desactivarBotonSolicitar());

        jCalendar.setMinSelectableDate(new Date());

        ponerMateriasComboBox();

        tfFechaNuevaSesion.setText("SELECCIONE EL DIA.");
    }

    public void cambiarTexto() {
        if (!tfFechaNuevaSesion.getText().isEmpty()) {
            fechaHoraMateria = null;
            jCalendar.addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    cambiarHoraMateria();
                }
            });
        }
    }

    public boolean desactivarBotonSolicitar() {
        return (!tfFechaNuevaSesion.getText().equals("SELECCIONE EL DIA."));
    }

    public void cambiarHoraMateria() {
        SimpleDateFormat ff = new SimpleDateFormat("dd/MM/yyyy");
        fecha = (ff.format(jCalendar.getCalendar().getTime()));

        hora = cbHora.getSelectedItem().toString();
        materia = cbMateria.getSelectedItem().toString();
        fechaHoraMateria = fecha + " - " + hora + " - " + materia;

        tfFechaNuevaSesion.setText(fechaHoraMateria);
        btnSolicitar.setEnabled(true);
    }

    public void ponerMateriasComboBox() {
        cx = new Conexion();
        String sql = "SELECT * FROM gestorestudio WHERE tipo = 0 AND correo = '" + correo + "'";

        try {
            cx.con = Conexion.getConection();
            cx.stmt = cx.con.createStatement();
            cx.rs = cx.stmt.executeQuery(sql);

            String texto = "";
            while (cx.rs.next()) {
                String nombreMateria = cx.rs.getString(3); // Obtener el valor de la columna 3
                cbMateria.addItem(nombreMateria);
                texto += nombreMateria + " ";
            }

            if (texto.isEmpty()) {
                tfFechaNuevaSesion.setEnabled(false);
                cbHora.setEnabled(false);
                cbMateria.setEnabled(false);
                btnSolicitar.setEnabled(false);
                jCalendar.setEnabled(false);

            }

        } catch (SQLException e) {
            System.out.println(e);
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
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    public void crearSesion() {
        int tipo = 1;
        String fechaPoner = fecha + " " + hora;

        cx = new Conexion();
        try {
            cx.con = Conexion.getConection();
            if (cx.con == null) {
                JOptionPane.showMessageDialog(null,
                        "No se pudo establecer una conexión a la base de datos.");
            } else {
                cx.stmt = cx.con.createStatement();
                cx.stmt.executeUpdate(
                        "INSERT INTO gestorestudio(correo, tipo,dato1, dato2, dato3,dato4) VALUES('"
                                + correo + "','" + tipo + "','"
                                + materia + "','"
                                + link + "','" + fechaPoner + "','" + estado + "')");

                JOptionPane.showMessageDialog(null, "SE HIZO LA SOLICITUD.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
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
        jCalendar = new com.toedter.calendar.JCalendar();
        jLabel1 = new javax.swing.JLabel();
        btnSolicitar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfFechaNuevaSesion = new javax.swing.JTextField();
        cbMateria = new javax.swing.JComboBox<>();
        cbHora = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnCrearMateria = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(936, 550));

        jPanel1.setBackground(new java.awt.Color(247, 251, 252));
        jPanel1.setMaximumSize(new java.awt.Dimension(936, 550));
        jPanel1.setMinimumSize(new java.awt.Dimension(936, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel1.add(btnCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 210, 97));

        btnSesiones.setBackground(new java.awt.Color(185, 215, 234));
        btnSesiones.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSesiones.setForeground(new java.awt.Color(66, 120, 181));
        btnSesiones
                .setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Botones/imgSesiones.png"))); // NOI18N
        btnSesiones.setText("SESIONES");
        btnSesiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSesionesActionPerformed(evt);
            }
        });
        jPanel1.add(btnSesiones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 218, 210, 97));

        btnCambiarCuenta.setBackground(new java.awt.Color(185, 215, 234));
        btnCambiarCuenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCambiarCuenta.setForeground(new java.awt.Color(66, 120, 181));
        btnCambiarCuenta.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Botones/imgCambiarCuenta.png"))); // NOI18N
        btnCambiarCuenta.setText("CAMBIAR CUENTA");
        btnCambiarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarCuentaActionPerformed(evt);
            }
        });
        jPanel1.add(btnCambiarCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 321, 210, 97));

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
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 424, 210, 97));

        btnCalendario.setBackground(new java.awt.Color(185, 215, 234));
        btnCalendario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCalendario.setForeground(new java.awt.Color(66, 120, 181));
        btnCalendario.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Botones/imgCalendario.png"))); // NOI18N
        btnCalendario.setText("CALENDARIO");
        btnCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalendarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnCalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 115, 210, 97));

        jCalendar.setBackground(java.awt.Color.lightGray);
        jCalendar.setForeground(new java.awt.Color(66, 120, 181));
        jCalendar.setDecorationBackgroundColor(new java.awt.Color(247, 251, 252));
        jCalendar.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                jCalendarHierarchyChanged(evt);
            }
        });
        jPanel1.add(jCalendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 440, 260));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(118, 159, 205));
        jLabel1.setText("HORA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 150, -1, -1));

        btnSolicitar.setBackground(new java.awt.Color(185, 215, 234));
        btnSolicitar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSolicitar.setForeground(new java.awt.Color(118, 159, 205));
        btnSolicitar.setText("Solicitar");
        btnSolicitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSolicitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 482, 90, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(118, 159, 205));
        jLabel2.setText("FECHA NUEVA SESION");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(484, 414, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(118, 159, 205));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Logos/imgUMBPequeño.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, 100, -1));

        tfFechaNuevaSesion.setBackground(new java.awt.Color(247, 251, 252));
        tfFechaNuevaSesion.setForeground(new java.awt.Color(66, 120, 181));
        jPanel1.add(tfFechaNuevaSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 440, 352, 30));

        cbMateria.setBackground(java.awt.Color.lightGray);
        cbMateria.setForeground(new java.awt.Color(66, 120, 181));
        cbMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMateriaActionPerformed(evt);
            }
        });
        jPanel1.add(cbMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 310, 190, 30));

        cbHora.setBackground(java.awt.Color.lightGray);
        cbHora.setForeground(new java.awt.Color(66, 120, 181));
        cbHora.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "8:00 a.m", "9:00 a.m", "10:00 a.m", "11:00 a.m", "12:00 mm", "1:00 p.m", "2:00 p.m",
                        "3:00 p.m", "4:00 p.m", "5:00 p.m", "6:00 p.m", "7:00 p.m", "8:00 p.m" }));
        cbHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHoraActionPerformed(evt);
            }
        });
        jPanel1.add(cbHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 180, 130, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(118, 159, 205));
        jLabel3.setText("MATERIA");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 280, -1, -1));

        jLabel6.setFont(new java.awt.Font("Crabs", 1, 55)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(118, 159, 205));
        jLabel6.setText("Programar Sesión");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 21, -1, -1));

        btnCrearMateria.setBackground(new java.awt.Color(185, 215, 234));
        btnCrearMateria.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCrearMateria.setForeground(new java.awt.Color(118, 159, 205));
        btnCrearMateria.setText("Crear materia");
        btnCrearMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearMateriaActionPerformed(evt);
            }
        });
        jPanel1.add(btnCrearMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 350, -1, -1));

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

    private void btnCrearMateriaActionPerformed(java.awt.event.ActionEvent evt) {
        PantallaCrearMateria panCreMat = new PantallaCrearMateria();
        panCreMat.setVisible(true);
        this.setVisible(false);
    }

    private void cbHoraActionPerformed(java.awt.event.ActionEvent evt) {
        cambiarHoraMateria();
        btnSolicitar.setEnabled(desactivarBotonSolicitar());
    }

    private void cbMateriaActionPerformed(java.awt.event.ActionEvent evt) {
        cambiarHoraMateria();
        btnSolicitar.setEnabled(desactivarBotonSolicitar());
    }

    private void jCalendarHierarchyChanged(java.awt.event.HierarchyEvent evt) {
        cambiarTexto();
        btnSolicitar.setEnabled(desactivarBotonSolicitar());
    }

    private void btnCuentaActionPerformed(java.awt.event.ActionEvent evt) {
        PantallaCuentaEstudiante cuenta = new PantallaCuentaEstudiante();
        cuenta.setVisible(true);
        this.setVisible(false);
    }

    private void btnSesionesActionPerformed(java.awt.event.ActionEvent evt) {
        PantallaSesionesEstudiante ses = new PantallaSesionesEstudiante();
        ses.setVisible(true);
        this.setVisible(false);
    }

    private void btnCambiarCuentaActionPerformed(java.awt.event.ActionEvent evt) {
        PantallaInicio pantalla = new PantallaInicio();
        pantalla.setVisible(true);
        this.setVisible(false);
    }

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void btnCalendarioActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(null, "YA SE ENCUENTRA EN ESTA PESTAÑA");
    }

    private void btnSolicitarActionPerformed(java.awt.event.ActionEvent evt) {
        crearSesion();
        btnSolicitar.setEnabled(false);
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
            java.util.logging.Logger.getLogger(PantallaCalendarioEstudiante.class.getName()).log(
                    java.util.logging.Level.SEVERE,
                    null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaCalendarioEstudiante.class.getName()).log(
                    java.util.logging.Level.SEVERE,
                    null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaCalendarioEstudiante.class.getName()).log(
                    java.util.logging.Level.SEVERE,
                    null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaCalendarioEstudiante.class.getName()).log(
                    java.util.logging.Level.SEVERE,
                    null,
                    ex);
        }
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaCalendarioEstudiante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalendario;
    private javax.swing.JButton btnCambiarCuenta;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCrearMateria;
    private javax.swing.JButton btnCuenta;
    private javax.swing.JButton btnSesiones;
    private javax.swing.JButton btnSolicitar;
    private javax.swing.JComboBox<String> cbHora;
    private javax.swing.JComboBox<String> cbMateria;
    private com.toedter.calendar.JCalendar jCalendar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tfFechaNuevaSesion;
    // End of variables declaration//GEN-END:variables
}
