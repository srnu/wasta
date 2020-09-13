package com.id.wasta.data.repository.jpa;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.util.bean.common.SelectListBean;
import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdPersonalInformationEntity;

/**
 * Repository : TIdPersonalInformation.
 */
public interface TIdPersonalInformationJpaRepository extends BaseRepository<TIdPersonalInformationEntity, Long> {
	
	List<TIdPersonalInformationEntity> findByProfileKey(Long profileKey);
	
	List<TIdPersonalInformationEntity> findByPinFirstName(String firstName);
	
	List<TIdPersonalInformationEntity> findByPinFirstNameAndPinLastNameAndPinKeyNotInAndActiveStatus(String firstName, String lastName, Long pinKey, String activeStatus);
	
	List<TIdPersonalInformationEntity> findByPinEmailContainsAndPinKeyNotIn(String email, Long pinKey);
	
	@Query("select new com.id.util.bean.common.SelectListBean (e.pinKey , e.pinFirstName ,e.pinFirstName||' '||e.pinLastName) from TIdPersonalInformationEntity as e order by e.pinFirstName")
	public List<SelectListBean> getCustInfoAll();
		
	List<TIdPersonalInformationEntity>  findByPinEmailContains(String userEmail);

	TIdPersonalInformationEntity findByPinEmailAndPinKey(String userEmail, Long userPinKey);
	
	@Query("select count(*) from TIdPersonalInformationEntity e")
	Long getContactCount();
	
	@Query(value="SELECT COUNT(*)  FROM t_id_landing_notification WHERE ld_to_pin_key=?1 AND ld_read_flag=0",nativeQuery=true)
	Long getNotificationCount(Long pinKey);
	
	/*@Query(value="SELECT COUNT(*) FROM t_id_my_contacts_link WHERE mcl_from_pin_key=:pinKey AND active_status='A'",nativeQuery=true)
	Long getMyContactsCount(@Param("pinKey") Long pinKey);*/
	
	@Query(value="SELECT COUNT(*) FROM `t_id_profile_follow_details` WHERE pfd_pin_followby_key=:pinKey AND active_status='A'",nativeQuery=true)
	Long getFavoritesCount(@Param("pinKey") Long pinKey);
	
	@Modifying
	@Transactional
	@Query("update TIdPersonalInformationEntity e set e.pinCreatorKey = :creatorPinKey where e.pinKey = :pinKey ")
	public int updateCreatorPinKey(@Param("pinKey") Long pinKey, @Param("creatorPinKey") Long creatorPinKey);
	
	@Modifying
	@Transactional
	@Query("update TIdPersonalInformationEntity e set e.pinCreatorKey = :creatorPinKey where e.pinKey in (:pinKey) ")
	public int changeCreatorPinKey(@Param("pinKey") List<Long> pinKey, @Param("creatorPinKey") Long creatorPinKey);
	
	@Query(value="SELECT * FROM t_id_personal_information WHERE pin_key NOT IN (?1) AND FIND_IN_SET(?2 ,pin_email) AND active_status='A' ",nativeQuery=true)
	List<TIdPersonalInformationEntity> findByPinKeyNotInAndPinEmail(@Param("pinKey")Long pinKey, @Param("pinEmail")String pinEmail);
	
	@Query(value="SELECT pin_key FROM t_id_personal_information WHERE pin_key not in (?2) and FIND_IN_SET(?1,pin_email) AND active_status='A' ",nativeQuery=true)
	List<Long> findByPinEmail(String emailId, Long pinKey);
	
    @Query("select new com.id.util.bean.common.SelectListBean (e.pinKey , e.pinFirstName ,e.pinFirstName||' '||e.pinLastName) from TIdPersonalInformationEntity as e where e.activeStatus =:activeStatus")
	public List<SelectListBean> getEmployeeList(@Param("activeStatus") String activeStatus);
	
	@Query("select new com.id.util.bean.common.SelectListBean (e.pinKey , e.pinFirstName ,e.pinFirstName||' '||e.pinLastName) from TIdPersonalInformationEntity as e where e.pinCreatorKey =?1 and e.pinKey not in(?2) order by e.pinFirstName")
	public List<SelectListBean> getContactsList(Long pinCreatorKey,List<Long> shadowContactsKeys);
	
	@Query("select new com.id.util.bean.common.SelectListBean (e.pinKey , e.pinFirstName ,e.pinFirstName||' '||e.pinLastName) from TIdPersonalInformationEntity as e where e.pinCreatorKey =?1 order by e.pinFirstName")
	public List<SelectListBean> getContactsList1(Long pinCreatorKey);
	
	
	@Query(value="select e.pinKey from TIdPersonalInformationEntity as e where e.pinPreviousStatus = ?1 and e.activeStatus = ?2 ")
	List<Long> findDeactiveEmployeeList(String pinPreviousStatus, String activeStatus);
	
	@Query("select e from TIdPersonalInformationEntity as e where e.pinKey =?1")
	TIdPersonalInformationEntity getEmailId(Long pinKey);

	@Query("select e.pinCreatorKey from TIdPersonalInformationEntity as e where e.pinKey =?1")
	Long getCreatorKeyByPinkey(Long key);

	@Transactional
	@Modifying
	@Query("update TIdPersonalInformationEntity e set e.pinPercentage =?2 where e.pinKey =?1 ")
	void savePercentage(Long pinKey, Long valueOf);

	@Modifying
	@Transactional
	@Query("update TIdPersonalInformationEntity e set e.profileKey = ?2 , e.pinCreatorKey =?3, e.pinParentKey =?4, e.activeStatus ='A'  where e.pinKey in (?1)")
	public int updateProfileKeyAndCreatorKey(List<Long> listOfPinKey, Long userKey, Long pinCreatorKey, Long parentKey);

	TIdPersonalInformationEntity findByPinKey(Long pinKey);


	@Query("select count(e.pinKey) from TIdPersonalInformationEntity as e where e.pinCreatorKey=?1 and e.pinKey!=?1")
	Long getTotalContactsByUser(Long userPinKey);

//	@Query("select count(e) from TIdPersonalInformationEntity as e where e.pinCreatorKey= ?1 and (e.modifiedOn >=?2 and e.modifiedOn <=?2) ")
	@Query(value="select count(*) from t_id_personal_information  where pin_creator_key=?1 and pin_key!=?1 and modified_on <?2",nativeQuery=true)
	Long getNewContactsCreatedOnDate(Long userPinKey, Date createdDate);
	
	
}
