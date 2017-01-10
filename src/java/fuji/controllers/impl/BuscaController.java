/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuji.controllers.impl;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import fuji.controllers.AbstractController;
import fuji.dao.usuario.UsuarioDAO;
import static fuji.dao.usuario.UsuarioDAOFactory.getUsuarioDAO;
import fuji.entities.Usuario;

/**
 *
 * @author juliano.lopes
 */
public class BuscaController extends AbstractController {

    public void execute() {
        Usuario usuario = null;
        Collection cUsuario = null;
        try {
            UsuarioDAO usuarios = getUsuarioDAO();
            if (this.getRequest().getParameter("id") != null) {
                int id = Integer.parseInt(this.getRequest().getParameter("id"));
                usuario = usuarios.buscaUsuarioPorId(id);
                this.setReturnPage("/resultadoBuscaID.jsp");
                this.getRequest().setAttribute("usuarioID", usuario);
            } else {
                String nome = this.getRequest().getParameter("nome");
                cUsuario = usuarios.buscaUsuarioPorNome(nome);
                this.setReturnPage("/resultadoNome.jsp");
                this.getRequest().setAttribute("nome", cUsuario);
            }
        } catch (Exception ex) {
            Logger.getLogger(BuscaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
