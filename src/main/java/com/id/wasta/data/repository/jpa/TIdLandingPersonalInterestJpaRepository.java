package com.id.wasta.data.repository.jpa;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.id.wasta.bean.LandingInfoBean;
import com.id.wasta.bean.jpa.TIdLandingPersonalInterestEntity;

/**
 * Repository : TIdLandingPersonalInterest.
 */
public interface TIdLandingPersonalInterestJpaRepository extends PagingAndSortingRepository<TIdLandingPersonalInterestEntity, Long> {
	
	@Query(value ="Select count(*) from t_id_landing_personal_interest WHERE ld_type_change!='Deleted' and FIND_IN_SET (:loggedPinKey, ld_access_info) and ld_key not in (select ll_ld_key from t_id_landing_personal_interest_link WHERE ll_pin_key=:loggedPinKey)", nativeQuery=true)
	Long getPersonInterestDetailsCount(@Param("loggedPinKey") Long loggedPinKey);
	
	@Query("Select new com.id.wasta.bean.LandingInfoBean(e.ldKey,e.ldUserName,e.ldUserPinKey,e.ldContactName,e.ldContactPinKey,e.ldCompany,e.ldIndustry,e.ldCountry,e.ldBoxName,e.ldFieldName,e.ldLatestUpdate,e.ldUpdateKey,e.ldReadFlag,e.lockKey,e.profileKey,e.createdOn, 1 ) from TIdLandingPersonalInterestEntity e "
			+ "where e.ldTypeChange!='Deleted' and e.ldAccessInfo like CONCAT(',%',:loggedPinKey,',%') and e.ldKey in (select ee.llLdKey from TIdLandingPersonalInterestLinkEntity ee where ee.llPinKey=:loggedPinKey)")
	List<LandingInfoBean> getPersonInterestDetails(@Param("loggedPinKey") Long loggedPinKey);
	
	@Query("Select new com.id.wasta.bean.LandingInfoBean(e.ldKey,e.ldUserName,e.ldUserPinKey,e.ldContactName,e.ldContactPinKey,e.ldCompany,e.ldIndustry,e.ldCountry,e.ldBoxName,e.ldFieldName,e.ldLatestUpdate,e.ldUpdateKey,e.ldReadFlag,e.lockKey,e.profileKey,e.createdOn, 0 ) from TIdLandingPersonalInterestEntity e "
			+ "where e.ldTypeChange!='Deleted' and e.ldAccessInfo like CONCAT(',%',:loggedPinKey,',%') and e.ldKey not in (select ee.llLdKey from TIdLandingPersonalInterestLinkEntity ee where ee.llPinKey=:loggedPinKey)")
	List<LandingInfoBean> getPersonInterestDetailsNotIn(@Param("loggedPinKey") Long loggedPinKey);
	
	List<TIdLandingPersonalInterestEntity> findByLdContactPinKey(Long pinKey);
	
	
	@Query(value ="Select count(*) from t_id_landing_personal_interest WHERE created_on >=:logoutDate and ld_contact_pin_key in (:toPinKey) and FIND_IN_SET (:loggedPinKey, ld_access_info) and ld_key not in (select ll_ld_key from t_id_landing_personal_interest_link WHERE ll_pin_key=:loggedPinKey)", nativeQuery=true)
	Long getPersonInterestDetailsCount(@Param("logoutDate") Date logoutDate, @Param("toPinKey") List<Long> toPinKey, @Param("loggedPinKey") Long loggedPinKey);
	
	@Query("Select new com.id.wasta.bean.LandingInfoBean(e.ldKey,e.ldUserName,e.ldUserPinKey,e.ldContactName,e.ldContactPinKey,e.ldCompany,e.ldIndustry,e.ldCountry,e.ldBoxName,e.ldFieldName,e.ldLatestUpdate,e.ldUpdateKey,e.ldReadFlag,e.lockKey,e.profileKey,e.createdOn, 1 ) from TIdLandingPersonalInterestEntity e "
			+ "where e.createdOn >= :logoutDate and e.ldContactPinKey in (:toPinKey) and e.ldAccessInfo like CONCAT('%,',:loggedPinKey,',%') and e.ldKey in (select ee.llLdKey from TIdLandingPersonalInterestLinkEntity ee where ee.llPinKey=:loggedPinKey)")
	List<LandingInfoBean> getPersonInterestDetails(@Param("logoutDate") Date logoutDate, @Param("toPinKey") List<Long> toPinKey, @Param("loggedPinKey") Long loggedPinKey);
	
	@Query("Select new com.id.wasta.bean.LandingInfoBean(e.ldKey,e.ldUserName,e.ldUserPinKey,e.ldContactName,e.ldContactPinKey,e.ldCompany,e.ldIndustry,e.ldCountry,e.ldBoxName,e.ldFieldName,e.ldLatestUpdate,e.ldUpdateKey,e.ldReadFlag,e.lockKey,e.profileKey,e.createdOn, 0 ) from TIdLandingPersonalInterestEntity e "
			+ "where e.createdOn >= :logoutDate and e.ldContactPinKey in (:toPinKey) and e.ldAccessInfo like CONCAT('%,',:loggedPinKey,',%') and e.ldKey not in (select ee.llLdKey from TIdLandingPersonalInterestLinkEntity ee where ee.llPinKey=:loggedPinKey)")
	List<LandingInfoBean> getPersonInterestDetailsNotIn(@Param("logoutDate") Date logoutDate, @Param("toPinKey") List<Long> toPinKey, @Param("loggedPinKey") Long loggedPinKey);
	
	@Modifying
	@Transactional
    @Query("update TIdLandingPersonalInterestEntity e set e.ldAuditLatestUpdate = ?1 where e.ldUpdateKey = ?2 and e.ldTypeChange in ('Created','Added')")
	int updateLatestUpdate(String ldAuditLatestUpdate, Long ldUpdateKey);

	
	
}