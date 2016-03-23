package com.findzero.ejb.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.hibernate.Session;

import com.findzero.ejb.model.EntityBase;

public class RepositoryBase<E extends EntityBase> {
	/**
	 * EntityManager que controla as Entity's da aplicação.
	 */
	private EntityManager entityManager;

	/**
	 * Construtor.
	 * 
	 * @param em
	 * - EntityManager que controla a conexão com o banco de dados.
	 */
	protected RepositoryBase(final EntityManager em) {
		this.entityManager = em;
	}

	/**
	 * @return the entityManager
	 */
	protected EntityManager getEntityManager() {
		return this.entityManager;
	}

	protected Session getSession() {
		return (Session) this.entityManager.getDelegate();
	}

	/**
	 * Persiste um Entity na base de dados.
	 *
	 * @param e
	 *            - Entity que será persistido.
	 * @return o Entity persistido.
	 * @throws Exception
	 *             caso ocorra algum erro.
	 */
	public E save(final E e) throws Exception {
		try {
			// Verifica se a Entity já existe para fazer Merge.
			if (e.getId() != null) {
				// Verifica se a Entity não está gerenciavel pelo EntityManager.
				if (!this.entityManager.contains(e)) {
					// Busca a Entity da base de dados, baseado no Id.
					if (this.entityManager.find(e.getClass(), e.getId()) == null) {
						throw new Exception("Objeto não existe!");
					}
				}
				return this.entityManager.merge(e);
			} else { // Se a Entity não existir persiste ela.
				this.entityManager.persist(e);
			}
			// Retorna a Entity persistida.
			return e;
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw pe;
		}
	}

	/**
	 * Exclui um Entity da base de dados.
	 *
	 * @param e
	 *            - Entity que será excluida.
	 * @param k
	 *            - Id da Entity que será excluida.
	 * @throws Exception
	 *             caso ocorra algum erro.
	 */
	public void delete(final Class<E> e, final Long k) throws Exception {
		try {
			E entity = this.findById(e, k);
			// Remove a Entity da base de dados.
			this.entityManager.remove(entity);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw pe;
		}
	}

	/**
	 * Consulta um Entity pelo seu Id.
	 *
	 * @param e
	 *            - Classe da Entity.
	 * @param l
	 *            - Id da Entity.
	 * @return - a Entity da classe.
	 */
	public E findById(final Class<E> e, final Long l) {
		// Procura uma Entity na base de dados a partir da classe e do seu ID.
		return this.entityManager.find(e, l);
	}

	@SuppressWarnings("unchecked")
	public List<E> findAll(final Class<E> e) {
		Query query = this.entityManager.createQuery("SELECT e FROM "
				+ e.getSimpleName() + " e");
		return (List<E>) query.getResultList();
	}

	public Long count(final Class<E> e) {
		Query query = this.entityManager.createQuery("SELECT COUNT(e) FROM "
				+ e.getSimpleName() + " e");
		return (Long) query.getSingleResult();
	}
}
