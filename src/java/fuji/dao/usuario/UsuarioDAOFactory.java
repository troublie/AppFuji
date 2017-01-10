/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuji.dao.usuario;

/**
 *
 * @author juliano.lopes
 */
public class UsuarioDAOFactory {

    private UsuarioDAOFactory() {
    }

    public static UsuarioDAO getUsuarioDAO() {
        return new UsuarioDAOJPAImpl();
    }
}
