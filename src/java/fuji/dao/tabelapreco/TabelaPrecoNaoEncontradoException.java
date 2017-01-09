/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuji.dao.tabelapreco;

import org.apache.commons.lang.exception.*;

/**
 *
 * @author juliano.lopes
 */
public class TabelaPrecoNaoEncontradoException extends NestableException {

    public TabelaPrecoNaoEncontradoException(String msg) {
        super(msg);
    }

    public TabelaPrecoNaoEncontradoException(Throwable t) {
        super(t);
    }

    public TabelaPrecoNaoEncontradoException(String msg, Throwable t) {
        super(msg, t);
    }
}
