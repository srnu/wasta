package com.id.wasta.data.repository.jpa;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdProfessionalInterestsEntity;

/**
 * Repository : TIdProfessionalInterests.
 */
public interface TIdProfessionalInterestsJpaRepository extends BaseRepository<TIdProfessionalInterestsEntity, Long> {

	
	@Query("select e.key from TIdProfessionalInterestsEntity as e where e.priPinKey=?1 and e.activeStatus='A' ")
	List<Long> findPriPinKey(Long pinKey);


	@Query("select count(e) from TIdProfessionalInterestsEntity as e where e.priCreatedBy=?1 and e.createdOn <?2")
	Long getNoOfProfessionalIntrest(Long userPinKey, Date yesterDayDate);
}
