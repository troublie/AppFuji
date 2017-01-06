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
import fuji.entities.Usuario;

/**
 *
 * @author juliano.lopes
 */
public class UserListController extends AbstractController {

    public void execute() {
        try {
            List usuarios = new ArrayList<Usuario>();
            usuarios.add(new Usuario(1, "Mack", "Junior"));
            usuarios.add(new Usuario(2, "Mack", "Neto"));
            this.setReturnPage("/index.jsp");
            this.getRequest().setAttribute("usuarios", usuarios);
        } catch (Exception ex) {
            Logger.getLogger(UserListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
