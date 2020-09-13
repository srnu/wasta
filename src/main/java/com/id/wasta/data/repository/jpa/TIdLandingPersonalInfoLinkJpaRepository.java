package com.id.wasta.data.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import com.id.wasta.bean.jpa.TIdLandingPersonalInfoLinkEntity;

public interface TIdLandingPersonalInfoLinkJpaRepository extends CrudRepository<TIdLandingPersonalInfoLinkEntity, Long>{
	
	TIdLandingPersonalInfoLinkEntity findByLlLdKeyAndLlPinKey(Long ldKey, Long loggedPinKey);

}
