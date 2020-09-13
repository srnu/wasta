package com.id.wasta.data.repository.jpa;

import java.util.List;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdProjectsInformationViewEntity;

public interface TIdProjectsInformationViewJpaRepository extends BaseRepository<TIdProjectsInformationViewEntity, Long> {

	List<TIdProjectsInformationViewEntity> findByPipPinKeyAndActiveStatusOrderByPipKeyDesc(Long pinKey,String status);
}
