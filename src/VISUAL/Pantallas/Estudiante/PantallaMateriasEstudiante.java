/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISUAL.Pantallas.Estudiante;

import VISUAL.Pantallas.General.PantallaInicio;
import VISUAL.Pantallas.General.PantallaRegistro;

import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import CODE.Clases.Conexion;
import CODE.Clases.Materia;

/**
 *
 * @author tutaa
 */

// TODO: HACER CALCULADORA DE NOTAS
// TODO: QUE NO HAYAN NOMBRES DE MATERIAS REPETIDOS
public class PantallaMateriasEstudiante extends javax.swing.JFrame {

        public static Materia materiaSeleccionada;

        /**
         * Creates new form PantallaMateriasEstudiante
         */
        public PantallaMateriasEstudiante() {
                initComponents();
                this.setLocationRelativeTo(null);
                this.setTitle("TUS MATERIAS");
                this.setResizable(false);

                materiaSeleccionada = null;

                mostrarTablaMaterias();
                setIconImage(Toolkit.getDefaultToolkit()
                                .getImage(getClass().getResource("/VISUAL/Imagenes/Logos/icon.png")));
                cargarAnaliticas();
                btnModificarMateria.setEnabled(activarBotones());
                btnEliminarMateria.setEnabled(activarBotones());
        }

        public void mostrarTablaMaterias() {
                String correo = PantallaRegistro.correoPoner;
                try {
                        Conexion cx = new Conexion();
                        String sql = "SELECT * FROM gestorestudio WHERE tipo = 0 AND correo = '" + correo + "'";

                        cx.con = Conexion.getConection();
                        cx.stmt = cx.con.createStatement();
                        cx.rs = cx.stmt.executeQuery(sql);

                        // Crear un modelo de tabla
                        DefaultTableModel tableModel = new DefaultTableModel();

                        // Agregar las columnas al modelo
                        ResultSetMetaData metaData = (ResultSetMetaData) cx.rs.getMetaData();
                        int columnCount = metaData.getColumnCount();

                        tableModel.addColumn("NOMBRE");
                        tableModel.addColumn("NOTA");
                        tableModel.addColumn("PROFESOR");
                        tableModel.addColumn("DESCRIPCIÓN");
                        tbInfoMaterias.setModel(tableModel);

                        while (cx.rs.next()) {
                                Object[] row = new Object[columnCount - 2]; // Ignorar las primeras 2 columnas
                                for (int i = 3; i <= columnCount; i++) {
                                        row[i - 3] = cx.rs.getObject(i); // Restar 3 para ajustar el índice del arreglo
                                                                         // row
                                }
                                tableModel.addRow(row);
                        }

                        tbInfoMaterias.setModel(tableModel);

                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }

        public void cargarAnaliticas() {
                // & PROMEDIO
                DefaultTableModel model = (DefaultTableModel) tbInfoMaterias.getModel();
                ArrayList<Double> notas = new ArrayList<Double>();

                int rowCount = model.getRowCount();
                int columnCount = model.getColumnCount();
                double suma = 0.0;
                double promedio = 0.0;
                double promedioRound = 0.0;

                double desviacionEst = 0.0;
                double desviacionRound = 0.0;

                if (columnCount >= 2 && rowCount > 0) {
                        for (int i = 0; i < rowCount; i++) {
                                double nota = Double.parseDouble(model.getValueAt(i, 1).toString());
                                notas.add(nota);
                                suma += nota;
                        }
                        promedio = suma / rowCount;
                        promedioRound = ((double) Math.round(promedio * 100.0) / 100.0);

                        // & DESVIACIÓN ESTÁNDAR
                        ArrayList<Double> diferenciaAbsolutaNotas = new ArrayList<Double>();
                        for (double i : notas) {
                                double diferencia = i - promedio;
                                diferenciaAbsolutaNotas.add(diferencia);
                        }
                        double sumaDiferencia = 0.0;

                        for (double i : diferenciaAbsolutaNotas) {
                                sumaDiferencia += Math.pow(i, 2);
                        }

                        desviacionEst = sumaDiferencia / diferenciaAbsolutaNotas.size();
                        double raizDesviacion = Math.sqrt(desviacionEst);
                        desviacionRound = ((double) Math.round(raizDesviacion * 100.0) / 100.0);

                }

                // & PERIODO
                Calendar calendario = Calendar.getInstance();
                int añoActual = calendario.get(Calendar.YEAR);
                int mesActual = calendario.get(Calendar.MONTH);
                String periodo = "";

                if (mesActual <= 5) {
                        periodo = "1";
                } else if (mesActual >= 7) {
                        periodo = "2";
                } else {
                        periodo = "0";
                }

                String textPeriodo = añoActual + "-" + periodo;

                lbPromedio.setText(String.valueOf(promedioRound));
                lbDesviacionEstandar.setText(String.valueOf(desviacionRound));
                lbPeriodo.setText(textPeriodo);
        }

        public boolean activarBotones() {
                return materiaSeleccionada != null;
        }

        public void eliminarMateria() {
                Conexion cx = new Conexion();
                String correo = PantallaRegistro.correoPoner;
                String nombreMateriaBorrar = materiaSeleccionada.getNombre();
                try {
                        cx.con = Conexion.getConection();
                        cx.ps = cx.con.prepareStatement("DELETE FROM gestorestudio WHERE correo = ? and dato1 = ?");
                        cx.ps.setString(1, correo);
                        cx.ps.setString(2, nombreMateriaBorrar);
                        int resultado = cx.ps.executeUpdate();

                        if (resultado > 0) {
                                JOptionPane.showMessageDialog(null, "Materia eliminada correctamente.");
                        } else {
                                JOptionPane.showMessageDialog(null, "No se encontró la materia con ese nombre.");
                        }
                } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Error al eliminar usuario: " + e.toString());
                } finally {
                        try {
                                if (cx.ps != null) {
                                        cx.ps.close();
                                }
                                if (cx.con != null) {
                                        cx.con.close();
                                }
                        } catch (SQLException e) {
                                JOptionPane.showMessageDialog(null, "Error al cerrar conexión: " + e.toString());
                        }
                }
                materiaSeleccionada = null;

                btnModificarMateria.setEnabled(activarBotones());
                btnEliminarMateria.setEnabled(activarBotones());

                mostrarTablaMaterias();
        }

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

