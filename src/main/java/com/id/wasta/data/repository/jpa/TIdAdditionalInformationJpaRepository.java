package com.id.wasta.data.repository.jpa;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdAdditionalInformationEntity;

/**
 * Repository : TIdAdditionalInformation.
 */
public interface TIdAdditionalInformationJpaRepository extends BaseRepository<TIdAdditionalInformationEntity, Long> {

	List<TIdAdditionalInformationEntity> findByPiadPinKey(Long PiadPinKey);
	
	@Modifying
	@Transactional
    @Query("update TIdAdditionalInformationEntity aie set aie.piadCurrentlyWorking = :piadCurrentlyWorking where aie.piadPinKey = :piadPinKey")
	public int updateCurrentWorkingStatus(@Param("piadPinKey") Long piadPinKey, @Param("piadCurrentlyWorking") String piadCurrentlyWorking);
	
	@Query("select e.piadKey from TIdAdditionalInformationEntity as e where e.piadPinKey=?1 and e.activeStatus='A' ")
	List<Long> findPiadPinKey(Long pinKey);
	
	@Query("select e.piadOrganization from TIdAdditionalInformationEntity as e where e.piadKey=?1")
	String findPiadOrganization(Long key);

	@Query("select count(e) from TIdAdditionalInformationEntity as e where e.piadCreatedBy=?1 and e.createdOn <?2")
	long getAdditionalInfo(Long userPinKey, Date yesterDayDate);

}
