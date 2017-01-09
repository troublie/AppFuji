/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuji.dao.tabelapreco;

/**
 *
 * @author juliano.lopes
 */
public class TabelaPrecoDAOFactory {

    private TabelaPrecoDAOFactory() {
    }

    public static TabelaPrecoDAO getTabelaPrecoDAO() {
        return new TabelaPrecoDAOImpl();
    }
}
