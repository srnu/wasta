package com.id.wasta.data.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import com.id.wasta.bean.jpa.TIdLandingHomeLinkEntity;

public interface TIdLandingHomeLinkJpaRepository extends CrudRepository<TIdLandingHomeLinkEntity, Long>{
	
	TIdLandingHomeLinkEntity findByLlLdKeyAndLlPinKey(Long ldKey, Long loggedPinKey);

}
