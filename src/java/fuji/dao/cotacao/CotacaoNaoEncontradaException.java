/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuji.dao.cotacao;

import org.apache.commons.lang.exception.NestableException;

/**
 *
 * @author juliano.lopes
 */
public class CotacaoNaoEncontradaException extends NestableException {

    public CotacaoNaoEncontradaException(String msg) {
        super(msg);
    }

    public CotacaoNaoEncontradaException(Throwable t) {
        super(t);
    }

    public CotacaoNaoEncontradaException(String msg, Throwable t) {
        super(msg, t);
    }
}
