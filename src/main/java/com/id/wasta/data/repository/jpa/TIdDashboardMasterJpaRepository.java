package com.id.wasta.data.repository.jpa;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.Query;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdDashboardMasterEntity;

/**
 * Repository : TIdDashboardMaster.
 */
public interface TIdDashboardMasterJpaRepository extends BaseRepository<TIdDashboardMasterEntity, Long> {
	
	@Query("select count(*) from TIdDashboardMasterEntity as e")
	public BigDecimal getMasterEntities();
	
	
}
