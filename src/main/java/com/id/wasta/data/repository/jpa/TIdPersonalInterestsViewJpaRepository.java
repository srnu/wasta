package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdPersonalInterestsViewEntity;

/**
 * Repository : TIdPersonalInterests.
 */
public interface TIdPersonalInterestsViewJpaRepository extends BaseRepository<TIdPersonalInterestsViewEntity, Long> {

	@Query("select e from TIdPersonalInterestsViewEntity as e where e.periPinKey = :periPinKey and e.activeStatus='A' ")
	public List<TIdPersonalInterestsViewEntity> getPersonalInterests(@Param("periPinKey") Long periPinKey);

	@Query("select e.name from TIdPersonalInterestsViewEntity as e where e.key=?1")
	String findName(Long key);
	
}
