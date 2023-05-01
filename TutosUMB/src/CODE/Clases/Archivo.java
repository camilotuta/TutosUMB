package CODE.Clases;

import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author tutaa
 */
public class Archivo {

    File archivo;

    public void crearArchivo() {
        try {
            archivo = new File("SesionesProgramadas.txt");
            if (archivo.createNewFile()) {
                JOptionPane.showMessageDialog(null, "GRACIAS POR CONFIAR EN NOSOTROS...");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void escribirEnArchivo(Sesion persona) {
        try {
            FileWriter escritura = new FileWriter(archivo, true);
            escritura.write(persona.getMateria() + "%" + persona.getLink() + "%" + persona.getFecha() + "\r\n");
            escritura.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
