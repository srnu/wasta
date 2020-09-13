package com.id.wasta.data.repository.jpa;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdLanguageMasterEntitySearch;

/**
 * Repository : TIdLanguageMaster.
 */
public interface TIdLanguageMasterSearchJpaRepository extends BaseRepository<TIdLanguageMasterEntitySearch, Long> {

	TIdLanguageMasterEntitySearch findByName(String name);
	
}
