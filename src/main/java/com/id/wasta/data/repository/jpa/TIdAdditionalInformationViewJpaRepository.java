package com.id.wasta.data.repository.jpa;

import java.util.List;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdAdditionalInformationViewEntity;

/**
 * Repository : TIdAdditionalInformation.
 */
public interface TIdAdditionalInformationViewJpaRepository extends BaseRepository<TIdAdditionalInformationViewEntity, Long> {

	List<TIdAdditionalInformationViewEntity> findByPiadPinKeyAndActiveStatusOrderByPiadKeyDesc(Long pinKey,String status);
}
