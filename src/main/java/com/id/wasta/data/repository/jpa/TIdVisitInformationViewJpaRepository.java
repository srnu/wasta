package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdVisitInformationViewEntity;

/**
 * Repository : TIdVisitInformation.
 */
public interface TIdVisitInformationViewJpaRepository extends BaseRepository<TIdVisitInformationViewEntity, Long> {

	List<TIdVisitInformationViewEntity> findByPivPinKeyAndActiveStatus(Long pinKey,String status);
	
	List<TIdVisitInformationViewEntity> findByPivVisitedPinKeyAndActiveStatus(Long pinKey,String status);

	@Query("select e.pivVisitedPurpose from TIdVisitInformationViewEntity as e where e.pivKey=?1")
	String findPivVisitedPurpose(Long pivKey);
	
}
