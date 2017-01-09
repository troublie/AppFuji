/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuji.controllers.impl;

import fuji.controllers.AbstractController;
import fuji.dao.usuario.UsuarioDAO;
import static fuji.dao.usuario.UsuarioDAOFactory.getUsuarioDAO;
import fuji.dao.usuario.UsuarioNaoEncontradoException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juliano.lopes
 */
public class RemoveUsuarioController extends AbstractController {

    @Override
    public void execute() {
        try {
            UsuarioDAO usuarios = getUsuarioDAO();
            int id = Integer.parseInt(this.getRequest().getParameter("idRem"));
            usuarios.removeUsuario(id);
            boolean res = true;
            this.setReturnPage("/resultadoRemove.jsp");
            this.getRequest().setAttribute("idRem", res);
        } catch (UsuarioNaoEncontradoException ex) {
            Logger.getLogger(RemoveUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
