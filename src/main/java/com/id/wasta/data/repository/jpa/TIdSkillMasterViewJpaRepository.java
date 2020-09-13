package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdSkillMasterViewEntity;
/**
 * Repository : TIdSkillMaster.
 */
public interface TIdSkillMasterViewJpaRepository extends BaseRepository<TIdSkillMasterViewEntity, Long> {
	
	@Query("select e from TIdSkillMasterViewEntity as e where e.skillCategory = :skillCategory and e.activeStatus= :activeStatus ORDER BY e.name ASC")	
	public List<TIdSkillMasterViewEntity> getSkillMaster(@Param("skillCategory") Long skillCategory,@Param("activeStatus") String activeStatus);
	

}
