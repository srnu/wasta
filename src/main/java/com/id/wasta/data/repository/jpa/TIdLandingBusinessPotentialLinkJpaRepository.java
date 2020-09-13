package com.id.wasta.data.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import com.id.wasta.bean.jpa.TIdLandingBusinessPotentialLinkEntity;

public interface TIdLandingBusinessPotentialLinkJpaRepository extends CrudRepository<TIdLandingBusinessPotentialLinkEntity, Long>{
	
	TIdLandingBusinessPotentialLinkEntity findByLlLdKeyAndLlPinKey(Long ldKey, Long loggedPinKey);

}
