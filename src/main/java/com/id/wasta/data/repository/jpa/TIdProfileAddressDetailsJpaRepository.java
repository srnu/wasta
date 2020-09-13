package com.id.wasta.data.repository.jpa;

import java.util.List;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdProfileAddressDetailsEntity;

public interface TIdProfileAddressDetailsJpaRepository extends BaseRepository<TIdProfileAddressDetailsEntity,Long> {

	List<TIdProfileAddressDetailsEntity> findByPadPinKey(Long pinKey);
}