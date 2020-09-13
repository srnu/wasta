package com.id.wasta.data.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import com.id.wasta.bean.jpa.TIdLandingRecreationLinkEntity;

public interface TIdLandingRecreationLinkJpaRepository extends CrudRepository<TIdLandingRecreationLinkEntity, Long>{
	
	TIdLandingRecreationLinkEntity findByLlLdKeyAndLlPinKey(Long ldKey, Long loggedPinKey);

}
