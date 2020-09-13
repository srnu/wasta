package com.id.wasta.data.repository.jpa;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdSkillMasterEntitySearch;

/**
 * Repository : TIdSkillMaster.
 */
public interface TIdSkillMasterSearchJpaRepository extends BaseRepository<TIdSkillMasterEntitySearch, Long> {

	public TIdSkillMasterEntitySearch findByNameAndSkillCategory(String name, Long skillCategory);

	public TIdSkillMasterEntitySearch findByNameAndKeyNotIn(String otherSkillName, Long key);

	public TIdSkillMasterEntitySearch findByNameAndSkillCategoryAndKeyNotIn(String otherSkillName, long l,
			Long apsSkillKey);
}
