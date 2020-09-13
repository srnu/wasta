package com.id.wasta.data.repository.jpa;

import java.util.List;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdSpecializationInformationViewEntity;

/**
 * Repository : TIdSpecializationInformation.
 */
public interface TIdSpecializationInformationViewJpaRepository extends BaseRepository<TIdSpecializationInformationViewEntity, Long> {

	List<TIdSpecializationInformationViewEntity> findByPesPeiKey(Long peiKey);
	
	List<TIdSpecializationInformationViewEntity> findByPesPeiKeyAndPesSpecializationStatus(Long peiKey, String status);
	
}

