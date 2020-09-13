package com.id.wasta.data.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import com.id.wasta.bean.jpa.TIdLandingProfessionalRelationshipLinkEntity;

public interface TIdLandingProfessionalRelationshipLinkJpaRepository extends CrudRepository<TIdLandingProfessionalRelationshipLinkEntity, Long>{
	
	TIdLandingProfessionalRelationshipLinkEntity findByLlLdKeyAndLlPinKey(Long ldKey, Long loggedPinKey);

}
