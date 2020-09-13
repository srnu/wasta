package com.id.wasta.data.repository.jpa;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdProfessionalExpertiseEntity;

/**
 * Repository : TIdProfessionalExpertise.
 */
public interface TIdProfessionalExpertiseJpaRepository extends BaseRepository<TIdProfessionalExpertiseEntity, Long> {
	
	
	@Query("select e.key from TIdProfessionalExpertiseEntity as e where e.ppePinKey=?1 and e.activeStatus='A' ")
	List<Long> findPpePinKey(Long pinKey);

	@Query("select count(e) from TIdProfessionalExpertiseEntity as e where e.ppeCreatedBy=?1 and e.createdOn <?2")
	long getTotalProfessionalExpertise(Long userPinKey, Date yesterDayDate);
	
}
