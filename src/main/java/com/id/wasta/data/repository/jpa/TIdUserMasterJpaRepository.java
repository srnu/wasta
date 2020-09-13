package com.id.wasta.data.repository.jpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.util.bean.common.SelectListBean;
import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdUserMasterEntity;

/**
 * Repository : TIdUserMaster.
 */
public interface TIdUserMasterJpaRepository extends BaseRepository<TIdUserMasterEntity, Long> {
	
	TIdUserMasterEntity findByUserCodeAndUserPassword(String userCode, String password);
	
	TIdUserMasterEntity findByUserKey(Long userkey);
	
	TIdUserMasterEntity findByUserPinKey(Long pinKey);

	TIdUserMasterEntity findByUserCodeAndUserPasswordAndUserVerificationCode(String userCode, String userPassword, Long userVerificationCode);

	TIdUserMasterEntity findByUserCode(String userCode);
	
	TIdUserMasterEntity findByUserAddressLink(Long commAddressKey);
	
	@Modifying
	@Transactional
    @Query("update TIdUserMasterEntity um set um.userLockCount = :userLockCount where um.userCode = :userCode")
	public int updateLockCount(@Param("userCode") String userCode,@Param("userLockCount") Long userLockCount);
	
	@Modifying
	@Transactional
    @Query("update TIdUserMasterEntity um set um.activeStatus = :activeStatus, um.userLockCount = :userLockCount  where um.userCode = :userCode")
	public int updateActiveStatusAndLockCount(@Param("userCode") String userCode,@Param("activeStatus") Long activeStatus, @Param("userLockCount") Long userLockCount);

	@Query("select new com.id.util.bean.common.SelectListBean (e.userKey , e.userFirstName ,e.userFirstName||' '||e.userLastName||' ('|| e.userCode ||')') from TIdUserMasterEntity as e where e.userPinKey=0 order by e.userFirstName")
	List<SelectListBean> getUserMasterAll();

	@Modifying
	@Transactional
    @Query("update TIdUserMasterEntity um set um.userPinKey = :userPinKey where um.userKey = :userKey")
	int updateUserPinKey(@Param("userKey")Long userKey, @Param("userPinKey")Long userPinKey);

	@Modifying
	@Transactional
    @Query("update TIdUserMasterEntity um set um.userPinKey = :userPinKey, um.activeStatus = :activeStatus where um.userKey = :userKey")
	int DeActivateUser(@Param("userKey")Long userKey, @Param("userPinKey")Long userPinKey, @Param("activeStatus") Long activeStatus);
	
	@Query("select e from TIdUserMasterEntity as e where e.userPasswordModified in (?1)")
	public List<TIdUserMasterEntity> getUserMastetList(List<String> value);

	@Query("select e from TIdUserMasterEntity as e")
	List<TIdUserMasterEntity> getAllUSer();

	
}
