package com.id.wasta.data.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import com.id.wasta.bean.jpa.TIdLandingPersonalPrioritiesLinkEntity;

public interface TIdLandingPersonalPrioritiesLinkJpaRepository extends CrudRepository<TIdLandingPersonalPrioritiesLinkEntity, Long>{
	
	TIdLandingPersonalPrioritiesLinkEntity findByLlLdKeyAndLlPinKey(Long ldKey, Long loggedPinKey);

}
