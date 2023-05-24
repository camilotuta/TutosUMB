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

    public void modificarEnArchivoSesiones(Sesion sesion) {
        try {
            File archivoTemporal = new File(archivo); // Archivo temporal para escribir los datos modificados
            FileWriter escrituraTemporal = new FileWriter(archivoTemporal);
            BufferedReader lectura = new BufferedReader(new FileReader(archivo));
            String linea;

            while ((linea = lectura.readLine()) != null) {
                String[] datos = linea.split("%");

                // Realiza la modificación si se encuentra la sesión correspondiente
                if (datos[0].equals(sesion.getMateria()) && datos[1].equals(sesion.getLink())) {
                    // Modifica los datos de la sesión según tus necesidades
                    datos[2] = sesion.getFecha();
                    datos[3] = sesion.getEstado();
                }

                // Escribe la línea en el archivo temporal
                escrituraTemporal.write(String.join("%", datos) + "\r\n");
            }

            lectura.close();
            escrituraTemporal.close();

            // Reemplaza el archivo original con el archivo temporal
            archivo.delete();
            archivoTemporal.renameTo(archivo);

            JOptionPane.showMessageDialog(null, "Modificación exitosa.");
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

    public void modificarEnArchivoMaterias(Materia materia) {

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

    public void modificarEnArchivoTareas(Sesion sesion) {
    }
}
