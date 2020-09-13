package com.id.wasta.data.repository.jpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.TIdLandingNotification;
import com.id.wasta.bean.jpa.TIdLandingNotificationEntity;

public interface TIdLandingNotificationJpaRepository extends BaseRepository<TIdLandingNotificationEntity, Long> {

	List<TIdLandingNotificationEntity> findByLdToPinKeyAndLdBoxName(Long ldToPinKey, String menuType);
	
	@Query("Select new com.id.wasta.bean.TIdLandingNotification(e.ldKey,e.ldUserTitle,e.ldUserName,e.ldUserPinKey,e.ldContactTitle,e.ldContactName,e.ldContactPinKey,e.ldCompany,e.ldIndustry,e.ldCountry,"
			+ "e.ldBoxName,e.ldFieldName,e.ldLatestUpdate,e.ldUpdateKey,e.ldToPinKey,e.ldToTitle,e.ldToName,e.ldReadFlag,e.lockKey,e.profileKey,e.createdOn,e.ldAppRejFlag,e.ldRequest) "
			+ "from TIdLandingNotificationEntity e where e.ldToPinKey=?1 and e.ldBoxName=?2 ")
	List<TIdLandingNotification> getNotificationList(Long ldToPinKey, String menuType, Pageable page);
	
	@Query("Select new com.id.wasta.bean.TIdLandingNotification(e.ldKey,e.ldUserTitle,e.ldUserName,e.ldUserPinKey,e.ldContactTitle,e.ldContactName,e.ldContactPinKey,e.ldCompany,e.ldIndustry,e.ldCountry,"
			+ "e.ldBoxName,e.ldFieldName,e.ldLatestUpdate,e.ldUpdateKey,e.ldToPinKey,e.ldToTitle,e.ldToName,e.ldReadFlag,e.lockKey,e.profileKey,e.createdOn,e.ldAppRejFlag,e.ldRequest) "
			+ "from TIdLandingNotificationEntity e where e.ldToPinKey=?1 and e.ldReadFlag=?2 ")
	List<TIdLandingNotification> getNotificationList(Long ldToPinKey, Boolean readFlag, Pageable page);
	
	@Query("Select new com.id.wasta.bean.TIdLandingNotification(e.ldKey,e.ldUserTitle,e.ldUserName,e.ldUserPinKey,e.ldContactTitle,e.ldContactName,e.ldContactPinKey,e.ldCompany,e.ldIndustry,e.ldCountry,"
			+ "e.ldBoxName,e.ldFieldName,e.ldLatestUpdate,e.ldUpdateKey,e.ldToPinKey,e.ldToTitle,e.ldToName,e.ldReadFlag,e.lockKey,e.profileKey,e.createdOn,e.ldAppRejFlag,e.ldRequest) "
			+ "from TIdLandingNotificationEntity e where e.ldToPinKey=?1 and e.ldBoxName=?2 and e.ldFieldName=?3 ")
	List<TIdLandingNotification> getNotificationList(Long ldToPinKey, String menuType, String fieldType, Pageable page);
	
	@Query(value = "select count(*) from t_id_landing_notification where ld_to_pin_key=?1 and ld_box_name=?2 and ld_read_flag='0'", nativeQuery = true)
	Long getNotificationCount(@Param("loggedPinKey") Long loggedPinKey, @Param("menuType") String menuType);

	@Query(value = "select count(*) from t_id_landing_notification where ld_to_pin_key=?1 and ld_box_name=?2 and ld_field_name=?3 and ld_read_flag='0'", nativeQuery = true)
	Long getNotificationCount(@Param("loggedPinKey") Long loggedPinKey, @Param("menuType") String menuType, @Param("fieldType") String fieldType);
	
	@Modifying
	@Transactional
	@Query("update TIdLandingNotificationEntity e set e.ldReadFlag =1 where e.ldKey = :ldKey")
	public int updateNotification(@Param("ldKey") Long ldKey);
	
	@Modifying
	@Transactional
	@Query("delete from TIdLandingNotificationEntity e where e.ldContactPinKey=?1 and e.ldAppRejFlag='0' ")
	public int deleteNotification(@Param("ldContactPinKey") Long ldContactPinKey);
	
	@Modifying
	@Transactional
	@Query("update TIdLandingNotificationEntity e set e.ldAppRejFlag = :ldAppRejFlag where e.ldKey = :ldKey")
	public int updateAppRejectFlag(@Param("ldAppRejFlag") Long ldAppRejFlag, @Param("ldKey") Long ldKey);
	
	@Query(value = "select e.ldToPinKey from TIdLandingNotificationEntity e where e.ldToPinKey in (?1) and e.ldBoxName=?2 and e.ldFieldName=?3 and e.ldUpdateKey=?4 and e.ldReadFlag='0'")
	List<Long> getListOfId(List<Long> toPinKey, String menuType, String fieldType, Long updateKey);
	
	
	@Modifying
	@Transactional
	@Query("delete from TIdLandingNotificationEntity e where e.ldToPinKey in (?1) and e.ldBoxName=?2 and e.ldFieldName=?3 and e.ldUpdateKey=?4 and e.ldReadFlag='0'")
	public int deleteListOfId(List<Long> toPinKey, String menuType, String fieldType, Long updateKey);


	@Query("select e from TIdLandingNotificationEntity e where e.ldUserPinKey =?1 and e.ldContactPinKey=?2 and e.ldReadFlag='0'")
	TIdLandingNotificationEntity getNotification(Long mclFromPinKey, Long mclToPinKey);
	
}
