/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuji.dao.cotacao;
import fuji.entities.Cotacao;
import java.util.Collection;
import java.util.Date;
/**
 *
 * @author juliano.lopes
 */
public interface CotacaoDAO {

    public Cotacao buscaCotacaoPorId(int id) throws CotacaoNaoEncontradaException;

    public Collection buscaTodasCotacoes();

    public void removeCotacao(int id) throws CotacaoNaoEncontradaException;

    public Cotacao criaCotacao(String contatoNome, Date data, String usuarioFirstName, 
            String descricao, String ref, String os, Double total);

    public void updateCotacao(int id, String contatoNome, Date data, String usuarioFirstName, 
            String descricao, String ref, String os, Double total) throws CotacaoNaoEncontradaException;

    public void close();

    public boolean isClosed();
}
