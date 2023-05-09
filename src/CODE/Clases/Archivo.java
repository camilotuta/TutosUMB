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
        String nombreArchivo = PantallaRegistro.correoPoner + tipoArchivo + ".txt";
        String rutaCompleta = System.getProperty("user.home") + "/Documents/" + nombreArchivo;
        archivo = new File(rutaCompleta);
        try {
            FileWriter escritura = new FileWriter(archivo, true);
            escritura.write("");
            escritura.close();
        } catch (IOException e) {
        }
    }

    public void escribirEnArchivoSesiones(Sesion sesion) {
        try {
            FileWriter escritura = new FileWriter(archivo, true);
            escritura.write(sesion.getMateria() + "%" + sesion.getLink() + "%" + sesion.getFecha() + "%"
                    + sesion.getEstado() + "\r\n");
            escritura.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void escribirEnArchivoMaterias(Materia materia) {
        try {
            FileWriter escritura = new FileWriter(archivo, true);
            escritura.write(materia.getNombre() + "%" + materia.getNota() + "%" + materia.getProfesor() + "%"
                    + materia.getDescripcion() + "\r\n");
            escritura.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void escribirEnArchivoTareas(Sesion sesion) {
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
