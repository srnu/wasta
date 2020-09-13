package com.id.wasta.data.repository.jpa;

import java.util.List;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdSocialMediaInformationEntity;

/**
 * Repository : TIdSocialMediaInformation.
 */
public interface TIdSocialMediaInformationJpaRepository extends BaseRepository<TIdSocialMediaInformationEntity, Long> {
	
	List<TIdSocialMediaInformationEntity> findByPsmPinKey(Long pinKey);
}
