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
public class AtualizaUsuarioController extends AbstractController {

    public void execute() {
        UsuarioDAO usuario = getUsuarioDAO();
        int id = Integer.parseInt(this.getRequest().getParameter("idAtualiza"));
        String nome = this.getRequest().getParameter("nomeAtualiza");
        String sobrenome = this.getRequest().getParameter("sobrenomeAtualiza");
        String email = this.getRequest().getParameter("emailAtualiza");
        try {
            usuario.updateUsuario(id, nome, sobrenome, email);
            boolean res = true;
            this.setReturnPage("/resultadoAtualiza.jsp");
            this.getRequest().setAttribute("res", res);
        } catch (UsuarioNaoEncontradoException ex) {
            Logger.getLogger(AtualizaUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
