package com.id.wasta.data.repository.jpa;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdDesignationMasterEntitySearch;

public interface TIdDesignationMasterEntitySearchJpaRepository extends BaseRepository<TIdDesignationMasterEntitySearch, Long> {
	
	public TIdDesignationMasterEntitySearch findByName(String name);

	public TIdDesignationMasterEntitySearch findByNameAndKeyNotIn(String otherPositionName, Long piaPosition);

}
