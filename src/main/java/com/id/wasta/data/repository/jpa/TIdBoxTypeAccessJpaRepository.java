package com.id.wasta.data.repository.jpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.id.wasta.bean.jpa.TIdBoxTypeAccessEntity;

public interface TIdBoxTypeAccessJpaRepository extends CrudRepository<TIdBoxTypeAccessEntity, Long>{
	
	@Query(value="select (FIND_IN_SET( ?1, bta_remove_access)=0) from t_id_box_type_access WHERE bta_pin_key = ?2 and bta_menu_type = ?3 and bta_profile_pin_key = ?4 and bta_share_type = ?5 and created_by = ?6", nativeQuery=true)
	public Integer isPropertyInBoxAccessGiven(Long propertyKey,Long loginPinKey, String menuType, Long contactPinKey, String shareType, Long propertyCreatedBy);
	
	@Query(value="select (FIND_IN_SET( ?1, bta_remove_access)=0) from t_id_box_type_access WHERE bta_menu_type = ?3 and bta_profile_pin_key = ?4 and bta_share_type = ?5 and created_by = ?6 and (bta_pin_key in  (select gl_gh_key from t_id_group_link where gl_pin_key = ?2 ))", nativeQuery=true)
	public Integer isPropertyInBoxAccessGivenForGroup(Long propertyKey,Long loginPinKey, String menuType, Long contactPinKey, String shareType, Long propertyCreatedBy);
	

	@Query(value="SELECT bta_profile_pin_Key FROM t_id_box_type_access  WHERE bta_share_type=?3 AND bta_menu_type=?5 AND (FIND_IN_SET( ?2, bta_remove_access)=0) and bta_pin_key=?1 and bta_profile_pin_key=?4", nativeQuery=true)
	public Long getOneToOneCount1(Long loginPinKey, Long currentPinKey, String shareType, Long currentProfilePinKey, String menuType);
	
	@Query(value="SELECT bta_profile_pin_Key FROM t_id_group_link WHERE gl_gh_key in" + 
			"(SELECT bta_pin_key FROM t_id_box_type_access  WHERE bta_share_type=?3 AND bta_menu_type=?5 AND (FIND_IN_SET( ?2, bta_remove_access)=0) and bta_profile_pin_key=?4 ) "
			+ "AND gl_pin_key = ?1", nativeQuery=true)
	public Long getGroupCount1(Long loginPinKey, Long currentPinKey, String shareType, Long currentProfilePinKey, String menuType);
	
	@Query(value="SELECT COUNT(*) FROM t_id_box_type_access  WHERE bta_share_type=?3 AND bta_menu_type=?5 AND (FIND_IN_SET( ?2, bta_remove_access)=0) and bta_pin_key=?1 and bta_profile_pin_key=?4", nativeQuery=true)
	public int getOneToOneCount(Long loginPinKey, Long currentPinKey, String shareType, Long currentProfilePinKey, String menuType);
	
	@Query(value="SELECT COUNT(*) FROM t_id_box_type_access  WHERE bta_share_type=?3 AND bta_menu_type=?5 AND (FIND_IN_SET( ?2, bta_remove_access)=0) and bta_pin_key=?1 and bta_profile_pin_key=?4 and bta_filed_type=?6", nativeQuery=true)
	public int getOneToOneCount(Long loginPinKey, Long currentPinKey, String shareType, Long currentProfilePinKey, String menuType,String fieldType);

	@Query(value="SELECT COUNT(*) FROM t_id_group_link WHERE gl_gh_key in" + 
			"(SELECT bta_pin_key FROM t_id_box_type_access  WHERE bta_share_type=?3 AND bta_menu_type=?5 AND (FIND_IN_SET( ?2, bta_remove_access)=0) and bta_profile_pin_key=?4 ) "
			+ "AND gl_pin_key = ?1", nativeQuery=true)
	public int getGroupCount(Long loginPinKey, Long currentPinKey, String shareType, Long currentProfilePinKey, String menuType);
	
	@Query(value="SELECT COUNT(*) FROM t_id_group_link WHERE gl_gh_key in " + 
			"(SELECT bta_pin_key FROM t_id_box_type_access  WHERE bta_share_type=?3 AND bta_menu_type=?5 AND (FIND_IN_SET( ?2, bta_remove_access)=0) and bta_profile_pin_key=?4  and bta_filed_type=?6) "
			+ "AND gl_pin_key = ?1", nativeQuery=true)
	public int getGroupCount(Long loginPinKey, Long currentPinKey, String shareType, Long currentProfilePinKey, String menuType, String fieldType);
	 
