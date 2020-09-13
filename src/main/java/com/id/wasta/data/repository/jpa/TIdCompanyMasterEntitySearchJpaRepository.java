package com.id.wasta.data.repository.jpa;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdCompanyMasterEntitySearch;

public interface TIdCompanyMasterEntitySearchJpaRepository extends  BaseRepository<TIdCompanyMasterEntitySearch, Long> {
	
	public TIdCompanyMasterEntitySearch	 findByName(String name);

	public TIdCompanyMasterEntitySearch findByNameAndCompanyKeyNotIn(String otherCompanyName, Long pipKey);

	public TIdCompanyMasterEntitySearch findByCompanyKey(Long pexKey);

}
