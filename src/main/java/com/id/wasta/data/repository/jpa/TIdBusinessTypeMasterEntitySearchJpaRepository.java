package com.id.wasta.data.repository.jpa;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdBusinessTypeMasterEntitySearch;

public interface TIdBusinessTypeMasterEntitySearchJpaRepository extends  BaseRepository<TIdBusinessTypeMasterEntitySearch, Long> {

	public TIdBusinessTypeMasterEntitySearch findByName(String otherIndustryName);

	public TIdBusinessTypeMasterEntitySearch findByNameAndBtmKeyNotIn(String otherIndustryName, Long pexKey);

	public TIdBusinessTypeMasterEntitySearch findByBtmKey(Long pexKey);

}

