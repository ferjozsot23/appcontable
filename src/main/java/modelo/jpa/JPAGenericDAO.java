package modelo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import modelo.dao.GenericDAO;

/**Clase generica para manejar la persistencia de los datos de la entidades
 * @author Cristian
 * @param <T>
 * @param <ID>
 */
public class JPAGenericDAO<T, ID> implements GenericDAO<T, ID> {

	private Class<T> persistentClass;
	protected EntityManager em;

	/**Constructor de los parámetros 
	 * @param persistentClass, clases persistentes
	 */
	public JPAGenericDAO(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
		this.em = Persistence.createEntityManagerFactory("examenweb").createEntityManager();
	}
	
	/**
	 *Método para crear una entidad en la base de datos
	 */
	public void create(T entity) {
		em.getTransaction().begin();
		try {
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(">>>> ERROR:JPAGenericDAO:create " + e);
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
		}
	}

	/**
	 *Método para obtener el objeto por ID
	 */
	public T getById(ID id) {
		return em.find(persistentClass, id);
	}

	/**
	 *Método para actualizar un registro
	 */
	public void update(T entity) {
		em.getTransaction().begin();
		try {
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(">>>> ERROR:JPAGenericDAO:update " + e);
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
		}

	}

	/**
	 *Método para borrar un registro
	 */
	public void delete(T entity) {
		em.getTransaction().begin();
		try {
			em.remove(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(">>>> ERROR:JPAGenericDAO:delete " + e);
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
		}

	}

	/**
	 *Método para borrar un registro por su ID
	 */
	public void deleteByID(ID id) {
		T entity = this.getById(id);
		if (entity != null)
			this.delete(entity);

	}

	/**
	 * @author Cristian Verduga
	 */
	@SuppressWarnings("unchecked")
	public List<T> get(String[] attributes, String[] values) {
		// Se crea un criterio de consulta
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(this.persistentClass);
		// Se establece la clausula FROM
		Root<T> root = criteriaQuery.from(this.persistentClass);
		// Se establece la clausula SELECT
		criteriaQuery.select(root); // criteriaQuery.multiselect(root.get(atr))
		// Se configuran los predicados, combinados por AND
		Predicate predicate = criteriaBuilder.conjunction();
		for (int i = 0; i < attributes.length; i++) {
			Predicate sig = criteriaBuilder.like(root.get(attributes[i]).as(String.class), values[i]);
			// Predicate sig =
			// criteriaBuilder.like(root.get(attributes[i]).as(String.class),values[i]);
			predicate = criteriaBuilder.and(predicate, sig);
		}
		// Se establece el WHERE
		criteriaQuery.where(predicate);

		Query query = em.createQuery(criteriaQuery);
		return query.getResultList();

	}

	/**
	 * @author Cristian Verduga
	 */
	@SuppressWarnings("unchecked")
	public List<T> get(String[] attributes, String[] values, String order, int index, int size) {
		// Se crea un criterio de consulta
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(this.persistentClass);
		// Se establece la clausula FROM
		Root<T> root = criteriaQuery.from(this.persistentClass);
		// Se establece la clausula SELECT
		criteriaQuery.select(root); // criteriaQuery.multiselect(root.get(atr))
		// Se configuran los predicados, combinados por AND
		Predicate predicate = criteriaBuilder.conjunction();
		for (int i = 0; i < attributes.length; i++) {
			Predicate sig = criteriaBuilder.like(root.get(attributes[i]).as(String.class), values[i]);
			// Predicate sig =
			// criteriaBuilder.like(root.get(attributes[i]).as(String.class),
			// values[i]);
			predicate = criteriaBuilder.and(predicate, sig);
		}
		// Se establece el WHERE
		criteriaQuery.where(predicate);
		// Se establece el orden
		if (order != null)
			criteriaQuery.orderBy(criteriaBuilder.asc(root.get(order)));
		// Se crea el resultado
		if (index >= 0 && size > 0) {
			TypedQuery<T> tq = em.createQuery(criteriaQuery);
			tq.setFirstResult(index);
			tq.setMaxResults(size); // Se realiza la query
			return tq.getResultList();
		} else {
			// Se realiza la query
			Query query = em.createQuery(criteriaQuery);
			return query.getResultList();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> get() {
		// Se crea un criterio de consulta
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(this.persistentClass);
		// Se establece la clausula FROM
		Root<T> root = criteriaQuery.from(this.persistentClass);
		// Se establece la clausula SELECT
		criteriaQuery.select(root); // criteriaQuery.multiselect(root.get(atr))
		
		Query query = em.createQuery(criteriaQuery);
		return query.getResultList();
	}



}
