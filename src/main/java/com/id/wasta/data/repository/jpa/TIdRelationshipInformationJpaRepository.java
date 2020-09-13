package com.id.wasta.data.repository.jpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdRelationshipInformationEntity;

/**
 * Repository : TIdRelationshipInformation.
 */
public interface 	TIdRelationshipInformationJpaRepository extends BaseRepository<TIdRelationshipInformationEntity, Long> {

	List<TIdRelationshipInformationEntity> findByPrlPinKey(Long pinKey);
	
	@Modifying
	@Transactional
    @Query("update TIdRelationshipInformationEntity e set e.prlPinKey = ?1 where e.prlPinKey = ?2 ")
	int updatePrlPinKey(Long prlPinKey, Long prlPinKey2);
	
	@Modifying
	@Transactional
    @Query("delete from TIdRelationshipInformationEntity as e where e.prlKey in (?1) ")
	void deleteUserKey(List<Long> prlKey);
	
	@Query("select e.prlKey from TIdRelationshipInformationEntity as e where e.prlPinKey =?1 and e.activeStatus = 'A'")
	List<Long> getPrlKeyByPrlPinKey(Long pinKey);
	
	
	
	
	
	

}
