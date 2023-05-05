package CODE.Clases;

import java.io.*;
import javax.swing.JOptionPane;

import VISUAL.Pantallas.General.PantallaRegistro;

/**
 *
 * @author tutaa
 */
public class Archivo {

    File archivo;

    // TODO: SUBIR ESTE ARCHIVO A DRIVE O ONEDRIVE
    public void crearArchivo(String tipoArchivo) {
        try {
            String nombreArchivo = PantallaRegistro.correoPoner + tipoArchivo + ".txt";
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
            escritura.write(sesion.getMateria() + "%" + sesion.getLink() + "%" + sesion.getFecha() + "%"
                    + sesion.getEstado() + "\r\n");
            escritura.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