	@Modifying
	@Transactional
	@Query("update TIdBoxTypeAccessEntity as e set e.btaRemoveAccess=?3 where e.btaMenuType=?1 and e.btaPinKey=?2 and e.btaShareType =?4")
	void updateBymenuTypeAndId(String menuType, Long pinKey, String removeAccess,String shareType);
	
	
	@Modifying
	@Transactional
	@Query("update TIdBoxTypeAccessEntity as e set e.btaRemoveAccess=?3 where e.btaMenuType=?1 and e.btaPinKey=?2 and e.btaShareType =?4 and e.btaFiledType =?5")
	void updateBymenuTypeAndId(String menuType, Long pinKey, String removeAccess,String shareType,String filedType);

	@Query(value="SELECT * FROM t_id_box_type_access  WHERE bta_menu_type=?1 AND (FIND_IN_SET( ?2, bta_remove_access)=0)", nativeQuery=true)
	public List<TIdBoxTypeAccessEntity> findByBtaMenuTypeAndBtaRemoveAccess(String menuType, Long key);
	
	@Query(value="SELECT btaPinKey FROM TIdBoxTypeAccessEntity  WHERE btaMenuType=?1 AND btaProfilePinKey=?2 and btaShareType=?3")
	public List<Long> getBoxShareCount(String menuType, Long ProfilePinKey, String shareType);

	@Query(value="select count(*) From t_id_box_type_access WHERE bta_pin_key=?1 and bta_profile_pin_key=?2 and bta_share_type = ?3", nativeQuery=true)
	public int getBoxShareCount(Long pinKey, Long contactPinKey, String shareType);
	
	@Query(value="SELECT * FROM t_id_box_type_access  WHERE bta_menu_type=?1 AND (FIND_IN_SET( ?2, bta_remove_access)=0) and bta_profile_pin_key=?3", nativeQuery=true)
	public List<TIdBoxTypeAccessEntity> findByBtaMenuTypeAndBtaRemoveAccessAndBtaProfilePinKey(String menuType, Long key, Long ProfilePinKey);
	
	@Query(value="SELECT * FROM t_id_box_type_access  WHERE bta_menu_type=?1 AND bta_filed_type=?2 AND (FIND_IN_SET( ?3, bta_remove_access)=0) and bta_profile_pin_key=?4", nativeQuery=true)
	public List<TIdBoxTypeAccessEntity> findByBtaMenuTypeAndFieldTypeAndBtaRemoveAccessAndBtaProfilePinKey(String menuType, String fieldType, Long key, Long ProfilePinKey);
	
	@Modifying
	@Transactional
	@Query("delete TIdBoxTypeAccessEntity as e where e.btaMenuType =?1 and e.btaShareType =?2")
	public void deleteBybtaMenuTypeAndBtaShareType(String menuType, String shareType);

	@Modifying
	@Transactional
	@Query("delete TIdBoxTypeAccessEntity as e where e.btaMenuType =?1 and e.btaShareType =?2 and e.btaProfilePinKey=?3")
	public void deleteBybtaMenuTypeAndBtaShareTypeAndBtaProfilePinKey(String menuType, String shareType, Long ProfilePinKey);
	
	@Modifying
	@Transactional
	@Query("delete TIdBoxTypeAccessEntity as e where e.btaMenuType =?1 and e.btaProfilePinKey=?2 and e.createdBy=?3")
	public void deleteBybtaMenuTypeAndBtaProfilePinKeyAndCreatedBy(String menuType, Long ProfilePinKey, Long createdBy);
	
	@Modifying
	@Transactional
	@Query("delete TIdBoxTypeAccessEntity as e where e.btaMenuType =?1 and e.btaFiledType =?2 and e.btaProfilePinKey=?3 and e.createdBy=?4 ")
	public void deleteBybtaMenuTypeAndFieldTypeAndBtaProfilePinKeyAndCreatedBy(String menuType, String fieldType, Long ProfilePinKey, Long createdBy);
	
	@Modifying
	@Transactional
	@Query("delete TIdBoxTypeAccessEntity as e where e.btaMenuType =?1 and e.btaShareType =?2 and e.btaProfilePinKey=?3 and e.createdBy=?4")
	public void deleteBybtaMenuTypeAndBtaShareTypeAndBtaProfilePinKeyAndCreatedBy(String menuType, String shareType, Long ProfilePinKey, Long createdBy);
	
	@Query("select e.btaRemoveAccess from TIdBoxTypeAccessEntity as e where e.btaMenuType=?1 and e.btaPinKey=?2 and e.btaShareType=?3")
	public String findByBtaMenuTypeAndBtaPinKeyAndBtaShareType(String experience, Long pinKey, String shareType);
	
