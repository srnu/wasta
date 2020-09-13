package com.id.wasta.data.repository.jpa;

import java.util.List;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdStateMasterEntitySearch;

/**
 * Repository : TIdStateMaster.
 */
public interface TIdStateMasterSearchJpaRepository extends BaseRepository<TIdStateMasterEntitySearch, Long> {

	List<TIdStateMasterEntitySearch> findByName(String name);

	public List<TIdStateMasterEntitySearch> findByNameAndKeyNotIn(String otherStateName, Long pexStateKey);
	
}
