package com.id.wasta.data.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import com.id.wasta.bean.jpa.TIdLandingPersonalRelationshipsLinkEntity;

public interface TIdLandingPersonalRelationshipsLinkJpaRepository extends CrudRepository<TIdLandingPersonalRelationshipsLinkEntity, Long>{
	
	TIdLandingPersonalRelationshipsLinkEntity findByLlLdKeyAndLlPinKey(Long ldKey, Long loggedPinKey);

}
