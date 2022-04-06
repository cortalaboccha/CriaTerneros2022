package EJB;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public abstract class AbstractFacade<T> {
	
	private Class<T> entityClass;
	
	public AbstractFacade (Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	
	protected abstract EntityManager getEntityManager();
	
	public void crear(T entity) {
		getEntityManager().persist(entity);
	}
	
	public void editar(T entity) {
		getEntityManager().merge(entity);
	}
	
	public void remove(T entity) {
		getEntityManager().remove(getEntityManager().merge(entity));
	}
	
	public T find(Object id) {
		return getEntityManager().find(entityClass, id);
	}
	
	
	
	public List<T> findAll(){
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<T> cq= criteriaBuilder.createQuery(entityClass);
		cq.select(cq.from(entityClass));
		return getEntityManager().createQuery(cq).getResultList();
	}
	
	
	/*
	
	public List<T> findAll(){
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
	    CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
	    Root<T> from = criteriaQuery.from(entityClass);
	    //	criteriaQuery.orderBy(criteriaBuilder.asc(from.get("nickname")));
	    CriteriaQuery<T> select = criteriaQuery.select(from);
	    TypedQuery<T> typedQuery = getEntityManager().createQuery(select);
	    List<T> resultList = typedQuery.getResultList();
	    return resultList;
	}
	
	*/
}
