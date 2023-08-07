/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package root.model.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import root.model.dao.exceptions.NonexistentEntityException;
import root.model.dao.exceptions.PreexistingEntityException;
import root.model.entities.Formula;

/**
 *
 * @author victor
 */
public class FormulaDAO implements Serializable {

    public FormulaDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");
    
   
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Formula formula) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(formula);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFormula(formula.getIdentificacion()) != null) {
                throw new PreexistingEntityException("Formula " + formula + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Formula formula) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            formula = em.merge(formula);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = formula.getIdentificacion();
                if (findFormula(id) == null) {
                    throw new NonexistentEntityException("The formula with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Formula formula;
            try {
                formula = em.getReference(Formula.class, id);
                formula.getIdentificacion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The formula with id " + id + " no longer exists.", enfe);
            }
            em.remove(formula);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Formula> findFormulaEntities() {
        return findFormulaEntities(true, -1, -1);
    }

    public List<Formula> findFormulaEntities(int maxResults, int firstResult) {
        return findFormulaEntities(false, maxResults, firstResult);
    }

    private List<Formula> findFormulaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Formula.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Formula findFormula(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Formula.class, id);
        } finally {
            em.close();
        }
    }

    public int getFormulaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Formula> rt = cq.from(Formula.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
