/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo;

import archivo.ClienteView;
import java.util.Observable;

/**
 *
 * @author tutaa
 */
public interface InterfaceCienteView {

    public abstract void ClienteView(String nombre, String cliente, String mensaje);

    public abstract ClienteView update(Observable o, Object arg);

    public void enviar(String nombre, String mensaje);
}
