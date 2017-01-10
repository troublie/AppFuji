/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuji.controllers.impl;

import fuji.controllers.AbstractController;
import fuji.dao.tabelapreco.TabelaPrecoDAO;
import fuji.dao.tabelapreco.TabelaPrecoDAOJPAImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juliano.lopes
 */
public class ListaTabelaController extends AbstractController {

    public void execute() {
        try {
            Collection result = new ArrayList<>();
            TabelaPrecoDAO tabelas = new TabelaPrecoDAOJPAImpl();
            result = (Collection) tabelas.buscaTodasTabelasPreco();
            this.setReturnPage("/listaTabelas.jsp");
            this.getRequest().setAttribute("tabelas", result);
        } catch (Exception ex) {
            Logger.getLogger(UserListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
