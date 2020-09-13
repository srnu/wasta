package com.id.wasta.data.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import com.id.wasta.bean.jpa.TIdLandingProfessionalInterestLinkEntity;

public interface TIdLandingProfessionalInterestLinkJpaRepository extends CrudRepository<TIdLandingProfessionalInterestLinkEntity, Long>{
	
	TIdLandingProfessionalInterestLinkEntity findByLlLdKeyAndLlPinKey(Long ldKey, Long loggedPinKey);

}
