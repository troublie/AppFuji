/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuji.dao.cotacao;

import com.sun.istack.internal.NotNull;
import fuji.dao.exception.DAORuntimeException;
import fuji.entities.Cotacao;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.apache.commons.logging.*;

/**
 *
 * @author juliano.lopes
 */
public class CotacaoDAOJPAImpl implements CotacaoDAO {

    static final private Log log = LogFactory.getLog(CotacaoDAOJPAImpl.class);
    private boolean bIsClosed = false;

    @Override
    public Cotacao buscaCotacaoPorId(int id) throws CotacaoNaoEncontradaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppFujiPU");
        EntityManager em = emf.createEntityManager();
        Cotacao c = em.find(Cotacao.class, id);
        if (c == null) {
            throw new CotacaoNaoEncontradaException("Cotação não encontrada");
        }
        em.clear();
        em.close();
        emf.close();
        return c;
    }

    @Override
    public Collection buscaTodasCotacoes() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppFujiPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select c from Cotacao c");
        Collection result = null;
        result = q.getResultList();
        em.clear();
        em.close();
        emf.close();
        return result;
    }

    @Override
    public void removeCotacao(int id) throws CotacaoNaoEncontradaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppFujiPU");
        EntityManager em = emf.createEntityManager();
        Cotacao c = em.find(Cotacao.class, id);
        if (c == null) {
            throw new CotacaoNaoEncontradaException("Cotação não encontrada");
        }
        try {
            em.getTransaction().begin();
            em.remove(c);
            em.flush();
            em.getTransaction().commit();
        } catch (final NoResultException ex) {
            log.error(ex);
            throw new DAORuntimeException(ex);
        } finally {
            em.clear();
            em.close();
            emf.close();
        }
    }

    @Override
    public Cotacao criaCotacao(String contatoNome, Date data, String usuarioFirstName,
            String descricao, String ref, String os, Double total) {
        Cotacao c = new Cotacao();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppFujiPU");
        EntityManager em = emf.createEntityManager();
        c.setContatoNome(contatoNome);
        c.setDate(data);
        c.setUsuarioFirstName(usuarioFirstName);
        c.setDescricao(descricao);
        c.setRef(ref);
        c.setOs(os);
        c.setTotal(total);
        em.getTransaction().begin();
        em.persist(c);
        em.flush();
        em.getTransaction().commit();

        return c;
    }

    @Override
    public void updateCotacao(int id, String contatoNome, Date data, String usuarioFirstName,
            String descricao, String ref, String os, Double total) throws CotacaoNaoEncontradaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppFujiPU");
        EntityManager em = emf.createEntityManager();
        Cotacao c = em.find(Cotacao.class, id);
        if (c == null) {
            throw new CotacaoNaoEncontradaException("Cotação não encontrada");
        }
        em.getTransaction().begin();
        c.setContatoNome(contatoNome);
        c.setDate(data);
        c.setUsuarioFirstName(usuarioFirstName);
        c.setDescricao(descricao);
        c.setRef(ref);
        c.setOs(os);
        c.setTotal(total);
        em.flush();
        em.getTransaction().commit();
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
