package com.id.wasta.data.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import com.id.wasta.bean.jpa.TIdLandingAddInformationLinkEntity;

public interface TIdLandingAddInformationLinkJpaRepository extends CrudRepository<TIdLandingAddInformationLinkEntity, Long>{
	
	TIdLandingAddInformationLinkEntity findByLlLdKeyAndLlPinKey(Long ldKey, Long loggedPinKey);

}
