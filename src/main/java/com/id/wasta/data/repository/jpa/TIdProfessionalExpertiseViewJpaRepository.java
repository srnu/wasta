package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdProfessionalExpertiseViewEntity;

/**
 * Repository : TIdProfessionalExpertise.
 */
public interface TIdProfessionalExpertiseViewJpaRepository extends BaseRepository<TIdProfessionalExpertiseViewEntity, Long> {
	
	@Query("select e from TIdProfessionalExpertiseViewEntity as e where e.ppePinKey = :ppePinKey and e.activeStatus='A'")	
	public List<TIdProfessionalExpertiseViewEntity> getProfessionalExpertise(@Param("ppePinKey") Long ppePinKey);

	@Query("select e.name from TIdProfessionalExpertiseViewEntity as e where e.key=?1")
	String findName(Long key);
	
}
