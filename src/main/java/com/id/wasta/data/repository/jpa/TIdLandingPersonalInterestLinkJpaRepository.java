package com.id.wasta.data.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import com.id.wasta.bean.jpa.TIdLandingPersonalInterestLinkEntity;

public interface TIdLandingPersonalInterestLinkJpaRepository extends CrudRepository<TIdLandingPersonalInterestLinkEntity, Long>{
	
	TIdLandingPersonalInterestLinkEntity findByLlLdKeyAndLlPinKey(Long ldKey, Long loggedPinKey);

}
