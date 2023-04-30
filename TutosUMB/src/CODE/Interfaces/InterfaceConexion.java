/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CODE.Interfaces;

import CODE.Clases.Conexion;

/**
 *
 * @author tutaa
 */
public interface InterfaceConexion {

    public abstract void Conexion(String ps, String rs);

    public abstract Conexion getConexion(String url, String usuario, String contraseña, String driver);
}
