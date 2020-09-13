package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdProfessionalInterestsViewEntity;

/**
 * Repository : TIdProfessionalInterests.
 */
public interface TIdProfessionalInterestsViewJpaRepository extends BaseRepository<TIdProfessionalInterestsViewEntity, Long> {

	@Query("select e from TIdProfessionalInterestsViewEntity as e where e.priPinKey = :priPinKey and e.activeStatus='A'")	
	public List<TIdProfessionalInterestsViewEntity> getProfessionalInterests(@Param("priPinKey") Long priPinKey);
	
	@Query("select e.name from TIdProfessionalInterestsViewEntity as e where e.key=?1")
	String findName(Long key);
	
}
