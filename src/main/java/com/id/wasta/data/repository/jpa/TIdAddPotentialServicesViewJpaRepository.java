package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdAddPotentialServicesViewEntity;

/**
 * Repository : TIdAddPotentialServices.
 */
public interface TIdAddPotentialServicesViewJpaRepository extends BaseRepository<TIdAddPotentialServicesViewEntity, Long> {
	
	@Query("select e from TIdAddPotentialServicesViewEntity as e where e.apsPinKey = :apsPinKey and e.activeStatus='A'")	
	public List<TIdAddPotentialServicesViewEntity> getPotentialServices(@Param("apsPinKey") Long apsPinKey);

	@Query("select e.name from TIdAddPotentialServicesViewEntity as e where e.key=?1")
	String findName(Long key);
	
}
