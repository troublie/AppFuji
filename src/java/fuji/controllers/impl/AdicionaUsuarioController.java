/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuji.controllers.impl;

import fuji.controllers.AbstractController;
import fuji.dao.usuario.UsuarioDAO;
import static fuji.dao.usuario.UsuarioDAOFactory.getUsuarioDAO;
import fuji.entities.Usuario;

/**
 *
 * @author juliano.lopes
 */
public class AdicionaUsuarioController extends AbstractController {

    public void execute() {

        Usuario novoUsuario = null;
        UsuarioDAO usuario = getUsuarioDAO();
        String usuarioFirstName = this.getRequest().getParameter("usuarioFirstName");
        String usuarioLastName = this.getRequest().getParameter("usuarioLastName");
        String usuarioEmail = this.getRequest().getParameter("usuarioEmail");
        novoUsuario = usuario.criaUsuario(usuarioFirstName, usuarioLastName, usuarioEmail);
        this.setReturnPage("/resultadoAdiciona.jsp");
        this.getRequest().setAttribute("usuario", novoUsuario);
    }
}
