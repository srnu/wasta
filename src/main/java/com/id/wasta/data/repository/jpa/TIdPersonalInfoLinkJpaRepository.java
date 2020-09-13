package com.id.wasta.data.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.id.wasta.bean.jpa.TIdPersonalInfoLinkEntity;

/**
 * Repository : TIdPersonalInfoLink.
 */
public interface TIdPersonalInfoLinkJpaRepository extends JpaRepository<TIdPersonalInfoLinkEntity, Long> {

	TIdPersonalInfoLinkEntity findByPilPinKey(Long pinKey);
	
	TIdPersonalInfoLinkEntity findByPilPexKey(Long pexKey);
	
	@Query(value = "SELECT work_exp3(?1)", nativeQuery = true)
	Long work_exp3(Long pinKey);
}
