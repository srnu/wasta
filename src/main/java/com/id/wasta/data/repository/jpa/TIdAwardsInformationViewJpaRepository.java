package com.id.wasta.data.repository.jpa;

import java.util.List;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdAwardsInformationViewEntity;

public interface TIdAwardsInformationViewJpaRepository extends BaseRepository<TIdAwardsInformationViewEntity,Long> {
	
	List<TIdAwardsInformationViewEntity> findByPiaPinKeyAndActiveStatusOrderByPiaKeyDesc(Long piaPinKey,String status);

}
