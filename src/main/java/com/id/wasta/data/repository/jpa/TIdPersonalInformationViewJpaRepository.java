package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdPersonalInformationViewEntity;

public interface TIdPersonalInformationViewJpaRepository extends BaseRepository<TIdPersonalInformationViewEntity,Long>{

	List<TIdPersonalInformationViewEntity> findByProfileKey(Long profileKey);
	
	@Query("select count(e) from TIdPersonalInformationViewEntity as e where e.pinEmail is not null or e.mobile is not null or e.landLine is not null")
	Long getTraceableCount();
	
	@Query("SELECT COUNT(e) FROM TIdPersonalInformationViewEntity as e WHERE (e.pinEmail IS NULL OR  e.pinEmail='') AND (e.landLine IS NULL OR e.landLine='') AND (e.mobile IS NULL OR e.mobile='')")
	Long getNonTraceableCount();

	List<TIdPersonalInformationViewEntity> findByPinKeyIn(List<Long> pinKey);
	
	@Query(value="SELECT * FROM t_id_personal_information_view WHERE pin_key NOT IN (?1) AND FIND_IN_SET(?2 ,mobile) AND active_status='A' ",nativeQuery=true)
	List<TIdPersonalInformationViewEntity> findByPinKeyNotInAndMobile(@Param("pinKey")Long pinKey, @Param("mobile")String mobile);
	
	@Query(value="SELECT * FROM t_id_personal_information_view WHERE pin_key NOT IN (?1) AND FIND_IN_SET(?2 ,landLine) AND active_status='A' ",nativeQuery=true)
	List<TIdPersonalInformationViewEntity> findByPinKeyNotInAndLandLine(@Param("pinKey")Long pinKey, @Param("landLine")String landLine);
	
	@Query(value="SELECT pin_key FROM t_id_personal_information_view WHERE pin_key not in (?2) and FIND_IN_SET(?1,mobile) AND active_status='A' ",nativeQuery=true)
	List<Long> findByMobile(String mobile, Long pinKey);
	
	@Query(value="SELECT pin_key FROM t_id_personal_information_view WHERE pin_key not in (?2) and FIND_IN_SET(?1,landline) AND active_status='A' ",nativeQuery=true)
	List<Long> findByLandLine(String landLine, Long pinKey);
	
}
