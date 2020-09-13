package com.id.wasta.data.repository.jpa;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdAwardsInformationEntity;
import com.id.wasta.bean.jpa.TIdAwardsInformationEntitySearch;

/**
 * Repository : TIdAwardsInformation.
 */
public interface TIdAwardsInformationJpaRepository extends BaseRepository<TIdAwardsInformationEntity, Long> {

	List<TIdAwardsInformationEntity> findByPiaPinKeyAndActiveStatusOrderByPiaKeyDesc(Long piaPinKey,String status);
	
	@Query("select e.piaKey from TIdAwardsInformationEntity as e where e.piaPinKey=?1 and e.activeStatus='A' ")
	List<Long> findPiaPinKey(Long pinKey);
	
	@Query("select e.piaAwardName from TIdAwardsInformationEntity as e where e.piaKey=?1")
	String findAwardName(Long key);

	public List<TIdAwardsInformationEntitySearch> findByPiaAwardNameAndPiaKeyNotIn(String otherPositionName, Long piaPosition);

	public TIdAwardsInformationEntitySearch findByPiaKey(Long piaPosition);

	@Query("select count(e) from TIdAwardsInformationEntity as e where e.piaCreatedBy=?1 and e.createdOn <?2")
	long getTotalAwards(Long userPinKey, Date yesterDayDate);

	
}