	@Query("select e.btaRemoveAccess from TIdBoxTypeAccessEntity as e where e.btaMenuType=?1 and e.btaPinKey=?2 and e.btaShareType=?3 and e.btaFiledType =?4")
	public String findByBtaMenuTypeAndBtaPinKeyAndBtaShareTypeAndBtaFiledType(String menuType, Long pinKey, String shareType,String filedType);

	@Query("select e from TIdBoxTypeAccessEntity as e where e.btaMenuType=?1 and e.btaProfilePinKey=?2 and e.createdBy=?3")
	public List<TIdBoxTypeAccessEntity> findByBtaMenuTypeAndBtaProfilePinKeyAndCreatedBy(String menuType, Long btaProfilePinKey, Long createdBy);

	@Query("select e from TIdBoxTypeAccessEntity as e where e.btaMenuType=?1 and e.btaFiledType=?2 and e.btaProfilePinKey=?3 and e.createdBy=?4")
	public List<TIdBoxTypeAccessEntity> findByBtaMenuTypeAndFieldTypeAndBtaProfilePinKeyAndCreatedBy(String menuType, String fieldType, Long btaProfilePinKey, Long createdBy);
	
	@Modifying
	@Transactional
	@Query("delete TIdBoxTypeAccessEntity as e where e.btaMenuType =?1 and e.btaShareType =?2 and e.btaFiledType =?3")
	public void deleteBybtaMenuTypeAndBtaShareTypeAndFieldType(String menuType, String shareType, String fieldType);

	@Modifying
	@Transactional
	@Query("delete TIdBoxTypeAccessEntity as e where e.btaMenuType =?1 and e.btaShareType =?2 and e.btaFiledType =?3 and e.btaProfilePinKey=?4")
	public void deleteBybtaMenuTypeAndBtaShareTypeAndFieldTypeAndBtaProfilePinKey(String menuType, String shareType, String fieldType, Long ProfilePinKey);
	
	@Modifying
	@Transactional
	@Query("delete TIdBoxTypeAccessEntity as e where e.btaMenuType =?1 and e.btaShareType =?2 and e.btaFiledType =?3 and e.btaProfilePinKey=?4 and e.createdBy=?5 ")
	public void deleteBybtaMenuTypeAndBtaShareTypeAndFieldTypeAndBtaProfilePinKeyAndCreatedBy(String menuType, String shareType, String fieldType, Long ProfilePinKey, Long createdBy);
	
	public List<TIdBoxTypeAccessEntity> findByBtaMenuTypeAndBtaFiledTypeAndBtaRemoveAccess(String headerInfo, String fieldType,Long pinKey);
	
	//public List<TIdBoxTypeAccessEntity> findByBtaMenuTypeAndBtaFiledTypeAndBtaRemoveAccessAndBtaProfilePinKey(String personalInfo, String fieldTypeInfo, Long pinKey, Long btaProfilePinKey);

	@Query("select e.btaRemoveAccess from TIdBoxTypeAccessEntity as e where e.btaMenuType=?1 and e.btaPinKey=?2 and e.btaShareType=?3 and e.btaProfilePinKey=?4")
	public String findByBtaMenuTypeAndBtaPinKeyAndBtaShareTypeAndBtaProfilePinKey(String menuType, Long pinKey,String shareType, Long ProfilePinKey);

	
	@Query("select e.btaRemoveAccess from TIdBoxTypeAccessEntity as e where e.btaMenuType=?1 and e.btaPinKey=?2 and e.btaShareType=?3 and e.btaFiledType =?4 and e.btaProfilePinKey=?5")
	public String findByBtaMenuTypeAndBtaPinKeyAndBtaShareTypeAndBtaFiledTypeAndBtaProfilePinKey(String menuType, Long pinKey,String shareType, String fieldType, Long ProfilePinKey);

	@Modifying
	@Transactional
	@Query("update TIdBoxTypeAccessEntity as e set e.btaRemoveAccess=?3 where e.btaMenuType=?1 and e.btaPinKey=?2 and e.btaShareType =?4 and e.btaProfilePinKey=?5")
	public void updateBymenuTypeAndIdAndBtaProfilePinKey(String menuType, Long pinKey, String string, String shareType,Long profilePinKey);


	@Modifying
	@Transactional
	@Query("update TIdBoxTypeAccessEntity as e set e.btaRemoveAccess=?3 where e.btaMenuType=?1 and e.btaPinKey=?2 and e.btaShareType =?4 and e.btaFiledType =?5 and e.btaProfilePinKey=?6")
	public void updateBymenuTypeAndIdAndBtaProfilePinKey(String string, Long pinKey, String string2, String shareType,String fieldType, Long profilePinKey);

	

	

	




}
