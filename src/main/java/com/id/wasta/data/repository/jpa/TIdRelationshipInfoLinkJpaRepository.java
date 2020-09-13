package com.id.wasta.data.repository.jpa;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdRelationshipInfoLinkEntity;

/**
 * Repository : TIdRelationshipInfoLink.
 */
public interface TIdRelationshipInfoLinkJpaRepository extends BaseRepository<TIdRelationshipInfoLinkEntity, Long> {

	TIdRelationshipInfoLinkEntity findByPrlkPrlKey(Long prlkPrlKey);

	List<TIdRelationshipInfoLinkEntity> findByPrlkToPinKeyAndPrlkContact(Long prlkToPinKey, Long contactKey);
	
	@Query("select e from TIdRelationshipInfoLinkEntity as e where e.prlkRelationship=?1 And e.prlkFromPinKey=?2 And e.activeStatus=?3")
	List<TIdRelationshipInfoLinkEntity> getDetails(String relationShip, Long prlPinKey, String string);
	
	@Query("select e from TIdRelationshipInfoLinkEntity as e where e.prlkFromPinKey=?1 And e.prlkToPinKey=?2")
	List<TIdRelationshipInfoLinkEntity> checkRelationStatus(Long fromPinKey, Long toPinKey);
	
	@Query("select e.prlkKey from TIdRelationshipInfoLinkEntity as e where e.prlkFromPinKey=?1 and prlkRelationType=?2 and e.activeStatus='A' ")
	List<Long> findPrlkFromPinKeyAndRelationType(Long pinKey, String relationType);
	
	@Query("select e.prlkRelationship from TIdRelationshipInfoLinkEntity as e where e.prlkKey=?1")
	String findPrlkRelationship(Long prlkKey);
	
	@Query("select e.prlkToPinKey from TIdRelationshipInfoLinkEntity e where e.prlkFromPinKey = ?1 and e.prlkContact!=1 ")
	List<Long> getPrlkToPinKey(Long prlkFromPinKey);
	
	@Modifying
	@Transactional
    @Query("update TIdRelationshipInfoLinkEntity e set e.prlkFromPinKey = ?1 where e.prlkFromPinKey = ?2 ")
	int updatePrlkFromPinKey(Long prlkFromPinKey, Long prlkFromPinKey2);
	
	@Modifying
	@Transactional
    @Query("update TIdRelationshipInfoLinkEntity e set e.prlkToPinKey = ?1 where e.prlkToPinKey = ?2 ")
	int updatePrlkToPinKey(Long prlkToPinKey, Long prlkToPinKey2);

	@Modifying
	@Transactional
    @Query("update TIdRelationshipInfoLinkEntity e set e.prlkRelationship = ?3 where e.prlkFromPinKey =?1 and e.prlkToPinKey = ?2 ")
	public void  updateRelationShip(Long pinKey, Long toPinKey, String relShip);

	@Query("select e.prlkKey from TIdRelationshipInfoLinkEntity as e where e.prlkToPinKey=?1 and e.prlkContact = ?2)")
	List<Long> getListOfPrlkKeyByUserKey(Long pinKey, Long l);

	@Modifying
	@Transactional
    @Query("delete from TIdRelationshipInfoLinkEntity as e where e.prlkToPinKey =?1 and e.prlkContact = ?2")
	void deleteUserKey(Long pinKey,Long l);
	
    @Query("select e.prlkPrlKey from TIdRelationshipInfoLinkEntity as e where e.prlkToPinKey =?1 and e.prlkContact = ?2")
	List<Long> findprlkPrlKey(Long pinKey,Long l);

	@Modifying
	@Transactional
	@Query("delete from TIdRelationshipInfoLinkEntity as e where e.prlkKey not in(?1) and e.prlkToPinKey = ?2 and e.prlkContact =?3")
	void deleteByPrimaryKeys(List<Long> primaryKeys, Long pinKey,Long l);

	@Modifying
	@Transactional
	@Query("select e.prlkPrlKey from TIdRelationshipInfoLinkEntity as e where e.prlkKey not in(?1) and e.prlkToPinKey = ?2 and e.prlkContact =?3")
	List<Long> findPrlkPrlKeyList(List<Long> primaryKeys, Long pinKey, Long l);

	@Query("select count(e) from TIdRelationshipInfoLinkEntity as e where e.prlkFromPinKey=?1 and e.prlkRelationType=?2 and e.createdOn <?3")
	long getPersonalProfessionalRelationCount(Long userPinKey, String string, Date todayDate);
	
	
}
