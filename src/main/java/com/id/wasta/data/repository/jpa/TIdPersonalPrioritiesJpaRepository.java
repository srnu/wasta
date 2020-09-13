package com.id.wasta.data.repository.jpa;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdPersonalPrioritiesEntity;

/**
 * Repository : TIdPersonalPriorities.
 */
public interface TIdPersonalPrioritiesJpaRepository extends BaseRepository<TIdPersonalPrioritiesEntity, Long> {
	
	@Query("select p from TIdPersonalPrioritiesEntity as p where p.perpPinKey=:perpPinKey and p.perpInfo=:perpInfo and p.key!=:key")
	TIdPersonalPrioritiesEntity  getbyPinkeyAndPinfonprky(@Param("perpPinKey") Long perpPinKey,@Param("perpInfo") String perpInfo,@Param("key") Long key);

	List<TIdPersonalPrioritiesEntity> findByPerpPinKey(Long pinKey);
	
	
	@Query("select e.key from TIdPersonalPrioritiesEntity as e where e.perpPinKey=?1 and e.activeStatus='A' ")
	List<Long> findPerpPinKey(Long pinKey);
	
	@Query("select e.perpInfo from TIdPersonalPrioritiesEntity as e where e.key=?1")
	String findName(Long key);

	@Query("select count(e) from TIdPersonalPrioritiesEntity as e where e.perpCreatedBy=?1 and e.createdOn <?2")
	long getTotalPersonalPriorities(Long userPinKey, Date yesterDayDate);
	
}
