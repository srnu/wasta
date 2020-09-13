package com.id.wasta.data.repository.jpa;

import java.util.List;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdRelationshipInformationViewEntity;

/**
 * Repository : TIdRelationshipInformation.
 */
public interface 	TIdRelationshipInformationViewJpaRepository extends BaseRepository<TIdRelationshipInformationViewEntity, Long> {

	List<TIdRelationshipInformationViewEntity> findByPrlPinKeyAndActiveStatus(Long pinKey,String status);
	
	List<TIdRelationshipInformationViewEntity> findByPrlPinKeyAndRelationTypeAndActiveStatus(Long pinKey, String relationType,String status);

}
