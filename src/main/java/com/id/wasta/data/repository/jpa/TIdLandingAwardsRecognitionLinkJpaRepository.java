package com.id.wasta.data.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import com.id.wasta.bean.jpa.TIdLandingAwardsRecognitionLinkEntity;

public interface TIdLandingAwardsRecognitionLinkJpaRepository extends CrudRepository<TIdLandingAwardsRecognitionLinkEntity, Long>{
	
	TIdLandingAwardsRecognitionLinkEntity findByLlLdKeyAndLlPinKey(Long ldKey, Long loggedPinKey);

}
