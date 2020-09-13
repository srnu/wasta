package com.id.wasta.data.gen.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.data.repository.support.Repositories;


public class GenericRepository {
	
	//@Autowired
	//private WebApplicationContext appContext;

	Repositories repositories = null;

	RepositoryFactorySupport factory = null;

	@PersistenceContext
	EntityManager em;
		
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JpaRepository getRepository(Class entity) {
		JpaRepository repo = (JpaRepository) factory.getRepository(entity);		
		return repo;
	}
	
	
	@SuppressWarnings("rawtypes")
	public Object findAll(Class entity) {
		return getRepository(entity).findAll();
	}

}
