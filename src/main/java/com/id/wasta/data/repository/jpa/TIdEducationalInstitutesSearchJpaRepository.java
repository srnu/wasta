package com.id.wasta.data.repository.jpa;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdEducationalInstitutesEntitySearch;

/**
 * Repository : TIdEducationalInstitutes.
 */
public interface TIdEducationalInstitutesSearchJpaRepository extends BaseRepository<TIdEducationalInstitutesEntitySearch, Long> {
	
	public TIdEducationalInstitutesEntitySearch findByName(String name);

	public TIdEducationalInstitutesEntitySearch findByNameAndKeyNotIn(String otherProvidedByName, Long piaPosition);

	public TIdEducationalInstitutesEntitySearch findByKey(Long peiKey);

}
