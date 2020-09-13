package com.id.wasta.data.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import com.id.wasta.bean.jpa.TIdLandingPhoneNoLinkEntity;

public interface TIdLandingPhoneNoLinkJpaRepository extends CrudRepository<TIdLandingPhoneNoLinkEntity, Long>{
	
	TIdLandingPhoneNoLinkEntity findByLlLdKeyAndLlPinKey(Long ldKey, Long loggedPinKey);

}
