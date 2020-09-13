package com.id.wasta.data.repository.jpa;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.id.wasta.bean.jpa.TIdTableAuditLogEntity;

/**
 * Repository : TIdTableAuditLog.
 */

public interface TIdTableAuditLogJpaRepository extends CrudRepository<TIdTableAuditLogEntity, Long> {

	@Query(value=("	SELECT * FROM t_id_table_audit_log WHERE taudit_key_value_2 =:primaryKeyValue order by taudit_key desc "),nativeQuery=true)
	public List<TIdTableAuditLogEntity> getAuditLogInfo(@Param("primaryKeyValue") Long primaryKeyValue );
	
	@Query(value=("	SELECT * FROM t_id_table_audit_log WHERE taudit_key_value_2 =:primaryKeyValue GROUP BY SUBSTR(taudit_time_stamp,1,11),`taudit_key_value_5` order by taudit_key desc "),nativeQuery=true)
	public List<TIdTableAuditLogEntity> getDistinctAuditLogInfo(@Param("primaryKeyValue") Long primaryKeyValue );

}
