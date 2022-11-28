/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo;

import archivo.Cuenta;

/**
 *
 * @author tutaa
 */
public interface InterfaceCuenta {

    public abstract void mostrarInfo(String nombre, String correo, String biografia);

    public abstract Cuenta guardar(String biografia);

    public void cancelar(String biografia);
}
