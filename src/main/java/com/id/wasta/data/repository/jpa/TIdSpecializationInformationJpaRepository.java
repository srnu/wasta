package com.id.wasta.data.repository.jpa;

import java.util.List;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdSpecializationInformationEntity;

/**
 * Repository : TIdSpecializationInformation.
 */
public interface TIdSpecializationInformationJpaRepository extends BaseRepository<TIdSpecializationInformationEntity, Long> {

	List<TIdSpecializationInformationEntity> findByPesPeiKey(Long peiKey);

}

