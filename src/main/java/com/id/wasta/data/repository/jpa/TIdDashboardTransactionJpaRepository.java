package com.id.wasta.data.repository.jpa;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdDashboardTransactionEntity;

/**
 * Repository : TIdDashboardTransaction.
 */
public interface TIdDashboardTransactionJpaRepository extends BaseRepository<TIdDashboardTransactionEntity, Long> {

	
	@Query("select count(*) from TIdDashboardTransactionEntity as e where e.dtPinKey= :pinKey")
	public BigDecimal findByDtPinKey(@Param("pinKey")Long pinKey);
}
