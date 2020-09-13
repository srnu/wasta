package com.id.wasta.data.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import com.id.wasta.bean.jpa.TIdLandingProjectExecutedLinkEntity;

public interface TIdLandingProjectExecutedLinkJpaRepository extends CrudRepository<TIdLandingProjectExecutedLinkEntity, Long>{
	
	TIdLandingProjectExecutedLinkEntity findByLlLdKeyAndLlPinKey(Long ldKey, Long loggedPinKey);

}
