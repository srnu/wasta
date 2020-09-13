package com.id.wasta.data.repository.jpa;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdVisitInformationEntity;

/**
 * Repository : TIdVisitInformation.
 */
public interface TIdVisitInformationJpaRepository extends BaseRepository<TIdVisitInformationEntity, Long> {

	List<TIdVisitInformationEntity> findByPivPinKey(Long pinKey);
	
	@Query("select e.pivKey from TIdVisitInformationEntity as e where e.pivPinKey=?1 and e.activeStatus='A' ")
	List<Long> findPivPinKey(Long pinKey);
	
	
	@Query("select e.pivKey from TIdVisitInformationEntity as e where e.pivPinKey=?1 and e.activeStatus='A' and e.pivCreatedBy!=?2 ")
	List<Long> findPivPinKey(Long pinKey, Long createdbyPinKey);
	
	
	
	@Query("select count(e) from TIdVisitInformationEntity as e where e.pivCreatedBy= ?1 and e.createdOn <?2)")
	Long getTotalDiscussionsByUserOnDate(Long userPinKey, Date yesterDayDate);
	
}
