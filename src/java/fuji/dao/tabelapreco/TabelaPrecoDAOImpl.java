/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuji.dao.tabelapreco;

import fuji.entities.TabelaPreco;
import java.sql.*;
import java.util.*;
import fuji.dao.exception.DAORuntimeException;
import org.apache.commons.lang.exception.*;
import org.apache.commons.logging.*;

/**
 *
 * @author juliano.lopes
 */
public class TabelaPrecoDAOImpl implements TabelaPrecoDAO {

    static final private Log log = LogFactory.getLog(TabelaPrecoDAOImpl.class);
    private boolean bIsClosed = false;

    public TabelaPrecoDAOImpl() {
        bIsClosed = false;
    }

    @Override
    public TabelaPreco buscaTabelaPrecoPorId(int id) throws TabelaPrecoNaoEncontradoException {
        Connection conn = TabelaPrecoUtil.getConnection();
        TabelaPreco result = null;
        ResultSet rs = null;
        PreparedStatement stmtSelect = null;
        try {
            StringBuilder sbSelect = new StringBuilder();
            sbSelect.append("SELECT tabelapreco_id, tabelapreconome, duhn, duhe, duhe2, ddu, fshn, fshe, fshe2, dfs FROM ");
            sbSelect.append(TabelaPrecoConstantes.TABELAPRECO_TABLE_NAME);
            sbSelect.append(" WHERE tabelapreco_id = ?");
            stmtSelect = conn.prepareStatement(sbSelect.toString());
            stmtSelect.setInt(1, id);
            rs = stmtSelect.executeQuery();
            Collection c = TabelaPrecoUtil.makeTabelaPrecoObjectsFromResultSet(rs);
            if (c.size() != 1) {
                throw new TabelaPrecoNaoEncontradoException("id = " + id);
            }
            Iterator iter = c.iterator();
            result = (TabelaPreco) iter.next();
        } catch (SQLException ex) {
            log.error(ex);
            throw new DAORuntimeException(ex);
        } finally {
            TabelaPrecoUtil.closeStatement(stmtSelect);
            TabelaPrecoUtil.closeResultSet(rs);
            TabelaPrecoUtil.closeJDBCConnection(conn);
        }
        return result;
    }
}

}

    public Collection buscaTabelaPrecoPorNome(String nome) {

    }

    public Collection buscaTodasTabelaPreco() {

    }

    public void removeTabelaPreco(int id) {

    }

    public TabelaPreco criaTabelaPreco(String nome, String duhn, String duhe, String duhe2, String ddu, String fshn, String fshe, String fshe2, String dfs) {

    }

    public void updateTabelaPreco(int id, String nome, String duhn, String duhe, String duhe2, String ddu, String fshn, String fshe, String fshe2, String dfs) throws TabelaPrecoNaoEncontradoException {

    }

    public void close() {

    }

    public boolean isClosed() {

    }