                popupMenu1 = new java.awt.PopupMenu();
                popupMenu2 = new java.awt.PopupMenu();
                jPanel1 = new javax.swing.JPanel();
                jScrollPane1 = new javax.swing.JScrollPane();
                tbInfoMaterias = new javax.swing.JTable();
                btnCuenta = new javax.swing.JButton();
                btnCalendario = new javax.swing.JButton();
                btnSesiones = new javax.swing.JButton();
                btnCambiarCuenta = new javax.swing.JButton();
                btnCerrar = new javax.swing.JButton();
                jLabel8 = new javax.swing.JLabel();
                jLabel6 = new javax.swing.JLabel();
                btnCrearMateria = new javax.swing.JButton();
                jLabel1 = new javax.swing.JLabel();
                lbPromedio = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                lbDesviacionEstandar = new javax.swing.JLabel();
                jLabel5 = new javax.swing.JLabel();
                lbPeriodo = new javax.swing.JLabel();
                btnModificarMateria = new javax.swing.JButton();
                btnEliminarMateria = new javax.swing.JButton();
                btnCalculadoraNotas = new javax.swing.JButton();

                popupMenu1.setLabel("popupMenu1");

                popupMenu2.setLabel("popupMenu2");

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jPanel1.setBackground(new java.awt.Color(247, 251, 252));
                jPanel1.setMinimumSize(new java.awt.Dimension(936, 550));

