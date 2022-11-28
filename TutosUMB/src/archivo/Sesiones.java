/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tutaa
 */
public class Sesiones extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();

    public Sesiones() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("SESIONES");
        this.setResizable(false);
        cargarModelo();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/icon.png")));

    }

    private void cargarModelo() {
        try {

            modelo.addColumn("MATERIA");
            modelo.addColumn("LINK");
            modelo.addColumn("FECHA");
            tablaRegistros.setModel(modelo);
            cargarArchivo();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void cargarArchivo() throws IOException {
        String fila[];

        try {

            FileReader archivo = new FileReader("RegistroSesiones.txt");
            try ( BufferedReader lectura = new BufferedReader(archivo)) {
                String linea = lectura.readLine();

                while (linea != null) {
                    fila = linea.split("%");
                    modelo.addRow(fila);
                    linea = lectura.readLine();
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        popupMenu2 = new java.awt.PopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRegistros = new javax.swing.JTable();
        canvas1 = new java.awt.Canvas();
        botonCuenta1 = new javax.swing.JButton();
        botonCalendario1 = new javax.swing.JButton();
        botonSesiones1 = new javax.swing.JButton();
        botonCambiarCuenta1 = new javax.swing.JButton();
        botonAtras1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        popupMenu1.setLabel("popupMenu1");

        popupMenu2.setLabel("popupMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(247, 251, 252));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(118, 159, 205));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivo/ww.jpeg"))); // NOI18N

        tablaRegistros.setBackground(new java.awt.Color(214, 230, 242));
        tablaRegistros.setForeground(new java.awt.Color(51, 51, 51));
        tablaRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "MATERIA", "MENSAJE", "FECHA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaRegistros.setColumnSelectionAllowed(true);
        tablaRegistros.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaRegistros);
        tablaRegistros.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tablaRegistros.getColumnModel().getColumnCount() > 0) {
            tablaRegistros.getColumnModel().getColumn(0).setResizable(false);
            tablaRegistros.getColumnModel().getColumn(1).setResizable(false);
            tablaRegistros.getColumnModel().getColumn(2).setResizable(false);
        }

        botonCuenta1.setBackground(new java.awt.Color(185, 215, 234));
        botonCuenta1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonCuenta1.setForeground(new java.awt.Color(66, 120, 181));
        botonCuenta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivo/notebook.png"))); // NOI18N
        botonCuenta1.setText("CUENTA");
        botonCuenta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCuenta1ActionPerformed(evt);
            }
        });

        botonCalendario1.setBackground(new java.awt.Color(185, 215, 234));
        botonCalendario1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonCalendario1.setForeground(new java.awt.Color(66, 120, 181));
        botonCalendario1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivo/calendar.png"))); // NOI18N
        botonCalendario1.setText("CALENDARIO");
        botonCalendario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCalendario1ActionPerformed(evt);
            }
        });

        botonSesiones1.setBackground(new java.awt.Color(185, 215, 234));
        botonSesiones1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonSesiones1.setForeground(new java.awt.Color(66, 120, 181));
        botonSesiones1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivo/message.png"))); // NOI18N
        botonSesiones1.setText("SESIONES");
        botonSesiones1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSesiones1ActionPerformed(evt);
            }
        });

        botonCambiarCuenta1.setBackground(new java.awt.Color(185, 215, 234));
        botonCambiarCuenta1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonCambiarCuenta1.setForeground(new java.awt.Color(66, 120, 181));
        botonCambiarCuenta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivo/arrows.png"))); // NOI18N
        botonCambiarCuenta1.setText("CAMBIAR CUENTA");
        botonCambiarCuenta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCambiarCuenta1ActionPerformed(evt);
            }
        });

        botonAtras1.setBackground(new java.awt.Color(185, 215, 234));
        botonAtras1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonAtras1.setForeground(new java.awt.Color(66, 120, 181));
        botonAtras1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivo/close.png"))); // NOI18N
        botonAtras1.setText("CERRAR");
        botonAtras1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtras1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(118, 159, 205));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivo/image.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonCuenta1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCalendario1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonSesiones1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCambiarCuenta1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAtras1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 42, Short.MAX_VALUE)
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(botonCuenta1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(botonCalendario1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(botonSesiones1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(botonCambiarCuenta1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(botonAtras1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCuenta1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botonCuenta1ActionPerformed
        Cuenta cuenta = new Cuenta();
        cuenta.setVisible(true);
        this.setVisible(false);
    }// GEN-LAST:event_botonCuenta1ActionPerformed

    private void botonCalendario1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botonCalendario1ActionPerformed
        Calendario cal = new Calendario();
        cal.setVisible(true);
        this.setVisible(false);
    }// GEN-LAST:event_botonCalendario1ActionPerformed

    private void botonSesiones1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botonSesiones1ActionPerformed
        JOptionPane.showMessageDialog(null, "YA SE ENCUENTRA EN ESTA PESTAÑA");
    }// GEN-LAST:event_botonSesiones1ActionPerformed

    private void botonCambiarCuenta1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botonCambiarCuenta1ActionPerformed
        PantallaInicio pantalla = new PantallaInicio();
        pantalla.setVisible(true);
        this.setVisible(false);
    }// GEN-LAST:event_botonCambiarCuenta1ActionPerformed

    private void botonAtras1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botonAtras1ActionPerformed
        System.exit(0);
    }// GEN-LAST:event_botonAtras1ActionPerformed

    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sesiones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAtras1;
    private javax.swing.JButton botonCalendario1;
    private javax.swing.JButton botonCambiarCuenta1;
    private javax.swing.JButton botonCuenta1;
    private javax.swing.JButton botonSesiones1;
    private java.awt.Canvas canvas1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.PopupMenu popupMenu1;
    private java.awt.PopupMenu popupMenu2;
    private javax.swing.JTable tablaRegistros;
    // End of variables declaration//GEN-END:variables
}
