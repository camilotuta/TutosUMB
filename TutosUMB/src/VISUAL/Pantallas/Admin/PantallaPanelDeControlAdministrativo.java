/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISUAL.Pantallas.Admin;

import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import CODE.Clases.Conexion;

/**
 *
 * @author tutaa
 */
public class PantallaPanelDeControlAdministrativo extends javax.swing.JFrame {

    /**
     * Creates new form PantallaPanelDeControlAdministrativo
     */

    public static String nombreEditar = "";

    public PantallaPanelDeControlAdministrativo() {
        initComponents();
        mostrarTablaEstudiantes();
        this.setLocationRelativeTo(null);
        this.setTitle("PANEL DE CONTROL ADMINISTRATIVO");
        this.setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/VISUAL/Imagenes/Logos/icon.png")));

        btnEditar.setEnabled(habilitarBotones());
        btnEliminar.setEnabled(habilitarBotones());

    }

    public boolean habilitarBotones() {
        return !cbNombreEstudiantes.getSelectedItem().toString().equals("Ninguno");
    }

    public void mostrarTablaEstudiantes() {
        try {
            Conexion cx = new Conexion();
            String sql = "SELECT * FROM usuarios";

            cx.con = cx.getConection();
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
        tomarNombres();
    }

    public void tomarNombres() {
        String sql = "SELECT nombre FROM usuarios";
        Conexion cx = new Conexion();
        try {
            cx.con = cx.getConection();
            cx.stmt = cx.con.createStatement();
            cx.rs = cx.stmt.executeQuery(sql);
            ArrayList<String> nombresEstudiantes = new ArrayList<String>();
            nombresEstudiantes.add("Ninguno");
            while (cx.rs.next()) {
                nombresEstudiantes.add(cx.rs.getString("nombre"));
            }
            if (nombresEstudiantes.size() > 0) {
                DefaultComboBoxModel model = new DefaultComboBoxModel(nombresEstudiantes.toArray());
                cbNombreEstudiantes.setModel(model);
            } else {
                cbNombreEstudiantes.setModel(new DefaultComboBoxModel());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar la base de datos: " + e.getMessage());
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

    public void eliminarUsuario() {
        Conexion cx = new Conexion();
        String nombre = cbNombreEstudiantes.getSelectedItem().toString();
        try {
            cx.con = cx.getConection();
            cx.ps = cx.con.prepareStatement("DELETE FROM usuarios WHERE nombre = ?");
            cx.ps.setString(1, nombre);
            int resultado = cx.ps.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró un usuario con ese nombre.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar usuario: " + e.toString());
        } finally {
            try {
                if (cx.ps != null)
                    cx.ps.close();
                if (cx.con != null)
                    cx.con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar conexión: " + e.toString());
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
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
        canvas1 = new java.awt.Canvas();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsuarios = new javax.swing.JTable();
        cbNombreEstudiantes = new javax.swing.JComboBox<>();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(247, 251, 252));

        jPanel1.setForeground(new java.awt.Color(247, 251, 252));

        jPanel2.setBackground(new java.awt.Color(247, 251, 252));

        jLabel1.setIcon(new javax.swing.ImageIcon(
                getClass().getResource("/VISUAL/Imagenes/Textos/imgAdministrar (Teléfono).png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(118, 159, 205));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Logos/imgUMBPequeño.png"))); // NOI18N

        tbUsuarios.setBackground(new java.awt.Color(247, 251, 252));
        tbUsuarios.setForeground(new java.awt.Color(66, 120, 181));
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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbUsuariosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbUsuarios);

        cbNombreEstudiantes.setBackground(new java.awt.Color(185, 215, 234));
        cbNombreEstudiantes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cbNombreEstudiantes.setForeground(new java.awt.Color(66, 120, 181));
        cbNombreEstudiantes.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbNombreEstudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNombreEstudiantesActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(185, 215, 234));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(66, 120, 181));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(185, 215, 234));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(66, 120, 181));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(70, 70, 70)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addGroup(jPanel2Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(cbNombreEstudiantes,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 475,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 114,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnEliminar))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 760,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(68, 68, 68)
                                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(19, Short.MAX_VALUE)));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel1))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(376, 376, 376)
                                                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 534,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(cbNombreEstudiantes,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnEditar))
                                        .addComponent(btnEliminar))
                                .addContainerGap(22, Short.MAX_VALUE)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
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
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbNombreEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {
        btnEditar.setEnabled(habilitarBotones());
        btnEliminar.setEnabled(habilitarBotones());

    }

    private void tbUsuariosMousePressed(java.awt.event.MouseEvent evt) {
        mostrarTablaEstudiantes();

        btnEditar.setEnabled(habilitarBotones());
        btnEliminar.setEnabled(habilitarBotones());

    }

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {
        nombreEditar = cbNombreEstudiantes.getSelectedItem().toString();

        PantallaModificarUsuario pModUser = new PantallaModificarUsuario();
        pModUser.setVisible(true);
        this.setVisible(false);
    }

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {
        eliminarUsuario();
        mostrarTablaEstudiantes();
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaPanelDeControlAdministrativo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private java.awt.Canvas canvas1;
    private javax.swing.JComboBox<String> cbNombreEstudiantes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbUsuarios;
    // End of variables declaration//GEN-END:variables
}
