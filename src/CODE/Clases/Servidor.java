package CODE.Clases;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor extends Observable implements Runnable {

    /**
     * atributos de a clase servidor
     */
    public static ServerSocket server;
    private Socket sc;
    private int puerto;

    // constructor de la clase
    public Servidor(int puerto) {
        this.puerto = puerto;
    }

    @Override
    public void run() {
        try {
            // TODO: Hay error al iniciar el serversocket
            server = new ServerSocket(puerto);
            while (true) {
                sc = server.accept();
                Asistente asistente = new Asistente(sc, this);
                Thread t = new Thread(asistente);
                t.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * método con el cual notificamos a los observadores
     * 
     * @param mensaje
     */
    public void notificacion(String mensaje) {
        // notifico los cambios a los observadores
        this.setChanged();
        this.notifyObservers(mensaje + "\n");
        this.clearChanged();
    }

}
