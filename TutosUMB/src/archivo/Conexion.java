/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivo;

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

    PreparedStatement ps;
    ResultSet rs;

    public static Connection getConection() {
        Connection con = null;
        Statement stmt = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String url = "jdbc:mysql://localhost:3306/tutosumb";
        String usuario = "root";
        String contraseñab = "";
        String driver = "com.mysql.jdbc.Driver";

        con = null;
        try {
            con = DriverManager.getConnection(url, usuario, contraseñab);
            System.out.println("conexion exitosa");
        } catch (SQLException e) {
            System.err.print(e.toString());
            JOptionPane.showMessageDialog(null, "Hubo un error");
        }
        return con;

    }

}
