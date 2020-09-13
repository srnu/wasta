package com.id.wasta.data.repository.jpa;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdBusinessPotentialInfoEntity;

/**
 * Repository : TIdBusinessPotentialInfo.
 */
public interface TIdBusinessPotentialInfoJpaRepository extends BaseRepository<TIdBusinessPotentialInfoEntity, Long> {

	TIdBusinessPotentialInfoEntity findByBpiPinKey(Long pinKey);
	
	@Query("select e.key from TIdBusinessPotentialInfoEntity as e where e.bpiPinKey=?1 and e.activeStatus='A' ")
	List<Long> findBpiPinKey(Long pinKey);
	
	@Query("select e.key from TIdBusinessPotentialInfoEntity as e where e.bpiPinKey=?1 and e.activeStatus='A' and e.bpiCreatedBy!=?2 ")
	List<Long> findBpiPinKey(Long pinKey, Long createdbyPinKey);

	@Query("select count(e) from TIdBusinessPotentialInfoEntity as e where e.bpiCreatedBy=?1 and e.createdOn <?2)")
	Long getNoOfBusinessUpdatedByUserOnDate(Long userPinKey, Date yesterDayDate);
	
	
}
