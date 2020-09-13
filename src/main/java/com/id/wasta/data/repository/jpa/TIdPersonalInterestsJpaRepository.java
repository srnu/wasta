package com.id.wasta.data.repository.jpa;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdPersonalInterestsEntity;

/**
 * Repository : TIdPersonalInterests.
 */
public interface TIdPersonalInterestsJpaRepository extends BaseRepository<TIdPersonalInterestsEntity, Long> {
	
	@Query("select e.key from TIdPersonalInterestsEntity as e where e.periPinKey=?1 and e.activeStatus='A' ")
	List<Long> findPeriPinKey(Long pinKey);
	
	@Query("select count(e) from TIdPersonalInterestsEntity as e where e.periCreatedBy=?1 and e.createdOn <?2")
	Long getTotalpersonalIntrest(Long userPinKey, Date createdDate);
	
}
