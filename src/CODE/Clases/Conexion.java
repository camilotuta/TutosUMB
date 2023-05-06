package CODE.Clases;

import java.sql.*;
import javax.swing.JOptionPane;

//TODO: HACER ESTA DB PUBLICA ALOJÁNDOLA EN UN SERVIDOR
public class Conexion {

    public PreparedStatement ps;
    public ResultSet rs;
    public String url;
    public Statement stmt;
    public Connection con;
    public String driver;

    public static Connection getConection() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String url = "jdbc:mysql://localhost:3306/tutosumb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=America/Bogota";
        String usuario = "root";
        String contraseñaBD = "";
        String driver = "com.mysql.cj.jdbc.Driver";

        con = null;
        try {
            con = DriverManager.getConnection(url, usuario, contraseñaBD);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return con;

    }

}