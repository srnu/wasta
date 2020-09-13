package com.id.wasta.data.repository.jpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdLanguageInformationEntity;

/**
 * Repository : TIdLanguageInformation.
 */
public interface TIdLanguageInformationJpaRepository extends BaseRepository<TIdLanguageInformationEntity, Long> {
	
	List<TIdLanguageInformationEntity> findByPliPinKey(Long pinKey);

	@Query("select e.pliKey from TIdLanguageInformationEntity as e where e.pliPinKey = ?1")
	List<Long> getListOfPrimaryKeysByPinKey(Long pinKey);

	@Modifying
	@Transactional
	@Query("delete from TIdLanguageInformationEntity as e where e.pliPinKey =?1")
	void deleteByUserKey(Long pinKey);

	@Modifying
	@Transactional
	@Query("delete from TIdLanguageInformationEntity as e where e.pliKey not in(?1) and e.pliPinKey =?2")
	void deleteByPrimaryKeys(List<Long> primaryKeys, Long pinKey);

}
