/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CODE.Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author tutaa
 */
public class Conexion {

    public PreparedStatement ps;
    public ResultSet rs;
    public String url;
    public Statement stmt;
    public Connection con;

    public static Connection getConection() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String url = "jdbc:mysql://localhost:3306/tutosumb";
        String usuario = "root";
        String contraseñaBD = "";
        String driver = "com.mysql.jdbc.Driver";

        con = null;
        try {
            con = DriverManager.getConnection(url, usuario, contraseñaBD);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return con;

    }

}
