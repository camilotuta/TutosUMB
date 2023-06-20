/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISUAL.Pantallas.Administrador;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import CODE.Clases.Conexion;
import VISUAL.Pantallas.General.PantallaInicio;
import VISUAL.Pantallas.General.PantallaRegistro;

/**
 *
 * @author tutaa
 */
public class PantallaPanelDeControlAdministrativo extends javax.swing.JFrame {

    /**
     * Creates new form PantallaPanelDeControlAdministrativo
     */
    public static String nombreSeleccionado = "", correoSeleccionado = "";

    Conexion cx;

    public PantallaPanelDeControlAdministrativo() {
        initComponents();
        mostrarTablaEstudiantes();
        mostrarTablaUltimaConexion();
        this.setLocationRelativeTo(null);
        this.setTitle("PANEL DE CONTROL ADMINISTRATIVO");
        this.setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/VISUAL/Imagenes/Logos/icon.png")));

        btnEditar.setEnabled(habilitarBotones());
        btnEliminar.setEnabled(habilitarBotones());
        eliminarCuentasInactivas();
    }

    public boolean habilitarBotones() {
        return !tfNombreEstudiante.getText().equals("Ninguno");
    }

    public void mostrarTablaEstudiantes() {
        try {
            cx = new Conexion();
            String sql = "SELECT * FROM usuarios";

            cx.con = Conexion.getConection();
            cx.stmt = cx.con.createStatement();
            cx.rs = cx.stmt.executeQuery(sql);

            // Crear un modelo de tabla
            DefaultTableModel tableModel = new DefaultTableModel();

            // Agregar las columnas al modelo
            ResultSetMetaData metaData = (ResultSetMetaData) cx.rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(metaData.getColumnName(i));
            }
            // Agregar las filas al modelo
            while (cx.rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = cx.rs.getObject(i);
                }
                tableModel.addRow(row);
            }
            tbUsuarios.setModel(tableModel);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mostrarTablaUltimaConexion() {
        try {
            cx = new Conexion();
            String sql = "SELECT * FROM ultimaconexion";

            cx.con = Conexion.getConection();
            cx.stmt = cx.con.createStatement();
            cx.rs = cx.stmt.executeQuery(sql);

            // Crear un modelo de tabla
            DefaultTableModel tableModel = new DefaultTableModel();

            // Agregar las columnas al modelo
            ResultSetMetaData metaData = (ResultSetMetaData) cx.rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(metaData.getColumnName(i));
            }
            // Agregar las filas al modelo
            while (cx.rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = cx.rs.getObject(i);
                }
                tableModel.addRow(row);
            }
            tbUltimaConexion.setModel(tableModel);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void compararMes() {
        cx = new Conexion();
        String sql = "select * from ultimaconexion";

        try {
            cx.con = Conexion.getConection();
            cx.stmt = cx.con.createStatement();
            cx.rs = cx.stmt.executeQuery(sql);

            String correo;
            int mesUltimaConexion;

            while (cx.rs.next()) {
                correo = cx.rs.getString("correo");
                mesUltimaConexion = cx.rs.getInt("conexion");
                int diferenciaMes = PantallaRegistro.mesActual - mesUltimaConexion;

                if (diferenciaMes >= 3 && tomarTipoUsuario(correo) == 1) {
                    eliminarCuentaTodasTablas(correo);
                }
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

    public void eliminarCuentaTodasTablas(String correo) {
        Conexion cx = null;
        try {
            cx = new Conexion();
            cx.con = Conexion.getConection();

            // Eliminar filas de la tabla "usuarios"
            cx.ps = cx.con.prepareStatement("DELETE FROM usuarios WHERE correo = ?");
            cx.ps.setString(1, correo);
            cx.ps.executeUpdate();

            // Eliminar filas de la tabla "gestorestudio"
            cx.ps = cx.con.prepareStatement("DELETE FROM gestorestudio WHERE correo = ?");
            cx.ps.setString(1, correo);
            cx.ps.executeUpdate();

            // Eliminar filas de la tabla "ultimaconexion"
            cx.ps = cx.con.prepareStatement("DELETE FROM ultimaconexion WHERE correo = ?");
            cx.ps.setString(1, correo);
            cx.ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar filas: " + e.toString());
        } finally {
            try {
                if (cx != null) {
                    if (cx.ps != null) {
                        cx.ps.close();
                    }
                    if (cx.con != null) {
                        cx.con.close();
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar conexión: " + e.toString());
            }
        }
        tfNombreEstudiante.setText("Ninguno");
    }

    public void eliminarCuentasInactivas() {
        if (PantallaRegistro.mesActual % 2 == 0) {
            compararMes();
        }
    }

    public int tomarTipoUsuario(String correoBuscar) {
        int tipo = 0;
        try {
            // Validate input
            if (correoBuscar == null || correoBuscar.isEmpty()) {
                JOptionPane.showMessageDialog(null, "El correo no puede estar vacío.");
                return tipo;
            }

            // Get database connection
            try (Connection con = Conexion.getConection();
                    PreparedStatement ps = con.prepareStatement("SELECT tipo FROM usuarios WHERE correo = ?")) {

                ps.setString(1, correoBuscar);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        tipo = rs.getInt("tipo");
                    } else {
                        JOptionPane.showMessageDialog(null, "NO HAY CUENTA ASOCIADA A ESTE CORREO.");
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar la base de datos: " + e.getMessage());
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

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsuarios = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnCrear = new javax.swing.JButton();
        tfNombreEstudiante = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbUltimaConexion = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(247, 251, 252));

        jPanel2.setBackground(new java.awt.Color(247, 247, 247));
        jPanel2.setPreferredSize(new java.awt.Dimension(995, 730));

        tbUsuarios.setBackground(new java.awt.Color(247, 247, 247));
        tbUsuarios.setForeground(new java.awt.Color(51, 51, 51));
        tbUsuarios.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null }
                },
                new String[] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }));
        tbUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbUsuarios);

        btnEliminar.setBackground(new java.awt.Color(220, 220, 220));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(51, 51, 51));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(220, 220, 220));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(51, 51, 51));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Crabs", 1, 90)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Administrar");

        btnRegresar.setBackground(new java.awt.Color(220, 220, 220));
        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(51, 51, 51));
        btnRegresar
                .setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Botones/btnRegresar.png"))); // NOI18N
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(118, 159, 205));
        jLabel6.setIcon(new javax.swing.ImageIcon(
                getClass().getResource("/VISUAL/Imagenes/Logos/imgUMBPequeñoAdministrador.png"))); // NOI18N

        btnCrear.setBackground(new java.awt.Color(220, 220, 220));
        btnCrear.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnCrear.setForeground(new java.awt.Color(51, 51, 51));
        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        tfNombreEstudiante.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        tfNombreEstudiante.setForeground(new java.awt.Color(51, 51, 51));
        tfNombreEstudiante.setText("Ninguno");

        btnActualizar.setBackground(new java.awt.Color(220, 220, 220));
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(51, 51, 51));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        tbUltimaConexion.setBackground(new java.awt.Color(247, 247, 247));
        tbUltimaConexion.setForeground(new java.awt.Color(51, 51, 51));
        tbUltimaConexion.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null }
                },
                new String[] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }));
        jScrollPane2.setViewportView(tbUltimaConexion);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(btnRegresar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel8)
                                                .addGap(153, 153, 153)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jScrollPane1,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 705,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jScrollPane2,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 243,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(14, 14, 14)
                                                                .addComponent(btnCrear)
                                                                .addGap(27, 27, 27)
                                                                .addComponent(tfNombreEstudiante,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btnEditar)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btnEliminar)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btnActualizar)))
                                                .addGap(0, 17, Short.MAX_VALUE)))
                                .addContainerGap()));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addComponent(btnRegresar))
                                                        .addComponent(jLabel6))
                                                .addGap(14, 14, 14))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                jPanel2Layout.createSequentialGroup()
                                                        .addComponent(jLabel8)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 534,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 534,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnEditar)
                                        .addComponent(btnEliminar)
                                        .addComponent(btnCrear)
                                        .addComponent(tfNombreEstudiante)
                                        .addComponent(btnActualizar))
                                .addGap(4, 4, 4)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {
        mostrarTablaEstudiantes();
        mostrarTablaUltimaConexion();
    }

    private void tbUsuariosMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = tbUsuarios.getSelectedRow();
        nombreSeleccionado = tbUsuarios.getValueAt(selectedRow, 0).toString();
        correoSeleccionado = tbUsuarios.getValueAt(selectedRow, 1).toString();
        tfNombreEstudiante.setText(nombreSeleccionado);

        btnEditar.setEnabled(habilitarBotones());
        btnEliminar.setEnabled(habilitarBotones());
    }

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {
        PantallaInicio panIn = new PantallaInicio();
        panIn.setVisible(true);
        this.setVisible(false);
    }

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {
        PantallaCrearUsuario panCreUser = new PantallaCrearUsuario();
        panCreUser.setVisible(true);
        this.setVisible(false);
    }

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {
        nombreSeleccionado = tfNombreEstudiante.getText();

        PantallaModificarUsuario pModUser = new PantallaModificarUsuario();
        pModUser.setVisible(true);
        this.setVisible(false);
    }

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {
        eliminarCuentaTodasTablas(correoSeleccionado);
        mostrarTablaEstudiantes();
        mostrarTablaUltimaConexion();
        btnEditar.setEnabled(habilitarBotones());
        btnEliminar.setEnabled(habilitarBotones());
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
            java.util.logging.Logger.getLogger(PantallaPanelDeControlAdministrativo.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPanelDeControlAdministrativo.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPanelDeControlAdministrativo.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPanelDeControlAdministrativo.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaPanelDeControlAdministrativo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbUltimaConexion;
    private javax.swing.JTable tbUsuarios;
    private javax.swing.JLabel tfNombreEstudiante;
    // End of variables declaration//GEN-END:variables
}
