/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuji.dao.usuario;

import org.apache.commons.lang.exception.*;

/**
 *
 * @author juliano.lopes
 */
public class UsuarioNaoEncontradoException extends NestableException {

    public UsuarioNaoEncontradoException(String msg) {
        super(msg);
    }

    public UsuarioNaoEncontradoException(Throwable t) {
        super(t);
    }

    public UsuarioNaoEncontradoException(String msg, Throwable t) {
        super(msg, t);
    }
}