                tbInfoMaterias.setBackground(new java.awt.Color(247, 251, 252));
                tbInfoMaterias.setForeground(new java.awt.Color(118, 159, 205));
                tbInfoMaterias.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {
                                                { null, null, null },
                                                { null, null, null },
                                                { null, null, null },
                                                { null, null, null }
                                },
                                new String[] {
                                                "MATERIA", "MENSAJE", "FECHA"
                                }) {
                        Class[] types = new Class[] {
                                        java.lang.String.class, java.lang.String.class, java.lang.String.class
                        };
                        boolean[] canEdit = new boolean[] {
                                        false, false, false
                        };

                        public Class getColumnClass(int columnIndex) {
                                return types[columnIndex];
                        }

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit[columnIndex];
                        }
                });
                tbInfoMaterias.setColumnSelectionAllowed(true);
                tbInfoMaterias.getTableHeader().setReorderingAllowed(false);
                tbInfoMaterias.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                tbInfoMateriasMouseClicked(evt);
                        }
                });
                jScrollPane1.setViewportView(tbInfoMaterias);
                tbInfoMaterias.getColumnModel().getSelectionModel()
                                .setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
                if (tbInfoMaterias.getColumnModel().getColumnCount() > 0) {
                        tbInfoMaterias.getColumnModel().getColumn(0).setResizable(false);
                        tbInfoMaterias.getColumnModel().getColumn(1).setResizable(false);
                        tbInfoMaterias.getColumnModel().getColumn(2).setResizable(false);
                }

                btnCuenta.setBackground(new java.awt.Color(185, 215, 234));
                btnCuenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                btnCuenta.setForeground(new java.awt.Color(66, 120, 181));
                btnCuenta.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource("/VISUAL/Imagenes/Botones/imgCuenta.png"))); // NOI18N
                btnCuenta.setText("CUENTA");
                btnCuenta.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCuentaActionPerformed(evt);
                        }
                });

                btnCalendario.setBackground(new java.awt.Color(185, 215, 234));
                btnCalendario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                btnCalendario.setForeground(new java.awt.Color(66, 120, 181));
                btnCalendario.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource("/VISUAL/Imagenes/Botones/imgCalendario.png"))); // NOI18N
                btnCalendario.setText("CALENDARIO");
                btnCalendario.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCalendarioActionPerformed(evt);
                        }
                });

                btnSesiones.setBackground(new java.awt.Color(185, 215, 234));
                btnSesiones.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                btnSesiones.setForeground(new java.awt.Color(66, 120, 181));
                btnSesiones.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource("/VISUAL/Imagenes/Botones/imgSesiones.png"))); // NOI18N
                btnSesiones.setText("SESIONES");
                btnSesiones.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnSesionesActionPerformed(evt);
                        }
                });

                btnCambiarCuenta.setBackground(new java.awt.Color(185, 215, 234));
                btnCambiarCuenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                btnCambiarCuenta.setForeground(new java.awt.Color(66, 120, 181));
                btnCambiarCuenta.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource("/VISUAL/Imagenes/Botones/imgCambiarCuenta.png"))); // NOI18N
                btnCambiarCuenta.setText("CAMBIAR CUENTA");
                btnCambiarCuenta.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCambiarCuentaActionPerformed(evt);
                        }
                });

                btnCerrar.setBackground(new java.awt.Color(185, 215, 234));
                btnCerrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                btnCerrar.setForeground(new java.awt.Color(66, 120, 181));
                btnCerrar.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource("/VISUAL/Imagenes/Botones/imgCerrar.png"))); // NOI18N
                btnCerrar.setText("CERRAR");
                btnCerrar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCerrarActionPerformed(evt);
                        }
                });

                jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
                jLabel8.setForeground(new java.awt.Color(118, 159, 205));
                jLabel8.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource("/VISUAL/Imagenes/Logos/imgUMBPequeño.png"))); // NOI18N

                jLabel6.setFont(new java.awt.Font("Crabs", 1, 60)); // NOI18N
                jLabel6.setForeground(new java.awt.Color(118, 159, 205));
                jLabel6.setText("Tús Materias");

                btnCrearMateria.setBackground(new java.awt.Color(185, 215, 234));
                btnCrearMateria.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                btnCrearMateria.setForeground(new java.awt.Color(118, 159, 205));
                btnCrearMateria.setText("Crear");
                btnCrearMateria.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCrearMateriaActionPerformed(evt);
                        }
                });

                jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(118, 159, 205));
                jLabel1.setText("PROMEDIO:");

                lbPromedio.setText("0");

                jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jLabel3.setForeground(new java.awt.Color(118, 159, 205));
                jLabel3.setText("DESVIACIÓN ESTÁNDAR:");

                lbDesviacionEstandar.setText("0");

                jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jLabel5.setForeground(new java.awt.Color(118, 159, 205));
                jLabel5.setText("PERIODO:");

                lbPeriodo.setText("-");

                btnModificarMateria.setBackground(new java.awt.Color(185, 215, 234));
                btnModificarMateria.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                btnModificarMateria.setForeground(new java.awt.Color(118, 159, 205));
                btnModificarMateria.setText("Modificar");
                btnModificarMateria.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnModificarMateriaActionPerformed(evt);
                        }
                });

                btnEliminarMateria.setBackground(new java.awt.Color(185, 215, 234));
                btnEliminarMateria.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                btnEliminarMateria.setForeground(new java.awt.Color(118, 159, 205));
                btnEliminarMateria.setText("Eliminar");
                btnEliminarMateria.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnEliminarMateriaActionPerformed(evt);
                        }
                });

                btnCalculadoraNotas.setBackground(new java.awt.Color(185, 215, 234));
                btnCalculadoraNotas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                btnCalculadoraNotas.setForeground(new java.awt.Color(118, 159, 205));
                btnCalculadoraNotas.setText("Calculadora de notas");
                btnCalculadoraNotas.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCalculadoraNotasActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(btnCuenta,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                210,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(btnCalendario,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                210,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(btnSesiones,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                210,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(btnCambiarCuenta,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                210,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(btnCerrar,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                210,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(60, 60, 60)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(109, 109, 109)
                                                                                                .addComponent(jLabel6)
                                                                                                .addGap(105, 105, 105)
                                                                                                .addComponent(jLabel8,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                100,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addComponent(jScrollPane1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                577,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabel1)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(lbPromedio)
                                                                                                .addGap(78, 78, 78)
                                                                                                .addComponent(jLabel3)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(lbDesviacionEstandar)
                                                                                                .addGap(108, 108, 108)
                                                                                                .addComponent(jLabel5)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(lbPeriodo))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(10, 10, 10)
                                                                                                .addComponent(btnCrearMateria)
                                                                                                .addGap(39, 39, 39)
                                                                                                .addComponent(btnModificarMateria)
                                                                                                .addGap(51, 51, 51)
                                                                                                .addComponent(btnEliminarMateria)
                                                                                                .addGap(46, 46, 46)
                                                                                                .addComponent(btnCalculadoraNotas)))));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(15, 15, 15)
                                                                .addComponent(btnCuenta,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                97,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(6, 6, 6)
                                                                .addComponent(btnCalendario,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                97,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(6, 6, 6)
                                                                .addComponent(btnSesiones,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                97,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(6, 6, 6)
                                                                .addComponent(btnCambiarCuenta,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                97,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(6, 6, 6)
                                                                .addComponent(btnCerrar,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                97,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(40, 40, 40)
                                                                                                .addComponent(jLabel6))
                                                                                .addComponent(jLabel8))
                                                                .addComponent(jScrollPane1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                327,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel1)
                                                                                .addComponent(lbPromedio)
                                                                                .addComponent(jLabel3)
                                                                                .addComponent(lbDesviacionEstandar)
                                                                                .addComponent(jLabel5)
                                                                                .addComponent(lbPeriodo))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(btnCrearMateria)
                                                                                .addComponent(btnModificarMateria)
                                                                                .addComponent(btnEliminarMateria)
                                                                                .addComponent(btnCalculadoraNotas))));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void btnEliminarMateriaActionPerformed(java.awt.event.ActionEvent evt) {
                int continuar = JOptionPane.showConfirmDialog(null,
                                "¿Está seguro de borrar " + materiaSeleccionada.getNombre() + "?",
                                "Confirmar acción", JOptionPane.YES_NO_OPTION);
                if (continuar == JOptionPane.YES_OPTION) {
                        eliminarMateria();
                } else {
                        tbInfoMaterias.clearSelection();
                        materiaSeleccionada = null;

                        btnModificarMateria.setEnabled(activarBotones());
                        btnEliminarMateria.setEnabled(activarBotones());
                }

        }

        private void btnCalculadoraNotasActionPerformed(java.awt.event.ActionEvent evt) {
                PantallaCalculadoraNotas panCalNot = new PantallaCalculadoraNotas();
                panCalNot.setVisible(true);
                this.setVisible(false);
        }

        private void tbInfoMateriasMouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = tbInfoMaterias.getSelectedRow();
                String nombreMateria = tbInfoMaterias.getValueAt(selectedRow, 0).toString();
                double notaMateria = Double.parseDouble(tbInfoMaterias.getValueAt(selectedRow, 1).toString());
                String descripcionMateria = tbInfoMaterias.getValueAt(selectedRow, 2).toString();
                String profesorMateria = tbInfoMaterias.getValueAt(selectedRow, 3).toString();

                materiaSeleccionada = new Materia(nombreMateria, notaMateria, profesorMateria, descripcionMateria);

                btnModificarMateria.setEnabled(activarBotones());

                btnEliminarMateria.setEnabled(activarBotones());
        }

        private void btnModificarMateriaActionPerformed(java.awt.event.ActionEvent evt) {
                PantallaModificarMateria panModMat = new PantallaModificarMateria();
                panModMat.setVisible(true);
                this.setVisible(false);
        }

        private void btnCrearMateriaActionPerformed(java.awt.event.ActionEvent evt) {
                PantallaCrearMateria panCreMat = new PantallaCrearMateria();
                panCreMat.setVisible(true);
                this.setVisible(false);
        }

        private void btnCuentaActionPerformed(java.awt.event.ActionEvent evt) {
                PantallaCuentaEstudiante cuenta = new PantallaCuentaEstudiante();
                cuenta.setVisible(true);
                this.setVisible(false);
        }

        private void btnCalendarioActionPerformed(java.awt.event.ActionEvent evt) {
                PantallaCalendarioEstudiante cal = new PantallaCalendarioEstudiante();
                cal.setVisible(true);
                this.setVisible(false);
        }

        private void btnSesionesActionPerformed(java.awt.event.ActionEvent evt) {
                PantallaSesionesEstudiante panSesEst = new PantallaSesionesEstudiante();
                panSesEst.setVisible(true);
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

        public static void main(String args[]) {
                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new PantallaMateriasEstudiante().setVisible(true);
                        }
                });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnCalculadoraNotas;
        private javax.swing.JButton btnCalendario;
        private javax.swing.JButton btnCambiarCuenta;
        private javax.swing.JButton btnCerrar;
        private javax.swing.JButton btnCrearMateria;
        private javax.swing.JButton btnCuenta;
        private javax.swing.JButton btnEliminarMateria;
        private javax.swing.JButton btnModificarMateria;
        private javax.swing.JButton btnSesiones;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JLabel lbDesviacionEstandar;
        private javax.swing.JLabel lbPeriodo;
        private javax.swing.JLabel lbPromedio;
        private java.awt.PopupMenu popupMenu1;
        private java.awt.PopupMenu popupMenu2;
        private javax.swing.JTable tbInfoMaterias;
        // End of variables declaration//GEN-END:variables
}
