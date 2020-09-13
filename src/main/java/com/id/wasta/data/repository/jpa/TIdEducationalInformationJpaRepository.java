package com.id.wasta.data.repository.jpa;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdEducationalInformationEntity;

/**
 * Repository : TIdEducationalInformation.
 * @param <EducationanInformationEntity>
 */
public interface TIdEducationalInformationJpaRepository extends BaseRepository<TIdEducationalInformationEntity, Long> {

	List<TIdEducationalInformationEntity> findByPeiPinKey(Long pinKey);
	
	
	@Query("select e.peiKey from TIdEducationalInformationEntity as e where e.peiPinKey=?1 and e.activeStatus='A' ")
	List<Long> findPeiPinKey(Long pinKey);

	@Query("select count(e) from TIdEducationalInformationEntity as e where e.peiCreatedBy=?1 and e.createdOn <?2")
	long getTotalEducational(Long userPinKey, Date yesterDayDate);
	
}
