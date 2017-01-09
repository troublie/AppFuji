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
    public TabelaPreco buscaTabelaPrecoPorId(final int id) throws TabelaPrecoNaoEncontradoException {
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

    @Override
    public Collection buscaTabelaPrecoPorNome(final String tabelaPrecoNome) {
        Connection conn = TabelaPrecoUtil.getConnection();
        Collection result = null;
        ResultSet rs = null;
        PreparedStatement stmtSelect = null;
        try {
            StringBuilder sbSelect = new StringBuilder();
            sbSelect.append("SELECT tabelapreco_id, tabelapreconome, duhn, duhe, duhe2, ddu, fshn, fshe, fshe2, dfs FROM ");
            sbSelect.append(TabelaPrecoConstantes.TABELAPRECO_TABLE_NAME);
            sbSelect.append(" WHERE tabelapreconome = ?");
            stmtSelect = conn.prepareStatement(sbSelect.toString());
            stmtSelect.setString(1, tabelaPrecoNome);
            rs = stmtSelect.executeQuery();
            result = TabelaPrecoUtil.makeTabelaPrecoObjectsFromResultSet(rs);
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

    public Collection buscaTodasTabelaPreco() {
        Connection conn = TabelaPrecoUtil.getConnection();
        Collection result = null;
        ResultSet rs = null;
        PreparedStatement stmtSelect = null;
        try {
            StringBuilder sbSelect = new StringBuilder();
            sbSelect.append("SELECT tabelapreco_id, tabelapreconome, duhn, duhe, duhe2, ddu, fshn, fshe, fshe2, dfs FROM ");
            sbSelect.append(TabelaPrecoConstantes.TABELAPRECO_TABLE_NAME);
            stmtSelect = conn.prepareStatement(sbSelect.toString());
            rs = stmtSelect.executeQuery();
            result = TabelaPrecoUtil.makeTabelaPrecoObjectsFromResultSet(rs);
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

    @Override
    public void removeTabelaPreco(final int id) throws TabelaPrecoNaoEncontradoException {
        Connection conn = TabelaPrecoUtil.getConnection();
        Collection result = null;
        PreparedStatement stmtDelete = null;
        try {
            StringBuilder sbDelete = new StringBuilder();
            sbDelete.append("DELETE FROM ");
            sbDelete.append(TabelaPrecoConstantes.TABELAPRECO_TABLE_NAME);
            sbDelete.append(" WHERE tabelapreco_id = ?");
            stmtDelete = conn.prepareStatement(sbDelete.toString());
            stmtDelete.setInt(1, id);
            int rows = stmtDelete.executeUpdate();
            if (rows != 1) {
                throw new SQLException("executeUpdate return value: " + rows);
            }
        } catch (SQLException ex) {
            log.error(ex);
            throw new DAORuntimeException(ex);
        } finally {
            TabelaPrecoUtil.closeStatement(stmtDelete);
            TabelaPrecoUtil.closeJDBCConnection(conn);
        }
    }

    @Override
    public TabelaPreco criaTabelaPreco(final String nome, final String duhn,
            final String duhe, final String duhe2, final String ddu, final String fshn,
            final String fshe, final String fshe2, final String dfs) {
        TabelaPreco result = null;
        PreparedStatement stmtInsert = null;
        Connection conn = TabelaPrecoUtil.getConnection();
        try {
            int tabelapreco_id = TabelaPrecoUtil.getUniqueTabelaPrecoId(conn);
            StringBuilder sbInsert = new StringBuilder();
            sbInsert.append("INSERT INTO ");
            sbInsert.append(TabelaPrecoConstantes.TABELAPRECO_TABLE_NAME);
            sbInsert.append(" ( tabelapreco_id, nome, duhn, duhe, duhe2, ddu, fshn, fshe, fshe2, dfs ) ");
            sbInsert.append(" VALUES (");
            sbInsert.append(" NEXT VALUE FOR ");
            sbInsert.append(TabelaPrecoConstantes.TABELAPRECO_ID_SEQUENCE_NAME);
            sbInsert.append(", ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
            stmtInsert = conn.prepareStatement(sbInsert.toString());
            stmtInsert.setString(1, nome);
            stmtInsert.setString(2, duhn);
            stmtInsert.setString(3, duhe);
            stmtInsert.setString(4, duhe2);
            stmtInsert.setString(5, ddu);
            stmtInsert.setString(6, fshn);
            stmtInsert.setString(7, fshe);
            stmtInsert.setString(8, fshe2);
            stmtInsert.setString(9, dfs);
            log.info("About to execute INSERT: values "
                    + nome + ", " + duhn + ", " + duhe + ", " + duhe2 + ", "
                    + ddu + ", " + fshn + ", " + fshe + ", " + fshe2 + ", " + dfs);
            int rows = stmtInsert.executeUpdate();
            if (rows != 1) {
                throw new SQLException(
                        "executeUpdate return value: "
                        + rows);
            }
            result = new TabelaPreco(tabelapreco_id, nome, duhn, duhe, duhe2, ddu, fshn, fshe, fshe2, dfs);
        } catch (SQLException ex) {
            log.error(ex);
            throw new DAORuntimeException(ex);
        } finally {
            TabelaPrecoUtil.closeStatement(stmtInsert);
            TabelaPrecoUtil.closeJDBCConnection(conn);
        }
        return result;
    }

    public void updateTabelaPreco(int id, String nome, String duhn, String duhe,
            String duhe2, String ddu, String fshn, String fshe, String fshe2,
            String dfs) throws TabelaPrecoNaoEncontradoException {
        Connection conn = TabelaPrecoUtil.getConnection();
        PreparedStatement stmtUpdate = null;
        try {
            StringBuilder sbUpdate = new StringBuilder();
            sbUpdate.append("UPDATE ");
            sbUpdate.append(TabelaPrecoConstantes.TABELAPRECO_TABLE_NAME);
            sbUpdate.append(" SET ");
            sbUpdate.append(" nome = ?, ");
            sbUpdate.append(" duhn = ? ");
            sbUpdate.append(" duhe = ? ");
            sbUpdate.append(" duhe2 = ? ");
            sbUpdate.append(" ddu = ? ");
            sbUpdate.append(" fshn = ? ");
            sbUpdate.append(" fshe = ? ");
            sbUpdate.append(" fshe2 = ? ");
            sbUpdate.append(" dfs = ? ");
            sbUpdate.append(" WHERE usuario_id = ?");
            stmtUpdate = conn.prepareStatement(sbUpdate.toString());
            stmtUpdate.setString(1, nome);
            stmtUpdate.setString(2, duhn);
            stmtUpdate.setString(3, duhe);
            stmtUpdate.setString(4, duhe2);
            stmtUpdate.setString(5, ddu);
            stmtUpdate.setString(6, fshn);
            stmtUpdate.setString(7, fshe);
            stmtUpdate.setString(8, fshe2);
            stmtUpdate.setString(9, dfs);
            stmtUpdate.setInt(10, id);
            int rows = stmtUpdate.executeUpdate();
            if (rows != 1) {
                throw new SQLException("executeUpdate return value: " + rows);
            }
        } catch (SQLException ex) {
            throw new DAORuntimeException(ex);
        } finally {
            TabelaPrecoUtil.closeStatement(stmtUpdate);
            TabelaPrecoUtil.closeJDBCConnection(conn);
        }
    }

    @Override
    public void close() {
        log.info("close() called");
        bIsClosed = true;
    }

    @Override
    public boolean isClosed() {
        return bIsClosed;
    }
}
