package com.id.wasta.data.repository.jpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdVisitRemarksEntity;

public interface TIdVisitRemarksJpaRepository extends BaseRepository<TIdVisitRemarksEntity, Long>{
	
	List<TIdVisitRemarksEntity> findByPivrPivKey(Long key);
	
	@Modifying 
	@Transactional
	@Query("delete from TIdVisitRemarksEntity v where v.pivrPivKey = ?1")
	void deleteVisitInfoDtls(Long pivrPivKey); 

}
