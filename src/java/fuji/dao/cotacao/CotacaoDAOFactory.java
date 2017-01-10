/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuji.dao.cotacao;

/**
 *
 * @author juliano.lopes
 */
public class CotacaoDAOFactory {
    private CotacaoDAOFactory() {
    }
    public static CotacaoDAO getCotacaoDAO() {
        return new CotacaoDAOJPAImpl();
    }
}
