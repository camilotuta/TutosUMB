package CODE.Clases;

import java.io.*;
import javax.swing.JOptionPane;

import VISUAL.Pantallas.PantallaRegistro;

/**
 *
 * @author tutaa
 */
public class Archivo {

    File archivo;

    public void crearArchivo() {
        try {
            String nombreArchivo = PantallaRegistro.correoPoner + ".txt";
            String rutaCompleta = System.getProperty("user.home") + "/Documents/" + nombreArchivo;
            archivo = new File(rutaCompleta);
            if (archivo.createNewFile()) {
                JOptionPane.showMessageDialog(null, "GRACIAS POR CONFIAR EN NOSOTROS...");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void escribirEnArchivo(Sesion sesion) {
        try {
            FileWriter escritura = new FileWriter(archivo, true);
            escritura.write(sesion.getMateria() + "%" + sesion.getLink() + "%" + sesion.getFecha() + "\r\n");
            escritura.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
