/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuji.dao.exception;

import org.apache.commons.lang.exception.*;

/**
 *
 * @author juliano.lopes
 */
public class DAORuntimeException extends NestableRuntimeException {

    public DAORuntimeException(final Throwable cause) {
        super(cause);
    }

    public DAORuntimeException(final String msg, final Throwable cause) {
        super(msg, cause);
    }

    public DAORuntimeException(final String msg) {
        super(msg);
    }
}
