/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISUAL.Pantallas.Estudiante;

import VISUAL.Pantallas.General.PantallaInicio;
import java.awt.Component;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author tutaa
 */
public class PantallaTrikiEstudiante extends javax.swing.JFrame {

    String turno = "X";
    String siguienteJuego = "O";
    String nombreJ1 = "";
    String nombreJ2 = "";
    String nombreTurno = "";
    JLabel lbs[] = new JLabel[9];

    int vs[][] = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9},
        {2, 5, 8},
        {3, 6, 9},
        {1, 4, 7},
        {1, 5, 9},
        {3, 5, 7},};

    /**
     * Creates new form PantallaTrikiEstudiante
     */
    public PantallaTrikiEstudiante() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("TRIKI");
        this.setResizable(false);
        habilitarBotonIniciar();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/VISUAL/Imagenes/Logos/icon.png")));

        lbs[0] = espacio1;
        lbs[1] = espacio2;
        lbs[2] = espacio3;
        lbs[3] = espacio4;
        lbs[4] = espacio5;
        lbs[5] = espacio6;
        lbs[6] = espacio7;
        lbs[7] = espacio8;
        lbs[8] = espacio9;

        for (Component i : jPanel3.getComponents()) {
            i.setEnabled(false);
        }
    }

    public void habilitarBotonIniciar() {
        if ((tfNombreJ1.getText().length() > 2) && (tfNombreJ2.getText().length() > 2)) {
            btnIniciar.setEnabled(true);
        } else {
            btnIniciar.setEnabled(false);
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
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCuenta = new javax.swing.JButton();
        btnSesiones = new javax.swing.JButton();
        btnCambiarCuenta = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnCalendario = new javax.swing.JButton();
        btnReiniciar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        O = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        espacio1 = new javax.swing.JLabel();
        espacio2 = new javax.swing.JLabel();
        espacio3 = new javax.swing.JLabel();
        espacio4 = new javax.swing.JLabel();
        espacio5 = new javax.swing.JLabel();
        espacio6 = new javax.swing.JLabel();
        espacio7 = new javax.swing.JLabel();
        espacio8 = new javax.swing.JLabel();
        espacio9 = new javax.swing.JLabel();
        X = new javax.swing.JLabel();
        tfNombreJ1 = new javax.swing.JTextField();
        tfNombreJ2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMostrarTurno = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(247, 251, 252));
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
        jPanel1.add(btnCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 15, 210, 97));

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
        jPanel1.add(btnSesiones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 221, 210, 97));

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
        jPanel1.add(btnCambiarCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 324, 210, 97));

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
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 427, 210, 97));

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
        jPanel1.add(btnCalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 118, 210, 97));

        btnReiniciar.setBackground(new java.awt.Color(185, 215, 234));
        btnReiniciar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReiniciar.setForeground(new java.awt.Color(118, 159, 205));
        btnReiniciar.setText("Reiniciar");
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });
        jPanel1.add(btnReiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 480, 90, 30));

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(118, 159, 205));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/Imagenes/Logos/imgUMBPequeño.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, 100, -1));

        jLabel9.setFont(new java.awt.Font("Crabs", 1, 100)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(118, 159, 205));
        jLabel9.setText("Triki");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, -1, -1));

        jPanel2.setBackground(new java.awt.Color(247, 251, 252));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        O.setBackground(new java.awt.Color(185, 215, 234));
        O.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        O.setForeground(new java.awt.Color(255, 255, 255));
        O.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        O.setText("O");
        O.setOpaque(true);
        jPanel2.add(O, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 192, 100, 100));

        jPanel3.setBackground(new java.awt.Color(247, 251, 252));

        espacio1.setBackground(new java.awt.Color(185, 215, 234));
        espacio1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        espacio1.setForeground(new java.awt.Color(255, 255, 255));
        espacio1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        espacio1.setOpaque(true);
        espacio1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                espacio1MousePressed(evt);
            }
        });

        espacio2.setBackground(new java.awt.Color(185, 215, 234));
        espacio2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        espacio2.setForeground(new java.awt.Color(255, 255, 255));
        espacio2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        espacio2.setOpaque(true);
        espacio2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                espacio2MousePressed(evt);
            }
        });

        espacio3.setBackground(new java.awt.Color(185, 215, 234));
        espacio3.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        espacio3.setForeground(new java.awt.Color(255, 255, 255));
        espacio3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        espacio3.setOpaque(true);
        espacio3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                espacio3MousePressed(evt);
            }
        });

        espacio4.setBackground(new java.awt.Color(185, 215, 234));
        espacio4.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        espacio4.setForeground(new java.awt.Color(255, 255, 255));
        espacio4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        espacio4.setOpaque(true);
        espacio4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                espacio4MousePressed(evt);
            }
        });

        espacio5.setBackground(new java.awt.Color(185, 215, 234));
        espacio5.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        espacio5.setForeground(new java.awt.Color(255, 255, 255));
        espacio5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        espacio5.setOpaque(true);
        espacio5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                espacio5MousePressed(evt);
            }
        });

        espacio6.setBackground(new java.awt.Color(185, 215, 234));
        espacio6.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        espacio6.setForeground(new java.awt.Color(255, 255, 255));
        espacio6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        espacio6.setOpaque(true);
        espacio6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                espacio6MousePressed(evt);
            }
        });

        espacio7.setBackground(new java.awt.Color(185, 215, 234));
        espacio7.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        espacio7.setForeground(new java.awt.Color(255, 255, 255));
        espacio7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        espacio7.setOpaque(true);
        espacio7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                espacio7MousePressed(evt);
            }
        });

        espacio8.setBackground(new java.awt.Color(185, 215, 234));
        espacio8.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        espacio8.setForeground(new java.awt.Color(255, 255, 255));
        espacio8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        espacio8.setOpaque(true);
        espacio8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                espacio8MousePressed(evt);
            }
        });

        espacio9.setBackground(new java.awt.Color(185, 215, 234));
        espacio9.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        espacio9.setForeground(new java.awt.Color(255, 255, 255));
        espacio9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        espacio9.setOpaque(true);
        espacio9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                espacio9MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(espacio7, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(espacio8, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(espacio9, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addComponent(espacio1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(espacio2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(espacio3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addComponent(espacio4, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(espacio5, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(espacio6, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(espacio1, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(espacio2, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(espacio3, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(espacio4, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(espacio5, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(espacio6, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(espacio7, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(espacio8, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(espacio9, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 84, -1, -1));

        X.setBackground(new java.awt.Color(185, 215, 234));
        X.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        X.setForeground(new java.awt.Color(255, 255, 255));
        X.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        X.setText("X");
        X.setOpaque(true);
        jPanel2.add(X, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 190, 100, 100));

        tfNombreJ1.setBackground(new java.awt.Color(247, 251, 252));
        tfNombreJ1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfNombreJ1KeyReleased(evt);
            }
        });
        jPanel2.add(tfNombreJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 308, 100, -1));

        tfNombreJ2.setBackground(new java.awt.Color(247, 251, 252));
        tfNombreJ2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfNombreJ2KeyReleased(evt);
            }
        });
        jPanel2.add(tfNombreJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 310, 100, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(118, 159, 205));
        jLabel1.setText("NOMBRE:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 166, 100, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(118, 159, 205));
        jLabel2.setText("NOMBRE:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 164, 100, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(118, 159, 205));
        jLabel3.setText("TURNO:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 51, -1, -1));

        txtMostrarTurno.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        txtMostrarTurno.setForeground(new java.awt.Color(118, 159, 205));
        jPanel2.add(txtMostrarTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 51, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 590, 420));

        btnIniciar.setBackground(new java.awt.Color(185, 215, 234));
        btnIniciar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnIniciar.setForeground(new java.awt.Color(118, 159, 205));
        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        jPanel1.add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 480, 90, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 936, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 936,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 550, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 550,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))));

        pack();
    }// </editor-fold>//GEN-END:initComponents
     // </editor-fold>

    private void btnCuentaActionPerformed(java.awt.event.ActionEvent evt) {
        PantallaCuentaEstudiante pc = new PantallaCuentaEstudiante();
        pc.setVisible(true);
        this.setVisible(false);
    }

    private void btnCalendarioActionPerformed(java.awt.event.ActionEvent evt) {
        PantallaCalendarioEstudiante pCal = new PantallaCalendarioEstudiante();
        pCal.setVisible(true);
        this.setVisible(false);
    }

    private void btnSesionesActionPerformed(java.awt.event.ActionEvent evt) {
        PantallaSesionesEstudiante ps = new PantallaSesionesEstudiante();
        ps.setVisible(true);
        this.setVisible(false);
    }

    private void btnCambiarCuentaActionPerformed(java.awt.event.ActionEvent evt) {
        PantallaInicio pi = new PantallaInicio();
        pi.setVisible(true);
        this.setVisible(false);
    }

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void espacio1MousePressed(java.awt.event.MouseEvent evt) {
        presionar(1);
    }

    private void espacio2MousePressed(java.awt.event.MouseEvent evt) {
        presionar(2);
    }

    private void espacio3MousePressed(java.awt.event.MouseEvent evt) {
        presionar(3);
    }

    private void espacio4MousePressed(java.awt.event.MouseEvent evt) {
        presionar(4);
    }

    private void espacio5MousePressed(java.awt.event.MouseEvent evt) {
        presionar(5);
    }

    private void espacio6MousePressed(java.awt.event.MouseEvent evt) {
        presionar(6);
    }

    private void espacio7MousePressed(java.awt.event.MouseEvent evt) {
        presionar(7);
    }

    private void espacio8MousePressed(java.awt.event.MouseEvent evt) {
        presionar(8);
    }

    private void espacio9MousePressed(java.awt.event.MouseEvent evt) {
        presionar(9);
    }

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {
        for (int i = 0; i < lbs.length; i++) {
            lbs[i].setText("");
        }
        turno = siguienteJuego;
        if (siguienteJuego.equals("O")) {
            siguienteJuego = "X";
        } else {
            siguienteJuego = "O";
        }
    }

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {
        nombreJ1 = tfNombreJ1.getText();
        nombreJ2 = tfNombreJ2.getText();
        txtMostrarTurno.setText(nombreJ1);
        for (Component i : jPanel3.getComponents()) {
            i.setEnabled(true);
        }
    }

    private void tfNombreJ1KeyReleased(java.awt.event.KeyEvent evt) {
        habilitarBotonIniciar();
    }

    private void tfNombreJ2KeyReleased(java.awt.event.KeyEvent evt) {
        habilitarBotonIniciar();
    }

    public void presionar(int casilla) {
        if (lbs[casilla - 1].getText().equals("")) {
            lbs[casilla - 1].setText(turno);
        }
        cambiarTurno();
        comprobarGanador();
    }

    public void cambiarTurno() {
        if (turno.equals("X")) {
            turno = "O";
            nombreTurno = nombreJ2;
            txtMostrarTurno.setText(nombreTurno);
        } else {
            turno = "X";
            nombreTurno = nombreJ1;
            txtMostrarTurno.setText(nombreTurno);
        }
    }

    private void comprobarGanador() {
        for (int i = 0; i < vs.length; i++) {
            if (lbs[vs[i][0] - 1].getText().equals("X")
                    && lbs[vs[i][1] - 1].getText().equals("X")
                    && lbs[vs[i][2] - 1].getText().equals("X")) {
                JOptionPane.showMessageDialog(null, "GANÓ " + nombreJ1);
            }
        }
        for (int i = 0; i < vs.length; i++) {
            if (lbs[vs[i][0] - 1].getText().equals("O")
                    && lbs[vs[i][1] - 1].getText().equals("O")
                    && lbs[vs[i][2] - 1].getText().equals("O")) {
                JOptionPane.showMessageDialog(null, "GANÓ " + nombreJ2);
            }
        }
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
            java.util.logging.Logger.getLogger(PantallaTrikiEstudiante.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaTrikiEstudiante.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaTrikiEstudiante.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaTrikiEstudiante.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaTrikiEstudiante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel O;
    private javax.swing.JLabel X;
    private javax.swing.JButton btnCalendario;
    private javax.swing.JButton btnCambiarCuenta;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCuenta;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JButton btnSesiones;
    private javax.swing.JLabel espacio1;
    private javax.swing.JLabel espacio2;
    private javax.swing.JLabel espacio3;
    private javax.swing.JLabel espacio4;
    private javax.swing.JLabel espacio5;
    private javax.swing.JLabel espacio6;
    private javax.swing.JLabel espacio7;
    private javax.swing.JLabel espacio8;
    private javax.swing.JLabel espacio9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField tfNombreJ1;
    private javax.swing.JTextField tfNombreJ2;
    private javax.swing.JLabel txtMostrarTurno;
    // End of variables declaration//GEN-END:variables

}
