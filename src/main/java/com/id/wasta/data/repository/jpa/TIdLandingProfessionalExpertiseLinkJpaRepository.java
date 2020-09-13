package com.id.wasta.data.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import com.id.wasta.bean.jpa.TIdLandingProfessionalExpertiseLinkEntity;

public interface TIdLandingProfessionalExpertiseLinkJpaRepository extends CrudRepository<TIdLandingProfessionalExpertiseLinkEntity, Long>{
	
	TIdLandingProfessionalExpertiseLinkEntity findByLlLdKeyAndLlPinKey(Long ldKey, Long loggedPinKey);

}
