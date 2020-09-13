package com.id.wasta.data.repository.jpa;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdAddPotentialServicesEntity;

/**
 * Repository : TIdAddPotentialServices.
 */
public interface TIdAddPotentialServicesJpaRepository extends BaseRepository<TIdAddPotentialServicesEntity, Long> {

	TIdAddPotentialServicesEntity findByApsPinKey(Long pinKey);
		
	@Query("select e.key from TIdAddPotentialServicesEntity as e where e.apsPinKey=?1 and e.activeStatus='A' ")
	List<Long> findApsPinKey(Long pinKey);
	
	@Query("select e.key from TIdAddPotentialServicesEntity as e where e.apsPinKey=?1 and e.activeStatus='A' and e.apsCreatedBy!=?2 ")
	List<Long> findApsPinKey(Long pinKey, Long createdbyPinKey);

	

	@Query("select count(e) from TIdAddPotentialServicesEntity as e where e.apsCreatedBy =?1 and e.createdOn <?2 ")
	Long getNoOfAddPotentialUdatedByUserOnDate(Long userPinKey, Date yesterDayDate);
}
