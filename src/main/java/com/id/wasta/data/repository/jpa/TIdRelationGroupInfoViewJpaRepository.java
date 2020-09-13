package com.id.wasta.data.repository.jpa;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.id.wasta.bean.jpa.TIdRelationGroupInfoViewEntity;

/**
 * Repository : TIdRelationshipInformation.
 */
public interface 	TIdRelationGroupInfoViewJpaRepository extends CrudRepository<TIdRelationGroupInfoViewEntity, Long> {

List<TIdRelationGroupInfoViewEntity> findByPrlPinKey(Long pinKey);
	
List<TIdRelationGroupInfoViewEntity> findByPrlPinKeyAndRelationtype(Long pinKey, String relationType);




}
