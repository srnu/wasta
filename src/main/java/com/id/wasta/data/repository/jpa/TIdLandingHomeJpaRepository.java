package com.id.wasta.data.repository.jpa;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.id.wasta.bean.LandingInfoBean;
import com.id.wasta.bean.jpa.TIdLandingHomeEntity;

/**
 * Repository : TIdLandingHome.
 */
public interface TIdLandingHomeJpaRepository extends PagingAndSortingRepository<TIdLandingHomeEntity, Long> {
	
	@Query(value ="Select count(*) from t_id_landing_home WHERE ld_type_change!='Deleted' and FIND_IN_SET (:loggedPinKey, ld_access_info) and ld_key not in (select ll_ld_key from t_id_landing_home_link WHERE ll_pin_key=:loggedPinKey)", nativeQuery=true)
	Long getHomesCount(@Param("loggedPinKey") Long loggedPinKey);
	
	@Query("Select new com.id.wasta.bean.LandingInfoBean(e.ldKey,e.ldUserName,e.ldUserPinKey,e.ldContactName,e.ldContactPinKey,e.ldCompany,e.ldIndustry,e.ldCountry,e.ldBoxName,e.ldFieldName,e.ldLatestUpdate,e.ldUpdateKey,e.ldReadFlag,e.lockKey,e.profileKey,e.createdOn, 1 ) from TIdLandingHomeEntity e "
			+ "where e.ldTypeChange!='Deleted' and e.ldAccessInfo like CONCAT(',%',:loggedPinKey,',%') and e.ldKey in (select ee.llLdKey from TIdLandingHomeLinkEntity ee where ee.llPinKey=:loggedPinKey)")
	List<LandingInfoBean> getHomes(@Param("loggedPinKey") Long loggedPinKey);
	
	@Query("Select new com.id.wasta.bean.LandingInfoBean(e.ldKey,e.ldUserName,e.ldUserPinKey,e.ldContactName,e.ldContactPinKey,e.ldCompany,e.ldIndustry,e.ldCountry,e.ldBoxName,e.ldFieldName,e.ldLatestUpdate,e.ldUpdateKey,e.ldReadFlag,e.lockKey,e.profileKey,e.createdOn, 0 ) from TIdLandingHomeEntity e "
			+ "where e.ldTypeChange!='Deleted' and e.ldAccessInfo like CONCAT(',%',:loggedPinKey,',%') and e.ldKey not in (select ee.llLdKey from TIdLandingHomeLinkEntity ee where ee.llPinKey=:loggedPinKey)")
	List<LandingInfoBean> getHomesNotIn(@Param("loggedPinKey") Long loggedPinKey);
	
	List<TIdLandingHomeEntity> findByLdContactPinKey(Long pinKey);
	
	
	@Query(value ="Select count(*) from t_id_landing_home WHERE created_on >=:logoutDate and ld_contact_pin_key in (:toPinKey) and FIND_IN_SET (:loggedPinKey, ld_access_info) and ld_key not in (select ll_ld_key from t_id_landing_home_link WHERE ll_pin_key=:loggedPinKey)", nativeQuery=true)
	Long getHomesCount(@Param("logoutDate") Date logoutDate, @Param("toPinKey") List<Long> toPinKey, @Param("loggedPinKey") Long loggedPinKey);
	
	@Query("Select new com.id.wasta.bean.LandingInfoBean(e.ldKey,e.ldUserName,e.ldUserPinKey,e.ldContactName,e.ldContactPinKey,e.ldCompany,e.ldIndustry,e.ldCountry,e.ldBoxName,e.ldFieldName,e.ldLatestUpdate,e.ldUpdateKey,e.ldReadFlag,e.lockKey,e.profileKey,e.createdOn, 1 ) from TIdLandingHomeEntity e "
			+ "where e.createdOn >= :logoutDate and e.ldContactPinKey in (:toPinKey) and e.ldAccessInfo like CONCAT('%,',:loggedPinKey,',%') and e.ldKey in (select ee.llLdKey from TIdLandingHomeLinkEntity ee where ee.llPinKey=:loggedPinKey)")
	List<LandingInfoBean> getHomes(@Param("logoutDate") Date logoutDate, @Param("toPinKey") List<Long> toPinKey, @Param("loggedPinKey") Long loggedPinKey);
	
	@Query("Select new com.id.wasta.bean.LandingInfoBean(e.ldKey,e.ldUserName,e.ldUserPinKey,e.ldContactName,e.ldContactPinKey,e.ldCompany,e.ldIndustry,e.ldCountry,e.ldBoxName,e.ldFieldName,e.ldLatestUpdate,e.ldUpdateKey,e.ldReadFlag,e.lockKey,e.profileKey,e.createdOn, 0 ) from TIdLandingHomeEntity e "
			+ "where e.createdOn >= :logoutDate and e.ldContactPinKey in (:toPinKey) and e.ldAccessInfo like CONCAT('%,',:loggedPinKey,',%') and e.ldKey not in (select ee.llLdKey from TIdLandingHomeLinkEntity ee where ee.llPinKey=:loggedPinKey)")
	List<LandingInfoBean> getHomesNotIn(@Param("logoutDate") Date logoutDate, @Param("toPinKey") List<Long> toPinKey, @Param("loggedPinKey") Long loggedPinKey);
	
	
}
