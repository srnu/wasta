package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdRecreationInfoViewEntity;

/**
 * Repository : TIdRecreationInfo.
 */
public interface TIdRecreationInfoViewJpaRepository extends BaseRepository<TIdRecreationInfoViewEntity, Long> {

	@Query("select e from TIdRecreationInfoViewEntity as e where e.reiPinKey = :reiPinKey and e.activeStatus='A'")	
	public List<TIdRecreationInfoViewEntity> getRecreationInfo(@Param("reiPinKey") Long reiPinKey);
	
	@Query("select e.name from TIdRecreationInfoViewEntity as e where e.key=?1")
	String findName(Long key);
	
}
