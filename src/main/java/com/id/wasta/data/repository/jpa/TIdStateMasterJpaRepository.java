package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdStateMasterEntity;

/**
 * Repository : TIdStateMaster.
 */
public interface TIdStateMasterJpaRepository extends BaseRepository<TIdStateMasterEntity, Long> {
	
	List<TIdStateMasterEntity> findByName(String name);

	@Query("select e.name from TIdStateMasterEntity e where e.key=:stateKey")
	public String getStateName(@Param("stateKey") Long stateKey);

	public List<TIdStateMasterEntity> findByNameAndKeyNotIn(String otherStateName, Long piadStateKey);

	public TIdStateMasterEntity findByKey(Long piadStateKey);	
	
	
}
