package com.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.FiltroPesquisa;
import com.model.Cadastro_Central;
import com.model.Status;

public abstract class GenericDAO<T> {
    private final static String UNIT_NAME = "Central";

    @PersistenceContext(unitName = UNIT_NAME)
    private EntityManager em;

    private Class<T> entityClass;

    public GenericDAO(Class<T> entityClass) {
	this.entityClass = entityClass;
    }

    public void save(T entity) {
	em.persist(entity);
    }

    protected void delete(Object id, Class<T> classe) {
    	T entityToBeRemoved = em.getReference(classe, id);
    	em.remove(entityToBeRemoved);
    }

    public T update(T entity) {
	return em.merge(entity);
    }

    public T find(Long entityID) {
	return em.find(entityClass, entityID);
    }

    // Using the unchecked because JPA does not have a
    // em.getCriteriaBuilder().createQuery()<T> method
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<T> findAll() {
	CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
	cq.select(cq.from(entityClass));
	return em.createQuery(cq).getResultList();
    }

    // Using the unchecked because JPA does not have a
    // ery.getSingleResult()<T> method
//    @SuppressWarnings("unchecked")
//    protected T findOneResult(String namedQuery, Map<String, Object> parameters) {
//	T result = null;
//
//	try {
//	    Query query = em.createNamedQuery(namedQuery);
//
//	    // Method that will populate parameters if they are passed not null and empty
//	    if (parameters != null && !parameters.isEmpty()) {
//		populateQueryParameters(query, parameters);
//	    }
//
//	    result = (T) query.getSingleResult();
//
//	} catch (Exception e) {
//	    System.out.println("Error while running query: " + e.getMessage());
//	    e.printStackTrace();
//	}
//
//	return result;
//    }
    
    
    @SuppressWarnings("unchecked")
	public T findOneResult(String namedQuery,  Map<String, Object> parametros) {
		T result = null;
		try {
			Query query = em.createNamedQuery(namedQuery);
			if (parametros != null && !parametros.isEmpty()) {
				populateQueryParameters(query, parametros);
			}
			result = (T) query.getSingleResult();
		} catch (NoResultException e) {
			System.out
					.println("No result found for named query: " + namedQuery);
		} catch (Exception e) {
			System.out.println("Error while running query: " + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public <J > J findOneResult(Class<J> classJ, String namedQuery,  Map<String, Object> parametros) {
		J result = null;
		try {
			Query query = em.createNamedQuery(namedQuery);
			if (parametros != null && !parametros.isEmpty()) {
				populateQueryParameters(query, parametros);
			}
			result = (J) query.getSingleResult();
		} catch (NoResultException e) {
			System.out
					.println("No result found for named query: " + namedQuery);
		} catch (Exception e) {
			System.out.println("Error while running query: " + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
    
    
    @SuppressWarnings("unchecked")
	public List findAllResults(String namedQuery,  Map<String, Object> parametros) {
		List result = null;
		try {
			Query query = em.createNamedQuery(namedQuery);
			if (parametros != null && !parametros.isEmpty()) {
				populateQueryParameters(query, parametros);
			}

			result = (List) query.getResultList();

		} catch (NoResultException e) {
			System.out
					.println("No result found for named query: " + namedQuery);
		} catch (Exception e) {
			System.out.println("Error while running query: " + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	protected List findAllResultsNQ(String nativeQuery, Map<String, Object> parametros) {
		List result = null;
		try {
			Query query = em.createNativeQuery(nativeQuery);
			if (parametros != null && !parametros.isEmpty()) {
				populateQueryParameters(query, parametros);
			}
			result = query.getResultList();
		} catch (NoResultException e) {
			System.out.println("No result found for named query: "
					+ nativeQuery);
		} catch (Exception e) {
			System.out.println("Error while running query: " + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
    

    private void populateQueryParameters(Query query, Map<String, Object> parameters) {

	for (Entry<String, Object> entry : parameters.entrySet()) {
	    query.setParameter(entry.getKey(), entry.getValue());
	}
    }
    
    @SuppressWarnings({ "unchecked" })
	public List<T> buscaFiltro(Date dateInicio, Date dateFim, Status status, String tipoCadastro, boolean documento ) {
    	
    	FiltroPesquisa filtro = new FiltroPesquisa();
    	filtro.setDateInicio(dateInicio);
    	filtro.setDateFim(dateFim);
    	filtro.setStatus(status);
    	filtro.setTipoCadastroSelecionado(tipoCadastro);
		List<T> listaRetorno = null;
		
		CriteriaBuilder cq = em.getCriteriaBuilder();
		CriteriaQuery<Cadastro_Central> c = cq.createQuery(Cadastro_Central.class);
		
		Root<Cadastro_Central> cadastro = c.from(Cadastro_Central.class);
		

		ParameterExpression<Date> dataInicio = cq.parameter(Date.class,"inicio");
		ParameterExpression<Date> dataFim = cq.parameter(Date.class,"fim");

		Expression<Date> data = cadastro.get("data");

		Predicate between = cq.between(data, dataInicio, dataFim);
		Predicate inStatus = null;
		Predicate inCadas = null;
		Predicate inDocu = null;
		
		Predicate and = cq.or(between);

		if(filtro.getTipoCadastroSelecionado() != null && filtro.getTipoCadastroSelecionado().length() > 0){
			inCadas = cadastro.get("tipo").in(filtro.getTipoCadastroSelecionado().toLowerCase());
			and = cq.and(between,inCadas);
		}
		
		if(filtro.getStatus() != null ){
			inStatus = cadastro.get("andamento").in(filtro.getStatus());
			if(inCadas != null){
				and = cq.and(between,inCadas,inStatus);
			} else {
				and = cq.and(between,inStatus);
			}
		}
		
		if(documento){
			inDocu = cadastro.get("documentoEnvio").in(documento);
			if(inStatus == null){
				and = cq.and(between,inCadas,inDocu);	
			} else {
				and = cq.and(between,inCadas,inStatus,inDocu);
			}
			
		}
		

		

		
		c.where(and).orderBy(cq.asc(cadastro.get("data")));
		
		TypedQuery<Cadastro_Central> q = em.createQuery(c);
		q.setParameter("inicio", filtro.getDateInicio());
		q.setParameter("fim", filtro.getDateFim());
		
		
		listaRetorno = (List<T>) q.getResultList();
		System.out.println(listaRetorno.size());
		return  listaRetorno;
	}
    
}
