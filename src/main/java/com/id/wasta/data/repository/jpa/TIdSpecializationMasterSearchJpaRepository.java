package com.id.wasta.data.repository.jpa;



import java.util.List;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdSpecializationMasterEntitySearch;

/**
 * Repository : TIdSpecializationMaster.
 */
public interface TIdSpecializationMasterSearchJpaRepository extends BaseRepository<TIdSpecializationMasterEntitySearch, Long> {

	TIdSpecializationMasterEntitySearch findByName(String otherSpecializationName);

	//public TIdSpecializationMasterEntitySearch findByNameAndSpecialKeyNotIn(String otherSpecializationName, Long peiKey);

	public TIdSpecializationMasterEntitySearch findBySpecialKey(Long peiKey);

	public List<TIdSpecializationMasterEntitySearch> findByNameAndSpecialKeyNotIn(String otherSpecializationName,Long otherSpecializationkey);

	
}

