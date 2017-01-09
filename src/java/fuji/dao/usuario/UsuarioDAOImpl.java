/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuji.dao.usuario;

import fuji.entities.Usuario;
import java.sql.*;
import java.util.*;
import fuji.dao.exception.DAORuntimeException;
import org.apache.commons.lang.exception.*;
import org.apache.commons.logging.*;

/**
 *
 * @author juliano.lopes
 */
public class UsuarioDAOImpl implements UsuarioDAO {

    static final private Log log = LogFactory.getLog(UsuarioDAOImpl.class);
    private boolean bIsClosed = false;

    public UsuarioDAOImpl() {
        bIsClosed = false;
    }

    @Override
    public Usuario buscaUsuarioPorId(final int id)
            throws UsuarioNaoEncontradoException {
        Connection conn = UsuarioUtil.getConnection();
        Usuario result = null;
        ResultSet rs = null;
        PreparedStatement stmtSelect = null;
        try {
            StringBuilder sbSelect = new StringBuilder();
            sbSelect.append("SELECT usuario_id, nome, sobrenome, email FROM ");
            sbSelect.append(UsuarioConstantes.USUARIO_TABLE_NAME);
            sbSelect.append(" WHERE usuario_id = ?");
            stmtSelect = conn.prepareStatement(sbSelect.toString());
            stmtSelect.setInt(1, id);
            rs = stmtSelect.executeQuery();
            Collection c = UsuarioUtil.makeUsuarioObjectsFromResultSet(rs);
            if (c.size() != 1) {
                throw new UsuarioNaoEncontradoException("id = " + id);
            }
            Iterator iter = c.iterator();
            result = (Usuario) iter.next();
        } catch (SQLException ex) {
            log.error(ex);
            throw new DAORuntimeException(ex);
        } finally {
            UsuarioUtil.closeStatement(stmtSelect);
            UsuarioUtil.closeResultSet(rs);
            UsuarioUtil.closeJDBCConnection(conn);
        }
        return result;
    }

    @Override
    public Collection buscaUsuarioPorNome(final String nome) {
        Connection conn = UsuarioUtil.getConnection();
        Collection result = null;
        ResultSet rs = null;
        PreparedStatement stmtSelect = null;
        try {
            StringBuilder sbSelect = new StringBuilder();
            sbSelect.append("SELECT usuario_id, nome, sobrenome, email FROM ");
            sbSelect.append(UsuarioConstantes.USUARIO_TABLE_NAME);
            sbSelect.append(" WHERE nome = ?");
            stmtSelect = conn.prepareStatement(sbSelect.toString());
            stmtSelect.setString(1, nome);
            rs = stmtSelect.executeQuery();
            result = UsuarioUtil.makeUsuarioObjectsFromResultSet(rs);
        } catch (SQLException ex) {
            log.error(ex);
            throw new DAORuntimeException(ex);
        } finally {
            UsuarioUtil.closeStatement(stmtSelect);
            UsuarioUtil.closeResultSet(rs);
            UsuarioUtil.closeJDBCConnection(conn);
        }
        return result;
    }

    @Override
    public void removeUsuario(final int id)
            throws UsuarioNaoEncontradoException {
        Connection conn = UsuarioUtil.getConnection();
        PreparedStatement stmtDelete = null;
        try {
            StringBuilder sbDelete = new StringBuilder();
            sbDelete.append("DELETE FROM ");
            sbDelete.append(UsuarioConstantes.USUARIO_TABLE_NAME);
            sbDelete.append(" WHERE usuario_id = ?");
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
            UsuarioUtil.closeStatement(stmtDelete);
            UsuarioUtil.closeJDBCConnection(conn);
        }
    }

    @Override
    public Usuario criaUsuario(
            final String nome,
            final String sobrenome,
            final String email) {
        Usuario result = null;
        PreparedStatement stmtInsert = null;
        Connection conn = UsuarioUtil.getConnection();
        try {
            int usuario_id = UsuarioUtil.getUniqueUsuarioId(conn);
            StringBuilder sbInsert = new StringBuilder();
            sbInsert.append("INSERT INTO ");
            sbInsert.append(UsuarioConstantes.USUARIO_TABLE_NAME);
            sbInsert.append(" ( usuario_id, nome, sobrenome, email ) ");
            sbInsert.append(" VALUES (");
            sbInsert.append(" NEXT VALUE FOR ");
            sbInsert.append(UsuarioConstantes.USUARIO_ID_SEQUENCE_NAME);
            sbInsert.append(", ?, ?, ?) ");
            stmtInsert = conn.prepareStatement(sbInsert.toString());
            stmtInsert.setString(1, nome);
            stmtInsert.setString(2, sobrenome);
            stmtInsert.setString(3, email);
            log.info("About to execute INSERT: values "
                    + nome + ", " + sobrenome + ", " + email);
            int rows = stmtInsert.executeUpdate();
            if (rows != 1) {
                throw new SQLException(
                        "executeUpdate return value: "
                        + rows);
            }
            result = new Usuario(usuario_id, nome, sobrenome, email);
        } catch (SQLException ex) {
            log.error(ex);
            throw new DAORuntimeException(ex);
        } finally {
            UsuarioUtil.closeStatement(stmtInsert);
            UsuarioUtil.closeJDBCConnection(conn);
        }
        return result;
    }

    @Override
    public void updateUsuario(final int id,
            final String nome,
            final String sobrenome,
            final String email) throws UsuarioNaoEncontradoException {
        Connection conn = UsuarioUtil.getConnection();
        PreparedStatement stmtUpdate = null;
        try {
            StringBuilder sbUpdate = new StringBuilder();
            sbUpdate.append("UPDATE ");
            sbUpdate.append(UsuarioConstantes.USUARIO_TABLE_NAME);
            sbUpdate.append(" SET ");
            sbUpdate.append(" nome = ?, ");
            sbUpdate.append(" sobrenome = ? ");
            sbUpdate.append(" email = ? ");
            sbUpdate.append(" WHERE usuario_id = ?");
            stmtUpdate = conn.prepareStatement(sbUpdate.toString());
            stmtUpdate.setString(1, nome);
            stmtUpdate.setString(2, sobrenome);
            stmtUpdate.setString(3, email);
            stmtUpdate.setInt(4, id);
            int rows = stmtUpdate.executeUpdate();
            if (rows != 1) {
                throw new SQLException("executeUpdate return value: " + rows);
            }
        } catch (SQLException ex) {
            throw new DAORuntimeException(ex);
        } finally {
            UsuarioUtil.closeStatement(stmtUpdate);
            UsuarioUtil.closeJDBCConnection(conn);
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

    @Override
    public Collection buscaTodosUsuarios() {
        Connection conn = UsuarioUtil.getConnection();
        Collection result = null;
        ResultSet rs = null;
        PreparedStatement stmtSelect = null;
        try {
            StringBuilder sbSelect = new StringBuilder();
            sbSelect.append("SELECT usuario_id, nome, sobrenome, email FROM ");
            sbSelect.append(UsuarioConstantes.USUARIO_TABLE_NAME);
            stmtSelect = conn.prepareStatement(sbSelect.toString());
            rs = stmtSelect.executeQuery();
            result = UsuarioUtil.makeUsuarioObjectsFromResultSet(rs);
        } catch (SQLException ex) {
            log.error(ex);
            throw new DAORuntimeException(ex);
        } finally {
            UsuarioUtil.closeStatement(stmtSelect);
            UsuarioUtil.closeResultSet(rs);
            UsuarioUtil.closeJDBCConnection(conn);
        }
        return result;
    }
}
