package com.id.wasta.data.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.wasta.bean.jpa.TIdLoginHistoryEntity;


public interface TIdLoginHistoryJpaRepository extends JpaRepository<TIdLoginHistoryEntity, Long> {
	
	@Query(value ="Select * from t_id_login_history WHERE lh_user_code =:usercode and lh_logout_time is null order by lh_key desc limit 1", nativeQuery=true)
	TIdLoginHistoryEntity findLoginInfo(@Param("usercode") String usercode);
	
	@Query(value ="Select * from t_id_login_history WHERE lh_user_code =:usercode and lh_logout_time is not null order by lh_key desc limit 1", nativeQuery=true)
	TIdLoginHistoryEntity findLogoutInfo(@Param("usercode") String usercode);
	
}
