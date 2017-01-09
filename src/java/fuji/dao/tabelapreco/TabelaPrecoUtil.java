/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuji.dao.tabelapreco;

import fuji.entities.TabelaPreco;
import java.sql.*;
import java.util.Collection;
import javax.sql.*;
import fuji.dao.exception.DAORuntimeException;
import org.apache.commons.lang.exception.*;
import org.apache.commons.logging.*;

/**
 *
 * @author juliano.lopes
 */
public final class TabelaPrecoUtil {

    static final private Log log = LogFactory.getLog(TabelaPrecoUtil.class);

    static public int getUniqueTabelaPrecoId(final Connection conn)
            throws java.sql.SQLException {
        int id;
        Statement stmtSelect = null;
        ResultSet rs = null;
        StringBuilder sbSelect = new StringBuilder();
        sbSelect.append("SELECT currentvalue FROM SYS.SYSSEQUENCES WHERE SEQUENCENAME='");
        sbSelect.append(TabelaPrecoConstantes.TABELAPRECO_ID_SEQUENCE_NAME.toUpperCase());
        sbSelect.append("'");
        try {
            stmtSelect = conn.createStatement();
            log.info("Executando a query: " + sbSelect.toString());
            rs = stmtSelect.executeQuery(sbSelect.toString());
            if (rs.next()) {
                log.info("OK");
            } else {
                log.info("NOK");
            }
            long aux = rs.getLong(1);
            id = (int) aux;
            id++;
        } finally {
            TabelaPrecoUtil.closeStatement(stmtSelect);
            TabelaPrecoUtil.closeResultSet(rs);
        }
        return id;
    }

    private TabelaPrecoUtil() {
// this constructor is intentionally private
    }

    static public Connection getConnection() {
        Connection conn = null;
        DataSource ds = null;
        try {
            Class.forName(TabelaPrecoConstantes.DRIVER).newInstance();
            conn = DriverManager.getConnection(TabelaPrecoConstantes.URL,
                    TabelaPrecoConstantes.USER,
                    TabelaPrecoConstantes.PASSWORD);
        } catch (ClassNotFoundException ex) {
            throw new DAORuntimeException(ex);
        } catch (InstantiationException e) {
            throw new DAORuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new DAORuntimeException(e);
        } catch (SQLException e) {
            throw new DAORuntimeException(e);
        }
        return conn;
    }

    public static void closeJDBCConnection(final Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.error(conn, ex);
            }
        }
    }

    public static void closeStatement(final Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                log.error(stmt, ex);
            }
        }
    }

    public static void closeResultSet(final ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                log.error(rs, ex);
            }
        }
    }

    static public Collection makeTabelaPrecoObjectsFromResultSet(final ResultSet rs)
            throws java.sql.SQLException {
        Collection result = new java.util.ArrayList();
        while (rs.next()) {
            int id = rs.getInt("usuario_id");
            String tabelaPrecoNome = rs.getString("tabelaPrecoNome");
            String duhn = rs.getString("duhn");
            String duhe = rs.getString("duhe");
            String duhe2 = rs.getString("duhe2");
            String ddu = rs.getString("ddu");
            String fshn = rs.getString("fshn");
            String fshe = rs.getString("fshe");
            String fshe2 = rs.getString("fshe2");
            String dfs = rs.getString("dfs");
            TabelaPreco u = new TabelaPreco(id, tabelaPrecoNome, duhn, duhe, duhe2, ddu, fshn, fshe, fshe2, dfs);
            result.add(u);
        }
        return result;
    }
}
