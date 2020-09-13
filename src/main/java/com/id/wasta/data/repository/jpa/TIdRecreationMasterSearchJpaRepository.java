package com.id.wasta.data.repository.jpa;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdRecreationMasterEntitySearch;

/**
 * Repository : TIdRecreationMaster.
 */
public interface TIdRecreationMasterSearchJpaRepository extends BaseRepository<TIdRecreationMasterEntitySearch, Long> {
	
	TIdRecreationMasterEntitySearch findByName(String name);

	public TIdRecreationMasterEntitySearch findByNameAndKeyNotIn(String othersRmName, Long key);

}
