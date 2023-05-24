/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISUAL.Pantallas.Estudiante;

import VISUAL.Pantallas.General.PantallaInicio;
import VISUAL.Pantallas.General.PantallaRegistro;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tutaa
 */

// TODO: MODIFICAR LA MATERIA
public class PantallaMateriasEstudiante extends javax.swing.JFrame {

        DefaultTableModel modelo = new DefaultTableModel();

        /**
         * Creates new form PantallaMateriasEstudiante
         */
        public PantallaMateriasEstudiante() {
                initComponents();
                this.setLocationRelativeTo(null);
                this.setTitle("TUS MATERIAS");
                this.setResizable(false);
                cargarModelo();
                setIconImage(Toolkit.getDefaultToolkit()
                                .getImage(getClass().getResource("/VISUAL/Imagenes/Logos/icon.png")));
                cargarAnaliticas();
        }

        private void cargarModelo() {
                try {
                        modelo.addColumn("NOMBRE");
                        modelo.addColumn("NOTA");
                        modelo.addColumn("PROFESOR");
                        modelo.addColumn("DESCRIPCIÓN");
                        tbInfoMaterias.setModel(modelo);
                        cargarArchivo();
                } catch (IOException e) {
                }
        }

        private void cargarArchivo() throws IOException {
                String fila[];
                try {
                        var rutaCompleta = System.getProperty("user.home")
                                        + "/Documents/"
                                        + PantallaRegistro.correoPoner
                                        + "Materias"
                                        + ".txt";
                        FileReader archivo = new FileReader(rutaCompleta);
                        try (BufferedReader lectura = new BufferedReader(archivo)) {
                                var linea = lectura.readLine();

                                while (linea != null) {
                                        fila = linea.split("%");
                                        modelo.addRow(fila);
                                        linea = lectura.readLine();
                                }
                        }
                } catch (FileNotFoundException e) {
                }
        }

        public void cargarAnaliticas() {
                // & PROMEDIO
                DefaultTableModel model = (DefaultTableModel) tbInfoMaterias.getModel();
                ArrayList<Double> notas = new ArrayList<Double>();

                var rowCount = model.getRowCount();
                var columnCount = model.getColumnCount();
                var suma = 0.0;
                var promedio = 0.0;
                var promedioRound = 0.0;

                var desviacionEst = 0.0;
                var desviacionRound = 0.0;

                if (columnCount >= 2 && rowCount > 0) {
                        for (int i = 0; i < rowCount; i++) {
                                var nota = Double.parseDouble(model.getValueAt(i, 1).toString());
                                notas.add(nota);
                                suma += nota;
                        }
                        promedio = suma / rowCount;
                        promedioRound = ((double) Math.round(promedio * 100.0) / 100.0);

                        // & DESVIACIÓN ESTÁNDAR
                        ArrayList<Double> diferenciaAbsolutaNotas = new ArrayList<Double>();
                        for (double i : notas) {
                                var diferencia = i - promedio;
                                diferenciaAbsolutaNotas.add(diferencia);
                        }
                        var sumaDiferencia = 0.0;

                        for (double i : diferenciaAbsolutaNotas) {
                                sumaDiferencia += Math.pow(i, 2);
                        }

                        desviacionEst = sumaDiferencia / diferenciaAbsolutaNotas.size();
                        var raizDesviacion = Math.sqrt(desviacionEst);
                        desviacionRound = ((double) Math.round(raizDesviacion * 100.0) / 100.0);

                }

                // & PERIODO
                Calendar calendario = Calendar.getInstance();
                var añoActual = calendario.get(Calendar.YEAR);
                var mesActual = calendario.get(Calendar.MONTH);
                var periodo = "";

                if (mesActual <= 5) {
                        periodo = "1";
                } else if (mesActual >= 7) {
                        periodo = "2";
                } else {
                        periodo = "0";
                }

                var textPeriodo = añoActual + "-" + periodo;

                lbPromedio.setText(String.valueOf(promedioRound));
                lbDesviacionEstandar.setText(String.valueOf(desviacionRound));
                lbPeriodo.setText(textPeriodo);
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
                        Class<?>[] types = new Class<?>[] {
                                        java.lang.String.class, java.lang.String.class, java.lang.String.class
                        };
                        boolean[] canEdit = new boolean[] { false, false, false };

                        public Class<?> getColumnClass(int columnIndex) {
                                return types[columnIndex];
                        }

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit[columnIndex];
                        }
                });
                tbInfoMaterias.setColumnSelectionAllowed(true);
                tbInfoMaterias.getTableHeader().setReorderingAllowed(false);
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
                btnCalendario.setIcon(
                                new javax.swing.ImageIcon(
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
                btnSesiones
                                .setIcon(new javax.swing.ImageIcon(
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
                btnCambiarCuenta.setIcon(
                                new javax.swing.ImageIcon(getClass()
                                                .getResource("/VISUAL/Imagenes/Botones/imgCambiarCuenta.png"))); // NOI18N
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
                btnCrearMateria.setText("Crear materia");
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
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(302, 302, 302)
                                                                                                .addComponent(btnCrearMateria)
                                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(60, 60, 60)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                                                                .addComponent(jLabel6)
                                                                                                                                .addGap(105, 105,
                                                                                                                                                105)
                                                                                                                                .addComponent(jLabel8,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                100,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                false)
                                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                                .createSequentialGroup()
                                                                                                                                                                .addComponent(jLabel1)
                                                                                                                                                                .addGap(18, 18, 18)
                                                                                                                                                                .addComponent(lbPromedio)
                                                                                                                                                                .addPreferredGap(
                                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                .addComponent(jLabel3)
                                                                                                                                                                .addGap(18, 18, 18)
                                                                                                                                                                .addComponent(lbDesviacionEstandar)
                                                                                                                                                                .addGap(117, 117,
                                                                                                                                                                                117)
                                                                                                                                                                .addComponent(jLabel5)
                                                                                                                                                                .addGap(18, 18, 18)
                                                                                                                                                                .addComponent(lbPeriodo))
                                                                                                                                                .addComponent(jScrollPane1,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                577,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                .addGap(0, 83, Short.MAX_VALUE)))))
                                                                .addContainerGap()));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                false)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
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
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                false)
                                                                                                                .addComponent(jLabel8)
                                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                jPanel1Layout.createSequentialGroup()
                                                                                                                                                .addContainerGap(
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                .addComponent(jLabel6)
                                                                                                                                                .addGap(8, 8, 8)))
                                                                                                .addComponent(jScrollPane1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                327,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                                .addComponent(jLabel3)
                                                                                                                                .addComponent(lbDesviacionEstandar))
                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                                .addComponent(jLabel5)
                                                                                                                                .addComponent(lbPeriodo))
                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                                .addComponent(jLabel1)
                                                                                                                                .addComponent(lbPromedio)))
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(btnCrearMateria)))
                                                                .addGap(26, 26, 26)));

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
                JOptionPane.showMessageDialog(null, "YA SE ENCUENTRA EN ESTA PESTAÑA");
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
        private javax.swing.JButton btnCalendario;
        private javax.swing.JButton btnCambiarCuenta;
        private javax.swing.JButton btnCerrar;
        private javax.swing.JButton btnCrearMateria;
        private javax.swing.JButton btnCuenta;
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
