/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuji.dao.tabelapreco;

import fuji.entities.TabelaPreco;
import java.util.Collection;
import com.sun.istack.internal.NotNull;
import fuji.dao.exception.DAORuntimeException;
import fuji.entities.Usuario;
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
public class TabelaPrecoDAOJPAImpl implements TabelaPrecoDAO {

    static final private Log log = LogFactory.getLog(TabelaPrecoDAOJPAImpl.class);
    private boolean bIsClosed = false;

    public TabelaPreco buscaTabelaPrecoPorId(final int id)
            throws TabelaPrecoNaoEncontradoException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppFujiPU");
        EntityManager em = emf.createEntityManager();
        TabelaPreco t = em.find(TabelaPreco.class, id);
        if (t == null) {
            throw new TabelaPrecoNaoEncontradoException("Tabela não encontrada");
        }
        em.clear();
        em.close();
        emf.close();
        return t;
    }

    @Override
    public Collection buscaTabelaPrecoPorNome(String nome) {
        Collection result = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppFujiPU");
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<TabelaPreco> criteria = builder.createQuery(TabelaPreco.class);
        Root<TabelaPreco> from = criteria.from(TabelaPreco.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("TabelaPrecoNome"), nome));
        TypedQuery<TabelaPreco> typed = em.createQuery(criteria);
        try {
            result = typed.getResultList();
        } catch (final NoResultException ex) {
            log.error(ex);
            throw new DAORuntimeException(ex);
        }
        em.clear();
        em.close();
        emf.close();
        return result;

    }

    @Override
    public Collection buscaTodasTabelaPreco() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppFujiPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select t from TabelaPreco t");
        Collection result = null;
        result = q.getResultList();
        em.clear();
        em.close();
        emf.close();
        return result;
    }

    @Override
    public void removeTabelaPreco(int id)
            throws TabelaPrecoNaoEncontradoException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppFujiPU");
        EntityManager em = emf.createEntityManager();
        TabelaPreco t = em.find(TabelaPreco.class, id);
        if (t == null) {
            throw new TabelaPrecoNaoEncontradoException("Tabela não encontrada");
        }
        try {
            em.getTransaction().begin();
            em.remove(t);
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

    public TabelaPreco criaTabelaPreco(String nome, String duhn, String duhe,
            String duhe2, String ddu, String fshn,
            String fshe, String fshe2, String dfs) {
        TabelaPreco t = new TabelaPreco();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppFujiPU");
        EntityManager em = emf.createEntityManager();
        t.setNome(nome);
        t.setDuhn(duhn);
        t.setDuhe(duhe);
        t.setDuhe2(duhe2);
        t.setDdu(ddu);
        t.setFshn(fshn);
        t.setFshe(fshe);
        t.setFshe2(fshe2);
        t.setDfs(dfs);
        em.getTransaction().begin();
        em.persist(t);
        em.flush();
        em.getTransaction().commit();

        return t;
    }

    public void updateTabelaPreco(int id, String nome, String duhn, String duhe,
            String duhe2, String ddu, String fshn,
            String fshe, String fshe2, String dfs)
            throws TabelaPrecoNaoEncontradoException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppFujiPU");
        EntityManager em = emf.createEntityManager();
        TabelaPreco t = em.find(TabelaPreco.class, id);
        if (t == null) {
            throw new TabelaPrecoNaoEncontradoException("Tabela não encontrada");
        }
        em.getTransaction().begin();
        t.setNome(nome);
        t.setDuhn(duhn);
        t.setDuhe(duhe);
        t.setDuhe2(duhe2);
        t.setDdu(ddu);
        t.setFshn(fshn);
        t.setFshe(fshe);
        t.setFshe2(fshe2);
        t.setDfs(dfs);
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
