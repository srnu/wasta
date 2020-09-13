package com.id.wasta.data.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import com.id.wasta.bean.jpa.TIdLandingEducationLinkEntity;

public interface TIdLandingEducationLinkJpaRepository extends CrudRepository<TIdLandingEducationLinkEntity, Long>{
	
	TIdLandingEducationLinkEntity findByLlLdKeyAndLlPinKey(Long ldKey, Long loggedPinKey);

}
