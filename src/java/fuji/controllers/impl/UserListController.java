/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuji.controllers.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import fuji.controllers.AbstractController;
import fuji.dao.usuario.UsuarioDAO;
import fuji.dao.usuario.UsuarioDAOImpl;
import fuji.entities.Usuario;
import java.util.Collection;

/**
 *
 * @author juliano.lopes
 */
public class UserListController extends AbstractController {

    public void execute() {
        try {
            //List usuarios = new ArrayList<Usuario>();
            //usuarios.add(new Usuario(1, "Juliano", "Lopes", "juliano@gmail.com"));
            //usuarios.add(new Usuario(2, "João", "Pedro", "joao@gmail.com"));
            Collection result = new ArrayList<>();
            UsuarioDAO usuarios = new UsuarioDAOImpl();
            result = (Collection) usuarios.buscaTodosUsuarios();
            this.setReturnPage("/index.jsp");
            this.getRequest().setAttribute("usuarios", result);
        } catch (Exception ex) {
            Logger.getLogger(UserListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
