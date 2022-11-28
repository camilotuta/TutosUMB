package archivo;

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
            archivo = new File("RegistroSesiones.txt");
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void escribirEnArchivo(Persona persona) {
        try {
            FileWriter escritura = new FileWriter(archivo, true);
            escritura.write(persona.getMateria() + "%" + persona.getLink() + "%" + persona.getFecha() + "\r\n");
            escritura.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
