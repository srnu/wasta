package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdBusinessPotentialInfoViewEntity;

/**
 * Repository : TIdBusinessPotentialInfo.
 */
public interface TIdBusinessPotentialInfoViewJpaRepository extends BaseRepository<TIdBusinessPotentialInfoViewEntity, Long> {
	
	@Query("select e from TIdBusinessPotentialInfoViewEntity as e where e.bpiPinKey = :bpiPinKey and e.activeStatus='A'")	
	public List<TIdBusinessPotentialInfoViewEntity> getBusinessPotential(@Param("bpiPinKey") Long bpiPinKey);

	@Query("select e.name from TIdBusinessPotentialInfoViewEntity as e where e.key=?1")
	String findName(Long key);
	
}
