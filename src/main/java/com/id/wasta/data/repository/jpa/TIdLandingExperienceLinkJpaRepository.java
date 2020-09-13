package com.id.wasta.data.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import com.id.wasta.bean.jpa.TIdLandingExperienceLinkEntity;

public interface TIdLandingExperienceLinkJpaRepository extends CrudRepository<TIdLandingExperienceLinkEntity, Long>{
	
	TIdLandingExperienceLinkEntity findByLlLdKeyAndLlPinKey(Long ldKey, Long loggedPinKey);

}
