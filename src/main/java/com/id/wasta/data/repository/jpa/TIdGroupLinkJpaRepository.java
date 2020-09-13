package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdGroupLinkEntity;

public interface TIdGroupLinkJpaRepository extends BaseRepository<TIdGroupLinkEntity, Long>{
	
	List<TIdGroupLinkEntity> findByTIdGroupHeaderIn(Long id);
	
	int deleteByGlKey(Long childPrimaryKey);
	
	List<TIdGroupLinkEntity> findByTIdGroupHeaderGhKey(Long glGhKey);

	@Query("select e from TIdGroupLinkEntity e where e.tIdGroupHeader.ghKey in (?1)  group by e.glPinKey")
	List<TIdGroupLinkEntity> getListOfGlPinKey(List<Long> headerKey);

	@Query("select e from TIdGroupLinkEntity e where e.tIdGroupHeader.ghKey = ?1  group by e.glPinKey")
	public List<TIdGroupLinkEntity> getListOfGlPinKey(long parseLong);

	
}
