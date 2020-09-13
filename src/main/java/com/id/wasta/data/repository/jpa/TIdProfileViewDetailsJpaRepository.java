package com.id.wasta.data.repository.jpa;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdProfileViewDetailsEntity;

/**
 * Repository : TIdProfileViewDetails.
 */
public interface TIdProfileViewDetailsJpaRepository extends BaseRepository<TIdProfileViewDetailsEntity, Long> {
	
	TIdProfileViewDetailsEntity findByPvdPinKeyAndPvdPinViewedbyKey(Long pinKey, Long pinViewedbyKey);

}
