package com.id.wasta.data.repository.jpa;

import java.util.List;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdProfileViewDetailsViewEntity;

public interface TIdProfileViewDetailsViewJpaRepository extends BaseRepository<TIdProfileViewDetailsViewEntity, Long> {

	List<TIdProfileViewDetailsViewEntity> findByPvdPinKey(Long pinKey);
	
}
