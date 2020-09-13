package com.id.wasta.data.repository.jpa;

import java.util.List;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdCityMasterEntitySearch;

/**
 * Repository : TIdCityMaster.
 */
public interface TIdCityMasterEntitySearchJpaRepository extends BaseRepository<TIdCityMasterEntitySearch, Long> {

	List<TIdCityMasterEntitySearch> findByName(String otherCityName);

	List<TIdCityMasterEntitySearch> findByNameAndKeyNotIn(String otherCityName, Long pexKey);
	
}

