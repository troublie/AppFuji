/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuji.dao.usuario;

import fuji.entities.Usuario;
import java.util.Collection;

/**
 *
 * @author juliano.lopes
 */
public interface UsuarioDAO {

    public Usuario buscaUsuarioPorId(int id) throws UsuarioNaoEncontradoException;

    public Collection buscaUsuarioPorNome(String nome);

    public Collection buscaTodosUsuarios();

    public void removeUsuario(int id) throws UsuarioNaoEncontradoException;

    public Usuario criaUsuario(String nome, String sobrenome, String email);

    public void updateUsuario(int id, String nome, String sobrenome, String email) throws UsuarioNaoEncontradoException;

    public void close();

    public boolean isClosed();
}
