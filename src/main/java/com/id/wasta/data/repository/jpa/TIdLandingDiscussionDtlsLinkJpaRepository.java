package com.id.wasta.data.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import com.id.wasta.bean.jpa.TIdLandingDiscussionDtlsLinkEntity;

public interface TIdLandingDiscussionDtlsLinkJpaRepository extends CrudRepository<TIdLandingDiscussionDtlsLinkEntity, Long>{
	
	TIdLandingDiscussionDtlsLinkEntity findByLlLdKeyAndLlPinKey(Long ldKey, Long loggedPinKey);

}
