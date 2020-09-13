package com.id.wasta.data.repository.jpa;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdFunctionalAreaMasterEntitySearch;

public interface TIdFunctionalAreaMasterEntitySearchJpaRepository extends BaseRepository<TIdFunctionalAreaMasterEntitySearch, Long> {

	TIdFunctionalAreaMasterEntitySearch findByName(String name);

	public TIdFunctionalAreaMasterEntitySearch findByNameAndFunctionKeyNotIn(String otherFunctionalAreaName, Long pexKey);

	public TIdFunctionalAreaMasterEntitySearch findByFunctionKey(Long pexKey);
}
