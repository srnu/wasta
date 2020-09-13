package com.id.wasta.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.id.wasta.bean.jpa.TIdInfoBaseMasterEntity;

/**
 * Repository : TIdInfoBaseMaster.
 */
public interface TIdInfoBaseMasterJpaRepository extends PagingAndSortingRepository<TIdInfoBaseMasterEntity, Long> {

	public TIdInfoBaseMasterEntity findByIbmTypeAndIbmBaseCode(String ibmType, String ibmBaseCode);
	
}
