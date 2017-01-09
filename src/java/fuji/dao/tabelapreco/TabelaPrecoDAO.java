/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuji.dao.tabelapreco;

import fuji.entities.TabelaPreco;
import java.util.Collection;

/**
 *
 * @author juliano.lopes
 */
public interface TabelaPrecoDAO {

    public TabelaPreco buscaTabelaPrecoPorId(int id) throws TabelaPrecoNaoEncontradoException;

    public Collection buscaTabelaPrecoPorNome(String nome);

    public Collection buscaTodasTabelaPreco();

    public void removeTabelaPreco(int id) throws TabelaPrecoNaoEncontradoException;

    public TabelaPreco criaTabelaPreco(String nome, String duhn, String duhe, String duhe2, String ddu, String fshn, String fshe, String fshe2, String dfs);

    public void updateTabelaPreco(int id, String nome, String duhn, String duhe, String duhe2, String ddu, String fshn, String fshe, String fshe2, String dfs) throws TabelaPrecoNaoEncontradoException;

    public void close();

    public boolean isClosed();
}
