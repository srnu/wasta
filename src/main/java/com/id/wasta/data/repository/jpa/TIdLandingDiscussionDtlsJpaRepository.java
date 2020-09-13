package com.id.wasta.data.repository.jpa;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.id.wasta.bean.LandingInfoBean;
import com.id.wasta.bean.jpa.TIdLandingDiscussionDtlsEntity;

/**
 * Repository : TIdLandingDiscussionDtls.
 */
public interface TIdLandingDiscussionDtlsJpaRepository extends PagingAndSortingRepository<TIdLandingDiscussionDtlsEntity, Long> {
	
	@Query(value ="Select count(*) from t_id_landing_discussion_dtls WHERE ld_type_change!='Deleted' and FIND_IN_SET (:loggedPinKey, ld_access_info) and ld_key not in (select ll_ld_key from t_id_landing_discussion_dtls_link WHERE ll_pin_key=:loggedPinKey)", nativeQuery=true)
	Long getdiscussDetailsCount(@Param("loggedPinKey") Long loggedPinKey);
	
	@Query("Select new com.id.wasta.bean.LandingInfoBean(e.ldKey,e.ldUserName,e.ldUserPinKey,e.ldContactName,e.ldContactPinKey,e.ldCompany,e.ldIndustry,e.ldCountry,e.ldBoxName,e.ldFieldName,e.ldLatestUpdate,e.ldUpdateKey,e.ldReadFlag,e.lockKey,e.profileKey,e.createdOn, 1 ) from TIdLandingDiscussionDtlsEntity e "
			+ "where e.ldTypeChange!='Deleted' and e.ldAccessInfo like CONCAT(',%',:loggedPinKey,',%') and e.ldKey in (select ee.llLdKey from TIdLandingDiscussionDtlsLinkEntity ee where ee.llPinKey=:loggedPinKey)")
	List<LandingInfoBean> getdiscussDetails(@Param("loggedPinKey") Long loggedPinKey);
	
	@Query("Select new com.id.wasta.bean.LandingInfoBean(e.ldKey,e.ldUserName,e.ldUserPinKey,e.ldContactName,e.ldContactPinKey,e.ldCompany,e.ldIndustry,e.ldCountry,e.ldBoxName,e.ldFieldName,e.ldLatestUpdate,e.ldUpdateKey,e.ldReadFlag,e.lockKey,e.profileKey,e.createdOn, 0 ) from TIdLandingDiscussionDtlsEntity e "
			+ "where e.ldTypeChange!='Deleted' and e.ldAccessInfo like CONCAT(',%',:loggedPinKey,',%') and e.ldKey not in (select ee.llLdKey from TIdLandingDiscussionDtlsLinkEntity ee where ee.llPinKey=:loggedPinKey)")
	List<LandingInfoBean> getdiscussDetailsNotIn(@Param("loggedPinKey") Long loggedPinKey);
	
	List<TIdLandingDiscussionDtlsEntity> findByLdContactPinKey(Long pinKey);
	
	
	@Query(value ="Select count(*) from t_id_landing_discussion_dtls WHERE created_on >=:logoutDate and ld_contact_pin_key in (:toPinKey) and FIND_IN_SET (:loggedPinKey, ld_access_info) and ld_key not in (select ll_ld_key from t_id_landing_discussion_dtls_link WHERE ll_pin_key=:loggedPinKey)", nativeQuery=true)
	Long getdiscussDetailsCount(@Param("logoutDate") Date logoutDate, @Param("toPinKey") List<Long> toPinKey, @Param("loggedPinKey") Long loggedPinKey);
	
	@Query("Select new com.id.wasta.bean.LandingInfoBean(e.ldKey,e.ldUserName,e.ldUserPinKey,e.ldContactName,e.ldContactPinKey,e.ldCompany,e.ldIndustry,e.ldCountry,e.ldBoxName,e.ldFieldName,e.ldLatestUpdate,e.ldUpdateKey,e.ldReadFlag,e.lockKey,e.profileKey,e.createdOn, 1 ) from TIdLandingDiscussionDtlsEntity e "
			+ "where e.createdOn >= :logoutDate and e.ldContactPinKey in (:toPinKey) and e.ldAccessInfo like CONCAT('%,',:loggedPinKey,',%') and e.ldKey in (select ee.llLdKey from TIdLandingDiscussionDtlsLinkEntity ee where ee.llPinKey=:loggedPinKey)")
	List<LandingInfoBean> getdiscussDetails(@Param("logoutDate") Date logoutDate, @Param("toPinKey") List<Long> toPinKey, @Param("loggedPinKey") Long loggedPinKey);
	
	@Query("Select new com.id.wasta.bean.LandingInfoBean(e.ldKey,e.ldUserName,e.ldUserPinKey,e.ldContactName,e.ldContactPinKey,e.ldCompany,e.ldIndustry,e.ldCountry,e.ldBoxName,e.ldFieldName,e.ldLatestUpdate,e.ldUpdateKey,e.ldReadFlag,e.lockKey,e.profileKey,e.createdOn, 0 ) from TIdLandingDiscussionDtlsEntity e "
			+ "where e.createdOn >= :logoutDate and e.ldContactPinKey in (:toPinKey) and e.ldAccessInfo like CONCAT('%,',:loggedPinKey,',%') and e.ldKey not in (select ee.llLdKey from TIdLandingDiscussionDtlsLinkEntity ee where ee.llPinKey=:loggedPinKey)")
	List<LandingInfoBean> getdiscussDetailsNotIn(@Param("logoutDate") Date logoutDate, @Param("toPinKey") List<Long> toPinKey, @Param("loggedPinKey") Long loggedPinKey);
	
	@Modifying
	@Transactional
    @Query("update TIdLandingDiscussionDtlsEntity e set e.ldAuditLatestUpdate = ?1 where e.ldUpdateKey = ?2 and e.ldTypeChange in ('Created','Added')")
	int updateLatestUpdate(String ldAuditLatestUpdate, Long ldUpdateKey);

	@Query("select count(e) from TIdLandingDiscussionDtlsEntity as e where e.ldUserPinKey= ?1 and e.createdOn <?2)")
	Long getTotalDiscussionsByUserOnDate(Long userPinKey, Date createdDate);

}
