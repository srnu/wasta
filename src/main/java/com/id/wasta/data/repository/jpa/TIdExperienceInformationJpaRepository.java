package com.id.wasta.data.repository.jpa;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdExperienceInformationEntity;

/**
 * Repository : TIdExperienceInformation.
 */
public interface TIdExperienceInformationJpaRepository extends BaseRepository<TIdExperienceInformationEntity, Long> {
	
	List<TIdExperienceInformationEntity> findByPexPinKey(Long pexPinKey);
	
	@Modifying
	@Transactional
    @Query("update TIdExperienceInformationEntity efe set efe.pexCurrentlyWorking = :pexCurrentlyWorking where efe.pexPinKey = :pexPinKey")
	public int updateCurrentWorkingStatus(@Param("pexPinKey") Long pexPinKey, @Param("pexCurrentlyWorking") String pexCurrentlyWorking);

	@Query("select e.pexKey from TIdExperienceInformationEntity as e where e.pexPinKey=?1 and e.activeStatus='A' ")
	List<Long> findPexPinKey(Long pinKey);
	
	@Query("select e.pexKey from TIdExperienceInformationEntity as e where e.pexPinKey=?1 and e.pexCurrentlyWorking=?2 order by e.pexKey desc")
	List<Long> findCurrentExperience(Long pinKey, String pexCurrentlyWorking);

	@Query("select e.pexKey from TIdExperienceInformationEntity as e where e.pexPinKey=?1 and e.activeStatus = 'A'")
	List<Long> getPrimaryKeysByUserKey(Long pinKey);

	@Query("select e from TIdExperienceInformationEntity as e where e.pexPinKey=?1 and e.pexCurrentlyWorking='Y'")
	TIdExperienceInformationEntity getPresentExperience(Long pinKey);

	@Query("select count(e) from TIdExperienceInformationEntity as e where e.pexCreatedBy=?1 and e.createdOn <?2")
	long getToatlExperience(Long userPinKey, Date yesterDayDate);

	
	
}
