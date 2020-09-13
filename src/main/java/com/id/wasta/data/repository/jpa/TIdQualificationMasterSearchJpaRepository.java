package com.id.wasta.data.repository.jpa;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdQualificationMasterEntitySearch;

/**
 * Repository : TIdQualificationMaster.
 */
public interface TIdQualificationMasterSearchJpaRepository extends BaseRepository<TIdQualificationMasterEntitySearch, Long> {
	
	TIdQualificationMasterEntitySearch findByName(String name);

	public TIdQualificationMasterEntitySearch findByNameAndQualificationKeyNotIn(String otherQualificationName, Long peiKey);

}
